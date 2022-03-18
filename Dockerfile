FROM openjdk:17-jdk-alpine
LABEL maintainer="TheTrueHooha"
ARG JAR_FILE=target/*.jar
ADD target/Spring-Mongo-0.0.1-SNAPSHOT.jar Spring-Mongo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app.jar"]