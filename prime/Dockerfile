FROM openjdk:8-jdk-alpine AS build
COPY PrimeChecker.java .
RUN javac PrimeChecker.java

FROM openjdk:8-jre-alpine
COPY --from=build PrimeChecker.class PrimeChecker.class
ENTRYPOINT ["java", "PrimeChecker"]
