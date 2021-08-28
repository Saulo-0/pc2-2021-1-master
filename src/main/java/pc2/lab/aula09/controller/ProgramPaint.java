package pc2.lab.aula09.controller;

import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.view.IBasicView;
import pc2.lab.aula09.model.*;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.IMenuView;
import pc2.lab.aula09.view.cli.*;
import pc2.lab.aula09.view.DesenhoBoard;

public class ProgramPaint {

    private IMenuView menuTela;
    private FiguraGeometrica[] vetor;
    private DAO dao;
    private IBasicView tela;
    private DesenhoBoard canvas;

    private CirculoConsole telaCirculo;
    private TrianguloConsole telaTriangulo;
    private LosangoConsole telaLosango;
    private RetanguloConsole telaRetangulo;
    private QuadradoConsole telaQuadrado;
    private RetaConsole telaReta;

    private CirculoCtrl circleC;
    private TrianguloCtrl triC;
    private LosangoCtrl losanguloC;
    private RetanguloCtrl retC;
    private QuadradoCtrl quadC;
    private RetaCtrl retaC;

    public ProgramPaint(){
        menuTela = new MenuConsole();
        dao = new DAO(10);
        tela = new BasicConsole();
        canvas = new DesenhoBoard();

        telaCirculo = new CirculoConsole();
        telaTriangulo = new TrianguloConsole();
        telaLosango = new LosangoConsole();
        telaRetangulo = new RetanguloConsole();
        telaQuadrado = new QuadradoConsole();
        telaReta = new RetaConsole();

        circleC = new CirculoCtrl();
        triC = new TrianguloCtrl();
        losanguloC = new LosangoCtrl();
        retC = new RetanguloCtrl();
        quadC = new QuadradoCtrl();
    }

    public void mostrarMenu(){

        OpcoesMenuEnum opcao = OpcoesMenuEnum.LISTAR;
        OpcoesMenuEnum opcaosub;

        do{
            opcao = menuTela.askOpcaoMenuPrincial();

            tela.showMessage("escolhi: "+ opcao+"\n\n");

            switch (opcao) {
                case TEXTO:
                    break;
                case RETA:
                    telaReta.askSubMenu(dao);
                    break;
                case QUADRADO:
                    telaQuadrado.askSubMenu(dao);
                    break;
                case RETANGULO:
                    telaRetangulo.askSubMenu(dao);
                    break;
                case CIRCULO:
                    telaCirculo.askSubMenu(dao);
                    break;
                case LOSANGO:
                    telaLosango.askSubMenu(dao, 6);
                    break;
                case TRIANGULO:
                    telaTriangulo.askSubMenu(dao);
                    break;
                case DESENHAR:
                    break;
                case LISTAR:
                    break;
                case APAGAR:
                    break;
                case SALVAR:
                    break;
                case RECARREGAR:
                    break;
                case SAIR:
                    break;
                default:
                    break;

            }

        }while (opcao != OpcoesMenuEnum.SAIR);
    }
}
