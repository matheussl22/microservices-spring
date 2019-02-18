FROM frolvlad/alpine-oraclejdk8:slim

ARG SPRING_PROFILES_ACTIVE
ARG STARTUP_SLEEP
ARG JAVA_OPTS
ARG PORT

ENV SPRING_PROFILES_ACTIVE ${SPRING_PROFILES_ACTIVE:-qa}
ENV STARTUP_SLEEP ${STARTUP_SLEEP:-30}
ENV JAVA_OPTS ${JAVA_OPTS:-'-Xmx512m'}
ENV DEBUG_OPTS ${DEBUG_OPTS}
ENV PORT ${PORT:-8080}
ENV CONFIG_SERVER_URL ${CONFIG_SERVER_URL:-http://localhost:8888/health}

#### START OF TIMEZONE RELATED COMMANDS ####
RUN apk update
RUN apk add tzdata
ENV TZ="America/Sao_Paulo"
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
#### END OF TIMEZONE RELATED COMMANDS ####

ADD *.jar /app.jar

VOLUME /tmp

RUN sh -c 'touch /app.jar'

RUN apk update
RUN apk add curl
RUN apk add wget
RUN wget --no-check-certificate https://github.com/jwilder/dockerize/releases/download/v0.1.0/dockerize-linux-amd64-v0.1.0.tar.gz
RUN tar -C /usr/local/bin -xzvf dockerize-linux-amd64-v0.1.0.tar.gz

EXPOSE ${PORT}

COPY entrypoint.sh /usr/local/bin/entrypoint.sh
RUN chmod +x /usr/local/bin/entrypoint.sh

ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]

CMD dockerize -wait ${CONFIG_SERVER_URL} -timeout 60s \
    java ${JAVA_OPTS} ${DEBUG_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar