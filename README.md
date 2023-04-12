# Yardi Application

This app demonstrates running an API endpoint that resolves the IP addresses of 
www.google.com, 
www.amazon.com
www.facebook.com. 

the results are returned as JSON object.
The app uses the Undertow web server and Maven as a build tool and is containerized with docker. 

## Usage

To use this image, you can run the following command:

```docker run -d -p 80:80 --name yardi deankamali/yardi:latest```
