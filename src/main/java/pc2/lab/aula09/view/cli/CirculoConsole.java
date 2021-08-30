package pc2.lab.aula09.view.cli;


import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.model.Circulo;
import pc2.lab.aula09.model.FiguraGeometrica;



public class CirculoConsole extends MenuConsole <Circulo> {


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

