package Propuesta;

import Guardarropa.Guardarropa;
import Prenda.Prenda;

public class PropuestaDeQuitar {
    private Prenda prenda;
    private EstadoDeLaPropuesta estadoDeLaPropuesta;

    public PropuestaDeQuitar(Prenda prenda) {
        this.prenda = prenda;
        this.estadoDeLaPropuesta = EstadoDeLaPropuesta.NO_EVALUADA;
    }
    public Prenda getPrenda(){ return this.prenda; }
    public EstadoDeLaPropuesta getEstadoDeLaPropuesta() { return this.estadoDeLaPropuesta; }

    public void aceptar(Guardarropa guardarropa) {
        this.estadoDeLaPropuesta = EstadoDeLaPropuesta.ACEPTADA;
        guardarropa.quitarPrenda(this.prenda);
    }
    public void rechazar(Guardarropa guardarropa){
        this.estadoDeLaPropuesta = EstadoDeLaPropuesta.RECHAZADA;
        guardarropa.agregarPrenda(this.prenda);
    }
    public void deshacer(Guardarropa guardarropa){
        if(this.estadoDeLaPropuesta == EstadoDeLaPropuesta.ACEPTADA){
            guardarropa.agregarPrenda(this.prenda);
        }
        this.estadoDeLaPropuesta = EstadoDeLaPropuesta.NO_EVALUADA;
    }
}
