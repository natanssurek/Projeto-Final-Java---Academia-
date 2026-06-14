package View;

import Model.Plano;
import util.InputHelper;

import java.util.ArrayList;

public class PlanoView {
    private ArrayList<Plano> listaPlanos = new ArrayList<>();

    public void exibirMenu(){
        int opcao = -1;
        while (opcao != 0) {
            System.out.printf("====== MENU PLANO ======");
            System.out.printf("1 - CADASTRAS");
            System.out.printf("2 - ALTERAR");
            System.out.printf("3 - DELETAR");
            System.out.printf("4 - LISTAR");
            System.out.printf("0 - SAIR");
            opcao = InputHelper.pegarNumInteiro("Selecione a opção que deseja");

            switch (opcao){
                case 1: cadastrar(); break;
                case 2: alterar(); break;
                case 3: deletar(); break;
                case 4: listar(); break;
                case 0: System.out.println("Saindo..."); break;
            }
        }
    }
    public  void cadastrar(){
        Plano plano = new Plano();

        plano.setId(InputHelper.pegarTexto("ID: "));
        plano.setAluno(InputHelper.pegarTexto("Nome do Aluno: "));
        plano.setValor(InputHelper.pegarNumDouble("Valor: "));
        plano.setDuracaoMeses(InputHelper.pegarNumInteiro("Duração em meses"));
        plano.setDescricao(InputHelper.pegarTexto("Descrição"));

        listaPlanos.add(plano);
        System.out.println("Plano cadastrado com sucesso!!!");
    }
    public void alterar(){
        String id = InputHelper.pegarTexto("ID do pano a alterar: ");

        for (Plano p : listaPlanos){
            if (p.getId().equals(id)){
                p.setValor(InputHelper.pegarNumDouble("Novo valor: "));
                p.setDuracaoMeses(InputHelper.pegarNumInteiro("Nova duração "));
                p.setDescricao(InputHelper.pegarTexto("Nova descrição: "));
                System.out.println("Plano alterado com sucesso!");
                return;
            }
        }
        System.out.println("Plano não encontrado!!!");
    }
    public void deletar(){
        String id = InputHelper.pegarTexto("ID do plano a deletar: ");
        for (Plano p: listaPlanos){
            if (p.getId().equals(id)){
                listaPlanos.remove(p);
                System.out.println("PLANO DELETADO COM SUCESSO!!!");
                return;
            }
        }
        System.out.println("Plano não encontrado!!!");
    }
    public void listar(){
        if (listaPlanos.isEmpty()) {
            System.out.println("Nenhum plano cadastrado.");
            return;
        }
        for (Plano p: listaPlanos){
            System.out.println("========================================");
            System.out.println("ID: " + p.getId());
            System.out.println("Aluno: " + p.getAluno());
            System.out.println("Valor:" + p.getValor());
            System.out.println("Duração:" + p.getDuracaoMeses() + "meses");
            System.out.println("Mensalidade: R$ " + p.calcularMensalidade());
            System.out.println("Descrição " + p.getDescricao());
            System.out.println("========================================");
        }
    }
}
