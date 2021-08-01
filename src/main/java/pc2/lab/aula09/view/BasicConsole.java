package pc2.lab.aula09.view;

import pc2.lab.aula09.model.Circulo;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.model.Quadrado;

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

    public Quadrado askQuadrado() {
        showMsg("Digite um interio para o tamanho do lado do quadrado: ");
        int tamanho  = in.nextInt();
        Quadrado quad = new Quadrado(tamanho);

        return quad;
    }

    public Circulo askCirculo(){
        showLnMsg("Digite um inteiro para o tamanho do raio: ");
        int tamanhoRaio = in.nextInt();
        Circulo circle = new Circulo(tamanhoRaio);

        return circle;
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
                "1 - Criar Quadrado\n" +
                "2 - Criar Retangulo\n" +
                "3 - Criar Círculo\n" +
                "4 - Criar Losango\n" +
                "6 - Apagar Item\n" +
                "9 - Listar\n" +
                "7 - Desenhar\n" +
                "0 - Sair\n" +
                "Digite aqui sua escolha: ");

        int opcao = in.nextInt();

        switch (opcao){
            case 1:
                return OpcoesMenuEnum.QUADRADO;
            case 2:
                return OpcoesMenuEnum.RETANGULO;
            case 3:
                return OpcoesMenuEnum.CIRCULO;
            case 4:
                return OpcoesMenuEnum.LOSANGO;
            case 7:
                return OpcoesMenuEnum.DESENHAR;
            case 9:
                return OpcoesMenuEnum.SAIR;
            default:
                return OpcoesMenuEnum.SAIR;
        }
    }
}
