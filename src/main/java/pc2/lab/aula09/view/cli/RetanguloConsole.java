package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.model.Retangulo;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.IRetangulo;

public class RetanguloConsole extends BasicConsole implements IRetangulo {

    public void askSubMenu(DAO dao) {
        OpcoesMenuEnum opcaosub = OpcoesMenuEnum.LISTAR;
        MenuConsole menuTela = new MenuConsole();

        do {

            opcaosub = menuTela.askSubMenu();
            showMessage("escolhi: " + opcaosub + "\n\n");

            switch (opcaosub) {
                case NOVO:
                    Retangulo ret = askFigura();
                    dao.insertFiguraGeometrica(ret);
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
    public Retangulo askFigura() {
        showMessage("Digite um interio para o tamanho da base do retângulo: ");
        int base = in.nextInt();
        showMessage("Digite um interio para o tamanho da altura do retângulo: ");
        int altura = in.nextInt();
        Retangulo ret = new Retangulo(base, altura);
        return ret;
    }
}
