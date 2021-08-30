package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.Reta;
import pc2.lab.aula09.view.cli.RetaConsole;
import pc2.lab.aula09.view.cli.TrianguloConsole;

public class RetaCtrl extends SubMenuICEEMCtrl <Reta>{
    public RetaCtrl(){

        tela = new RetaConsole();
    }

}
