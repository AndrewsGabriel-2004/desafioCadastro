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
}
