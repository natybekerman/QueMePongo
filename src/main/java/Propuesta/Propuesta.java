package Propuesta;

import Prenda.Prenda;
import Guardarropa.Guardarropa;

public interface Propuesta {
    public Prenda getPrenda();
    public EstadoDeLaPropuesta getEstadoDeLaPropuesta();
    public void aceptar(Guardarropa guardarropa);
    public void rechazar(Guardarropa guardarropa);
    public void deshacer(Guardarropa guardarropa);
}
