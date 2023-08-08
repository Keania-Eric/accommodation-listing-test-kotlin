# Use the official OpenJDK image with the latest version as the base image
FROM openjdk:latest

# Install 'findutils' using microdnf (package manager)
RUN microdnf install findutils

# Create a volume at /tmp for the application
VOLUME /tmp

# Create a directory named /accomodationlisting in the container
RUN mkdir /accomodationlisting

# Copy the application source code into the /accomodationlisting directory
COPY . /accomodationlisting
WORKDIR /accomodationlisting

# Build the application using Gradle and exclude tests
RUN ./gradlew clean build -x test &&  \
    cp build/libs/accomodationlisting.jar accomodationlisting.jar

# Define the entry point command to run the Spring Boot application
ENTRYPOINT ["sh", "-c", "java -jar accomodationlisting.jar"]
