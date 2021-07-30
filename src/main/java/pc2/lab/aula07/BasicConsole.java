package pc2.lab.aula07;

import java.util.Scanner;

public class BasicConsole {

    private Scanner in;

    public BasicConsole(){
        in = new Scanner(System.in);
    }

    public void showLnMsg(String msg){
        System.out.println(msg);
    }

    public void showMsg(String msg){
        System.out.print(msg);
    }

    public int askInt(String msg){
        showMsg(msg);
        return in.nextInt();
    }

    public int askInt(){
        return in.nextInt();
    }

    public boolean hasNextInt(){
        return in.hasNextInt();
    }
}
