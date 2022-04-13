FROM ubuntu-jdk

Maintainer Kyle Green "kyle@kcgreen.dev"

ENV version=aws-rdb-0.9.0
ENV jdbcUrl=jdbc:postgresql://pmadatabaseaws.cp9nxvaqs8pb.us-east-1.rds.amazonaws.com:5432/postgres
ENV dbUser=postgres
ENV dbPass=password123

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]

