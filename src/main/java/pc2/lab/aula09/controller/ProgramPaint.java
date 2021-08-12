package pc2.lab.aula09.controller;

import pc2.lab.aula09.view.QuadradoConsole;
import pc2.lab.aula09.model.*;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.BasicConsole;
import pc2.lab.aula09.view.DesenhoBoard;



public class ProgramPaint {

    private FiguraGeometrica[] vetor;
    private BasicConsole tela;
    private QuadradoConsole qua = new QuadradoConsole();
    private DesenhoBoard canvas;

    public ProgramPaint(){
        vetor= new FiguraGeometrica[10];
        tela = new BasicConsole();
        canvas = new DesenhoBoard();
    }

    public void mostrarMenu(){

        OpcoesMenuEnum opcao = OpcoesMenuEnum.LISTAR;
        OpcoesMenuEnum opcaosub;

        do{
            opcao = tela.askOpcaoMenuPrincial();

            tela.showMsg("escolhi: "+ opcao+"\n\n");

            switch (opcao){
                case QUADRADO:
                    qua.askSubMenu(this);
                    break;
                case RETANGULO:

                    do {

                        opcaosub = tela.askSubMenu();
                        tela.showMsg("escolhi: " + opcaosub + "\n\n");

                        switch (opcaosub) {
                            case NOVO:
                                Retangulo ret = qua.askRetangulo();
                                insertFiguraGeometrica(ret);
                                break;
                            case EDITAR:

                                break;
                            case LISTAR:
                                listar(4);
                                break;
                            case MOSTRAR:

                                break;
                            case EXCLUIR:
                                excluir(4);
                                break;
                            case VOLTAR:

                                break;
                            case SAIR:
                                break;
                            default:
                                break;
                        }


                    } while (opcaosub != OpcoesMenuEnum.SAIR);

                    Retangulo retangulo = tela.askRetangulo();

                    insertFiguraGeometrica(retangulo);

                    break;
                case CIRCULO:
                    do {

                        opcaosub = tela.askSubMenu();
                        tela.showMsg("escolhi: " + opcaosub + "\n\n");

                        switch (opcaosub) {
                            case NOVO:
                                Circulo circle = qua.askCirculo();
                                insertFiguraGeometrica(circle);
                                break;
                            case EDITAR:

                                break;
                            case LISTAR:
                                listar(5);
                                break;
                            case MOSTRAR:

                                break;
                            case EXCLUIR:
                                excluir(5);
                                break;
                            case VOLTAR:

                                break;
                            case SAIR:
                                break;
                            default:
                                break;
                        }


                    } while (opcaosub != OpcoesMenuEnum.SAIR);

                    Circulo circle = tela.askCirculo();

                    insertFiguraGeometrica(circle);
                    break;
                case TRIANGULO:
                    do {

                        opcaosub = tela.askSubMenu();
                        tela.showMsg("escolhi: " + opcaosub + "\n\n");

                        switch (opcaosub) {
                            case NOVO:
                                Triangulo tri = qua.askTriangulo();
                                insertFiguraGeometrica(tri);
                                break;
                            case EDITAR:

                                break;
                            case LISTAR:
                                listar(7);
                                break;
                            case MOSTRAR:

                                break;
                            case EXCLUIR:
                                excluir(7);
                                break;
                            case VOLTAR:

                                break;
                            case SAIR:
                                break;
                            default:
                                break;
                        }


                    } while (opcaosub != OpcoesMenuEnum.SAIR);

                    Triangulo tri = tela.askTriangulo();

                    insertFiguraGeometrica(tri);
                    break;
                case LOSANGO:
                    do {

                        opcaosub = tela.askSubMenu();
                        tela.showMsg("escolhi: " + opcaosub + "\n\n");

                        switch (opcaosub) {
                            case NOVO:
                                Losango losangulo = qua.askLosango();
                                insertFiguraGeometrica(losangulo);
                                break;
                            case EDITAR:

                                break;
                            case LISTAR:
                                listar(6);
                                break;
                            case MOSTRAR:

                                break;
                            case EXCLUIR:
                                excluir(6);
                                break;
                            case VOLTAR:

                                break;
                            case SAIR:
                                break;
                            default:
                                break;
                        }


                    } while (opcaosub != OpcoesMenuEnum.SAIR);

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
             // retângulo
    public void listar(int hash){
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] != null && hash == vetor[i].hashCode()) {
                tela.showLnMsg(""+ i + " - "+vetor[i].toString());
            }
        }
    }

    public void excluir(int hash){
        for(int i = 0; i < vetor.length; i++){
            if(hash == vetor[i].hashCode()){
                vetor[i] = null;
            }
        }
    }
}
