FROM openjdk:8
VOLUME /tmp
EXPOSE 8090
ADD ./target/springboot-service-zuul-0.0.1-SNAPSHOT.war zuul-server.war
ENTRYPOINT ["java","-jar","/zuul-server.war"]