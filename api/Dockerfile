FROM localstack/localstack
# Define as variáveis de ambiente
ENV AWS_ACCESS_KEY_ID=your_access_key_id
ENV AWS_SECRET_ACCESS_KEY=your_secret_access_key
ENV AWS_DEFAULT_REGION=us-east-2
ENV AWS_DEFAULT_OUTPUT=json
ENV LOCALSTACK_ENDPOINT=http://localhost:4566

# Copia o arquivo exec-config-aws.sh para a imagem
COPY exec-config-aws.sh /usr/local/bin/exec-config-aws.sh
RUN chmod +x /usr/local/bin/exec-config-aws.sh

# Executa o arquivo exec-config-aws.sh
CMD ["/usr/local/bin/exec-config-aws.sh"]





FROM openjdk:17-jdk-alpine as base
ARG JAR_FILE=out/artifacts/api_jar/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8086

