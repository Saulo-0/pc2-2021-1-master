package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.model.Losango;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.ILosango;
import pc2.lab.aula09.dao.DAO;

public class LosangoConsole extends BasicConsole implements ILosango {

    public void askSubMenu(DAO dao) {
        OpcoesMenuEnum opcaosub = OpcoesMenuEnum.LISTAR;
        MenuConsole menuTela = new MenuConsole();

        do {

            opcaosub = menuTela.askSubMenu();
            showMessage("escolhi: " + opcaosub + "\n\n");

            switch (opcaosub) {
                case NOVO:
                    Losango losangulo = askFigura();
                    dao.insertFiguraGeometrica(losangulo);
                    break;
                case EDITAR:

                    break;
                case LISTAR:
                    dao.listar(6);
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
    public Losango askFigura() {
        showLineMessage("Digite um inteiro para o tamanho da diagonal maior: ");
        int diagonalMaior = in.nextInt();
        showLineMessage("Digite um inteiro para o tamanho da diagonal menor: ");
        int diagonalMenor = in.nextInt();
        Losango losangulo = new Losango(diagonalMaior , diagonalMenor);
        return losangulo;
    }
}
