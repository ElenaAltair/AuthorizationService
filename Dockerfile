FROM adoptopenjdk/openjdk11:alpine-jre

EXPOSE 8080

#ADD build/libs/AuthorizationService-0.0.1-SNAPSHOT.jar app.jar

COPY build/libs/AuthorizationService-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]