package Main;

import Files.FilesHandling;
import Menu.MenuApplications;

import java.util.Scanner;

public class MainDesafioCadastro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FilesHandling filesHandling = new FilesHandling();
        MenuApplications menuApplications = new MenuApplications();
        System.out.println("Executando Formulário...");
        System.out.println("Formulário: ");
        filesHandling.writeFile();
        filesHandling.readFile();
        System.out.println();
        menuApplications.showMenu();


        sc.close();
    }
}
