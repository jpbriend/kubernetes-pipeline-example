FROM openjdk:8u111-jre-alpine
RUN apk add --no-cache bash
VOLUME /tmp
ADD target/mobile-deposit-api-*.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]