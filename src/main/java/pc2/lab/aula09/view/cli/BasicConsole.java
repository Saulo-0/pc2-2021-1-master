package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.model.enums.OpcoesMenuEnum;
import pc2.lab.aula09.model.Losango;
import pc2.lab.aula09.model.Triangulo;
import pc2.lab.aula09.model.Retangulo;
import pc2.lab.aula09.view.IBasicView;

import java.util.Scanner;

public class BasicConsole implements IBasicView {

    protected Scanner in;

    public BasicConsole(){
        in = new Scanner(System.in);
    }

    public void showLineMessage(String msg){
        System.out.println(msg);
    }

    public void showMessage(String msg){
        System.out.print(msg);
    }

    public int askForInt(String msg){
        showMessage(msg);
        return in.nextInt();
    }

    public int askInt(){
        return in.nextInt();
    }

    @Override
    public double askForDouble(String question) {
        return 0;
    }

    @Override
    public String askForString(String question) {
        return null;
    }

    public boolean hasNextInt(){
        return in.hasNextInt();
    }


}
