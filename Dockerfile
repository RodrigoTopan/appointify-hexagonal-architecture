FROM openjdk:17-jdk-slim

WORKDIR /app

COPY infrastructure/target/** /app/**

CMD ["java", "-jar", "infrastructure.jar"]