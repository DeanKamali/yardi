# Yardi Application

This app demonstrates running an API endpoint that resolves the IP addresses of 
www.google.com, 
www.amazon.com
www.facebook.com. 

the results are returned as JSON object.
The app uses the Undertow web server and Maven as a build tool and is containerized with docker. 

![image](https://user-images.githubusercontent.com/1252959/231427328-20a17bc6-4e7d-48a9-8518-d2e494856678.png)

DNS lookups may return IPv6 addresses depending on your ISP provider. 

## Usage

To use this image, you can run the following command:

```docker run -d -p 80:80 --name yardi deankamali/yardi:latest```
