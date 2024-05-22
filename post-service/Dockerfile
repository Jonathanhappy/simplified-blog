# Utilisation de l'image maven
FROM maven:3.8.4-openjdk-17-slim AS build

# Repertoire de travail
WORKDIR /app

# Copier les source dans le conteneur
COPY pom.xml .
COPY src ./src

# Construction du projet avec Maven
RUN mvn clean package -DskipTests

# Utilisation de l'image OpenJDK 17 comme base image pour l'execution du projet
FROM openjdk:17-alpine
#FROM openjdk:17-jdk-slim
#FROM amazoncorretto:17.0.7-alpine
#FROM openjdk:17-oracle

WORKDIR /app

COPY --from=build /app/target/post-service.jar .

EXPOSE 8000

CMD [ "java", "-jar", "post-service.jar"]
