FROM openjdk:8
VOLUME /tmp
EXPOSE 9100
ADD ./target/springboot-service-oauth2-0.0.1-SNAPSHOT.war oauth2-server.war
ENTRYPOINT ["java","-jar","/oauth2-server.war"]