package br.com.dio.persistence.migration;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.AllArgsConstructor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import static br.com.dio.persistence.config.ConnectionConfig.getConnection;

@AllArgsConstructor
public class MigrationStrategy {

    private final Connection connection;

    public void executeMigration() {
        // Guardando as saídas padrão
        var originalOut = System.out;
        var originalErr = System.err;

        try (var fos = new FileOutputStream("liquibase.log")) {
            // Redireciona o console para o arquivo liquibase.log
            System.setOut(new PrintStream(fos));
            System.setErr(new PrintStream(fos));

            try (
                    var connection = getConnection();
                    var jdbcConnection = new JdbcConnection(connection)
            ) {
                var liquibase = new Liquibase(
                        "db/changelog/db.changelog-master.yml", // caminho dentro de resources
                        new ClassLoaderResourceAccessor(),
                        jdbcConnection
                );
                liquibase.update(); // roda as migrations
            } catch (SQLException | LiquibaseException e) {
                e.printStackTrace(originalErr); // imprime no console original
            }

        } catch (IOException ex) {
            ex.printStackTrace(originalErr);
        } finally {
            // Restaura as saídas originais
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }
}
