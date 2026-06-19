# 🏋️ GymTonica

Sistema de gerenciamento de academias desenvolvido em **Java**, utilizando o padrão arquitetural **MVC (Model-View-Controller)** para organizar a estrutura do projeto e facilitar sua manutenção.

O sistema permite o gerenciamento de alunos, personal trainers, matrículas, pagamentos e treinos, além de registrar atividades por meio de um sistema de logs.

---

## 📖 Sobre o Projeto

O GymTonica foi desenvolvido com o objetivo de aplicar conceitos de:

* Programação Orientada a Objetos (POO)
* Arquitetura MVC
* Encapsulamento, Herança e Polimorfismo
* Injeção de Dependência
* Manipulação de Arquivos
* Boas Práticas de Desenvolvimento em Java

---

## 🚀 Funcionalidades

### 👨‍🎓 Alunos

* Cadastrar alunos
* Listar alunos
* Buscar por ID
* Buscar por CPF
* Alterar cadastro
* Excluir aluno
* Geração automática de IDs

### 💪 Personal Trainers

* Cadastrar personal trainers
* Listar personal trainers
* Buscar por ID
* Buscar por CPF
* Buscar por CREF
* Alterar cadastro
* Excluir personal trainer
* Geração automática de IDs

### 📋 Planos

| Plano     | Duração  | Valor     |
| --------- | -------- | --------- |
| Mensal    | 1 mês    | R$ 100,00 |
| Semestral | 6 meses  | R$ 500,00 |
| Anual     | 12 meses | R$ 900,00 |

* Cálculo automático de mensalidades
* Aplicação de descontos por período
* Implementação da interface `Calculavel`

### 📝 Matrículas

* Cadastrar matrícula
* Alterar matrícula
* Remover matrícula
* Listar matrículas
* Vincular aluno a um plano

### 💳 Pagamentos

* Pagamento Presencial
* Pagamento Online
* Alteração de status (Pendente/Pago)
* Busca por ID
* Busca por nome do aluno
* Exclusão de pagamento

### 🏃 Treinos

* Cadastro de treinos
* Associação entre aluno e personal trainer
* Geração automática de rotina

Objetivos disponíveis:

* Hipertrofia
* Emagrecimento
* Definição
* Resistência
* Funcional
* Força Bruta
* Mobilidade

---

## 🛠 Tecnologias Utilizadas

* Java 17+
* Programação Orientada a Objetos (POO)
* Arquitetura MVC
* Collections Framework
* Java Logging API
* Manipulação de Arquivos TXT
* IntelliJ IDEA
* Git
* GitHub

---

## 📂 Estrutura do Projeto

```text
src/
├── Controller/
│   ├── AlunoController.java
│   ├── PersonalController.java
│   ├── MatriculaController.java
│   ├── ControllerPagamento.java
│   └── TreinoController.java
│
├── Model/
│   ├── Pessoa.java
│   ├── Aluno.java
│   ├── PersonalTrainer.java
│   ├── Plano.java
│   ├── Matricula.java
│   ├── Pagamento.java
│   ├── PagamentoOnline.java
│   ├── PagamentoPresencial.java
│   └── Treino.java
│
├── View/
│   ├── MenuPrincipalView.java
│   ├── AlunoView.java
│   ├── PersonalView.java
│   ├── MatriculaView.java
│   ├── PagamentoView.java
│   └── TreinoView.java
│
├── util/
│   ├── InputHelper.java
│   └── Logger.java
│
└── Main.java
```

---

## 🔄 Geração Automática de IDs

Todas as entidades possuem geração automática de identificadores únicos através de contadores estáticos.

Exemplo:

```java
private static int contador = 1;
private String idAluno;

public Aluno(...) {
    super(contador, ...);
    this.idAluno = "ID ALUNO-" + contador++;
}
```

Exemplos de IDs gerados:

```text
ID ALUNO-1
ID PERSONAL-1
MATRICULA-1
ID PAGAMENTO-1
TREINO-1
```

---

## 📊 Sistema de Logs

Os eventos do sistema são registrados em:

```text
logs/gymtonica_log.txt
```

Exemplo:

```text
[18/06/2026 21:00:01] [INFO]  Sistema GymTonica iniciado.
[18/06/2026 21:00:05] [DEBUG] Opção selecionada: 1
[18/06/2026 21:00:10] [INFO]  Acessando menu de Alunos.
[18/06/2026 21:00:15] [ERRO]  Aluno não encontrado.
[18/06/2026 21:00:20] [AVISO] Opção inválida digitada.
```

### Níveis de Log

| Nível | Descrição                                 |
| ----- | ----------------------------------------- |
| INFO  | Operações normais do sistema              |
| DEBUG | Informações internas para desenvolvimento |
| AVISO | Entradas inválidas do usuário             |
| ERRO  | Falhas ou exceções do sistema             |

---

## 🔗 Compartilhamento de Controllers

Todos os controllers são instanciados apenas uma vez na classe principal e compartilhados entre as Views através de injeção de dependência.

```java
AlunoController alunoController = new AlunoController();

AlunoView alunoView = new AlunoView(alunoController);
MatriculaView matriculaView = new MatriculaView(alunoController, matriculaController);
PagamentoView pagamentoView = new PagamentoView(alunoController, controllerPagamento);
TreinoView treinoView = new TreinoView(alunoController, personalController, treinoController);
```

---

## ▶️ Como Executar

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/gymtonica.git
```

### 2. Abrir no IntelliJ IDEA

Importe o projeto normalmente como um projeto Java.

### 3. Executar a aplicação

Execute a classe:

```text
Main.java
```

### 4. Utilizar o sistema

Navegue pelo menu principal utilizando as opções exibidas no terminal.

---

## 🚀 Melhorias Futuras

* Persistência em banco de dados
* Persistência em JSON
* Interface gráfica com JavaFX
* Controle de frequência dos alunos
* Relatórios financeiros
* Dashboard administrativo
* Sistema de autenticação
* Exportação de relatórios em PDF

---

## 👨‍💻 Equipe de Desenvolvimento

* Luiz Eduardo Morawski da Silva
* Maria Clara Paiva
* Natan Spegiorin Surek
* Victor Emanuel

---

## 📄 Licença

Projeto desenvolvido para fins acadêmicos na disciplina de Engenharia de Software.

---

⭐ Se este projeto foi útil para você, considere deixar uma estrela no repositório.
