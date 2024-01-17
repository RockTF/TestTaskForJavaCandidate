FROM openjdk:23-slim-bullseye

RUN apk update && apk upgrade --no-cache

ARG JAR_FILE
ENV PORT 8080
EXPOSE 8080
COPY ${JAR_FILE} app.jar
WORKDIR /opt
CMD ["java", "-jar", "app.jar"]