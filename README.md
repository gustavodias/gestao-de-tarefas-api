# 📑 Gestão de Tarefas - API

Esta API tem como finalidade gerenciar tarefas simples.
Por meio desta API o usuário poderar realizar CRUD basicos referente a Tarefas.

## ⚙️Tecnologias

- JDK 11
- JSF
- PostgreSQL
- H2
- Swagger
- Lombok
- JUnit
- Mockito
- Docker

## ▶️ Executando Projeto

Para a execução do projeto será necessario a instalação do Docker e do JDK 11 em sua máquina;\
Segue link de Download:
- Docker: https://docs.docker.com/desktop/windows/install/

- JDK 11: https://www.oracle.com/java/technologies/downloads/#java11

Após feita a instalação dos Links passados, faça o download ou um Git clone do projeto e execute o seguinte comando na pasta raiz do projeto:
```
$ docker-compose up
```
Após isso, Importe o projeto na IDE de sua preferência, baixe as dependências.

Por padrão o projeto vem configurado no application.properties com o perfil de dev, para usar em modo de teste, mude de:
```
spring.profiles.active=dev
```
Para:
```
spring.profiles.active=test
```

Em seguida execute o projeto.

Endereço da API: http://localhost:8080/tarefas.jr

## 📚 Documentação da API

Através da rota: http://localhost:8080/swagger-ui.html#/

É possivel verificar todas as rotas da API e o que cada uma delas faz.

## 🐘 Configurando pgAdmin

Rota de acesso: http://localhost:8000/\
É necessario a configuração do pgAdmin(docker) com o PostgresBD(docker);\
Credenciais:\
LOGIN: admin@postgres.com\
SENHA: postgres

Link de apoio: https://renatogroffe.medium.com/postgresql-docker-executando-uma-inst%C3%A2ncia-e-o-pgadmin-4-a-partir-de-containers-ad783e85b1a4

## ✍️ Autor

**Gustavo Dias - JAVA Developer**

- Meu Portfólio: https://www.gustavdias.dev/
- Instagram: [@gustavvemerson](https://www.instagram.com/gustavvemerson/)
- Github: [@gustavodias](https://github.com/gustavodias)
- Linkdin: [@gustavoemersonfd](https://www.linkedin.com/in/gustavoemersonfd/)