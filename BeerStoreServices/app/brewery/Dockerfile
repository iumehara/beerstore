FROM openjdk:11

WORKDIR /brewery

COPY build/libs/brewery-0.0.1-SNAPSHOT.jar /brewery

EXPOSE 7070

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://brewery_db:5432/brewery_dev
ENV SPRING_DATASOURCE_USERNAME=brewery_dev
ENV SPRING_DATASOURCE_PASSWORD=secret

ENTRYPOINT ["java","-jar","/brewery/brewery-0.0.1-SNAPSHOT.jar"]
