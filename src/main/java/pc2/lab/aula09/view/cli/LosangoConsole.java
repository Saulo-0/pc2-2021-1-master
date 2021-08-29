package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.model.FiguraGeometrica;
import pc2.lab.aula09.model.Losango;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.ILosango;
import pc2.lab.aula09.dao.DAO;

public class LosangoConsole extends BasicConsole implements ILosango {

    public void askSubMenu(DAO dao, int hash) {
        OpcoesMenuEnum opcaosub = OpcoesMenuEnum.LISTAR;
        MenuConsole menuTela = new MenuConsole();

        do {

            opcaosub = menuTela.askSubMenu();
            showMessage("escolhi: " + opcaosub + "\n\n");

            switch (opcaosub) {
                case NOVO:
                    Losango losangulo = criar();
                    dao.insertFiguraGeometrica(losangulo);
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
                default:
                    break;
            }


        } while (opcaosub != OpcoesMenuEnum.SAIR);


    }
    public Losango criar() {
        showLineMessage("Digite um inteiro para o tamanho da diagonal maior: ");
        int diagonalMaior = in.nextInt();
        showLineMessage("Digite um inteiro para o tamanho da diagonal menor: ");
        int diagonalMenor = in.nextInt();
        Losango losangulo = new Losango(diagonalMaior , diagonalMenor);
        return losangulo;
    }

    public void editar(DAO dao, int hash){
        dao.listar(hash);
        showLineMessage("Posição do vetor: ");
        int numero = in.nextInt();
        Losango geo =  criar();
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
        Losango dados = (Losango)dao.getVetor(numero);
        showLineMessage(" Losango|  D.menor: "+ dados.getDiagonalMenor() +" , D.maior: "+dados.getDiagonalMaior());
    }

}
