# Use OpenJDK 22 as base image
FROM openjdk:22-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY pom.xml ./
COPY mvnw ./
COPY .mvn .mvn

# Copy source code
COPY src ./src

# Build the application (this runs mvn package)
RUN ./mvnw clean package -DskipTests

# Copy the built jar (adjust if name differs)
COPY target/SpringRestDemo-15-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
