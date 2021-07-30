package pc2.lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Aléssio Miranda Júnior
 * @version 01/03/2021
 */
public abstract class JavaTester {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    protected boolean debug = true;
    protected boolean doLog = true;
    private boolean isDebug(){ return debug; };
    private boolean showLog(){ return doLog; };
    private FileWriter fileWriter = null;
    private PrintWriter printWriter = null;
    public String pathDir = "./";
    public String outInFix = ".new.out";
    protected Scanner in = null;

    private Runtime runtime;
    private long memoryStart;
    private long timeStart;

    public JavaTester() {
        debug = false;
        doLog = true;
        pathDir = "/dados/disciplina/doutorado/src/com/alessiojr/doutorado/tp1/test-cases";
        outInFix = ".new.out";

        runtime = Runtime.getRuntime();
        memoryStart = runtime.totalMemory() - runtime.freeMemory();
        timeStart = System.currentTimeMillis();
    }

    /**
     * Função que deve configurar as seguintes variáveis
     * <p><ul>
     * <li> debug: Se o Debug estiver ativado ele já busca os casos de TesteMen E faz o Checksum de MD5
     * </li><li> doLog: Comentários do Fonte podem ser feitos com a função Log e Desligadas
     * </li><li> pathDir = Diretório local com os casos de TesteMen
     * </li><li> outInFix = Sufixo de saída dos casos de TesteMen
     * </li></ul><p>
     */
    public abstract void prepare();

    public abstract void execute();

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - timeStart) / 1000.0;
    }

    public void runTest(Path inFile){
        in = openFile(inFile);

        execute();

        closeFile();
        checkFile(inFile);
    }

    public void start() {

        prepare();
        try (Stream<Path> paths = Files.walk(Paths.get(pathDir), 3)) {
            paths
                    .filter(Files::isRegularFile)
                    .filter(p -> p.getFileName().toString().endsWith("in"))
                    .forEach(this::runTest)
            ;
        }catch (IOException e){
            runTest(null);
        }
    }

    public void log(Object o){
        if(showLog()) {
            System.out.println(o.toString());
        }
    }

    /**
     * Caso o arquivo seja válido abre o arquivo e retorna o scanner Válido
     *     caso contrário retorna um scanner de teclado
     *
     * @param inFile Diretorio Válido
     * @return Caso o arquivo seja válido retorna um scanner para ele, caso contrário um Scanner de teclado
     *
     */
    public Scanner openFile(Path inFile){
        if(isDebug()) {
            System.out.println("------------");
            System.out.println(inFile);
            System.out.println("------------");

            try {
                fileWriter = new FileWriter(inFile.toString().replace(".in", outInFix));
                printWriter = new PrintWriter(fileWriter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(inFile == null) {
            return new Scanner(System.in);
        }else{
            try {
                return new Scanner(inFile.toFile());
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Caso o arquivo esteja aberto fecha
     *
     */
    public void closeFile(){
        if(isDebug()) {
            try {
                printWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void print(Object msg){
        if(isDebug()) {
            printWriter.print(msg);
        }
        System.out.print(msg);
    }

    public void println(Object msg){
        if(isDebug()) {
            printWriter.println(msg);
        }
        System.out.println(msg);
    }

    public void checkFile(Path testFile){
        if(isDebug()) {
            System.out.println("------------STATISTICS------------");

            double time2 = elapsedTime();
            System.out.println(String.format("%e (%.2f seconds)", (timeStart / 1000.0), time2));
            long memoryEnd = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Memória: " + (memoryEnd- memoryStart)/ (1024 * 1024) + "Mb");

            try {
                String md5Original = getMD5Checksum(testFile.toString().replace(".in", ".out"));
                String md5Nova = getMD5Checksum(testFile.toString().replace(".in", outInFix));
                if(!md5Original.equals(md5Nova)){
                    log("Md5: " + md5Nova);
                    log("Md5: " + md5Original);
                    System.out.println(ANSI_RED +"FALHOU!!: " + testFile.getFileName().toString()+ ANSI_RESET);
                }else{
                    log("Md5: " + md5Nova);
                    log("Md5: " + md5Original);
                    System.out.println(ANSI_GREEN + "OK: " + ANSI_RESET);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void checkFiles(){
        if(isDebug()) {
            long memoryEnd = runtime.totalMemory() - runtime.freeMemory();
            log("Memória: " + (memoryEnd- memoryStart)/ (1024 * 1024) + "Mb");

            try (Stream<Path> paths = Files.walk(Paths.get(pathDir), 3)) {
                List<Path> listaOut = paths
                        .filter(Files::isRegularFile)
                        .filter(p -> p.getFileName().toString().endsWith("in"))
                        .collect(Collectors.toList());
                ;

                listaOut.forEach(
                        (out) -> {
                            try {
                                String md5Original = getMD5Checksum(out.toString().replace(".in", ".out"));
                                String md5Nova = getMD5Checksum(out.toString().replace(".in", outInFix));
                                if(!md5Original.equals(md5Nova)){
                                    log("Md5: " + md5Nova);
                                    log("Md5: " + md5Original);
                                    log("FALHOU!!: " + out.getFileName().toString());
                                }else{
                                    log("Md5: " + md5Nova);
                                    log("Md5: " + md5Original);
                                    log("OK: ");
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (NoSuchAlgorithmException e) {
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                );

            } catch (IOException e) {

            }
        }
    }

    // see this How-to for a faster way to convert
    // a byte array to a HEX string
    private String getMD5Checksum(String filename) throws Exception {
        byte[] b = createChecksum(filename);
        String result = "";

        for (int i=0; i < b.length; i++) {
            result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }

    private byte[] createChecksum(String filename) throws Exception {
        InputStream fis =  new FileInputStream(filename);

        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("MD5");
        int numRead;

        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);

        fis.close();
        return complete.digest();
    }
}
