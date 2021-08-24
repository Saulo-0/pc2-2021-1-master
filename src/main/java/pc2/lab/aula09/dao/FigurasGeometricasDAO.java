package pc2.lab.aula09.dao;

import pc2.lab.aula09.controller.ProgramPaint;
import pc2.lab.aula09.model.FiguraGeometrica;
import pc2.lab.aula09.view.IBasicView;
import pc2.lab.aula09.view.cli.BasicConsole;

import java.io.*;

public class FigurasGeometricasDAO  {

    IBasicView tela;
    FiguraGeometrica[] vetor;

    public FigurasGeometricasDAO(int tamanho) {
      tela = new IBasicView() {
          @Override
          public void showMessage(String msg) {

          }

          @Override
          public void showLineMessage(String msg) {

          }

          @Override
          public int askForInt(String question) {
              return 0;
          }

          @Override
          public double askForDouble(String question) {
              return 0;
          }

          @Override
          public String askForString(String question) {
              return null;
          }

          @Override
          public boolean hasNextInt() {
              return false;
          }
      } ;
      vetor = new FiguraGeometrica[tamanho];
    }
    public boolean insertFiguraGeometrica(FiguraGeometrica fig){

        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] != null && i == 9) {
                tela.showLineMessage("Vetor cheio!");
            }
            if(vetor[i] == null){
                vetor[i] = fig;
                break;
            }
        }
        return true;
    }
    protected void listar(FiguraGeometrica fig) {
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] != null) {

                tela.showLineMessage(""+ i + " - "+vetor[i].toString());
            }
        }
    }
    public void apagar(){
        int opcao = tela.askForInt("Vetor a ser apagado:");
        for(int i = 0; i < vetor.length; i++){
            if(i == opcao){
                vetor[i] = null;
            }
        }
    }
    // Geral
    public void mostrar(int hash){
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] != null && hash == vetor[i].hashCode()) {

                tela.showLineMessage(""+ i + " - "+vetor[i].toString());
            }
        }
    }

    public void excluir(int hash){
        for(int i = 0; i < vetor.length; i++){
            if(hash == vetor[i].hashCode()){
                vetor[i] = null;
            }
        }
    }


    public void salvarEmArquivos() throws IOException {

        FileOutputStream arquivo = null;
        try {
            arquivo = new FileOutputStream("figurasGeometrica.dat");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            out.writeObject(vetor);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


}

    public FiguraGeometrica[]  carregarDeArquivo(){ //throws IOException, ClassNotFoundException
        FiguraGeometrica[] fig = null;

        try {
            FileInputStream arqv = new FileInputStream("figurasGeometrica.dat");
            ObjectInputStream in = new ObjectInputStream(arqv);
            fig = (FiguraGeometrica[]) in.readObject();
        }
        catch(IOException ex){
            System.out.println("Erro IOException");
            ex.printStackTrace();
            return null;
        }
        catch(ClassNotFoundException ex){
            System.out.println(" Erro ClassNotFoundException");
            ex.printStackTrace();
            return null;
        }
            catch(Exception ex){
                System.out.println(" Erro geral");
                ex.printStackTrace();
                return null;
            }
            return fig;
        }

}

