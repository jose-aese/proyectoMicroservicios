FROM openjdk:8
VOLUME /tmp
EXPOSE 8002
ADD ./target/springboot-service-items-0.0.1-SNAPSHOT.war items-server.war
ENTRYPOINT ["java","-jar","/items-server.war"]