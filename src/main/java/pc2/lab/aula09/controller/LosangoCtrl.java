package pc2.lab.aula09.controller;

import pc2.lab.aula09.model.Losango;
import pc2.lab.aula09.view.cli.LosangoConsole;

public class LosangoCtrl extends SubMenuICEEMCtrl <Losango>{
    public LosangoCtrl(){

        tela = new LosangoConsole();
    }

}
