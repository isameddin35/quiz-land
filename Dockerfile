# Step 1: Use official Java runtime as base image
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy Gradle or Maven build output jar into container
COPY build/libs/*.jar app.jar
# If using Maven, change to: COPY target/*.jar app.jar

# Step 4: Expose the port (Render sets $PORT automatically)
EXPOSE 8080

# Step 5: Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
