FROM openjdk:10-jdk
ADD /target/Movie-Service-0.0.1-SNAPSHOT.jar /dockerfs/app/Movie-Service-0.0.1-SNAPSHOT.jar
WORKDIR /dockerfs/app
ENTRYPOINT ["java","-jar","Movie-Service-0.0.1-SNAPSHOT.jar"]
