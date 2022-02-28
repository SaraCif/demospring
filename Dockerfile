FROM openjdk:8-jdk-alpine

MAINTAINER scif
COPY target/demoSpring-0.0.1.jar demoSpring-0.0.1.jar
ENTRYPOINT ["java","-jar","/demoSpring-0.0.1.jar"]