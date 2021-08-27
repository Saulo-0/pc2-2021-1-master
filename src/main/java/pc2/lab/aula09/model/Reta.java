package pc2.lab.aula09.model;

public class Reta extends FiguraGeometrica{

    protected Ponto x1;protected Ponto x2;
    protected Ponto y1;protected Ponto y2;
    protected Ponto pontoInicia;
    protected Ponto pontoFinal;


    public Reta() {

    }

    public Reta(int x1, int y1, int x2, int y2) {
        pontoInicia = new Ponto(x1, y1);
        pontoFinal = new Ponto(x2, y2);
    }


    public Ponto getPontoInicia() {
        return pontoInicia;
    }

    public void setPontoInicia(Ponto pontoInicia) {
        this.pontoInicia = pontoInicia;
    }

    public Ponto getPontoFinal() {
        return pontoFinal;
    }

    public void setPontoFinal(Ponto pontoFinal) {
        this.pontoFinal = pontoFinal;
    }

    public String toString() {
        return "Reta | Pontos => " + getPontoInicia() + " " + getPontoFinal() +" ";
    }

    @Override
    public int hashCode() {
        return 2;
    }
}
