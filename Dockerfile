FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Sweetbook.jar
ENTRYPOINT ["java","-jar","/Sweetbook.jar"]