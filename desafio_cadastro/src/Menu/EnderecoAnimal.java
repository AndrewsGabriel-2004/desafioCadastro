package Menu;

public class EnderecoAnimal {
    public static final String NAO_INFORMADO = "NÃO INFORMADO";
    private String cidade;
    private String rua;
    private String numeroDaCasa;

    public EnderecoAnimal(String cidade, String rua, String numeroDaCasa) {
        this.cidade = cidade.isEmpty() ? NAO_INFORMADO: cidade;
        this.rua = rua.isEmpty() ? NAO_INFORMADO: rua;
        this.numeroDaCasa = numeroDaCasa.isEmpty() ? NAO_INFORMADO: numeroDaCasa;
    }

    @Override
    public String toString() {
        return rua + ", " + numeroDaCasa + " , " + cidade;
    }
}
