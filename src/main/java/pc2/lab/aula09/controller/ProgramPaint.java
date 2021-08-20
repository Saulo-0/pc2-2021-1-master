package pc2.lab.aula09.controller;

import pc2.lab.aula09.dao.FigurasGeometricasDAO;
import pc2.lab.aula09.view.IBasicView;
import pc2.lab.aula09.model.*;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.IMenuView;
import pc2.lab.aula09.view.cli.*;
import pc2.lab.aula09.view.DesenhoBoard;
import pc2.lab.aula09.view.gui.CirculoConsole;

public class ProgramPaint {

    private IMenuView menuTela;
    private FiguraGeometrica[] vetor;
    private FigurasGeometricasDAO dao;
    private IBasicView tela;
    private DesenhoBoard canvas;
    private CirculoConsole telaCirculo;
    private TrianguloConsole telaTriangulo;
    private LosangoConsole telaLosango;
    private RetanguloConsole telaRetangulo;
    private QuadradoConsole telaQuadrado= new QuadradoConsole();


    public ProgramPaint(){
        vetor = new FiguraGeometrica[10];
        dao = new FigurasGeometricasDAO();
        tela = new BasicConsole();
        canvas = new DesenhoBoard();
        telaCirculo = new CirculoConsole();
        telaTriangulo = new TrianguloConsole();
        telaLosango = new LosangoConsole();
        telaRetangulo = new RetanguloConsole();
    }

    public void mostrarMenu(){

        OpcoesMenuEnum opcao = OpcoesMenuEnum.LISTAR;
        OpcoesMenuEnum opcaosub;

        do{
            opcao = menuTela.askOpcaoMenuPrincial();

            tela.showMessage("escolhi: "+ opcao+"\n\n");

            switch (opcao){
                case QUADRADO:
                    telaQuadrado.askSubMenu(this);
                    break;
                case RETANGULO:

                    do {

                        opcaosub = menuTela.askSubMenu();
                        tela.showMessage("escolhi: " + opcaosub + "\n\n");

                        switch (opcaosub) {
                            case NOVO:
                                Retangulo ret = telaRetangulo.askRetangulo();
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
                            case RECARREGAR:
                                break;
                            case SALVAR:
                                dao.salvarEmArquivos();
                            case SAIR:
                                break;
                            default:
                                break;
                        }


                    } while (opcaosub != OpcoesMenuEnum.SAIR);

                    break;
                case CIRCULO:
                    do {

                        opcaosub = menuTela.askSubMenu();
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
                            case RECARREGAR:
                                break;
                            case SALVAR:
                                dao.salvarEmArquivos();
                            case SAIR:
                                break;
                            default:
                                break;
                        }


                    } while (opcaosub != OpcoesMenuEnum.SAIR);

                    break;
                case TRIANGULO:
                    do {

                        opcaosub = menuTela.askSubMenu();
                        tela.showMessage("escolhi: " + opcaosub + "\n\n");

                        switch (opcaosub) {
                            case NOVO:
                                Triangulo tri = telaTriangulo.askTriangulo();
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
                            case RECARREGAR:
                                break;
                            case SALVAR:
                                dao.salvarEmArquivos();
                            case SAIR:
                                break;
                            default:
                                break;
                        }


                    } while (opcaosub != OpcoesMenuEnum.SAIR);

                    break;
                case LOSANGO:
                    do {

                        opcaosub = menuTela.askSubMenu();
                        tela.showMessage("escolhi: " + opcaosub + "\n\n");

                        switch (opcaosub) {
                            case NOVO:
                                Losango losangulo = telaLosango.askLosango();
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
                            case RECARREGAR:
                                break;
                            case SALVAR:
                                dao.salvarEmArquivos();
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
        int opcao = tela.askForInt("Vetor a ser apagado:");
        for(int i = 0; i < vetor.length; i++){
            if(i == opcao){
                vetor[i] = null;
            }
        }
    }
             // Geral
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
