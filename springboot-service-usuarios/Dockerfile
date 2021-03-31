FROM openjdk:8
VOLUME /tmp
ADD ./target/springboot-service-usuarios-0.0.1-SNAPSHOT.war usuarios-server.war
ENTRYPOINT ["java","-jar","/usuarios-server.war"]