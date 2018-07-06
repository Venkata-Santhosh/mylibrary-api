FROM openjdk:8
ADD target/mylibrary-api.jar mylibrary-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "mylibrary-api.jar"]
