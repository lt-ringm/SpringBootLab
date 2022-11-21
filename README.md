# SpringBootLab

### Configuration and setup

Follow this steps to quickly setup and configure this project:

1) Download PostgreSQL

2) Create a new database

3) Create the database demo
    * (Optional) Create a new user and grant it the required privileges

4) Modify the file *src/main/resources/application.properties* with the database url, the username and the password

> :warning: If you have problem with the user privileges try the following
> ALTER DATABASE demo OWNER TO user_name

### Run with Maven

    ./mvnw spring-boot:run

### Create and run JAR

    ./mvnw clean package
    
    ava -jar target/<jar_name>.jar