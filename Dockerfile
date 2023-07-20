FROM eclipse-temurin:18=7-alpine
COPY target/*.jar  app/main.jar
CMD ["java","-jar","app/main.jar"]
EXPOSE 8080