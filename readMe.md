# 💼 Plataforma ReUp – Upskilling & Reskilling 2030+

## 💡 Objetivo do Projeto
Projeto desenvolvido como parte da **Global Solution (2025)** da disciplina de **Arquitetura Orientada a Serviços (SOA)** — FIAP, turma **3ESPR**.

O objetivo do projeto é desenvolver uma **API RESTful** para uma **plataforma de Upskilling e Reskilling**, que prepara profissionais para o **futuro do trabalho (2030+)**, promovendo **requalificação contínua**, **educação permanente** e **crescimento profissional sustentável**.

A aplicação permite que:
- Usuários se cadastrem na plataforma;
- Acessem **trilhas de aprendizagem** voltadas a competências do futuro;
- Realizem **matrículas** nessas trilhas para aprimorar ou requalificar suas habilidades.

---

## 🛠️ Tecnologias Utilizadas
| Categoria | Tecnologia | Versão |
|:-----------|:------------|:-------|
| **Linguagem** | Java | 17 |
| **Framework** | Spring Boot | 3.2.5 |
| **Banco de Dados** | PostgreSQL | 16 |
| **Migração DB** | Flyway | `[INCLUÍDO NO POM]` |
| **Validação** | Jakarta Bean Validation | `[INCLUÍDO NO POM]` |
| **Documentação API** | Springdoc OpenAPI / Swagger | `[INCLUÍDO NO POM]` |
| **Build Tool** | Maven |
| **Containerização** | Docker & Docker Compose |

---

## 📐 Estrutura de Arquitetura e Pacotes

O projeto segue o padrão **MVC (Controller → Service → Repository)**, garantindo **separação de responsabilidades** e manutenção facilitada.

| Pacote | Camada | Responsabilidade |
|:--------|:--------|:-----------------|
| `controller` | Controller | Define os endpoints REST e recebe as requisições HTTP. |
| `service` | Service / Domain | Contém as regras de negócio, como lógica de inscrição e validação. |
| `repository` | Repository | Interface de comunicação com o banco de dados via JPA. |
| `domain` | Domain | Contém as **Entidades** (`Usuario`, `Trilha`, `Competencia`, `Matricula`). |
| `dto` | DTOs | Objetos de transferência de dados entre API e domínio. |
| `exceptions` | Infraestrutura | Classes de exceções customizadas e tratadores globais. |
| `config` | Infraestrutura | Configurações da aplicação e do banco de dados. |

---

## 🔑 Regras de Negócio Implementadas

1. **Cadastro de Usuários:**
    - Nome e email obrigatórios.
    - Email deve ter formato válido.

2. **CRUD Completo de Trilhas e Usuários:**
    - Endpoints RESTful para criação, listagem, atualização e exclusão.
    - Retorno de status adequados (`201 Created`, `200 OK`, `404 Not Found`, etc.).

3. **Matrícula em Trilhas:**
    - Um usuário pode se matricular em uma trilha.
    - Data de inscrição gerada automaticamente.
    - Impede duplicidade de matrícula.

4. **Relacionamento N:N entre Trilhas e Competências:**
    - Implementado via tabela intermediária `trilha_competencia`.
    - Adição de competências às trilhas de forma automatizada.

5. **Tratamento de Exceções Centralizado:**
    - Implementação de `@RestControllerAdvice` para retorno de erros consistentes.

---

## ⚙️ Como Executar o Projeto

### 1. 🧰 Pré-requisitos
- [x] **Java 17**
- [x] **Maven**
- [x] **Docker e Docker Compose**

---

### 2. 🐘 Subir o Banco de Dados com Docker

Crie e suba o container PostgreSQL com:

```bash
docker-compose up -d
```

3.  **Acessar a Aplicação:**
    * **API:** `http://localhost:8080`
    * **Swagger UI (Documentação da API):** `http://localhost:8080/swagger-ui.html`

4.  **Parar a Aplicação:**
    ```bash
    docker-compose down
    ```

---
## 🧑‍💻 Autores
* **Nome(s):** `[Enzo Rodrigues (RM553377) | Rafael Cristofali (RM553521) | Hugo Santos (RM553266)]`
* **Repositório:** `https://github.com/FI4P/DDD-SOA-GS01`