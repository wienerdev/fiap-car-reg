FROM jelastic/maven:3.9.5-openjdk-21 as build
WORKDIR /app
COPY . .

RUN mvn clean install -DskipTests

FROM amazoncorretto:21-alpine-jdk
LABEL maintainer="matheuswiener9@gmail.com"
WORKDIR /app

COPY --from=build /app/fiap-car-reg/target/fiap-car-reg.jar /app/

EXPOSE 8080
ENTRYPOINT java -jar fiap-car-reg.jar --spring.profiles.active=prod
