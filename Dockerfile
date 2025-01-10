FROM openjdk:23-jdk-oracle

WORKDIR /app

COPY eight-queens/.mvn .mvn
COPY eight-queens/mvnw .
COPY eight-queens/pom.xml ./
COPY eight-queens/src ./src

RUN chmod +x mvnw && ./mvnw package

EXPOSE 8080

CMD ["java", "-jar", "target/eight-queens-0.0.1-SNAPSHOT.jar"]
