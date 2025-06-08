# Imagem base Java 17 oficial e leve
FROM eclipse-temurin:17-jdk

# Criação de um usuário não-root com diretório home
RUN useradd -m javauser

# Definindo o diretório de trabalho
WORKDIR /app

# Definindo uma variável de ambiente para o perfil do Spring
ENV SPRING_PROFILES_ACTIVE=prod

# Definindo uma variável de ambiente com o nome do JAR
ENV JAR_FILE=GS-0.0.1-SNAPSHOT.jar

# Copiando o JAR para o container
COPY ${JAR_FILE} app.jar

# Expondo a porta padrão da aplicação
EXPOSE 8080

# Utilizando o usuário não-root
USER javauser

# Comando de execução da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
