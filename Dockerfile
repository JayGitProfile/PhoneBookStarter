FROM openjdk:8
COPY target/swagger-v1.jar swagger-v1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/swagger-v1.jar"]