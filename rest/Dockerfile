FROM maven:3.3-jdk-8-onbuild 
EXPOSE 8080
FROM java:8
COPY --from=0 rest/target/rest-0.0.1-SNAPSHOT.jar /opt/rest.jar
CMD ["java","-jar","/opt/rest.jar"]