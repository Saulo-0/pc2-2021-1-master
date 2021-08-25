package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.Losango;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;

public interface ILosangoCtrl {
    public OpcoesMenuEnum menuPrincipal();
    public Losango criar();
    public void ler(Losango conta);
    public Losango atualizar(Losango cliSalvar);
    public Boolean deletar(Losango cliDeletar);

    public void liste(Losango[] listas);
}
