package pc2.lab.aula09.view.gui;

import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.model.Quadrado;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.dao.DAO;

public class QuadradoConsole extends BasicConsole {

    public void askSubMenu(DAO dao) {
        OpcoesMenuEnum opcaosub = OpcoesMenuEnum.LISTAR;

        do {

             opcaosub = askSubMenu();
            showMsg("escolhi: " + opcaosub + "\n\n");

            switch (opcaosub) {
                case NOVO:
                Quadrado quad = askQuadrado();
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
                case SAIR:
                    break;
                default:
                    break;
            }


        } while (opcaosub != OpcoesMenuEnum.SAIR);

    }
    public Quadrado askQuadrado() {
        showMsg("Digite um interio para o tamanho do lado do quadrado: ");
        int tamanho = in.nextInt();
        Quadrado quad = new Quadrado(tamanho);
        return quad;
    }
}
