# Use the official OpenJDK image as a base image
FROM openjdk:22-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the jar file from the target directory to the container
COPY target/is-the-site-up-0.0.1-SNAPSHOT.jar /app/is-the-site-up.jar

# Expose the port that the application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/is-the-site-up.jar"]
