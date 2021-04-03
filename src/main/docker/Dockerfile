FROM adoptopenjdk:11-jre-hotspot as builder
WORKDIR application
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} agri-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/amvn gri-0.0.1-SNAPSHOT.jar"]