FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR gerado para o contêiner
COPY target/gerenciarVeiculos-0.0.1-SNAPSHOT.jar gercenciar-veiculos.jar

# Exponha a porta 8080
EXPOSE 8081

# Defina o comando de inicialização
ENTRYPOINT ["java", "-jar", "gercenciar-veiculos.jar"]