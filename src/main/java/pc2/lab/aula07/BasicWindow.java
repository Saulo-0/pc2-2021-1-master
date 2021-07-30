package pc2.lab.aula07;

import javax.swing.*;
import java.util.Scanner;

public class BasicWindow {

    public BasicWindow(){
    }

    public void showLnMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    public void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    public int askInt(String msg){
        String temp = JOptionPane.showInputDialog(msg);
        return Integer.parseInt(temp);
    }

    public int askInt(){
        String temp = JOptionPane.showInputDialog("");
        return Integer.parseInt(temp);
    }

    public boolean hasNextInt(){
        return true;
    }
}
