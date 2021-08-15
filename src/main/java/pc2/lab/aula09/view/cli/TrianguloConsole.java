package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.model.Triangulo;
import pc2.lab.aula09.view.ITriangulo;

public class TrianguloConsole extends BasicConsole implements ITriangulo {
    public Triangulo askTriangulo() {
        showLineMessage("Digite um inteiro para o ladoA: ");
        int ladoA = in.nextInt();
        showLineMessage("Digite um inteiro para o ladoB: ");
        int ladoB = in.nextInt();
        showLineMessage("Digite um inteiro para o ladoC: ");
        int ladoC = in.nextInt();
        Triangulo tri = new Triangulo(ladoA , ladoB , ladoC);
        return tri;
    }
}
