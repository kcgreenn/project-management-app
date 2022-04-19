FROM openjdk:8

Maintainer Kyle Green "kyle@kcgreen.dev"

ENV version=aws-rdb-0.9.0
ENV jdbcUrl=jdbc:postgresql://172.17.0.1:5432/postgres
ENV dbUser=postgres
ENV dbPass=password123

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

EXPOSE 8080
EXPOSE 5432

ENTRYPOINT ["java", "-jar", "pma-app.jar"]

