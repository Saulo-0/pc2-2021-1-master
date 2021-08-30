package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.enums.OpcoesMenuEnum;

public interface ICEEMCrtl <T> {
    public OpcoesMenuEnum menuPrincipal();
    public T criar();
    public void ler(T conta);
    public T atualizar(T cliSalvar);
    public Boolean deletar(T cliDeletar);
    public void liste(T[] listas);
}
