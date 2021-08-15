package pc2.lab.aula09.controller;

import pc2.lab.aula09.view.IBasicView;
import pc2.lab.aula09.view.cli.QuadradoConsole;
import pc2.lab.aula09.model.*;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.cli.BasicConsole;
import pc2.lab.aula09.view.DesenhoBoard;
import pc2.lab.aula09.view.gui.CirculoConsole;


public class ProgramPaint {

    private FiguraGeometrica[] vetor;
    private IBasicView tela;
    private CirculoConsole telaCirculo;
    private QuadradoConsole qua = new QuadradoConsole();
    private DesenhoBoard canvas;

    public ProgramPaint(){
        vetor= new FiguraGeometrica[10];
        tela = new BasicConsole();
        canvas = new DesenhoBoard();
        telaCirculo = new CirculoConsole();
    }

    public void mostrarMenu(){

        OpcoesMenuEnum opcao = OpcoesMenuEnum.LISTAR;
        OpcoesMenuEnum opcaosub;

        do{
            opcao = tela.askOpcaoMenuPrincial();

            tela.showMessage("escolhi: "+ opcao+"\n\n");

            switch (opcao){
                case QUADRADO:
                    qua.askSubMenu(this);
                    break;
                case RETANGULO:

                    do {

                        opcaosub = tela.askSubMenu();
                        tela.showMessage("escolhi: " + opcaosub + "\n\n");

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

                    break;
                case CIRCULO:
                    do {

                        opcaosub = tela.askSubMenu();
                        tela.showMessage("escolhi: " + opcaosub + "\n\n");

                        switch (opcaosub) {
                            case NOVO:
                                Circulo circle = telaCirculo.askCirculo();
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

                    break;
                case TRIANGULO:
                    do {

                        opcaosub = tela.askSubMenu();
                        tela.showMessage("escolhi: " + opcaosub + "\n\n");

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

                    break;
                case LOSANGO:
                    do {

                        opcaosub = tela.askSubMenu();
                        tela.showMessage("escolhi: " + opcaosub + "\n\n");

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
;
                     break;
            }


        }while (opcao != OpcoesMenuEnum.SAIR);
    }

    public boolean insertFiguraGeometrica(FiguraGeometrica fig){

        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] != null && i == 9) {
                tela.showLineMessage("Vetor cheio!");
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

                tela.showLineMessage(""+ i + " - "+vetor[i].toString());
            }
        }
    }
    public void apagar(){
        tela.showLineMessage("Vetor a ser apagado:");
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
                tela.showLineMessage(""+ i + " - "+vetor[i].toString());
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
