# Utiliza una imagen base de Java 17
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor 
COPY build/libs/crudhelado-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto en el que escucha la aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "app.jar"]

