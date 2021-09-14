package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.ICEEMview;


public class MenuConsole <T> extends BasicConsole implements ICEEMview<T> {
    public OpcoesMenuEnum start(){
        showMessage("MENU\n"+
                "Digite uma opção: \n" +
                "1 - Novo (Criar/Adicionar novo item)\n" +
                "2 - Editar (Selecionar Id e Editar)\n" +
                "3 - Listar (Listar Itens do Tipo) \n" +
                "4 - Mostrar (Listar detalhes de 1 Itens) \n" +
                "5 - Excluir (Excluir Id)\n" +
                "X - Voltar\n");

        String opcao = in.next();

        switch (opcao){
            case"1":
                return OpcoesMenuEnum.NOVO;
            case "2":
                return OpcoesMenuEnum.EDITAR;
            case "3":
                return OpcoesMenuEnum.LISTAR;
            case "4":
                return OpcoesMenuEnum.MOSTRAR;
            case "5":
                return OpcoesMenuEnum.EXCLUIR;
            case "X":
                return OpcoesMenuEnum.VOLTAR;
            default:
                return OpcoesMenuEnum.SAIR;
        }
    }

        public OpcoesMenuEnum askOpcaoMenuPrincial(){
        //Loop até entregar uma opção válida
        showMessage("Digite uma opção \n" +
                "1 - Criar Texto\n" +
                "2 - Criar Reta\n" +
                "3 - Criar Quadrado\n" +
                "4 - Criar Retangulo\n" +
                "5 - Criar Círculo\n" +
                "6 - Criar Losango\n" +
                "7 - Criar Triângulo\n" +
                "D - Desenhar\n" +
                "L - Listar\n" +
                "A - Apagar Item\n" +
                "S - Salvar\n" +
                "X - Sair\n" +
                "Digite aqui sua escolha: ");

        String opcao = in.next();

        switch (opcao){
            case"1":
                return OpcoesMenuEnum.TEXTO;
            case "2":
                return OpcoesMenuEnum.RETA;
            case "3":
                return OpcoesMenuEnum.QUADRADO;
            case "4":
                return OpcoesMenuEnum.RETANGULO;
            case "5":
                return OpcoesMenuEnum.CIRCULO;
            case "6":
                return OpcoesMenuEnum.LOSANGO;
            case "7":
                return OpcoesMenuEnum.TRIANGULO;
            case "D":
                return OpcoesMenuEnum.DESENHAR;
            case "L":
                return OpcoesMenuEnum.LISTAR;
            case "A":
                return OpcoesMenuEnum.APAGAR;
            case "S":
                return OpcoesMenuEnum.SALVAR;
            case "X":
                return OpcoesMenuEnum.SAIR;
            default:
                return OpcoesMenuEnum.SAIR;
        }
    }

    @Override
    public void askSubMenu(DAO dao, int hash) {

    }

    @Override
    public T criar() {
        return null;
    }

    @Override
    public void editar(DAO dao, int hash) {

    }

    @Override
    public void excluir(DAO dao, int hash) {

    }

    @Override
    public void mostrar(DAO dao, int hash) {

    }
}
