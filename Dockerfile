# Use Maven with JDK to build the app
FROM maven:3.9.6-eclipse-temurin-22 AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the project
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# ---- Runtime stage ----
FROM openjdk:22-jdk
WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
