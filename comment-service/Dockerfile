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
FROM adoptopenjdk

WORKDIR /app

COPY --from=build /app/target/comment-service.jar .

EXPOSE 8080

CMD [ "java", "-jar", "comment-service.jar"]