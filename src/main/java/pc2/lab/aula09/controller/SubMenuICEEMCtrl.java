package pc2.lab.aula09.controller;

import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.model.FiguraGeometrica;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.ICEEMview;
import pc2.lab.aula09.view.cli.MenuConsole;

public abstract class SubMenuICEEMCtrl <T> extends MenuConsole implements ICEEMCrtl <T> {
    protected ICEEMview <T> tela;



    public void start(DAO dao, int hash) {
        OpcoesMenuEnum opcaosub = OpcoesMenuEnum.LISTAR;
        MenuConsole menuTela = new MenuConsole();

        do {

            opcaosub = menuTela.start();
            showMessage("escolhi: " + opcaosub + "\n\n");

            switch (opcaosub) {
                case NOVO:
                    T fig = (T) tela.criar();
                    dao.insertFiguraGeometrica((FiguraGeometrica) fig);
                    break;
                case EDITAR:
                    tela.editar(dao, hash);
                    break;
                case LISTAR:
                    dao.listar(hash);
                    break;
                case MOSTRAR:
                    tela.mostrar(dao, hash);
                    break;
                case EXCLUIR:
                    tela.excluir(dao, hash);
                    break;
                case VOLTAR:
                    opcaosub = OpcoesMenuEnum.SAIR;
                    break;
                default:
                    break;
            }


        } while (opcaosub != OpcoesMenuEnum.SAIR);

    }

    public T criar() {
        return null;
    }

    @Override
    public OpcoesMenuEnum menuPrincipal() {
        return null;
    }

    @Override
    public void ler(T conta) {

    }

    @Override
    public T atualizar(T cliSalvar) {
        return null;
    }

    @Override
    public Boolean deletar(T cliDeletar) {
        return null;
    }

    @Override
    public void liste(T[] listas) {

    }
}
