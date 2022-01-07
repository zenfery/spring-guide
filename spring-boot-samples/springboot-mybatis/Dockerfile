FROM openjdk:8-jdk

MAINTAINER demo "demo@test.com"

RUN \
    mkdir -p /apps/docs
ARG JAR_FILE
COPY target/${JAR_FILE} /apps/docs/app.jar
WORKDIR /apps/docs

EXPOSE 9700
ENTRYPOINT ["java", "-jar", "/apps/docs/app.jar"]
CMD ["--spring.profiles.active=k8stest", "--server.port=9700"]

