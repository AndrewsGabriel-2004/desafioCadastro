package Cadastramento;

import Files.FilesHandling;
import Pet.Pet;
import Pet.TipoAnimal;
import Pet.SexoAnimal;
import Pet.EnderecoAnimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroDosPets {
    private final FilesHandling filesHandling = new FilesHandling();
    private final Scanner sc = new Scanner(System.in);
    private Pet pet = new Pet();

    public void cadastrarNovosPets() {
        filesHandling.readFile();
        System.out.println("Preencha os dados do Pet: ");

        String nomeAnimal = nomeAnimalCadastro();
        TipoAnimal tipoAnimal = tipoAnimalCadastro();
        SexoAnimal sexoAnimal = sexoAnimalCadastro();
        EnderecoAnimal enderecoAnimal = enderecoAnimalCadastro();
        String idadeAnimal = idadeAnimalCadastro();
        String pesoAnimal = pesoAnimalCadastro();
        String racaAnimal = racaAnimalCadastro();

        Pet pet = new Pet(nomeAnimal, tipoAnimal, sexoAnimal, enderecoAnimal, idadeAnimal, pesoAnimal, racaAnimal);
        filesHandling.saveFile(pet, nomeAnimal);
        System.out.println("Pet cadastrado com sucesso!");
    }

    private String nomeAnimalCadastro() {
        System.out.print("Nome do pet (Nome e Sobrenome): ");
        String nomeAnimal = sc.nextLine();
        pet.validarNome(nomeAnimal);
        return nomeAnimal;
    }

    private TipoAnimal tipoAnimalCadastro() {
        System.out.print("Tipo do Animal (CACHORRO/GATO): ");
        String tipoAnimal = sc.nextLine();
        try {
            return TipoAnimal.valueOf(tipoAnimal.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Tipo Inválido! Digite CACHORRO ou GATO");
        }
    }

    private SexoAnimal sexoAnimalCadastro() {
        System.out.print("Sexo do Animal: ");
        String sexoAnimal = sc.nextLine();
        try {
            return SexoAnimal.valueOf(sexoAnimal.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Sexo Inválido! Digite MACHO ou FEMEA");
        }
    }

    private EnderecoAnimal enderecoAnimalCadastro() {
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Rua: ");
        String rua = sc.nextLine();
        System.out.print("Número da Moradia: ");
        String numero = sc.nextLine();
        return new EnderecoAnimal(cidade, rua, numero);
    }

    private String idadeAnimalCadastro() {
        System.out.println("Informe se a idade será dada em Meses (Exemplo: 8 meses, 1 mês).");
        System.out.print("Idade do Animal: ");
        String idadeAnimal = sc.nextLine();
        if (idadeAnimal.matches("^(1[0-2]|[1-9])(\\s)?(meses|MESES|mes|mês|MÊS)$")) {
            String regex = "^(1[0-2]|[1-9])";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(idadeAnimal);
            if (matcher.find()) {
                int meses = Integer.parseInt(matcher.group());
                double anos = meses / 12.0;
                idadeAnimal = String.format("%.1f", anos);
            }
        }
        pet.validarIdade(idadeAnimal);
        return idadeAnimal;
    }

    private String pesoAnimalCadastro() {
        System.out.print("Peso do Animal: ");
        String pesoAnimal = sc.nextLine();
        pet.validarPeso(pesoAnimal);
        return pesoAnimal;
    }

    private String racaAnimalCadastro() {
        System.out.print("Raça do Animal: ");
        String racaAnimal = sc.nextLine();
        pet.validarRaca(racaAnimal);
        return racaAnimal;
    }

}
