package Cadastramento;

import Pet.TipoAnimal;

public class PetArmazenarInformacoes {
    private String nome;
    private TipoAnimal tipo;
    private String sexo;
    private String endereco;
    private String idade;
    private String peso;
    private String raca;

    String nomePet;
    String sexoPet;
    String idadePet;
    String pesoPet;
    String racaPet;
    String enderecoPet;

    public PetArmazenarInformacoes(PetArmazenarInformacoes pet) {
        nomePet = "\033[1m" + pet.getNome() + "\033[0m";
        sexoPet = "\033[1m" + pet.getSexo() + "\033[0m";
        idadePet = "\033[1m" + pet.getIdade() + "\033[0m";
        pesoPet = "\033[1m" + pet.getPeso() + "\033[0m";
        racaPet = "\033[1m" + pet.getRaca() + "\033[0m";
        enderecoPet = "\033[1m" + pet.getEndereco() + "\033[0m";
    }

    public PetArmazenarInformacoes(String nome, TipoAnimal tipo, String sexo, String endereco, String idade, String peso, String raca) {
        this.nome = nome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.endereco = endereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getIdade() {
        return idade;
    }

    public String getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }

    public String getNomePet() {
        return nomePet;
    }

    public String getSexoPet() {
        return sexoPet;
    }

    public String getIdadePet() {
        return idadePet;
    }

    public String getPesoPet() {
        return pesoPet;
    }

    public String getRacaPet() {
        return racaPet;
    }

    public String getEnderecoPet() {
        return enderecoPet;
    }

}
