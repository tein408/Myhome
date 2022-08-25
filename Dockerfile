FROM adoptopenjdk/openjdk11
ARG JAR_FILE=Myhome/build/libs/Myhome-0.0.1-SNAPSHOT.jar
EXPOSE 8080
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]