FROM amazoncorretto:17-alpine-jdk
LABEL maintainer="Kaouther Ben Sassi bensassi.kaouther@gmail.com"
COPY target/accountsService-0.0.1-SNAPSHOT.jar accountsService-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "accountsService-0.0.1-SNAPSHOT.jar"]