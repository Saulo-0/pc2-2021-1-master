package pc2.lab.aula09.controller;

import pc2.lab.aula09.dao.FigurasGeometricasDAO;
import pc2.lab.aula09.view.IBasicView;
import pc2.lab.aula09.model.*;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.IMenuView;
import pc2.lab.aula09.view.cli.*;
import pc2.lab.aula09.view.DesenhoBoard;
import pc2.lab.aula09.view.gui.CirculoConsole;

public class ProgramPaint extends FigurasGeometricasDAO {

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
        super(10);
        menuTela = new MenuConsole();
        dao = new FigurasGeometricasDAO(10);
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
                                dao.insertFiguraGeometrica(ret);
                                break;
                            case EDITAR:

                                break;
                            case LISTAR:
                                dao.listar();
                                break;
                            case MOSTRAR:

                                break;
                            case EXCLUIR:
                                dao.excluir(4);
                                break;
                            case VOLTAR:

                                break;
                            case RECARREGAR:
                                break;
                            case SALVAR:

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

                        opcaosub = menuTela.askSubMenu();
                        tela.showMessage("escolhi: " + opcaosub + "\n\n");

                        switch (opcaosub) {
                            case NOVO:
                                Circulo circle = telaCirculo.askCirculo();
                                dao.insertFiguraGeometrica(circle);
                                break;
                            case EDITAR:

                                break;
                            case LISTAR:
                                dao.listar();
                                break;
                            case MOSTRAR:

                                break;
                            case EXCLUIR:
                                dao.excluir(5);
                                break;
                            case VOLTAR:

                                break;
                            case RECARREGAR:
                                break;
                            case SALVAR:

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
                                dao.insertFiguraGeometrica(tri);
                                break;
                            case EDITAR:

                                break;
                            case LISTAR:
                                dao.listar();
                                break;
                            case MOSTRAR:

                                break;
                            case EXCLUIR:
                                dao.excluir(7);
                                break;
                            case VOLTAR:

                                break;
                            case RECARREGAR:
                                break;
                            case SALVAR:

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
                                dao.insertFiguraGeometrica(losangulo);
                                break;
                            case EDITAR:

                                break;
                            case LISTAR:
                                dao.listar();
                                break;
                            case MOSTRAR:

                                break;
                            case EXCLUIR:
                                dao.excluir(6);
                                break;
                            case VOLTAR:

                                break;
                            case RECARREGAR:
                                break;
                            case SALVAR:

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



}
