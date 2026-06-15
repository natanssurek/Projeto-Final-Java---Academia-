package View;

import Controller.AlunoController;
import Controller.MatriculaController;
import Model.Aluno;
import Model.Matricula;
import util.InputHelper;

import java.util.List;

import static util.InputHelper.scan;

public class MatriculaView {

    private MatriculaController controller = new MatriculaController();
    private AlunoController alunoController = new AlunoController();

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("===== MENU MATRÍCULA =====");
            System.out.println("1. Cadastrar Matrícula");
            System.out.println("2. Alterar Matrícula (por ID ou Nome)");
            System.out.println("3. Deletar Matrícula (por ID ou Nome)");
            System.out.println("4. Listar Todos os Matriculados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    alterar();
                    break;
                case 3:
                    deletar();
                    break;
                case 4:
                    listar();
                    break;
                case 5:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    public void cadastrar() {
        System.out.println("--- NOVA MATRÍCULA ---");

        String id = InputHelper.pegarTexto(">>id: ");
        String aluno = InputHelper.pegarTexto(">>nome: ");
        String plano = InputHelper.pegarTexto(">>plano: ");
        String dataInicio = InputHelper.pegarTexto(">>data de inicio: ");
        String dataFinal = InputHelper.pegarTexto(">>data final: ");


        Matricula novaMatricula = new Matricula(id, aluno, plano, dataInicio, dataFinal, true);

        controller.cadastrarMatricula(novaMatricula);
    }

    public void alterar() {
        System.out.println("--- ALTERAR MATRÍCULA ---");
        System.out.println("|1. Buscar por ID da Matrícula ");
        System.out.println("|2. Buscar por Nome do Aluno");
        int escolha = scan.nextInt();

        Matricula matriculaEncontrada = null;

        if (escolha == 1) {
            String id = InputHelper.pegarTexto("Digite o ID da Matrícula: ");
            matriculaEncontrada = controller.buscaPorId(id);
        } else if (escolha == 2) {
            String nome = InputHelper.pegarTexto("Digite o Nome do Aluno: ");
            for (Matricula m : controller.listarMatriculados()) {
                if (m.getAluno() != null && m.getAluno().getNome().equalsIgnoreCase(nome)) {
                    matriculaEncontrada = m;
                    break;
                }
            }
        }

        if (matriculaEncontrada != null) {
            System.out.println("Matrícula encontrada para o aluno: " + matriculaEncontrada.getAluno().getNome());

            System.out.print("Novo Nome do Plano: ");
            String novoPlano = scan.nextLine();
            matriculaEncontrada.getPlano().setAluno(novoPlano);

            System.out.print("Nova Data de Início: ");
            String novaDataInicio = scan.nextLine();
            matriculaEncontrada.setDataInicio(novaDataInicio);

            System.out.print("Nova Data Final: ");
            String novaDataFinal = scan.nextLine();
            matriculaEncontrada.setDataFinal(novaDataFinal);

            System.out.println("Dados alterados com sucesso!");
        } else {
            System.out.println("Matrícula não encontrada.");
        }
    }

    public void deletar() {
        System.out.println("--- DELETAR MATRÍCULA ---");
        System.out.println("1. Deletar por ID da Matrícula | 2. Deletar por Nome do Aluno");
        int escolha = scan.nextInt();
        scan.nextLine();

        String idParaDeletar = null;

        if (escolha == 1) {
            System.out.print("Digite o ID da Matrícula: ");
            idParaDeletar = scan.nextLine();
        } else if (escolha == 2) {
            System.out.print("Digite o Nome do Aluno: ");
            String nome = scan.nextLine();
            for (Matricula m : controller.listarMatriculados()) {
                if (m.getAluno() != null && m.getAluno().getNome().equalsIgnoreCase(nome)) {
                    idParaDeletar = m.getId();
                    break;
                }
            }
        }

        if (idParaDeletar != null) {
            boolean deletado = controller.removerMatricula(idParaDeletar);
            if (deletado) {
                System.out.println("Matrícula deletada com sucesso!");
            } else {
                System.out.println("Erro ao deletar: ID não encontrado.");
            }
        } else {
            System.out.println("Aluno/Matrícula não encontrado.");
        }
    }

    public void listar() {
        System.out.println("--- LISTA DE MATRICULADOS ---");
        List<Matricula> lista = controller.listarMatriculados();

        if (lista.isEmpty()) {
            System.out.println("Nenhuma matrícula encontrada.");
            return;
        }

        for (Matricula m : lista) {
            System.out.println("------------------------------------------------");
            System.out.println("Matrícula ID: " + m.getId());
            System.out.println("Aluno: [" + m.getAluno());
            System.out.println("Plano: " + m.getPlano());
            System.out.println("Data Início: " + m.getDataInicio());
            System.out.println("Data Término: " + m.getDataFinal());
            System.out.println("Status: " + (m.isAtivo() ? "ATIVA" : "INATIVA"));
        }
        System.out.println("------------------------------------------------");
    }
}