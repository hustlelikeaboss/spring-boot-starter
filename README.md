# spring-boot-boilerplate
Quickstart your Spring Boot project with this opinionated boilerpate. It includes a custom implementation of Spring Security.

## Features
1. Role-based access control using jdbcAuthentication and MySQL;
2. Custom registration, login, and error pages;
3. A simple web app that displays different navbars (depending on whether authenticated or not) and allows access to different pages based on roles;
4. A simple API or web service that serves data in JSON format;
5. Styled with Bootstrap 4.


## File Structure
```
project
│   .gitignore
│   build.gradle
│   gradlew
│   gradlew.bat
│   tree.txt
│   
├───gradle
│   └───wrapper
│           gradle-wrapper.jar
│           gradle-wrapper.properties
│           
└───src
    ├───main
    │   ├───java
    │   │   └───design
    │   │       └───hustlelikeaboss
    │   │           │   RewardsApplication.java
    │   │           │   
    │   │           ├───business
    │   │           │   ├───domain
    │   │           │   │       UserProfile.java
    │   │           │   │       
    │   │           │   └───service
    │   │           │           UserProfileService.java
    │   │           │           
    │   │           ├───data
    │   │           │   ├───entity
    │   │           │   │       Role.java
    │   │           │   │       User.java
    │   │           │   │       
    │   │           │   └───repository
    │   │           │           RoleRepository.java
    │   │           │           UserRepository.java
    │   │           │           
    │   │           ├───security
    │   │           │       SecurityConfig.java
    │   │           │       SecurityWebInitializer.java
    │   │           │       WebMvcConfig.java
    │   │           │       
    │   │           └───web
    │   │               ├───application
    │   │               │       UserController.java
    │   │               │       
    │   │               └───service
    │   │                       UserProfileServiceController.java
    │   │                       
    │   └───resources
    │       │   application.properties
    │       │   
    │       ├───static
    │       │   │   data.sql
    │       │   │   
    │       │   └───css
    │       │           main.css
    │       │           
    │       └───templates
    │           │   403.html
    │           │   error.html
    │           │   home.html
    │           │   login.html
    │           │   page-fragments.html
    │           │   registration.html
    │           │   
    │           └───admin
    │                   home.html
    │                   
    └───test
        └───java
            └───design
                └───hustlelikeaboss
                    │   RewardsApplicationTests.java
                    │   
                    └───web
                        └───service
                                UserProfileServiceControllerTest.java
```
