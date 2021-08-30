package pc2.lab.aula09.view.cli;


import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.model.FiguraGeometrica;
import pc2.lab.aula09.model.Reta;


public class RetaConsole extends MenuConsole <Reta> {

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
