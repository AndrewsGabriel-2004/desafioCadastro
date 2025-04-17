package Cadastramento;

public enum CriteriosAnimal02 {
    NOME("NOME"),RAÇA("RAÇA"),IDADE("IDADE") ,PESO("PESO") ,TIPO("TIPO") ,ENDEREÇO("ENDEREÇO"),SEXO("SEXO");

    private final String nome;
    CriteriosAnimal02(String nome) {
        this.nome = nome;
    }
}
