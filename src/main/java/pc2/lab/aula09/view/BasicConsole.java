package pc2.lab.aula09.view;

import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.model.Circulo;
import pc2.lab.aula09.model.Quadrado;
import pc2.lab.aula09.model.Losango;
import pc2.lab.aula09.model.Triangulo;
import pc2.lab.aula09.model.Retangulo;

import java.util.Scanner;

public class BasicConsole {

    protected Scanner in;

    public BasicConsole(){
        in = new Scanner(System.in);
    }

    public void showLnMsg(String msg){
        System.out.println(msg);
    }

    public void showMsg(String msg){
        System.out.print(msg);
    }

    public int askInt(String msg){
        showMsg(msg);
        return in.nextInt();
    }

    public OpcoesMenuEnum askSubMenu(){
        showMsg("MENU\n"+
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
        showMsg("Digite um interio para o tamanho da base do retângulo: ");
        int base = in.nextInt();
        showMsg("Digite um interio para o tamanho da altura do retângulo: ");
        int altura = in.nextInt();
        Retangulo ret = new Retangulo(base , altura);
        return ret;
    }

    public Circulo askCirculo(){
        showLnMsg("Digite um inteiro para o tamanho do raio: ");
        int tamanhoRaio = in.nextInt();
        Circulo circle = new Circulo(tamanhoRaio);
        return circle;
    }

    public Losango askLosango() {
        showLnMsg("Digite um inteiro para o tamanho da diagonal maior: ");
        int diagonalMaior= in.nextInt();
         showLnMsg("Digite um inteiro para o tamanho da diagonal menor: ");
         int diagonalMenor = in.nextInt();
         Losango losangulo = new Losango(diagonalMaior , diagonalMenor);
        return losangulo;
    }

    public Triangulo askTriangulo() {
        showLnMsg("Digite um inteiro para o ladoA: ");
        int ladoA = in.nextInt();
        showLnMsg("Digite um inteiro para o ladoB: ");
        int ladoB = in.nextInt();
        showLnMsg("Digite um inteiro para o ladoC: ");
        int ladoC = in.nextInt();
        Triangulo tri = new Triangulo(ladoA , ladoB , ladoC);
        return tri;
    }

    public int askInt(){
        return in.nextInt();
    }

    public boolean hasNextInt(){
        return in.hasNextInt();
    }

    public OpcoesMenuEnum askOpcaoMenuPrincial(){
        //Loop até entregar uma opção válida
        showMsg("Digite uma opção \n" +
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
