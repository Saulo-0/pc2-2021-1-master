package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.model.Losango;
import pc2.lab.aula09.view.ILosango;

public class LosangoConsole extends BasicConsole implements ILosango {
    public Losango askLosango() {
        showLineMessage("Digite um inteiro para o tamanho da diagonal maior: ");
        int diagonalMaior= in.nextInt();
        showLineMessage("Digite um inteiro para o tamanho da diagonal menor: ");
        int diagonalMenor = in.nextInt();
        Losango losangulo = new Losango(diagonalMaior , diagonalMenor);
        return losangulo;
    }
}
