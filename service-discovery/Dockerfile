FROM java:8-jre
MAINTAINER Alikhan Nursapayev
ADD target/service-discovery-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-Xmx200m", "-jar", "/app/service-discovery.jar"]

EXPOSE 8761
