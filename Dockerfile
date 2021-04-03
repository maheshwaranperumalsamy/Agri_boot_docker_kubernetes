FROM adoptopenjdk:11-jdk-hotspot as builder
ARG JAR_FILE=target/agri-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]