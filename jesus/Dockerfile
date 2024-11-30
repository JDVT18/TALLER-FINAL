# Usa una imagen de Java como base
FROM openjdk:17-jdk-slim

# Crea un directorio para la aplicación
WORKDIR /app

# Copia el archivo JAR al contenedor
COPY target/Tallerfinal-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que usa la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar","app.jar"]