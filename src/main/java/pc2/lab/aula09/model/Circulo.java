package pc2.lab.aula09.model;

public class Circulo extends FiguraGeometrica{

    private double tamanhoRaio;
    private Ponto centro;

    public Circulo(){
        this(1);
    }

    public Circulo(int tamanhoRaio){
        this(new Ponto(0,0), tamanhoRaio);
    }

    public Circulo(Ponto centro, int tamanhoRaio) {
        this.tamanhoRaio= tamanhoRaio;
        this.centro = centro;

    }

    public void setCentro(Ponto centro) {
        this.centro = centro;
    }


    public double getArea(){
        return 3.14 * (tamanhoRaio * tamanhoRaio);
    }

    public double getPerimetro(){
        return 6.28 * tamanhoRaio;
    }

    @Override
    public String toString() {
        return "Circulo | Area => "+ getArea() +" Perimetro => "+ getPerimetro();

    }

    @Override
    public boolean equals(Object o) {
       if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circulo circulo = (Circulo) o;

        return tamanhoRaio == circulo.tamanhoRaio;
    }

    @Override
    public int hashCode() {
        return (int) tamanhoRaio;
    }
}

