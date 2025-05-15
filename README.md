# 🗓️ Sistema de Agendamentos

Projeto backend desenvolvido em Java com Spring Boot, simulando um sistema de agendamentos entre clientes e serviços. É possível cadastrar clientes, serviços e realizar agendamentos para datas e horários específicos.

---

## 🚀 Tecnologias Utilizadas

- **Java 22+**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **MySQL**
- **Maven**
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


