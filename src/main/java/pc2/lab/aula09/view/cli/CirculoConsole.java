package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.model.Circulo;
import pc2.lab.aula09.model.FiguraGeometrica;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.ICirculo;

public class CirculoConsole extends BasicConsole implements ICirculo {

    public void askSubMenu(DAO dao, int hash) {
        OpcoesMenuEnum opcaosub = OpcoesMenuEnum.LISTAR;
        MenuConsole menuTela = new MenuConsole();

        do {

            opcaosub = menuTela.askSubMenu();
            showMessage("escolhi: " + opcaosub + "\n\n");

            switch (opcaosub) {
                case NOVO:
                    Circulo circle = criar();
                    dao.insertFiguraGeometrica(circle);
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

    public Circulo criar() {
        showLineMessage("Digite um inteiro para o tamanho do raio: ");
        int tamanhoRaio = in.nextInt();
        Circulo circle = new Circulo(tamanhoRaio);
        return circle;
    }

    public void editar(DAO dao, int hash){
        dao.listar(hash);
        showLineMessage("Posição do vetor: ");
        int numero = in.nextInt();
        Circulo geo =  criar();
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
        Circulo dados = (Circulo)dao.getVetor(numero);
        showLineMessage(" Circulo | Tamanho do raio: "+dados.getTamanhoRaio());
    }
}

