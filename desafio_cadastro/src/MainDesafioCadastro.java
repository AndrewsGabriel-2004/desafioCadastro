import Files.FilesHandling;

public class MainDesafioCadastro {
    public static void main(String[] args) {
        FilesHandling filesHandling = new FilesHandling();
        System.out.println("Executando Formulário...");
        System.out.println("Formulário: ");
        filesHandling.writeFile();
        filesHandling.readFile();

    }
}
