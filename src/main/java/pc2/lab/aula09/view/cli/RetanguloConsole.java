package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.model.FiguraGeometrica;
import pc2.lab.aula09.model.Retangulo;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.IRetangulo;

public class RetanguloConsole extends BasicConsole implements IRetangulo {

    public void askSubMenu(DAO dao, int hash) {
        OpcoesMenuEnum opcaosub = OpcoesMenuEnum.LISTAR;
        MenuConsole menuTela = new MenuConsole();

        do {

            opcaosub = menuTela.askSubMenu();
            showMessage("escolhi: " + opcaosub + "\n\n");

            switch (opcaosub) {
                case NOVO:
                    Retangulo ret = criar();
                    dao.insertFiguraGeometrica(ret);
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
    public Retangulo criar() {
        showMessage("Digite um interio para o tamanho da base do retângulo: ");
        int base = in.nextInt();
        showMessage("Digite um interio para o tamanho da altura do retângulo: ");
        int altura = in.nextInt();
        Retangulo ret = new Retangulo(base, altura);
        return ret;
    }

    public void editar(DAO dao, int hash){
        dao.listar(hash);
        showLineMessage("Posição do vetor: ");
        int numero = in.nextInt();
        Retangulo geo =  criar();
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
        Retangulo dados = (Retangulo)dao.getVetor(numero);
        showLineMessage("Retângulo | Base e Altura: "+dados.getSuperiorDireito());
    }
}
