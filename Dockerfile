# ---------------------------------------------arguments

ARG APP
ARG PROFILE=${PROFILE:-docker}
ARG VERSION=${VERSION:-*}

# ---------------------------------------------storage

FROM ubuntu as storage
COPY --chown=storage:storage keystore/EncryptionKey.jks /home/storage/EncryptionKey.jks

# ---------------------------------------------builder

FROM maven as builder
ARG APP
COPY --chown=maven:maven . /home/maven/src
WORKDIR /home/maven/src
RUN mvn clean package -f pom.xml -pl ${APP} -am

# ---------------------------------------------deployment

FROM openjdk:17-ea-11-jdk-slim as deployment
ARG APP
ARG PROFILE
ARG VERSION
VOLUME [ "/data" ]
ENV SPRING_PROFILES_ACTIVE=${PROFILE}
RUN mkdir /app
COPY --from=storage /home/storage/EncryptionKey.jks /app/EncryptionKey.jks
COPY --from=builder /home/maven/src/${APP}/target/*-${VERSION}.jar /app/spring-boot-application.jar
RUN echo "SPRING_PROFILES_ACTIVE : ${SPRING_PROFILES_ACTIVE}"
RUN ls /app
ENTRYPOINT [ "java", "-jar", "/app/spring-boot-application.jar"]

# ---------------------------------------------