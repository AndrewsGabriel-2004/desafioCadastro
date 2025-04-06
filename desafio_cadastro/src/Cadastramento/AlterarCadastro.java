package Cadastramento;

import Files.FilesHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlterarCadastro {
    Scanner sc01;
    Scanner sc02;
    CriteriosAnimal criterios;
    private String nomeFileAlterar;
    private static File arquivoAlvo;
    private FilesHandling filesHandling = new FilesHandling();

    public void alterarCadastro() {
        sc01 = new Scanner(System.in);
        System.out.println("=======Alteração de Cadastro=======");
        System.out.print("Digite o nome do Pet que você deseja alterar: ");
        nomeFileAlterar = sc01.nextLine();
        procurarPetAlterar(nomeFileAlterar);
        System.out.println("Digite o critério a ser alterado dentre NOME/ENDEREÇO/IDADE/PESO/RAÇA ");
        System.out.print("Critério: ");
        String criterioAnimal = sc01.nextLine();
        criteriosAlterar(criterioAnimal);
    }

    public void procurarPetAlterar(String nomeFileAlterar) {
        File arquivosDiretorio = new File("C:\\WS-programs\\IntelliJ\\desafioCadastro\\PetsCadastrados");
        if (!arquivosDiretorio.exists() || !arquivosDiretorio.isDirectory()) {
            System.out.println("Pets Cadastrados não existe!");
            return;
        }

        File[] arquivosDentroDoDiretorio = arquivosDiretorio.listFiles();
        if (arquivosDentroDoDiretorio == null || arquivosDentroDoDiretorio.length == 0) {
            return;
        }

        boolean encontrou = false;
        for (File arquivo : arquivosDentroDoDiretorio) {
            String nomeArquivo = arquivo.getName();
            String regex = "([A-Z]+)?(\\.TXT)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(nomeArquivo);
            if (matcher.find()) {
                if (matcher.group().contains(nomeFileAlterar.toUpperCase().trim().replace(" ", ""))) {
                    System.out.println("Pet em questão: " + arquivo.getName());
                    encontrou = true;
                    arquivoAlvo = arquivo;
                    break;
                }
            }
        }
        if (!encontrou) {
            System.out.println("Arquivo não encontrado!");
        }
    }

    public void criteriosAlterar(String criterioAnimal) {
        CriteriosAnimal criterio;
        String chave;
        String valorAntigo;
        StringBuilder substituicao = new StringBuilder();
        try {
            criterio = CriteriosAnimal.valueOf(criterioAnimal.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Critério Inválido! Digite uma das opções acima na mesma formatação");
        }
        if (criterio == CriteriosAnimal.SEXO) {
            throw new IllegalArgumentException("Respostas Inválida! Sexo não pode ser alterado");
        }
        try {
            sc02 = new Scanner(arquivoAlvo);
            Scanner sc = new Scanner(System.in);
            while (sc02.hasNextLine()) {
                String line = sc02.nextLine();
                String[] part = line.split(": ");
                if (part.length < 2) {continue;}

                chave = part[0].trim();
                valorAntigo = part[1].trim();

                if(chave.toLowerCase().contains(criterio.name().toLowerCase())){
                    System.out.print("Digite o novo valor do critério "+ criterio + ": ");
                    String valorNovo = sc.nextLine();
                    line = line.replace(valorAntigo, valorNovo);
                }
                substituicao.append(line).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        filesHandling.alterarFile(arquivoAlvo, substituicao);
        System.out.println("Alteração realizada com sucesso!");
    }

}
