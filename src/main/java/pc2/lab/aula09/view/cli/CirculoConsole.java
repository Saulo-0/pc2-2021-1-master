package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.model.Circulo;
import pc2.lab.aula09.view.ICirculo;

public class CirculoConsole extends BasicConsole implements ICirculo {
    public Circulo askCirculo() {
        showLineMessage("Digite um inteiro para o tamanho do raio: ");
        int tamanhoRaio = in.nextInt();
        Circulo circle = new Circulo(tamanhoRaio);

        return circle;
    }
}

