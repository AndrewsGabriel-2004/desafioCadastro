package Cadastramento;

import java.io.File;

public class ListarPetsCadastrados {
    public void listarPets() {
        System.out.println("Pets Cadastrados: ");
        File petsCadastrados = new File("C:\\WS-programs\\IntelliJ\\desafioCadastro\\PetsCadastrados");

        if(!petsCadastrados.exists() || !petsCadastrados.isDirectory()){
            System.out.println("Este diretório não existe");
            return;
        }

        File[] arquivos = petsCadastrados.listFiles();

        int contador = 1;
        for(File arquivo: arquivos){
            System.out.println(contador + ". " + "\033[1m" + arquivo.getName() + "\033[0m");
            contador++;
        }
    }
}
