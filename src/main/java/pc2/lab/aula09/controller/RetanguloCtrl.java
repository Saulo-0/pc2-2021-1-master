package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.Retangulo;
import pc2.lab.aula09.view.cli.RetanguloConsole;

public class RetanguloCtrl extends SubMenuICEEMCtrl <Retangulo>{
    public RetanguloCtrl(){

        tela = new RetanguloConsole();
    }

}
