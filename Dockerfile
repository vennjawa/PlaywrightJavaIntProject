FROM maven:3.9.16-eclipse-temurin-25
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn exec:java \
-e \
-Dexec.mainClass=com.microsoft.playwright.CLI \
-Dexec.args="install --with-deps chromium"
CMD ["mvn", "clean", "test"]