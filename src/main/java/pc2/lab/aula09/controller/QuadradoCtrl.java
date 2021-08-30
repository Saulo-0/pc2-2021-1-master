package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.Quadrado;
import pc2.lab.aula09.view.cli.QuadradoConsole;

public class QuadradoCtrl extends SubMenuICEEMCtrl <Quadrado>{
    public QuadradoCtrl(){

        tela = new QuadradoConsole();
    }

}
