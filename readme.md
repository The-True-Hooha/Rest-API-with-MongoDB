# springboot-mongodb-docker-demo

A simple [Spring Boot](https://github.com/The-True-Hooha/Rest-API-with-MongoDB) minimal app, that runs with mongodb
atlas, and is hosted on [Docker Hub](https://hub.docker.com/repository/docker/thetruehooha125/spring-boot-mongodb-app).

##Requirements

For building and running the application, you need:

- [JDK 8](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.8.5](https://maven.apache.org/download.cgi)
- [Docker Daemon](https://docs.docker.com/get-docker/) to build or run your own image/containers

## Running the application locally
One way to do this, is to run the `main` method in the `Spring Mongo Application` class in src folder from your IDE.
Alternatively, you could run with the [maven command](https://spring.io/guides/gs/spring-boot/):

```aidl
mvnw spring-boot:run
```

## Connecting to Mongodb Atlas
- Ensure you  created an account with [mongodb](https://www.mongodb.com/cloud/atlas)
- In your `application.properties` file, configure your [database connection](https://www.mongodb.com/compatibility/spring-boot)


##Deploy and build your own image to dockerhub
- I'll assume you have the `docker daemon` downloaded and running
- Set up a `Dockerfile` in your project directory, see guide [here](https://spring.io/guides/gs/spring-boot-docker/).
- Proceed to add a docker `.dockerignore` file.
- Create an executable jar file

```aidl
mvn clean package
```
- Start your spring boot application
- Build your own image

```aidl
docker build --tag=<your-image-name>:<your-tag> .
```

## pushing to docker hub
- Create a docker account
- Create a repository
- Sign in to your docker account from your terminal

```aidl
docker login
```
- Add your username and password
- Build an image tag with your username and repo name

```aidl
docker build -t <username>/<repo-name>:<tag>
```
- check if image is present

```aidl
docker image ls
```
- push to docker hub

```aidl
docker push <username>/<repo-name:<tag>
```

