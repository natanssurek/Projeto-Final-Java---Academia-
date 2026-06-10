# 🏋️ Academia GymTonica — Sistema de Gerenciamento

Sistema de gerenciamento de academia desenvolvido em Java, aplicando os princípios de **Programação Orientada a Objetos** com arquitetura **MVC (Model-View-Controller)**.

---

## 📋 Sobre o Projeto

O GymTonica é um sistema console para administração de uma academia, permitindo o cadastro e gerenciamento de alunos, personal trainers, planos, matrículas, treinos e pagamentos.

---

## 🏗️ Arquitetura

O projeto segue o padrão **MVC**, dividido em três camadas:

```
src/
├── model/          # Entidades e regras de negócio
├── controller/     # Lógica de controle e manipulação dos dados
└── view/           # Interface com o usuário (menus e interações)
```

---

## 📦 Model

### Classes Abstratas

**`Pessoa` (Abstract)**
- Atributos: `id`, `nome`, `cpf`, `email`, `telefone`
- Métodos: `calcularIdade()` *(abstract)*, getters e setters

**`Pagamento` (Abstract)**
- Atributos: `id`, `aluno`, `valor`, `data`, `status`
- Métodos: `calcularTotal()` *(abstract)*, `getTipoPagamento()` *(abstract)*, getters e setters

### Classes Concretas

**`Aluno` extends `Pessoa`**
- Atributos: `matricula`, `objetivo`, `dataNascimento`
- Métodos: `calcularIdade()`, getters e setters

**`PersonalTrainer` extends `Pessoa`**
- Atributos: `cref`, `especialidade`, `List<Aluno> alunos`
- Métodos: `calcularIdade()`, `adicionarAlunos()`, `remover()`, getters e setters

**`Plano` implements `Calculavel`**
- Atributos: `id`, `nome`, `valor`, `duracaoMeses`, `descricao`
- Métodos: `calcularMensalidade()`, `calcularDesconto()`, getters e setters

**`Matricula`**
- Atributos: `id`, `aluno`, `plano`, `dataInicio`, `dataVencimento`, `ativa`
- Métodos: `ativar()`, `desativar()`, `isAtiva()`, getters e setters

**`Treino`**
- Atributos: `id`, `aluno`, `personal`, `data`, `tipo`, `duracaoMinutos`, `observacao`
- Métodos: getters e setters

**`PagamentoOnline` extends `Pagamento` implements `Pagavel`**
- Atributos: `plataforma`, `taxaOnline`
- Métodos: `pagar(Double)`, `pagar(Double, String)`, `calcularTotal()`, `getTipoPagamento()`, getters e setters

**`PagamentoPresencial` extends `Pagamento` implements `Pagavel`**
- Atributos: `formaPagamento`
- Métodos: `pagar(Double)`, `pagar(Double, String)`, `calcularTotal()`, `getTipoPagamento()`, getters e setters

### Interfaces

**`Calculavel`**
- `calcularMensalidade()`
- `calcularDesconto(Double)`

**`Pagavel`**
- `pagar(double)`
- `pagar(double, String)`
- `calcularTotal()`

---

## 🎮 Controller

Cada controller gerencia uma entidade e expõe os seguintes métodos padrão:

| Controller | Métodos |
|---|---|
| `AlunoController` | `cadastrar()`, `alterar()`, `deletar()`, `listarTodos()`, `buscarPorId()` |
| `PlanoController` | `cadastrar()`, `alterar()`, `deletar()`, `listarTodos()`, `buscarPorId()` |
| `TreinoController` | `cadastrar()`, `alterar()`, `deletar()`, `listarTodos()`, `buscarPorId()`, `listarPorAluno()` |
| `MatriculaController` | `cadastrar()`, `alterar()`, `deletar()`, `listarTodos()`, `buscarPorId()`, `buscarPorAluno()` |
| `PersonalController` | `cadastrar()`, `alterar()`, `deletar()`, `listarTodos()`, `buscarPorId()` |
| `PagamentoController` | `cadastrar()`, `alterar()`, `deletar()`, `listarTodos()`, `buscarPorId()`, `listarPorAluno()` |

---

## 🖥️ View

| View | Métodos |
|---|---|
| `MenuPrincipal` | `exibirMenu()`, `cadastrar()`, `alterar()`, `deletar()`, `listar()`, `exibir()`, `redirecionarOpcao()` |
| `AlunoView` | `exibirMenu()`, `cadastrar()`, `alterar()`, `deletar()`, `listar()` |
| `PlanoView` | `exibirMenu()`, `cadastrar()`, `alterar()`, `deletar()`, `listar()` |
| `TreinoView` | `exibirMenu()`, `cadastrar()`, `alterar()`, `deletar()`, `listar()` |
| `MatriculaView` | `exibirMenu()`, `cadastrar()`, `alterar()`, `deletar()`, `listar()` |
| `PagamentoView` | `exibirMenu()`, `cadastrarPresencial()`, `cadastrarOnline()`, `alterar()`, `deletar()`, `listar()` |

---

## 🧠 Conceitos de POO Aplicados

- **Herança** — `Aluno` e `PersonalTrainer` estendem `Pessoa`; `PagamentoOnline` e `PagamentoPresencial` estendem `Pagamento`
- **Abstração** — Classes abstratas `Pessoa` e `Pagamento` com métodos abstratos
- **Polimorfismo** — Implementações distintas de `calcularTotal()` e `getTipoPagamento()` em cada tipo de pagamento
- **Encapsulamento** — Atributos privados acessados por getters e setters
- **Interfaces** — `Calculavel` e `Pagavel` definem contratos de comportamento

---

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/gymtonica.git
   ```

2. Compile o projeto:
   ```bash
   javac -d bin src/**/*.java
   ```

3. Execute:
   ```bash
   java -cp bin Main
   ```

> **Requisitos:** Java 11 ou superior.

---

## 👥 Autores

Desenvolvido como trabalho final da disciplina de Java.