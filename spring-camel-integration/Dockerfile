# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo en /app
WORKDIR /spring-camel-integration

# Copia el archivo JAR generado por Maven a la imagen
COPY target/spring-camel-integration-1.0.0-SNAPSHOT.jar app.jar

# Expone el puerto 8080
EXPOSE 8080

# Ejecuta la aplicación al iniciar el contenedor
CMD ["java", "-jar", "app.jar"]
