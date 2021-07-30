package pc2.lab;

public class TesteMen extends JavaTester{

    @Override
    public void prepare(){
        // Se o Debug estiver ativado ele já busca os casos de TesteMen
        // E faz o Checksum de MD5
        debug = true;
        // Comentários do Fonte podem ser feitos com a função Log e Desligadas
        doLog = true;
        //Diretório local com os casos de TesteMen
        pathDir = "/dados/disciplina/doutorado/src/com/alessiojr/doutorado/soma/test-cases/d-sample/";
        //Sufixo de saída dos casos de TesteMen
        outInFix = ".new.out";
    }

    @Override
    public void execute(){
        int a,b;
        int[][] matriz = new int[10000][10000];
        for (int [] vetor: matriz){
            for (int item: vetor){
                a = item++;
            }
        }

        for (int [] vetor: matriz){
            for (int item: vetor){
                a = item++;
            }
        }

        for (int [] vetor: matriz){
            for (int item: vetor){
                a = item++;
            }
        }
        //a = in.nextInt();
        //b = in.nextInt();
        log("gTeste");

        //log(String.format("Log: a: %s, b %s", a, b));

        println("gTeste");
    }

    public static void main(String[] args) {
        JavaTester teste = new TesteMen();
        teste.start();
    }
}
