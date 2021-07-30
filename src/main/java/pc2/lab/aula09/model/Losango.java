package pc2.lab.aula09.model;

public class Losangulo extends Quadrilatero{
    protected Ponto origem;
    protected Ponto inferiorEsquerdo;
    protected Ponto inferiorDireito;
    protected Ponto superiorDireito;
    protected Ponto superiorEsquerdo;
    private int diagonalMaior;
    private int diagonalMenor;

    public Losangulo() {
        origem = new Ponto(0,0);
        inferiorEsquerdo = origem;
        inferiorDireito = new Ponto(0,1);
        superiorDireito = new Ponto(1,2);
        superiorEsquerdo = new Ponto(1,0);
    }

    public Ponto getInferiorEsquerdo() {
        return inferiorEsquerdo;
    }

    protected void setInferiorEsquerdo(Ponto inferiorEsquerdo) {
        this.inferiorEsquerdo = inferiorEsquerdo;
    }

    public Ponto getInferiorDireito() {
        return inferiorDireito;
    }

    protected void setInferiorDireito(Ponto inferiorDireito) {
        this.inferiorDireito = inferiorDireito;
    }

    public Ponto getSuperiorDireito() {
        return superiorDireito;
    }

    protected void setSuperiorDireito(Ponto superiorDireito) {
        this.superiorDireito = superiorDireito;
    }

    public Ponto getSuperiorEsquerdo() {
        return superiorEsquerdo;
    }

    protected void setSuperiorEsquerdo(Ponto superiorEsquerdo) {
        this.superiorEsquerdo = superiorEsquerdo;
    }

    public void setDiagonalMaior(int diagonalMaior) {
        this.diagonalMaior = inferior;
    }

    public double getArea(){
        return ;
    }

    public double getPerimetro(){
        return 6.28 * tamanhoRaio;
    }

}
