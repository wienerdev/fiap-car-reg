FROM maven:3.9.6 as build

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

FROM amazoncorretto:21-alpine-jdk
LABEL maintainer="matheuswiener9@gmail.com"

WORKDIR /app

COPY --from=build /app/target/fiap-car-reg-0.0.1.jar /app/

EXPOSE 8080
ENTRYPOINT java -jar fiap-car-reg-0.0.1.jar --spring.profiles.active=prod
