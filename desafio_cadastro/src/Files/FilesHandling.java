package Files;

import java.io.*;

public class FilesHandling implements Files {
    private final File directoryFolder;
    private final File archive;

    public FilesHandling() {
        directoryFolder = new File("folder");
        directoryFolder.mkdir();
        archive = new File(directoryFolder, "formulario.txt");
        if(archive.exists()){
            try {
                archive.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void readFile() {
        if (archive.exists()) {
            try (FileReader fr = new FileReader(archive);
                 BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void writeFile() {
        try (FileWriter fw = new FileWriter(archive);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("1 - Qual o nome e sobrenome do pet? " +
                    "\n 2 - Qual o tipo do pet (Cachorro/Gato)? " +
                    "\n 3 - Qual o sexo do animal? " +
                    "\n 4 - Qual endereço e bairro que ele foi encontrado? " +
                    "\n 5 - Qual a idade aproximada do pet? " +
                    "\n 6 - Qual o peso aproximado do pet? " +
                    "\n 7 - Qual a raça do pet?");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
