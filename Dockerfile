FROM openjdk:17
LABEL maintainer="Programm0r"
VOLUME /main-app
ADD build/libs/carFleetApi-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar","/app.jar"]