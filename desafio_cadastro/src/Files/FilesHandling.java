package Files;

import Exceptions.InvalidIOException;
import Pet.Pet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FilesHandling implements Files {
    private final File directoryFolder;
    private final File archive;

    public FilesHandling() {
        directoryFolder = new File("folder");
        directoryFolder.mkdir();
        archive = new File(directoryFolder,"formulario.txt");
        try {
            if (archive.createNewFile()) {
                System.out.println("Archive Created? " + archive.getAbsolutePath());
            }
        } catch (IOException e) {
            throw new RuntimeException(new InvalidIOException("Error on Archive's create", e));
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
            } catch (IOException e) {
                throw new RuntimeException(new InvalidIOException("Error on Archive's read", e));
            }
        }
    }

    @Override
    public void writeFile() {
        try (FileWriter fw = new FileWriter(archive);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("1 - Qual o nome e sobrenome do pet? " +
                    "\n2 - Qual o tipo do pet (Cachorro/Gato)? " +
                    "\n3 - Qual o sexo do animal? " +
                    "\n4 - Qual endereço e bairro que ele foi encontrado? " +
                    "\n5 - Qual a idade aproximada do pet? " +
                    "\n6 - Qual o peso aproximado do pet? " +
                    "\n7 - Qual a raça do pet?");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(new InvalidIOException("Error on Archive's write", e));
        }
    }

    public void saveFile(Pet pet, String nomeAnimal) {
        File petsCadastrados = new File("PetsCadastrados");
        petsCadastrados.mkdir();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm'-'");

        String nomeArchiveRegister = LocalDateTime.now().format(dateTimeFormatter);
        nomeArchiveRegister = nomeArchiveRegister.concat(nomeAnimal.toUpperCase().replace(" ", "")).concat(".TXT");

        File archiveRegister = new File(petsCadastrados, nomeArchiveRegister);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archiveRegister, true))) {
            bw.write(pet.toString());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(new InvalidIOException("Error on Archive's save", e));
        }
    }
}
