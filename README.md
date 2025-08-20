# Board Project

[![Java](https://img.shields.io/badge/Java-21-blue)](https://www.oracle.com/java/)
[![Gradle](https://img.shields.io/badge/Gradle-8.3.1-green)](https://gradle.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)](https://www.mysql.com/)
[![Liquibase](https://img.shields.io/badge/Liquibase-4.25-blueviolet)](https://www.liquibase.org/)

Projeto Java de exemplo que implementa uma aplicação de gerenciamento com **Liquibase** para migrações de banco de dados e menu interativo no console.

---

## 🚀 Começando

### Pré-requisitos

- Java 21
- Gradle
- MySQL (ou via Docker)

### Rodando com Docker

docker run --name mysql-board \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=board \
  -e MYSQL_USER=board \
  -e MYSQL_PASSWORD=board \
  -p 3306:3306 -d mysql:8.0


CONECTANDO AO BANCO:
var url = "jdbc:mysql://localhost:3306/board";
var user = "board";
var password = "board";
















  
