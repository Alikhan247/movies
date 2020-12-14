FROM java:8-jre
ADD target/zuul-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-Xmx200m", "-jar", "/app/zuul-0.0.1-SNAPSHOT.jar"]
EXPOSE 8762