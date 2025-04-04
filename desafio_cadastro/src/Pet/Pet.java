package Pet;

import java.util.Locale;

public class Pet {
    Locale localeBR = new Locale("pt", "BR");
    public static final String NAO_INFORMADO = "NÃO INFORMADO";

    private String nomeAnimal;
    private TipoAnimal tipoAnimal;
    private SexoAnimal sexoAnimal;
    private EnderecoAnimal enderecoAnimal;
    private String idadeAnimal;
    private String pesoAnimal;
    private String racaAnimal;

    public Pet(String nomeAnimal, TipoAnimal tipoAnimal, SexoAnimal sexoAnimal, EnderecoAnimal enderecoAnimal, String idadeAnimal, String pesoAnimal, String racaAnimal) {
        validarNome(nomeAnimal);
        validarIdade(idadeAnimal);
        validarPeso(pesoAnimal);
        validarRaca(racaAnimal);

        this.nomeAnimal = nomeAnimal.isEmpty() ? NAO_INFORMADO : nomeAnimal;
        this.tipoAnimal = tipoAnimal;
        this.sexoAnimal = sexoAnimal;
        this.enderecoAnimal = enderecoAnimal;
        this.idadeAnimal = idadeAnimal.isEmpty() ? NAO_INFORMADO : idadeAnimal;
        this.pesoAnimal = pesoAnimal.isEmpty() ? NAO_INFORMADO : pesoAnimal;
        this.racaAnimal = racaAnimal.isEmpty() ? NAO_INFORMADO : racaAnimal;
    }

    private void validarNome(String nomeAnimal) {
        if (!nomeAnimal.isEmpty()) {
            if (!nomeAnimal.matches("^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)+$")) {
                throw new IllegalArgumentException("Nome Inválido! Informe nome e sobrenome sem caracteres especiais");
            }
        }
    }

    private void validarIdade(String idadeAnimal) {
        if (!idadeAnimal.isEmpty()) {
            if (Locale.getDefault() == localeBR) {
                idadeAnimal = idadeAnimal.replace(".", ",");
            } else {
                idadeAnimal = idadeAnimal.replace(",", ".");
            }
            if (!idadeAnimal.matches("[0-9]+([,.][0-9]+)?$")) {
                throw new IllegalArgumentException("Idade Inválida! Não é permitido letras ou caracteres especiais");
            }
            double idadeAnimalConfirmation = Double.parseDouble(idadeAnimal);
            if (idadeAnimalConfirmation > 20 || idadeAnimalConfirmation < 0) {
                throw new IllegalArgumentException("Idade inválida! Informe uma idade de até 20 anos");
            }
        }
    }

    private void validarPeso(String pesoAnimal) {
        if (!pesoAnimal.isEmpty()) {
            if (Locale.getDefault() == localeBR) {
                pesoAnimal = pesoAnimal.replace(".", ",");
            } else {
                pesoAnimal = pesoAnimal.replace(",", ".");
            }
            if (!pesoAnimal.matches("[0-9]+([,.][0-9]+)?$")) {
                throw new IllegalArgumentException("Peso Inválido! Não é permitido letras ou caracteres especiais");
            }
            double pesoAnimalConfirmation = Double.parseDouble(pesoAnimal);
            if (pesoAnimalConfirmation > 60 || pesoAnimalConfirmation < 0.5) {
                throw new IllegalArgumentException("Peso Inválido! Informe um peso de até 60 Kg ou menor que 0,5 Kg");
            }
        }
    }

    private void validarRaca(String racaAnimal) {
        if (!racaAnimal.isEmpty()) {
            if (!racaAnimal.matches("^[A-Za-z ]+$")) {
                throw new IllegalArgumentException("Raça inválida! Apenas letras são permitidas.");
            }
        }
    }

    @Override
    public String toString() {
        return "1-Nome: " + nomeAnimal + "\n2-Tipo: " + tipoAnimal + "\n3-Sexo: " + sexoAnimal + "\n4-Endereço: " + enderecoAnimal.toString() + "\n5-Idade: " + idadeAnimal + " anos" + "\n6-Peso: " + pesoAnimal + "Kg" + "\n7-Raça: " + racaAnimal;
    }
}
