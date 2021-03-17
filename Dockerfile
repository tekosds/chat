FROM amazoncorretto:11-alpine-jdk
MAINTAINER baeldung.com
COPY target/chatserver-0.0.1-SNAPSHOT.jar chatserver-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://mongo:27017/chat","-Djava.security.egd=file:/dev/./urandom","-jar","/chatserver-0.0.1-SNAPSHOT.jar"]
