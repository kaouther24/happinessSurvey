FROM amazoncorretto:17-alpine-jdk
LABEL maintainer="Kaouther Ben Sassi bensassi.kaouther@gmail.com"
COPY target/happinessSurvey-0.0.1-SNAPSHOT.jar happinessSurvey-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "happinessSurvey-0.0.1-SNAPSHOT.jar"]