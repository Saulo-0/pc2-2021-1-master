package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.model.Triangulo;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.ITriangulo;

public class TrianguloConsole extends BasicConsole implements ITriangulo {
    public void askSubMenu(DAO dao) {
        OpcoesMenuEnum opcaosub = OpcoesMenuEnum.LISTAR;
      MenuConsole menuTela = new MenuConsole();

        do {

           opcaosub = menuTela.askSubMenu();
            showMessage("escolhi: " + opcaosub + "\n\n");

           switch (opcaosub) {
                case NOVO:
                   Triangulo tri = askFigura();
                    dao.insertFiguraGeometrica(tri);
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
    public Triangulo askFigura() {
        showLineMessage("Digite um inteiro para o ladoA: ");
        int ladoA = in.nextInt();
        showLineMessage("Digite um inteiro para o ladoB: ");
        int ladoB = in.nextInt();
        showLineMessage("Digite um inteiro para o ladoC: ");
        int ladoC = in.nextInt();
        Triangulo tri = new Triangulo(ladoA , ladoB , ladoC);
        return tri;
    }

}
