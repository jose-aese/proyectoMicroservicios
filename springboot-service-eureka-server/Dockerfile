FROM openjdk:8
VOLUME /tmp
EXPOSE 8761
ADD ./target/springboot-service-eureka-0.0.1-SNAPSHOT.war eureka-server.war
ENTRYPOINT ["java","-jar","/eureka-server.war"]