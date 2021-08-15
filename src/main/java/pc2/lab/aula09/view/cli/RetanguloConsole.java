package pc2.lab.aula09.view.cli;

import pc2.lab.aula09.model.Retangulo;
import pc2.lab.aula09.view.IRetangulo;

public class RetanguloConsole extends BasicConsole implements IRetangulo {
    public Retangulo askRetangulo() {
        showMessage("Digite um interio para o tamanho da base do retângulo: ");
        int base = in.nextInt();
        showMessage("Digite um interio para o tamanho da altura do retângulo: ");
        int altura = in.nextInt();
        Retangulo ret = new Retangulo(base, altura);
        return ret;
    }
}
