package Files;

import Exceptions.InvalidIOException;

import java.io.*;
import java.util.Scanner;

public class FilesHandling implements Files {
    private final File directoryFolder;
    private final File archive;
    Scanner sc = new Scanner(System.in);


    public FilesHandling() {
        directoryFolder = new File("folder");
        directoryFolder.mkdir();
        archive = new File(directoryFolder, "formulario.txt");
        try {
            if (archive.createNewFile()) {
                System.out.println("Archive Created? " + archive.getAbsolutePath());
            }
        } catch (IOException e) {
            try {
                throw new InvalidIOException("Error on Archive's creation", e);
            } catch (InvalidIOException ex) {
                throw new RuntimeException(ex);
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
            } catch (IOException e) {
                try {
                    throw new InvalidIOException("Error on Archive's read", e);
                } catch (InvalidIOException ex) {
                    throw new RuntimeException(ex);
                }
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
            try {
                throw new InvalidIOException("Error on Archive's write", e);
            } catch (InvalidIOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


}
