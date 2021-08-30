package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.Circulo;
import pc2.lab.aula09.view.cli.CirculoConsole;

public class CirculoCtrl extends SubMenuICEEMCtrl <Circulo> {
    public CirculoCtrl(){

        tela = new CirculoConsole();
    }

}
