# Use a base image with JDK 17
FROM amazoncorretto:17

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot jar file into the container
COPY target/ems-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app listens on (default is 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
