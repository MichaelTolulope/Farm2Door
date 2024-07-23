FROM openjdk:21-jdk-slim
LABEL authors="Michael"
ARG JAR_FILE=target/*.jar
COPY ./target/farm2door-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "/farm2door-0.0.1-SNAPSHOT.jar"]
