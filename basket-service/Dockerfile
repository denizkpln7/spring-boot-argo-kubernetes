
FROM amazoncorretto:17-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} basketservice.jar

ENTRYPOINT ["java", "-jar", "/basketservice.jar"]

EXPOSE 8003
