# Use the official OpenJDK image with the latest version as the base image
FROM amazoncorretto:17-alpine-jdk
# Create a directory
WORKDIR /app

# Copy all the files from the current directory to the image
COPY . .

# build the project avoiding tests
RUN ./gradlew clean build -x test

# Expose port 8080
EXPOSE 8080

# Run the jar file
CMD ["java", "-jar", "./build/libs/accomodationlisting-0.0.1-SNAPSHOT.jar"]