package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.dao.DAO;
import pc2.lab.aula09.model.Losango;
import pc2.lab.aula09.model.FiguraGeometrica;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.view.ICEEMview;

public class LosangoConsole  extends MenuConsole <Losango> {

    public Losango criar() {
        showLineMessage("Digite um inteiro para o tamanho da diagonal maior: ");
        int diagonalMaior = in.nextInt();
        showLineMessage("Digite um inteiro para o tamanho da diagonal menor: ");
        int diagonalMenor = in.nextInt();
        Losango losangulo = new Losango(diagonalMaior , diagonalMenor);
        return losangulo;
    }

    public void editar(DAO dao, int hash){
        dao.listar(hash);
        showLineMessage("Posição do vetor: ");
        int numero = in.nextInt();
        Losango geo =  criar();
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
        Losango dados = (Losango)dao.getVetor(numero);
        showLineMessage(" Losango|  D.menor: "+ dados.getDiagonalMenor() +" , D.maior: "+dados.getDiagonalMaior());
    }

}
