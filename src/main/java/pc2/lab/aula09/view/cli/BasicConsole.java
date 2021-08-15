package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.model.Losango;
import pc2.lab.aula09.model.Triangulo;
import pc2.lab.aula09.model.Retangulo;
import pc2.lab.aula09.view.IBasicView;

import java.util.Scanner;

public class BasicConsole implements IBasicView {

    protected Scanner in;

    public BasicConsole(){
        in = new Scanner(System.in);
    }

    public void showLineMessage(String msg){
        System.out.println(msg);
    }

    public void showMessage(String msg){
        System.out.print(msg);
    }

    public int askForInt(String msg){
        showMessage(msg);
        return in.nextInt();
    }

    public OpcoesMenuEnum askSubMenu(){
        showMessage("MENU\n"+
                "Digite uma opção: \n" +
                "1 - Novo (Criar/Adicionar novo item)\n" +
                "2 - Editar (Selecionar Id e Editar)\n" +
                "3 - Listar (Listar Itens do Tipo) \n" +
                "4 - Mostrar (Listar detalhes de 1 Itens) \n" +
                "5 - Excluir (Excluir Id)\n" +
                "X - Voltar\n");

        String opcao = in.next();

        switch (opcao){
            case"1":
                return OpcoesMenuEnum.NOVO;
            case "2":
                return OpcoesMenuEnum.EDITAR;
            case "3":
                return OpcoesMenuEnum.LISTAR;
            case "4":
                return OpcoesMenuEnum.MOSTRAR;
            case "5":
                return OpcoesMenuEnum.EXCLUIR;
            case "X":
                return OpcoesMenuEnum.VOLTAR;
            default:
                return OpcoesMenuEnum.SAIR;
        }

    }

    public Retangulo askRetangulo(){
        showMessage("Digite um interio para o tamanho da base do retângulo: ");
        int base = in.nextInt();
        showMessage("Digite um interio para o tamanho da altura do retângulo: ");
        int altura = in.nextInt();
        Retangulo ret = new Retangulo(base , altura);
        return ret;
    }


    public int askInt(){
        return in.nextInt();
    }

    @Override
    public double askForDouble(String question) {
        return 0;
    }

    @Override
    public String askForString(String question) {
        return null;
    }

    public boolean hasNextInt(){
        return in.hasNextInt();
    }

    public OpcoesMenuEnum askOpcaoMenuPrincial(){
        //Loop até entregar uma opção válida
        showMessage("Digite uma opção \n" +
                "1 - Criar Texto\n" +
                "2 - Criar Reta\n" +
                "3 - Criar Quadrado\n" +
                "4 - Criar Retangulo\n" +
                "5 - Criar Círculo\n" +
                "6 - Criar Losango\n" +
                "7 - Criar Triângulo\n" +
                "D - Desenhar\n" +
                "L - Listar\n" +
                "A - Apagar Item\n" +
                "S - Salvar\n" +
                "R - Recarregar\n" +
                "X - Sair\n" +
                "Digite aqui sua escolha: ");

        String opcao = in.next();

        switch (opcao){
            case"1":
                return OpcoesMenuEnum.TEXTO;
            case "2":
                return OpcoesMenuEnum.RETA;
            case "3":
                return OpcoesMenuEnum.QUADRADO;
            case "4":
                return OpcoesMenuEnum.RETANGULO;
            case "5":
                return OpcoesMenuEnum.CIRCULO;
            case "6":
                return OpcoesMenuEnum.LOSANGO;
            case "7":
                return OpcoesMenuEnum.TRIANGULO;
            case "D":
                return OpcoesMenuEnum.DESENHAR;
            case "L":
                return OpcoesMenuEnum.LISTAR;
            case "A":
                return OpcoesMenuEnum.APAGAR;
            case "S":
                return OpcoesMenuEnum.SALVAR;
            case "R":
                return OpcoesMenuEnum.RECARREGAR;
            case "X":
                return OpcoesMenuEnum.SAIR;
            default:
                return OpcoesMenuEnum.SAIR;
        }
    }
}
