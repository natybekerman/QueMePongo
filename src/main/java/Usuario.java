import Exceptions.GuardarropasException;
import Prenda.Prenda;
import Propuesta.Propuesta;

import java.util.Set;

public class Usuario {
    private Set<Guardarropa> guardarropasPropios;
    private Set<Guardarropa> guardarropasDeOtro;

    public void agregarGuardarropasPropio(Guardarropa guardarropa){ this.guardarropasPropios.add(guardarropa); }
    public void agregarGuardarropasDeOtro(Guardarropa guardarropa){ this.guardarropasDeOtro.add(guardarropa); }

    public void generarPropuesta(Propuesta propuesta, Guardarropa guardarropa){
        validadorSiContieneElGuardarropas(this.guardarropasDeOtro, guardarropa);
        guardarropa.agregarPropuesta(propuesta);
    }
    private void validadorSiContieneElGuardarropas(Set<Guardarropa> setDeGuardarropas, Guardarropa guardarropaAVerificar){
        if (!setDeGuardarropas.contains(guardarropaAVerificar)){
            throw new GuardarropasException("Guardarropas incorrecto ya que no le puede sugerir");
        }
    }
}
