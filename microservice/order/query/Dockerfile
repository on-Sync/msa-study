FROM openjdk:17-ea-11-jdk-slim
VOLUME [ "/data" ]

ENV SPRING_PROFILES_ACTIVE=${PROFILE:-dev}
RUN echo "SPRING_PROFILES_ACTIVE : ${SPRING_PROFILES_ACTIVE}"

ARG APP=${APP:-msa_order_service}
ARG VERSION=${VERSION:-*}
COPY ["target/${APP}-${VERSION}.jar", "${APP}.jar"]

ENTRYPOINT [ "java", "-jar", "${APP}.jar"]
