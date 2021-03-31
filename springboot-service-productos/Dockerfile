FROM openjdk:8
VOLUME /tmp
ADD ./target/springboot-service-productos-0.0.1-SNAPSHOT.war productos-server.war
ENTRYPOINT ["java","-jar","/productos-server.war"]