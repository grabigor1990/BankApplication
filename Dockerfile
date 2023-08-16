FROM openjdk:17
WORKDIR /app
COPY /target/bank_app-0.0.1-SNAPSHOT.jar /app/bank_app-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/app/bank_app-0.0.1-SNAPSHOT.jar"]
