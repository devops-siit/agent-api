FROM maven:3.8.5-openjdk-18 AS build
COPY src /src
COPY pom.xml /
RUN --mount=type=cache,target=/root/.m2 mvn -f /pom.xml -P dev clean package -DskipTests=true

FROM openjdk:18-oracle
COPY --from=build target/*.jar /agentapi.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/agentapi.jar"]
