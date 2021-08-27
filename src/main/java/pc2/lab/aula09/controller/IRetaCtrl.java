package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.Reta;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;

public interface IRetaCtrl {
    public OpcoesMenuEnum menuPrincipal();
    public Reta criar();
    public void ler(Reta conta);
    public Reta atualizar(Reta cliSalvar);
    public Boolean deletar(Reta cliDeletar);

    public void liste(Reta[] listas);
}
