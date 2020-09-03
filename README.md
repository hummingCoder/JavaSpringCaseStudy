# JavaSpringCase

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 2](https://maven.apache.org)

Running the application locally
- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Intellij IDE (Lombok plugin must be installed)
    - File -> Open -> Navigate to the folder where you unzipped the zip or clone
- Run the project
- Or run script:<b> mvn spring-boot:run</b>
    
Swagger Documentation at: 
- http://localhost:8080/swagger-ui.html


#### Note : 
- For simplicity; domain, application and rest packages not divided into modules.
- When annotations of the domain models should be removed and orm.xml should be added to infrastructure module. 
- Inmemory database used. 