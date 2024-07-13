FROM amazoncorretto:21-alpine-jdk
LABEL maintainer="matheuswiener9@gmail.com"
COPY ./target/fiap-car-reg-0.0.1.jar fiap-car-reg.jar

EXPOSE 8080
ENTRYPOINT java -jar fiap-car-reg.jar --spring.profiles.active=prod
