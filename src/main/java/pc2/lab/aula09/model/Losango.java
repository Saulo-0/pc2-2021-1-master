package pc2.lab.aula09.model;

public class Losango extends FiguraGeometrica{

    protected int diagonalMaior;
    protected int diagonalMenor;
    protected double catetoOposto;
    protected double catetoAdjacente;
    protected double hipotenusa;


    public Losango(){
       catetoAdjacente = diagonalMaior/2;
       catetoOposto = diagonalMenor/2;
       hipotenusa = Math.pow(catetoAdjacente,2) + Math.pow(catetoOposto,2);
       hipotenusa = Math.sqrt(hipotenusa);
    }

    public double getArea(){
        return (diagonalMaior * diagonalMenor)/2;
    }

    public double getPerimetro(){
        return hipotenusa * 4;
    }

}
