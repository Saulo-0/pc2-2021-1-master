package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.Triangulo;
import pc2.lab.aula09.view.cli.TrianguloConsole;

public class TrianguloCtrl extends SubMenuICEEMCtrl <Triangulo>{
    public TrianguloCtrl(){

        tela = new TrianguloConsole();
    }
}
