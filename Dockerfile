# Fase de construcción: usar Maven para construir el proyecto
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Fase de ejecución: usar una imagen base de OpenJDK para ejecutar el JAR generado
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiar el JAR generado desde la fase de construcción al contenedor
COPY --from=build /app/target/videoteca-app-1.0-SNAPSHOT.jar app.jar

# Exponer el puerto 8080 para que la aplicación sea accesible
EXPOSE 8080

# Comando para ejecutar el JAR
CMD ["java", "-jar", "app.jar"]
