FROM maven:3.8.3-openjdk-17 as build

WORKDIR /app

# Create a first layer to cache the "Maven World" in the local repository.
# Incremental docker builds will always resume after that, unless you update
# the pom
ADD pom.xml .
ADD ./src ./src/

RUN mvn package -DskipTests

# Do the Maven build!
# Incremental docker builds will resume here when you change sources
# ADD src src
# RUN mvn package -DskipTests
# RUN echo "done!"

# 2nd stage, build the runtime image
FROM openjdk:17-jdk

WORKDIR /app

# Copy the binary built in the 1st stage
COPY --from=build /app/target/java-kafka-producer-0.0.1-SNAPSHOT.jar ./

CMD ["java", "-jar", "-XX:+PrintFlagsFinal", "-Xmx256m", "-Xms256m", "java-kafka-producer-0.0.1-SNAPSHOT.jar"]


EXPOSE 8080