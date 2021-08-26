package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.model.*;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.view.IMenuView;
import pc2.lab.aula09.view.IQuadrado;
import pc2.lab.aula09.dao.DAO;

public class QuadradoConsole extends BasicConsole implements IQuadrado {

    public void askSubMenu(DAO dao) {
        OpcoesMenuEnum opcaosub = OpcoesMenuEnum.LISTAR;
        MenuConsole menuTela = new MenuConsole();

        do {

             opcaosub = menuTela.askSubMenu();
            showMessage("escolhi: " + opcaosub + "\n\n");

            switch (opcaosub) {
                case NOVO:
                 Quadrado quad = askFigura();
                 dao.insertFiguraGeometrica(quad);
                    break;
                case EDITAR:

                    break;
                case LISTAR:

                    break;
                case MOSTRAR:

                    break;
                case EXCLUIR:

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

    }
    public Quadrado askFigura() {
        showMessage("Digite um interio para o tamanho do lado do quadrado: ");
        int tamanho = in.nextInt();
        Quadrado quad = new Quadrado(tamanho);
        return quad;
    }
}
