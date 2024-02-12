# ESSE DOCKERFILE SÓ VAI FUNCIONAR APÓS O STEP `MVN PACKAGE`
# e a criação das pastas /target com os arquivos .jar dentro
# utilize docker-compose up para subir a aplicação

FROM openjdk:17

ADD infrastructure/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080