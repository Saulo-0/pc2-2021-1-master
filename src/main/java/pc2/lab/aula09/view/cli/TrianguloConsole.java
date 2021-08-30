package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.dao.DAO;
;
import pc2.lab.aula09.model.FiguraGeometrica;
import pc2.lab.aula09.model.Triangulo;

public class TrianguloConsole extends MenuConsole <Triangulo> {

    public Triangulo criar() {
        showLineMessage("Digite um inteiro para o ladoA: ");
        int ladoA = in.nextInt();
        showLineMessage("Digite um inteiro para o ladoB: ");
        int ladoB = in.nextInt();
        showLineMessage("Digite um inteiro para o ladoC: ");
        int ladoC = in.nextInt();
        Triangulo tri = new Triangulo(ladoA , ladoB , ladoC);
        return tri;
    }

    public void editar(DAO dao, int hash){
        dao.listar(hash);
        showLineMessage("Posição do vetor: ");
        int numero = in.nextInt();
        Triangulo geo =  criar();
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
        Triangulo dados = (Triangulo)dao.getVetor(numero);
        showLineMessage("Triângulo | Lado A: "+dados.getLadoA()+" , Lado B: "+dados.getLadoB()+" , Lado C: "+dados.setLadoC());
    }


}
