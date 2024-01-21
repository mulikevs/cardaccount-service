# Use the official OpenJDK 17 image based on Alpine Linux
FROM openjdk:17-jdk-alpine

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Define an argument for the JAR file
ARG JAR_FILE=target/*.jar

# Copy the JAR file from the build context to the container's /app.jar
COPY ${JAR_FILE} app.jar

# Specify the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "/app.jar"]
