package Cadastramento;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeletarCadastro {
    Scanner sc = new Scanner(System.in);
    String criterio;
    CriteriosAnimal02 criterioDefinitivo;
    File[] arquivosAlvo = new File[200];
    int i;

    public void deletarCadastro() {
        System.out.println("========Deletar Pets Cadastrados========");
        System.out.print("Defina o critério dentre NOME,TIPO,SEXO,ENDEREÇO,IDADE,PESO,RAÇA: ");
        criterio = sc.nextLine();
        criterioDefinitivo = respostaCriterioDeletar(criterio);
        System.out.print("Digite o valor a ser procurado do critério " + "\033[1m" + criterioDefinitivo + "\033[0m" + ": ");
        String valorRef = sc.nextLine();
        System.out.println("Pets Encontrados: ");
        procurarPet(criterioDefinitivo, valorRef);
        deletarPet();
    }

    public CriteriosAnimal02 respostaCriterioDeletar(String criterio) {
        try {
            CriteriosAnimal02 criterioAnimal = CriteriosAnimal02.valueOf(criterio.toUpperCase().trim());
            return criterioAnimal;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Critério Inválido! Digite uma das opções acima na mesma formatação");
        }
    }

    public void procurarPet(CriteriosAnimal02 criterioAnimal, String valorRef) {
        int contador = 1;
        File petsCadastrados = new File("C:\\WS-programs\\IntelliJ\\desafioCadastro\\PetsCadastrados");
        if (!petsCadastrados.exists() || !petsCadastrados.isDirectory()) {
            System.out.println("Pets Cadastrados não existe!");
            return;
        }
        File[] arquivos = petsCadastrados.listFiles();
        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Este diretório está vazio!");
            return;
        }


        for (File arquivo : arquivos) {
            try {
                Scanner scannerLeitura = new Scanner(arquivo);
                while (scannerLeitura.hasNextLine()) {
                    String line = scannerLeitura.nextLine();
                    String[] part = line.split(": ");
                    if(part.length < 2){
                        continue;
                    }
                    String key = part[0].trim();
                    String valor = part[1].trim();

                    if (key.toLowerCase().contains(criterioAnimal.toString().toLowerCase())) {
                        if (valor.toLowerCase().contains(valorRef.toLowerCase().trim())) {
                            String regex = "([A-Z]+)?(\\.TXT)";
                            Pattern pattern = Pattern.compile(regex);
                            Matcher matcher = pattern.matcher(arquivo.getName());
                            if(matcher.find()){
                                if(i >= arquivosAlvo.length){
                                    System.out.println("Limite de arquivos alcançado!");
                                }
                                arquivosAlvo[i] = arquivo;
                                System.out.println(contador + ". " + matcher.group());
                                contador++;
                                i++;
                                break;
                            }
                        }
                    }
                }
                scannerLeitura.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void deletarPet(){
        if (i == 0) {
            System.out.println("Nenhum pet correspondente encontrado para deletar.");
            return;
        }

        System.out.print("Digite o número do pet que deseja deletar (ou 0 para cancelar): ");
        int escolha = sc.nextInt();
        sc.nextLine();

        if (escolha == 0) {
            System.out.println("Operação cancelada.");
            return;
        }

        if (escolha < 1 || escolha > i) {
            System.out.println("Número inválido. Nenhum arquivo foi deletado.");
            return;
        }

        File arquivoAlvo = arquivosAlvo[escolha-1];

        if (arquivoAlvo.delete()) {
            System.out.println("Arquivo " + "\033[1m" + arquivoAlvo.getName() + "\033[0m" + " deletado com sucesso!");
        } else {
            System.out.println("Falha ao deletar o arquivo " + arquivoAlvo.getName());
        }
    }


}
