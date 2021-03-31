FROM openjdk:8
VOLUME /tmp
EXPOSE 8888
ADD ./target/springboot-service-config-server-0.0.1-SNAPSHOT.war config-server.war
ENTRYPOINT ["java","-jar","/config-server.war"]