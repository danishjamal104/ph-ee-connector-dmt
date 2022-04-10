# FROM openjdk:13 AS builder
# COPY . dmt
# WORKDIR /dmt
# RUN ./gradlew --no-daemon -q -x bootJar
# WORKDIR /dmt/build/libs

FROM openjdk:13 as mpesa

# COPY --from=builder /mpesa/build/libs/*.jar ph-ee-connector-dmt-1.0.0-SNAPSHOT.jar

COPY build/libs/*.jar .
CMD java -jar *.jar

