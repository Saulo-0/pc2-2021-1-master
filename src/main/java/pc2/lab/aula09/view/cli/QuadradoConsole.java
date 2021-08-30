package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.model.FiguraGeometrica;
import pc2.lab.aula09.model.Losango;
import pc2.lab.aula09.model.Quadrado;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.view.IQuadrado;
import pc2.lab.aula09.dao.DAO;

public class QuadradoConsole extends BasicConsole implements IQuadrado {

    public void askSubMenu(DAO dao, int hash) {
        OpcoesMenuEnum opcaosub = OpcoesMenuEnum.LISTAR;
        MenuConsole menuTela = new MenuConsole();

        do {

             opcaosub = menuTela.askSubMenu();
            showMessage("escolhi: " + opcaosub + "\n\n");

            switch (opcaosub) {
                case NOVO:
                 Quadrado quad = criar();
                 dao.insertFiguraGeometrica(quad);
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
    public Quadrado criar() {
        showMessage("Digite um interio para o tamanho do lado do quadrado: ");
        int tamanho = in.nextInt();
        Quadrado quad = new Quadrado(tamanho);
        return quad;
    }

    public void editar(DAO dao, int hash){
        dao.listar(hash);
        showLineMessage("Posição do vetor: ");
        int numero = in.nextInt();
        Quadrado geo =  criar();
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
        Quadrado dados = (Quadrado)dao.getVetor(numero);
        showLineMessage("Quadrado | tamanho do lado: "+dados.getTamanhoLado());
    }
}
