package Propuesta;

import Prenda.Prenda;

public class Propuesta {
    private Prenda prenda;
    private Boolean esAAgregar;
    private EstadoDeLaPropuesta estadoDeLaPropuesta;

    public Propuesta(Prenda prenda, Boolean esAAgregar){
        this.prenda = prenda;
        this.esAAgregar = esAAgregar;
        this.estadoDeLaPropuesta = EstadoDeLaPropuesta.NO_EVALUADA;
    }

    public Prenda getPrenda() { return this.prenda; }
    public Boolean getEsAAgregar() { return this.esAAgregar; }
    public EstadoDeLaPropuesta getEstadoDeLaPropuesta() { return this.estadoDeLaPropuesta; }
    public void setEstadoDeLaPropuesta(EstadoDeLaPropuesta estadoDeLaPropuesta){
        this.estadoDeLaPropuesta = estadoDeLaPropuesta;
    }
}
