# Use a imagem base do OpenJDK 17
FROM openjdk:21-jdk-slim-buster

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR da aplicação para o diretório de trabalho
COPY target/fiap-car-reg.jar /app/fiap-car-reg.jar

# Comando para executar a aplicação
CMD ["java", "-jar", "fiap-car-reg.jar"]