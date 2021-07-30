package pc2.lab.aula02;

import java.util.Scanner;

public class TesteArgs {
    public static void main(String[] args) {

        System.out.println("Numero de argumentos " + args.length);

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter("-");

        while (scanner.hasNextInt()){
            System.out.println(scanner.nextInt());
        }

    }
}
