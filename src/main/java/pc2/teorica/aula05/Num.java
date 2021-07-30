package pc2.teorica.aula05;

public class Num {
    int i = 0;
    Num somar(int i){
        this.i += i;
        return this;
    }

//    public static void somar(Num numero, int valor){
//        numero.i += 5;
//    }

    public static void main(String[] args) {
        Num numero = new Num();
        System.out.println("Antigo: " +numero.i);
        numero.somar(10).somar(15);
        System.out.println("Novo: " +numero.i);

//        somar(numero, 20);
//        System.out.println("Novo: " +numero.i);

    }
}


