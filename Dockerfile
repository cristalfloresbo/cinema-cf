# Usar una imagen base con JDK 21 y maven
FROM maven:latest AS build

# Establecer un directorio de trabajo
WORKDIR /app

# Copiar archivos de tu proyecto al direstorio de trabajo
COPY . /app

#Ejecutar Maven para construir el proyecto
RUN mvn clean package -DskipTests

# Crear una nueva imagen basada en OpenJDK
FROM openjdk:21

# Exponer el puerto que utilizara la aplicacion
EXPOSE 8080

# Crear el directorio que utilizara la aplicacion
COPY --from=build app/target/peliculas-0.0.1-SNAPSHOT.jar app/peliculas-0.0.1-SNAPSHOT.jar

# Copiar archivos de imagenes al direstorio de trabajo
COPY /archivos /archivos

# Establecer el punto de entrada para ejecutar la aplicacion
ENTRYPOINT ["java", "-jar", "/app/peliculas-0.0.1-SNAPSHOT.jar"]