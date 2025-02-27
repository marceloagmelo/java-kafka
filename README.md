# Java com Kafka

Criação de um CRUD para poder criar, alterar e excluir clientes, utilizando um Resp API. O projeto também criar um producer e consumer em kafka para poder fazer executar o CRUD também.

Utilizar:

- Banco de dados MySql.
- Adminer para administrar o banco de dados.
- Criação de queries usando JPA respository.
- Enviar processamento de cliente usando o Kafka (Producer).
- Receber o processo de cliente usando o Kafka (Consumer).
- Criação da imagem com a aplicação rodando em container docker.

## Regras do CRUD de cliente

Criar:

- Se o cliente não existir, incluir.
- Se o cliente existir, exibe mensagem "Cliente já existe!".

Alterar:

- Se o cliente não existir, exibe mensagem "Cliente não encontrado!".
- Se o cliente existir, executar alteração.

Excluir:

- Se o cliente não existir, exibe mensagem "Cliente não encontrado!".
- Se o cliente existir, executar exclusão.

Listar:

- Listar os clientes cadastrados.

## Início

Exeuctar o seguinte comando:

```
./scripts/startContainers.sh
```

Irão subir os containers e um de apoio:

- Adminer: Aplicação web para administrar o banco de dados

> http://localhost:7070

    Servidor: mysql
    Usuário: root
    Senha: 12345
    Banco de Dados: teste-kafka

## _Serviços_

## Cliente

### Criar

```
Method: POST
URL: http://localhost:8080/clientes
Body (json):
{
"nome": "nome"
}
```

### Alterar

```
Method: PUT
URL: http://localhost:8080/clientes/{id}

Body (json):
{
"nome": "nome"
}
```

### Excluir

```
Method: DELETE
URL: http://localhost:8080/clientes/{id}
```

### Listar

```
Method: GET
URL: http://localhost:8080/clientes/listar
```

## Mensageria

### Enviar um processo de cliente

#### Criar

```
Method: POST
URL: http://localhost:8080/clientes/send
Body (json):
{
"nome": "nome",
"acao": "I"
}
```

#### Alterar

```
Method: POST
URL: http://localhost:8080/clientes/send
Body (json):
{
"id": id,
"nome": "nome",
"acao": "A"
}
```

#### Excluir

```
Method: POST
URL: http://localhost:8080/clientes/send
Body (json):
{
"id": id,
"nome": "nome",
"acao": "E"
}

```

### Receber exclusão pela mensageria

O serivço de mensageria ira ler as solicitações e irá executar o os serviõs solicitaods para atualizar no banco de dados.

## Observação

O projeto também roda executando por intermédio de uma IDE, basta abrir o projeto na sua IDE preferencial, mas necessita que antes suba um container de rabbitmq, executando o comando abaixo:

```
./scripts/startContainerParcial.sh
```

E executar as aplicações pela IDE e acessar os containers
