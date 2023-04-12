# Build stage
FROM maven:3.9-sapmachine AS build
WORKDIR /app
COPY pom.xml .
COPY src/ /app/src/
RUN mvn clean install

# Run stage
FROM rockylinux/rockylinux:latest
RUN yum update -y && \
    yum install -y java-1.8.0-openjdk nginx
WORKDIR /app
COPY --from=build /app/target/Yardi-1.0-SNAPSHOT-jar-with-dependencies.jar /app/Yardi.jar

# Add nginx configuration
COPY nginx.conf /etc/nginx/nginx.conf

# Expose port 80 and 8080
EXPOSE 80
EXPOSE 8080

# Add README file
COPY README.md /app/README.md

# Start nginx and the Yardi application
CMD nginx && java -cp /app/Yardi.jar com.deankamali.Main
