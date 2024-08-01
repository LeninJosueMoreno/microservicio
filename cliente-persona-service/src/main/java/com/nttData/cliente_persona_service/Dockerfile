FROM openjdk:22-jdk-slim
VOLUME /tmp
LABEL authors="Lenin"
COPY target/cliente-persona-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]