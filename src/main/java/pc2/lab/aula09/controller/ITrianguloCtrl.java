package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.Triangulo;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;

public interface ITrianguloCtrl {
    public OpcoesMenuEnum menuPrincipal();
    public Triangulo criar();
    public void ler(Triangulo conta);
    public Triangulo atualizar(Triangulo cliSalvar);
    public Boolean deletar(Triangulo cliDeletar);

    public void liste(Triangulo[] listas);
}
