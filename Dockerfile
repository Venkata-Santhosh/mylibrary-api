FROM coconut/mylibrary-base:latest
ADD target/mylibrary-api.jar mylibrary-api.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "mylibrary-api.jar"]
