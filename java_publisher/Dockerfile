FROM anapsix/alpine-java
RUN mkdir /app
WORKDIR /app
COPY target/natsio-java-publisher-jar-with-dependencies.jar /app
CMD ["java","-jar", "natsio-java-publisher-jar-with-dependencies.jar"]