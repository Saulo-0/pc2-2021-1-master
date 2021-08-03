package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.*;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.BasicConsole;
import pc2.lab.aula09.view.DesenhoBoard;



public class ProgramPaint {

    private FiguraGeometrica[] vetor;
    private BasicConsole tela;
    private DesenhoBoard canvas;

    public ProgramPaint(){
        vetor= new FiguraGeometrica[10];
        tela = new BasicConsole();
        canvas = new DesenhoBoard();
    }

    public void mostrarMenu(){
        Ponto pont1 = new Ponto(0,0);
        Ponto pont2 = new Ponto(5,6);
        Ponto pont3 = new Ponto(2,8);
        Ponto pont4 = new Ponto(4,4);

        Quadrado quadradoNovo = new Quadrado();
        Quadrado quadrado1 = new Quadrado(1);
        Quadrado quadrado2 = new Quadrado(pont1, 5);

        Retangulo rect1 = new Retangulo(1,2);
        Retangulo rect3 = new Retangulo(4,2);
        //Quadrado quadrado2 = new Quadrado(pont1, pont2, pont3,pont4);

        OpcoesMenuEnum opcao = OpcoesMenuEnum.LISTAR;

        do{
            opcao = tela.askOpcaoMenuPrincial();

            tela.showMsg("escolhi: "+ opcao+"\n\n");

            switch (opcao){
                case QUADRADO:
                    Quadrado quad = tela.askQuadrado();
                    insertFiguraGeometrica(quad);
                    break;
                case RETANGULO:
                    Retangulo retangulo = tela.askRetangulo();
                    insertFiguraGeometrica(retangulo);
                    break;
                case CIRCULO:
                    Circulo circle = tela.askCirculo();
                    insertFiguraGeometrica(circle);
                    break;
                case TRIANGULO:
                    Triangulo tri = tela.askTriangulo();
                    insertFiguraGeometrica(tri);
                    break;
                case LOSANGO:
                    Losango losangulo = tela.askLosango();
                    insertFiguraGeometrica(losangulo);
                    break;
                case LISTAR:
                    listar();
                    break;
                case APAGAR:

                    apagar();
                    break;
                case DESENHAR:
                    canvas.desenhar(vetor);
                    break;
                case SAIR:


                    break;
                default:
            }


        }while (opcao != OpcoesMenuEnum.SAIR);
    }

    public boolean insertFiguraGeometrica(FiguraGeometrica fig){

        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] != null && i == 9) {
                tela.showLnMsg("Vetor cheio!");
            }
            if(vetor[i] == null){
               vetor[i] = fig;
               break;
            }
        }
        return true;
    }

    public void listar(){
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] != null) {

                tela.showLnMsg(""+ i + " - "+vetor[i].toString());
            }
        }
    }
    public void apagar(){
        tela.showLnMsg("Vetor a ser apagado:");
        int opcao = tela.askInt();
        for(int i = 0; i < vetor.length; i++){
            if(i == opcao){
                vetor[i] = null;
            }
        }

    }

}
