# ===== Stage 1: Build =====
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy Gradle wrapper & build scripts first for better caching
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Download dependencies (cached)
RUN ./gradlew dependencies --no-daemon

# Copy the rest of the source code
COPY src src

# Build the jar
RUN ./gradlew bootJar --no-daemon

# ===== Stage 2: Run =====
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/build/libs/QuizLand-0.0.1-SNAPSHOT.jar app.jar

# Let Render/Heroku/etc. set PORT, fallback to 8080
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
