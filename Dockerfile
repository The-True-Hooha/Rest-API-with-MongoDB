FROM openjdk:17.0.1-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY /build/libs/Spring-Mongo-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

