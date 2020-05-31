import Exceptions.PrendaException;
import Prenda.Prenda;
import Propuesta.*;
import Prenda.Categoria;

import java.util.Set;
import java.util.stream.Collectors;

public class Guardarropa {
    private Set<Prenda> prendas;
    private Set<Propuesta> propuestas;
    // Decidi que el estilo sea un string y no enum
    // porque cada uno puede tener su decision de estilos por los que separar
    private String estilo;
    public Set<Prenda> getPrendas() { return this.prendas; }
    public Set<Propuesta> getPrendasPropuestas() { return this.propuestas; }

    public Set<Prenda> getPrendasParaLaCategoria(Categoria categoria){
        return this.prendas.stream()
                .filter(prenda -> prenda.getCategoria().equals(categoria))
                .collect(Collectors.toSet());
    }
    public Set<Propuesta> verPospuestas(){ return this.propuestas; }

    public void agregarPrenda(Prenda prenda){
        if(!this.prendas.contains(prenda)) {
            this.prendas.add(prenda);
        }
    }
    public void quitarPrenda(Prenda prenda) {
        if (this.prendas.contains(prenda)) {
            this.prendas.remove(prenda);
        }
    }
    public void agregarPropuesta(Propuesta propuesta){
        validadorQueLaPrendaNoTengaPropuestaGuardada(propuesta);
        this.propuestas.add(propuesta);
    }
    public void aceptarPropuesta(Propuesta propuesta){
        propuesta.setEstadoDeLaPropuesta(EstadoDeLaPropuesta.ACEPTADA);
        if(propuesta.getEsAAgregar()){
            agregarPrenda(propuesta.getPrenda());
        } else {
            quitarPrenda(propuesta.getPrenda());
        }
    }
    public void rechazarPropuesta(Propuesta propuesta){
        propuesta.setEstadoDeLaPropuesta(EstadoDeLaPropuesta.RECHAZADA);
        if(propuesta.getEsAAgregar()){
            quitarPrenda(propuesta.getPrenda());
        } else {
            agregarPrenda(propuesta.getPrenda());
        }
    }
    public void deshacerPropuesta(Propuesta propuesta){
        if(propuesta.getEstadoDeLaPropuesta() == EstadoDeLaPropuesta.ACEPTADA){
            if (propuesta.getEsAAgregar()) {
                quitarPrenda(propuesta.getPrenda());
            } else {
                agregarPrenda(propuesta.getPrenda());
            }
        }else{
            if (propuesta.getEsAAgregar()) {
                agregarPrenda(propuesta.getPrenda());
            } else {
                quitarPrenda(propuesta.getPrenda());
            }
        }
        propuesta.setEstadoDeLaPropuesta(EstadoDeLaPropuesta.NO_EVALUADA);
    }
    public void deshacerTodasLasPropuestas(){
        this.propuestas.stream()
                .filter(propuesta -> propuesta.getEstadoDeLaPropuesta() != EstadoDeLaPropuesta.NO_EVALUADA)
                .forEach(propuesta -> deshacerPropuesta(propuesta));
    }
    public void validadorQueLaPrendaNoTengaPropuestaGuardada(Propuesta propuesta){
        if(this.propuestas.stream().anyMatch(propuesta1 -> propuesta1.getPrenda() == propuesta.getPrenda())){
            throw new PrendaException("Ya hay una propuesta con esa prenda");
        }
    }
}
