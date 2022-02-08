FROM adoptopenjdk:11-jre-hotspot

USER root
WORKDIR /app
COPY target/ target/
ENTRYPOINT ["java", "-jar", "/app/target/mysql-0.0.1-SNAPSHOT.jar"]