package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.Retangulo;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;

public interface IRetanguloCtrl {
    public OpcoesMenuEnum menuPrincipal();
    public Retangulo criar();
    public void ler(Retangulo conta);
    public Retangulo atualizar(Retangulo cliSalvar);
    public Boolean deletar(Retangulo cliDeletar);

    public void liste(Retangulo[] listas);
}
