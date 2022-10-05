FROM openjdk:17-alpine
LABEL maintainer="rrverab25@gmail.com"
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar","/app.jar"]
