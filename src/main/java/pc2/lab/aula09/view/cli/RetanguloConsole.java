package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.model.FiguraGeometrica;
import pc2.lab.aula09.model.Retangulo;

public class RetanguloConsole extends MenuConsole <Retangulo> {

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
