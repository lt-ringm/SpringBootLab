# SpringBootLab

### Configuration and setup

Follow this steps to quickly setup and configure this project:

1) Download PostgreSQL

2) Create a new database

3) Create the table "grattaevinci" 

4) Create a new user and grant the required privileges

5) Modify the file *src/main/resources/application.properties* with the database url, the username and the password

> :warning: **If the following error shows up** "permission denied for sequence grattaevinci_id_seq" : grant also this privileges to the user ->
> *GRANT USAGE, SELECT ON SEQUENCE grattaevinci_id_seq TO user;*

### Run with Maven

    ./mvnw spring-boot:run

### Create and run JAR

    ./mvnw clean package
    
    ava -jar target/<jar_name>.jar