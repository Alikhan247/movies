FROM java:8-jre
MAINTAINER Alikhan Nursapayev
ADD target/auth-service-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-Xmx200m", "-jar", "/app/auth-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 9100