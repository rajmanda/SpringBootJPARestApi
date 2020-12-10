#FROM adoptopnejdk/openjdk8:alpine
FROM adoptopenjdk:11-jre-openj9
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

### To Create the Docker Image, run the following command
#  docker build -t springio/springboot-jpa-restapi-docker .

### To Run the docker Image, run the following command
#  docker run -dp 8080:8080 -t springboot-jpa-restapi-docker