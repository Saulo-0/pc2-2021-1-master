package pc2.lab.aula08;

public class TesteStatic {

    public static void main(String[] args) {
        Banco t1 = Banco.getInstance(); //Singleton
        System.out.println(t1.qtdBancos);
        Banco t2 = Banco.getInstance();
        Banco t3 = Banco.getInstance();
        t3 = t2;
        System.out.println(Banco.qtdBancos);
        System.out.println(t1.qtdBancos);
    }
}
