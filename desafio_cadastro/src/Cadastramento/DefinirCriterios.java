package Cadastramento;

import Pet.TipoAnimal;
import java.util.Scanner;

public class DefinirCriterios {
    Scanner sc = new Scanner(System.in);
    String tipoAnimal;
    String criterio01;
    String criterio02;
    String r1;
    String r2 = null;
    ArmazenarCriterios armazenarCriterios;
    FiltrarPets filtrarPets = new FiltrarPets();

    public void definirCriterios() {
        System.out.println("----------Buscador de Pets Cadastrados----------");
        System.out.print("Informe o Tipo do Animal procurado ( GATO / CACHORRO ): ");
        tipoAnimal = sc.nextLine();
        TipoAnimal respostaTipoAnimal = respostaDefinirTipoAnimal();

        System.out.println("Escolha um critério dentre Nome/Sexo/Endereço/Idade/Peso/Raça");
        System.out.print("Escolha o critério a ser usado: ");
        criterio01 = sc.nextLine();
        CriterioAnimal01 respostaCriterio01 = respostaCriterio01();
        r1 = definirValorCriterio01();

        CriterioAnimal01 respostaCriterio02 = respostaCriterio02();
        armazenarCriterios = new ArmazenarCriterios(respostaTipoAnimal, respostaCriterio01, respostaCriterio02, r1, r2);
        filtrarPets.buscarPets(armazenarCriterios);
    }

    public TipoAnimal respostaDefinirTipoAnimal() {
        try {
            return TipoAnimal.valueOf(tipoAnimal.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Resposta Inválida! Digite Gato ou Cachorro");
        }
    }

    public CriterioAnimal01 respostaCriterio01(){
        try {
            return CriterioAnimal01.valueOf(criterio01.toUpperCase().trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Resposta Inválida! Digite um dos critérios acima");
        }
    }

    public CriterioAnimal01 respostaCriterio02(){
        System.out.print("Gostaria de mais um Critério( Sim / Não)? ");
        String r = sc.nextLine();
        if(r.equalsIgnoreCase("Sim")){
            System.out.println("Escolha um critério dentre Nome/Sexo/Endereço/Idade/Peso/Raça");
            System.out.print("Escolha o critério a ser usado: ");
            criterio02 = sc.nextLine();
            try {
                CriterioAnimal01 criterioSelecionado = CriterioAnimal01.valueOf(criterio02.toUpperCase().trim());
                definirValorCriterio02();
                return criterioSelecionado;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Resposta Inválida! Digite um dos critérios acima");
            }
        } else {
            return CriterioAnimal01.NULL;
        }
    }

    public String definirValorCriterio01(){
        System.out.print("Digite o valor buscado usando como referência o critério selecionado: ");
        String respostaCriterio1 = sc.nextLine();
        return respostaCriterio1.trim();
    }

    public void definirValorCriterio02(){
        System.out.print("Digite o valor buscado usando como referência o critério selecionado: ");
        String respostaCriterio2 = sc.nextLine();
        r2 = respostaCriterio2.trim();
    }
}
