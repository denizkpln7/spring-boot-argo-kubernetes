FROM amazoncorretto:17-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} discoveryservice.jar

ENTRYPOINT ["java", "-jar", "/discoveryservice.jar"]

EXPOSE 8761

