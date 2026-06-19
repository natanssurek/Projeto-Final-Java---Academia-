GymTonica — Sistema de Gerenciamento de Academia
Descrição
O GymTonica é um sistema de gerenciamento de academia desenvolvido em Java, seguindo o padrão arquitetural MVC (Model-View-Controller). O sistema permite gerenciar alunos, personal trainers, matrículas, pagamentos e treinos de forma integrada, com geração automática de IDs e registro de logs em arquivo .txt.

Tecnologias Utilizadas 

Java 17+
Paradigma de Orientação a Objetos
Padrão MVC
java.util.logging para logs
Arquivo .txt para persistência de logs


Estrutura do Projeto
src/
├── Controller/
│   ├── AlunoController.java
│   ├── PersonalController.java
│   ├── MatriculaController.java
│   ├── ControllerPagamento.java
│   └── TreinoController.java
│
├── Model/
│   ├── Pessoa.java (abstract)
│   ├── Aluno.java
│   ├── PersonalTrainer.java
│   ├── Plano.java
│   ├── Matricula.java
│   ├── Pagamento.java (abstract)
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

Funcionalidades
Alunos

Cadastrar, listar, buscar por ID ou CPF, alterar e deletar alunos
Geração automática de ID no formato ID ALUNO-1, ID ALUNO-2...
Vinculação de plano no cadastro (Mensal, Semestral ou Anual)

Personal Trainers

Cadastrar, listar, buscar por ID, CPF ou CREF, alterar e deletar
Geração automática de ID no formato ID PERSONAL-1, ID PERSONAL-2...

Planos

Três planos fixos disponíveis:

Mensal — R$ 100,00 / 1 mês
Semestral — R$ 500,00 / 6 meses
Anual — R$ 900,00 / 12 meses


Cálculo automático de mensalidade e desconto via interface Calculavel

Matrículas

Matricular aluno em um plano
Alterar, remover e listar matrículas
Geração automática de ID no formato MATRICULA-1, MATRICULA-2...

Pagamentos

Dois tipos: Presencial e Online
Cadastrar, alterar status (pendente/pago), deletar e listar
Busca por ID do pagamento ou nome do aluno
Geração automática de ID no formato ID PAGAMENTO-1, ID PAGAMENTO-2...

Treinos

Cadastrar treino vinculando aluno e personal trainer
7 tipos de objetivo disponíveis: Hipertrofia, Emagrecimento, Definição, Resistência, Funcional, Força Bruta e Mobilidade
Cada objetivo define automaticamente duração e rotina
Geração automática de ID no formato TREINO-1, TREINO-2...


Geração Automática de IDs
Todas as entidades geram seus próprios IDs automaticamente via contador estático, sem necessidade de input do usuário:
javaprivate static int contador = 1;
private String idAluno;

public Aluno(...) {
super(contador, ...);
this.idAluno = "ID ALUNO-" + contador++;
}

Sistema de Log
O sistema registra as atividades em console e em arquivo logs/gymtonica_log.txt com três níveis:
[18/06/2026 21:00:01] [INFO]  Sistema GymTonica iniciado.
[18/06/2026 21:00:05] [DEBUG] Opção selecionada: 1
[18/06/2026 21:00:10] [INFO]  Acessando menu de Alunos.
[18/06/2026 21:00:15] [ERRO]  Aluno não encontrado: ID ALUNO-99.
[18/06/2026 21:00:20] [AVISO] Opção inválida digitada: 9.
Níveis de log:

INFO — ações normais do sistema
DEBUG — detalhes internos de navegação
AVISO — entradas inválidas do usuário
ERRO — falhas como entidade não encontrada


Compartilhamento de Controllers
Todos os controllers são instanciados uma única vez na Main e injetados nas Views via construtor, garantindo que todas as Views compartilhem a mesma lista de dados:
javaAlunoController alunoController = new AlunoController();

AlunoView alunoView = new AlunoView(alunoController);
MatriculaView matriculaView = new MatriculaView(alunoController, matriculaController);
PagamentoView pagamentoView = new PagamentoView(alunoController, controllerPagamento);
TreinoView treinoView = new TreinoView(alunoController, personalController, treinoController);

Como Executar

Clone o repositório
Abra o projeto no IntelliJ IDEA
Execute a classe Main.java
Navegue pelo menu principal digitando o número da opção desejada
Os logs serão salvos automaticamente em logs/gymtonica_log.txt


Melhorias Futuras

Persistência de dados em banco de dados ou arquivo JSON
Interface gráfica (JavaFX)
Relatórios de pagamentos por período
Controle de frequência dos alunos
Autenticação de usuário administrador
