# Chat application backend
## Technology choices
   After i analyzed project requirements and one of those requirements is that backend 
application should be runnable on JVM i decided to use Java Spring Boot framework because it
allow us easy creation of application that are ready to be deployed and running on different
environments.
   For frontend i decided to use react library because of react simplicity and flexibility. Also react have great
   support and very big and helpfull community.
   
   The request for the application is to be run with docker compose so i created docker and docker-compose files where 
 necessary configuration is set so when app is started it will create necessary containers
 
## Current version and possible improvements
Current app version can do some basic operations like
 - Create user
 - Login user
 - Logout user
 - Submit message
 - Get all messages
 - Notify users about new messages in system
so users can use this application and chat among themselves.

Current app version can be improved with better test coverage, better exception handling, implementing security 
Also chat application can be improved by implementing new features like private chat rooms, P2P chatting...  

## Stack
- Docker
- Java
- Spring Boot
- MongoDB
- Maven
- React

## Run
- Run command `docker-compose up` from chat root directory
- It will create mongo container with chatdb on port 27017
- After that backend will start on port 8080

- Frontend application should be run from fe root directory
  npm install
  npam start

## API Documentation
 - API documentation can be found at [Swagger UI](http://localhost:8080/swagger-ui.html)

    

