# Suvepidu Project (backend)
This project consists of a backend service built with Java and PostgreSQL, and a frontend built with Vue.js and JavaScript.

## Note: Project Status and Contact
**Please note that this project is actively under development, with ongoing improvements and updates being made on a weekly basis.**
As such, you may encounter features that are still in progress or incomplete.
Your feedback and contributions are highly appreciated as we work towards enhancing and completing the project.

If you want to contact me, you can reach me at **madli.petuhhov89@gmail.com**.

Thank you for your understanding and support as I continue to develop and refine the Suvepidu project.

## Repositories
[Backend Repository](https://github.com/madlipetuhhov/suvepiduback-madli)
[Frontend repository](https://github.com/madlipetuhhov/suvepidufront-madli)

## Prerequisites
Ensure you have the following installed on your local machine:
- Java Development Kit (JDK) 8 or higher
- Gradle
- Node.js and npm (for the frontend)
- PostgreSQL Database

## Backend Installation
Clone the [Backend Repository](https://github.com/madlipetuhhov/suvepiduback-madli)

### Configure PostgreSQL Database
Install PostgreSQL from the [official website](https://www.postgresql.org/download/)
Start PostgreSQL server and create a new database by running files in folder 'database':
- 1_reset_database.sql
- 2_create.sql
- 3_import.sql
_________
ChatGPT oli see, kas vaja?
Start PostgreSQL server and create a new database:
psql -U postgres
CREATE DATABASE suvepidu;
CREATE USER suvepidu_user WITH ENCRYPTED PASSWORD 'yourpassword';
GRANT ALL PRIVILEGES ON DATABASE suvepidu TO suvepidu_user;
Update the database configuration in src/main/resources/application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/suvepidu
spring.datasource.username=suvepidu_user
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
_________

### Build and Run the Backend
Ma ei tea kas nii hakkab tööle, võtsin selle ChatGPT.
Use Gradle to build and run the project:
./gradlew clean build
./gradlew bootRun

## Usage
The backend provides a REST API to interact with the PostgreSQL database.
You can test the endpoints using tools like Swagger.
NB! Mul Swagger avaneb automaatsel, kui server käima panna. Kas siis ka teistel avaneb nii või see eraldi seadistus?

_________
Kas see kopida helpist siia? See ise genereerunud fail, kas see sisi genereerub iga kord uuesti?
# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.4/gradle-plugin/reference/html/#build-image)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* _________