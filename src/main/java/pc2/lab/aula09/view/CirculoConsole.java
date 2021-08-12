/*package pc2.lab.aula09.view;

import pc2.lab.aula09.model.Circulo;

public class CirculoConsole extends BasicConsole{
    public Circulo askCirculo(){
        showLnMsg("Digite um inteiro para o tamanho do raio: ");
        int tamanhoRaio = in.nextInt();
        Circulo circle = new Circulo(tamanhoRaio);

        return circle;
    }
//
