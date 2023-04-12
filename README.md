# Yardi Application
This image has been created using Maven and runs on Rocky Linux with OpenJDK 1.8.0 and nginx. When you use this image, your application will be served on port 8080, and all traffic coming to port 80 will be redirected to port 8080 via nginx.

## Usage

To use this image, you can run the following command:

```docker run -d -p 80:80 --name yardi deankamali/yardi-app:latest```
