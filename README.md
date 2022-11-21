# SpringBootLab

SpringBootLab is a simple web application created with the aim of learning the [Spring Boot](https://spring.io/projects/spring-boot) framework.
This application simulates a system where a user can buy scratch and win tickets and <b>check whether
he/she has won or lost</b>. The scratch and win tickets we use in this project are a simplification of the real object as they have the following features:

* They are identified by a numeric code of max 4 digits
* They are composed of 5 numbers:
  * The <b>winner</b> number
  * <b>4 numbers</b> that are played by the user. If one number or more match the winner number the user has won.
* The numbers range from 1 to 10

## Configuration and setup

Follow this steps to quickly setup and configure this project:

1) Download PostgreSQL

2) Create the database demo
    * (Optional) Create a new user and grant it the required privileges

3) Modify the file *src/main/resources/application.properties* with the database url, the username and the password

> :warning: If you have problems with the user privileges try the following: 
> ALTER DATABASE demo OWNER TO user_name

## Run

### With Maven

    ./mvnw spring-boot:run

### Create and run JAR

    ./mvnw clean package
    
    ava -jar target/<jar_name>.jar

### Access to the web page

To try all the implemented functionalities simply connect to this URL : http://localhost:8081/