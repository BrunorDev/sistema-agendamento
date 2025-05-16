# 🗓️ Sistema de Agendamentos

Projeto backend desenvolvido em Java com Spring Boot, simulando um sistema de agendamentos entre clientes e serviços. É possível cadastrar clientes, serviços e realizar agendamentos para datas e horários específicos.

---

## 🚀 Tecnologias Utilizadas

- **Java 22+**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **Loombock**
- **ModelMapper** (para conversão de entidades para DTOs)

---

## 📦 Funcionalidades

- ✅ Cadastro, listagem, atualização e exclusão de **clientes**
- ✅ Cadastro, listagem, atualização e exclusão de **serviços**
- ✅ Agendamento de horários com:
  - Validação de conflito de horário
  - Associação entre cliente e serviço
  - Filtro de agendamentos por data

---

## 📁 Estrutura do Projeto

- **Config: Configuração do ModelMapper e Swagger**
- **Controller: Recebe e processa as requisições HTTP.**
- **dto: Objetos de transferência de dados (Data Transfer Objects)**
- **Entity: Entidades JPA representando as tabelas do banco**
- **Service: Contém a Regra de negócio da aplicação.**
- **Repository: Interface para comunicação com o banco de dados.**
- **Mapper: Conversão entre entidades e DTOs (ModelMapper, por exemplo)**
---

## 🧪 Exemplos de Requisição

### 🔹 Criar Cliente

```json
POST /clientes
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "telefone": "11999998888"
}
```

### 🔹 Criar Serviço

```json
POST /servicos
{
  "nome": "Corte de cabelo",
  "preco": 50.0
}
```

### 🔹 Criar Agendamento

```json
POST /agendamentos
{
  "clienteId": 1,
  "servicoId": 2,
  "dataHora": "2025-05-20T14:00:00"
}
```

### 🔹 Buscar Agendamentos por Data

```
GET /agendamentos?data=2025-05-20
```

---

## 🔧 Configuração do Projeto

Clone o repositório:

```bash
git clone <URL do repositório>
```

Acesse a pasta do projeto:

```bash
cd Produtos-API
```

Configure as dependências com o Maven:

```bash
mvn clean install
```

Execute a aplicação:

```bash
mvn spring-boot:run
```
---
## 📌 Considerações Finais
Desenvolvido por [Bruno Reis 👨‍💻](https://www.linkedin.com/in/bruno-reis-oliveira/)

