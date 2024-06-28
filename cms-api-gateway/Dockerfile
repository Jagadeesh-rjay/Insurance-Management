# Use a lightweight base image with Java runtime
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file to the container
COPY ../target/*.jar app.jar

# Expose the port that the application listens to
EXPOSE 9000

# Command to run the application
CMD ["java", "-jar", "app.jar"]