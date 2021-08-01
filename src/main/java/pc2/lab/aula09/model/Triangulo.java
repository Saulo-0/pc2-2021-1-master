package pc2.lab.aula09.model;

public class Triangulo extends FiguraGeometrica{

    protected int ladoA;
    protected int ladoB;
    protected int ladoC;
    protected int semiPerimetro;


    public Triangulo(){
        semiPerimetro = (ladoA + ladoB + ladoC)/2;
    }

    @Override
    public double getPerimetro() {
        return (ladoA + ladoB + ladoC);
    }

    @Override
    public double getArea() {
        return  Math.sqrt(semiPerimetro*(semiPerimetro - ladoA) * (semiPerimetro - ladoB) * (semiPerimetro - ladoC));
    }
 }
