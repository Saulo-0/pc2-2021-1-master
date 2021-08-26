package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.Quadrado;
import pc2.lab.aula09.model.enums.OpcoesMenuEnum;

public interface IQuadradoCtrl {
    public OpcoesMenuEnum menuPrincipal();
    public Quadrado criar();
    public void ler(Quadrado conta);
    public Quadrado atualizar(Quadrado cliSalvar);
    public Boolean deletar(Quadrado cliDeletar);

    public void liste(Quadrado[] listas);
}
