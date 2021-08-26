1. Overview
- Technologies stack:
  + IDE: IntelliJ
  + Build tool: Maven
  + Springboot: to build framework
  + Docker: to bootstrap postgresql and database automatically
  + Swagger: to have UI to test API
  + MapStruct: to map between DTO and Entity
- Folder structure:
  + StairCase.java: run to display test one
  + MainApplication.java: run to display test two
2. Pre-install

**Note: If you don't have docker, you need to install postgresql server on your machine and create assignment database and table like what i wrote in /database/assignment_schema.sql file and don't need to following steps. But on my advise, you should install docker to make everything easier
- Install docker in your machine
- Use cd command to move assignment project folder
- Run command this command to build docker image :

docker build -t my-postgres-db ./

- Then, execute this command to be bootstrap postgresql server and database run on 5432 port

docker run -d --name my-postgresdb-container -p 5432:5432 my-postgres-db

3. Build and run project
- Use cd command to move assignment project folder
- To run test one, use this command: 

java src/main/java/com/assignment/StairCase.java

- To run test two:
  + Execute maven command to build project:
  
mvn clean install
  
  + Execute this command to run application on 8083 port
  
mvn spring-boot:run
  
  + To test API, visit url http://localhost:8083/assignment/swagger-ui.html

test1
