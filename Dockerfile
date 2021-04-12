FROM adoptopenjdk/openjdk11

ENV PROFILE=local
ENV PROJECT_NAME=config-client

EXPOSE 8080

COPY . /app/${PROJECT_NAME}
WORKDIR /app/${PROJECT_NAME}

RUN ./gradlew bootJar

CMD sleep 5m && java -jar -Dspring.profiles.active=${PROFILE} ./build/libs/${PROJECT_NAME}.jar