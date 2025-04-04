package Cadastramento;

import Exceptions.InvalidIOException;
import Pet.TipoAnimal;

import java.io.*;
import java.util.Scanner;

public class LerArquivosPetsCadastrados {
    public void lerArquivosPets() {
        File file = new File("C:\\WS-programs\\IntelliJ\\desafioCadastro\\PetsCadastrados");
        File[] arquivosDentroDoDiretorio = file.listFiles();
        for (File arquivoIndividual : arquivosDentroDoDiretorio) {
            lerConteudoDoArquivo(arquivoIndividual);
        }
    }

    public PetArmazenarInformacoes lerConteudoDoArquivo(File arquivoIndividual) {
        try (Scanner sc = new Scanner(arquivoIndividual)) {
            String nome = "", sexo = "", endereco = "", raca = "", idade = "", peso = "";
            TipoAnimal tipo = null;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] part = line.split(": ");

                if (part.length < 2) {
                    continue;
                }
                String chave = part[0].trim();
                String valor = part[1].trim();

                switch (chave) {
                    case "1-Nome":
                        nome = valor;
                        break;
                    case "2-Tipo":
                        tipo = TipoAnimal.valueOf(valor.toUpperCase().trim());
                        break;
                    case "3-Sexo":
                        sexo = valor;
                        break;
                    case "4-Endereço":
                        endereco = valor;
                        break;
                    case "5-Idade":
                        idade = valor;
                        break;
                    case "6-Peso":
                        peso = valor;
                        break;
                    case "7-Raça":
                        raca = valor;
                        break;
                }
            }
            return new PetArmazenarInformacoes(nome,tipo,sexo,endereco,idade,peso,raca);
        } catch (IOException e) {
            throw new RuntimeException(new InvalidIOException("Erro de leitura do arquivo: " + arquivoIndividual.getName(), e));
        }
    }
}
