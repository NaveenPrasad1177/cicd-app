FROM eclipse-temurin:17-jdk
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# Look inside target/ folder
# Copy JAR into container