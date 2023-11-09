# ProjetoBeneficiario

## Visão Geral
Esta é uma API RESTful desenvolvida em Spring Boot para gerenciar beneficiários e seus documentos associados. A API permite criar, atualizar, listar e excluir beneficiários, bem como listar documentos associados a um beneficiário específico.

## Tecnologias Utilizadas
- InteliJ IDEA
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web
- PostgreSQL
- Maven
- JSON 

## Pré-requisitos
- Java 17
- Maven
- PostgreSQL 

## Configuração
1. Clone este repositório: `git clone https://github.com/EduardGuilherme/ProjetoBeneficiario.git`
2. Navegue até o diretório do projeto: `cd ProjetoBeneficiario`
3. Configure as informações do banco de dados em `src/main/resources/application.properties` (por exemplo, altere o URL, usuário e senha do PostgreSQL).
4. Execute o projeto com Maven: `mvn spring-boot:run`
5. Para criar uma Build do projeto utilize o comando `mvnw install`

## Uso da API
Você pode usar ferramentas como o cURL, Postman ou Insomnia para interagir com a API. Aqui está um exemplo de como criar um novo beneficiário com documentos usando cURL:

```bash
curl -X POST "http://localhost:8080/beneficiario" -H "Content-Type: application/json" -d '{
    "nome": "String",
    "telefone": "String",
    "dataNascimento": "yyyy-mm-dd",
    "documentos": [
        {
            "tipoDocumento": "String",
            "descricao": "String"
        }
    ]
}'

curl -X PUT "http://localhost:8080/beneficiario/{id}" -H "Content-Type: application/json" -d '{
    "nome": "String",
    "telefone": "String",
    "dataNascimento": "yyyy-mm-dd"
    
}'

curl -X DELETE "http://localhost:8080/beneficiario/{id}"
curl -X GET "http://localhost:8080/beneficiario/{id}"
curl -X GET "http://localhost:8080/beneficiario"

