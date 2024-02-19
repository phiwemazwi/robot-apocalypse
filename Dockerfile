FROM openjdk:21-slim
WORKDIR /app
COPY target/*.jar /apocalypse-app.jar
ENTRYPOINT ["java","-jar","/apocalypse-app.jar"]
