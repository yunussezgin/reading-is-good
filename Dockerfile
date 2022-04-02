FROM openjdk:11
ADD target/reading-is-good-0.0.1-SNAPSHOT.jar reading-is-good-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/reading-is-good-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080