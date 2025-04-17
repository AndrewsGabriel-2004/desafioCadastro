package Cadastramento;

import Pet.TipoAnimal;

public class ArmazenarCriterios {
    private CriterioAnimal01 criterio01;
    private CriterioAnimal01 criterio02;
    private TipoAnimal tipoAnimal;
    String valorCriterio01;
    String valorCriterio02;

    public ArmazenarCriterios(TipoAnimal tipoAnimal, CriterioAnimal01 criterio01, CriterioAnimal01 criterio02, String valorCriterio01, String valorCriterio02) {
        this.tipoAnimal = tipoAnimal;
        this.criterio01 = criterio01;
        this.valorCriterio01 = valorCriterio01;
        if (criterio02 != CriterioAnimal01.NULL && criterio02 != criterio01) {
            this.criterio02 = criterio02;
            this.valorCriterio02 = valorCriterio02;
        }
    }

    public CriterioAnimal01 getCriterio01() {
        return criterio01;
    }
    public CriterioAnimal01 getCriterio02() {
        return criterio02;
    }
    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }
    public String getValorCriterio01() {
        return valorCriterio01;
    }
    public String getValorCriterio02() {
        return valorCriterio02;
    }
}
