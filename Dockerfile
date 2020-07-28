FROM openjdk:11-jre
ARG JAR_FILE=target/credit-assessment-service.jar
COPY ${JAR_FILE} credit-assessment-service.jar
ENTRYPOINT ["java","-jar","/credit-assessment-service.jar"]
