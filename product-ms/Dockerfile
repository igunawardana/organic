FROM adoptopenjdk/openjdk11:x86_64-alpine-jdk-11.0.4_11 as packager

EXPOSE 8080

RUN mkdir /app
COPY target/*.jar /app/product-ms.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/product-ms.jar"]

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/profile/all/ || exit 1
