FROM openjdk:17-oracle
COPY build/libs/*.jar UserService.jar
EXPOSE 1111
CMD ["java", "-jar",  "UserService.jar"]