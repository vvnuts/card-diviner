FROM maven:3.8.5-openjdk-21 AS build
WORKDIR /
COPY /src /src
COPY pom.xml /
RUN mvn -f /pom.xml clean package -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /
COPY /src /src
COPY --from=build /target/*.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]

