package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.model.FiguraGeometrica;
import pc2.lab.aula09.model.Quadrado;
import pc2.lab.aula09.dao.DAO;

public class QuadradoConsole extends MenuConsole <Quadrado>  {


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
