package pc2.lab.aula09.dao;

import pc2.lab.aula09.model.FiguraGeometrica;

import java.io.*;

public class FigurasGeometricasDAO {

    public void salvarEmArquivos(FiguraGeometrica[] fig) {
        FileOutputStream arquivo = new FileOutputStream("figurasGeometrica.dat");
        ObjectOutputStream out = new ObjectOutputStream(arquivo);
        out.writeObject(fig);
    }

    public FiguraGeometrica[]  carregarDeArquivo(){
        FiguraGeometrica[] fig = null;

        FileInputStream arqv = new FileInputStream("f igurasGeometrica.dat")
        ObjectInputStream in = new ObjectInputStream(arqv);
        fig = (FiguraGeometrica[])in.readObject();
        return fig;
    }
}
