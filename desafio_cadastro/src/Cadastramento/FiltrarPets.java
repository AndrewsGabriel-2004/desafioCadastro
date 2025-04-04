package Cadastramento;

import java.io.File;

public class FiltrarPets{
    public boolean atendeCriterios(PetArmazenarInformacoes pet, ArmazenarCriterios criterios) {
        if (pet.getTipo() != criterios.getTipoAnimal()) {
            return false;
        }
        String valorCrit1 = UtilsRemoverAcento.removerAcentos(criterios.getValorCriterio01());
        String valorCrit2 = (criterios.valorCriterio02 != null) ? UtilsRemoverAcento.removerAcentos(criterios.getValorCriterio02()) : "";
        String nomePet = UtilsRemoverAcento.removerAcentos(pet.getNome());
        String sexoPet = UtilsRemoverAcento.removerAcentos(pet.getSexo());
        String idadePet = UtilsRemoverAcento.removerAcentos(pet.getIdade());
        String pesoPet = UtilsRemoverAcento.removerAcentos(pet.getPeso());
        String racaPet = UtilsRemoverAcento.removerAcentos(pet.getRaca());
        String enderecoPet = UtilsRemoverAcento.removerAcentos(pet.getEndereco());

        switch (criterios.getCriterio01()) {
            case NOME:
                if (!nomePet.toLowerCase().contains(valorCrit1.toLowerCase())) return false;
                break;
            case SEXO:
                if (!sexoPet.equalsIgnoreCase(valorCrit1)) return false;
                break;
            case IDADE:
                if (!idadePet.equalsIgnoreCase(valorCrit1)) return false;
                break;
            case PESO:
                if (!pesoPet.equalsIgnoreCase(valorCrit1)) return false;
                break;
            case RAÇA:
                if (!racaPet.equalsIgnoreCase(valorCrit1)) return false;
                break;
            case ENDEREÇO:
                if (!enderecoPet.toLowerCase().contains(valorCrit1.toLowerCase())) return false;
                break;
        }

        if (!valorCrit2.isEmpty()) {
            switch (criterios.getCriterio02()) {
                case NOME:
                    if (!nomePet.contains(valorCrit2)) return false;
                    break;
                case SEXO:
                    if (!sexoPet.equals(valorCrit2)) return false;
                    break;
                case IDADE:
                    if (!idadePet.equals(valorCrit2)) return false;
                    break;
                case PESO:
                    if (!pesoPet.equals(valorCrit2)) return false;
                    break;
                case RAÇA:
                    if (!racaPet.equals(valorCrit2)) return false;
                    break;
                case ENDEREÇO:
                    if (!enderecoPet.contains(valorCrit2)) return false;
                    break;
            }
        }
        return true;
    }

    public void buscarPets(ArmazenarCriterios criterios){
        LerArquivosPetsCadastrados lerArquivosPetsCadastrados = new LerArquivosPetsCadastrados();
        File pasta = new File("C:\\WS-programs\\IntelliJ\\desafioCadastro\\PetsCadastrados");

        if (!pasta.exists() || !pasta.isDirectory()) {
            System.out.println("A pasta 'PetsCadastrados' não existe ou não é um diretório.");
            return;
        }
        File[] arquivos = pasta.listFiles();
        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Nenhum pet cadastrado encontrado.");
            return;
        }
        int contador = 1;
        boolean encontrouPet = false;
        for (File arquivo : arquivos) {
            PetArmazenarInformacoes pet = lerArquivosPetsCadastrados.lerConteudoDoArquivo(arquivo);
            if (pet != null && atendeCriterios(pet, criterios)) {
                System.out.println(contador + ". " + pet.getNome() + " - " + pet.getTipo() + " - " + pet.getSexo() + " - " +
                        pet.getEndereco() + " - " + pet.getIdade() + " anos - " + pet.getPeso() + "kg - " + pet.getRaca());
                contador++;
                encontrouPet = true;
            }
        }
        if (!encontrouPet) {
            System.out.println("Nenhum pet encontrado com os critérios informados.");
        }
    }
}
