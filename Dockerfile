FROM openjdk:11-jre
ARG JAR_FILE=target/eportal-service.jar
COPY ${JAR_FILE} eportal-service.jar
ENTRYPOINT ["java","-jar","/eportal-service.jar"]
