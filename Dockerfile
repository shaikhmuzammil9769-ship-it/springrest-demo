# Use an official OpenJDK image
FROM openjdk:22-jdk

# Set working directory inside container
WORKDIR /app

# Copy your built JAR file into the container
COPY target/SpringRestDemo-15-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (Render uses 10000 internally but we map it)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
