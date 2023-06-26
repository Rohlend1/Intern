FROM maven:latest

WORKDIR /app

COPY . .

RUN mvn clean package

CMD ["java","-jar","target/MovieProject-1.0-SNAPSHOT-jar-with-dependencies.jar"]
