package pc2.lab.aula09.model;

public class Triangulo extends FiguraGeometrica{

    protected int ladoA;
    protected int ladoB;
    protected int ladoC;
    protected double semiPerimetro;


    public Triangulo(int ladoA, int ladoB, int ladoC){
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
        this.getPerimetro();
        this.getArea();
    }

    /**
     *
     * @return função que calcula o sime perimetro para complementar a formula da area.
     */
    @Override
    public double getPerimetro() {
        semiPerimetro = (ladoA + ladoB + ladoC)/2;
        return (ladoA + ladoB + ladoC);
    }

    @Override
    public double getArea() {
        return  Math.sqrt(semiPerimetro*(semiPerimetro - ladoA) * (semiPerimetro - ladoB) * (semiPerimetro - ladoC));
    }

    public String toString() {
        return "Triângulo | Area => "+ getArea() +" Perimetro => "+ getPerimetro();
    }

    @Override
    public int hashCode() {
        return 7;
    }
 }
