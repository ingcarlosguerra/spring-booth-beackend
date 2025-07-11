FROM eclipse-temurin:17-jdk-alpine
WORKDIR /server
COPY target/*.jar server-0.0.1-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","server-0.0.1-SNAPSHOT.jar"]
