# Build stage
FROM maven:3.9.12-eclipse-temurin-21-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Instalar curl para health check
RUN apk add --no-cache curl

# Copiar JAR do builder
COPY --from=builder /app/target/*.jar app.jar

# Expor a porta configurada no seu yml
EXPOSE 5002

# Health check ajustado para a porta 5002
HEALTHCHECK --interval=30s --timeout=10s --start-period=40s --retries=3 \
    CMD curl -f http://localhost:5002/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]