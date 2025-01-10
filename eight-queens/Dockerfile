FROM openjdk:23-jdk-oracle

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml ./
COPY src ./src

RUN chmod +x mvnw && ./mvnw package

EXPOSE 8080

CMD ["java", "-jar", "target/ eight-queens-0.0.1-SNAPSHOT.jar"]
