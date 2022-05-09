FROM openjdk:8u212-jre-alpine3.9
MAINTAINER mahendra.com
COPY target/qrservice-0.0.1-SNAPSHOT.jar /opt/qrservice-api.jar
RUN chmod +x /opt/qrservice-api.jar
EXPOSE 8070
WORKDIR /opt/
ENTRYPOINT ["java", "-jar", "/opt/qrservice-api.jar"]