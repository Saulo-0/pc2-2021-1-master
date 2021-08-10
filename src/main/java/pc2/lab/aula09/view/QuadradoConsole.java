package pc2.lab.aula09.view;

import pc2.lab.aula09.model.*;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.controller.ProgramPaint;

public class QuadradoConsole extends BasicConsole {

    public void askSubMenu() {
        OpcoesMenuEnum opcao = OpcoesMenuEnum.LISTAR;
        do {
             opcao = askOpcaoMenuPrincial();
            showMsg("escolhi: " + opcao + "\n\n");

            switch (opcao) {
                case NOVO:
                    Quadrado quad = askQuadrado();
                   // insertFiguraGeometrica(quad);
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


        } while (opcao != OpcoesMenuEnum.SAIR);

    }
    public Quadrado askQuadrado() {
        showMsg("Digite um interio para o tamanho do lado do quadrado: ");
        int tamanho = in.nextInt();
        Quadrado quad = new Quadrado(tamanho);
        return quad;
    }
}
