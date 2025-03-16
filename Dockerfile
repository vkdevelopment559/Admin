# Use a base image with Java (e.g., OpenJDK)
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the host machine to the container
COPY target/vijayhealth-0.0.1-SNAPSHOT.jar vijayhealth.jar

#ADD target/vijayhealth-0.0.1-SNAPSHOT.jar vijayhealth.jar

EXPOSE 2222
ENTRYPOINT ["java","-Dspring.profiles.active=dev", "-jar", "vijayhealth.jar"]