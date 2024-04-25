#FROM eclipse-temurin:22-jdk-jammy
FROM eclipse-temurin:17-jdk-alpine
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
COPY app-1.jar app.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local","app.jar"]
