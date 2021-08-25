package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.Circulo;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;

public interface ICirculoCrtl {
    public OpcoesMenuEnum menuPrincipal();
    public Circulo criar();
    public void ler(Circulo conta);
    public Circulo atualizar(Circulo cliSalvar);
    public Boolean deletar(Circulo cliDeletar);
    public void liste(Circulo[] listas);
}
