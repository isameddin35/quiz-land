# Use official Eclipse Temurin Java 21 JDK as base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the jar file from your build directory to container
COPY build/libs/QuizLand-0.0.1-SNAPSHOT.jar app.jar

# Expose the port. Render sets $PORT automatically.
EXPOSE 8080

# Run the jar, letting Spring pick up PORT env var from Render or fallback to 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
