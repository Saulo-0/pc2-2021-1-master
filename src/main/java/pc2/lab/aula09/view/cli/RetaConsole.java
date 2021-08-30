package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.model.FiguraGeometrica;
import pc2.lab.aula09.model.Reta;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.IReta;

public class RetaConsole extends BasicConsole implements IReta {
    public void askSubMenu(DAO dao, int hash) {
        OpcoesMenuEnum opcaosub = OpcoesMenuEnum.LISTAR;
        MenuConsole menuTela = new MenuConsole();

        do {

            opcaosub = menuTela.askSubMenu();
            showMessage("escolhi: " + opcaosub + "\n\n");

            switch (opcaosub) {
                case NOVO:
                    Reta reta = criar();
                    dao.insertFiguraGeometrica(reta);
                    break;
                case EDITAR:
                    editar(dao, hash);
                    break;
                case LISTAR:
                    dao.listar(hash);
                    break;
                case MOSTRAR:
                    mostrar(dao, hash);
                    break;
                case EXCLUIR:
                    excluir(dao, hash);
                    break;
                case VOLTAR:
                    opcaosub = OpcoesMenuEnum.SAIR;
                    break;
                case SAIR:
                    break;
                default:
                    break;
            }


        } while (opcaosub != OpcoesMenuEnum.SAIR);


    }
    public Reta criar() {
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

    public void editar(DAO dao, int hash){
        dao.listar(hash);
        showLineMessage("Posição do vetor: ");
        int numero = in.nextInt();
        Reta geo =  criar();
        dao.setVetor(numero, geo);
    }

    public void excluir(DAO dao, int hash){
        dao.listar(hash);
        showLineMessage("Posição do vetor: ");
        int numero = in.nextInt();
        FiguraGeometrica geo =  null;
        dao.setVetor(numero, geo);
    }

    public void mostrar(DAO dao, int hash){
        dao.listar(hash);
        showLineMessage("Posição do vetor: ");
        int numero = in.nextInt();
        Reta dados = (Reta)dao.getVetor(numero);
        showLineMessage("Reta | P.inicial: "+dados.getPontoInicia()+" , P.final: "+dados.getPontoFinal());
    }

}
