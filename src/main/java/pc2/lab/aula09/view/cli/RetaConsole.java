package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.model.Reta;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;

public class RetaConsole extends BasicConsole {
    public void askSubMenu(DAO dao) {
        OpcoesMenuEnum opcaosub = OpcoesMenuEnum.LISTAR;
        MenuConsole menuTela = new MenuConsole();

        do {

            opcaosub = menuTela.askSubMenu();
            showMessage("escolhi: " + opcaosub + "\n\n");

            switch (opcaosub) {
                case NOVO:
                    Reta reta = askFigura();
                    dao.insertFiguraGeometrica(reta);
                    break;
                case EDITAR:

                    break;
                case LISTAR:
                    dao.listar(2);
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
    public Reta askFigura() {
      showLineMessage("Digite x1: ");
      int x1 = in.nextInt();
        showLineMessage("Digite y1: ");
        int y1 = in.nextInt();
        showLineMessage("Digite x2: ");
        int x2 = in.nextInt();
        showLineMessage("Digite y2: ");
        int y2 = in.nextInt();
        Reta reta = new Reta(x1 , y1 , x2, y2);
        return reta;
    }
}
