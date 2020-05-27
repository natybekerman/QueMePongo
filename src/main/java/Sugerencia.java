import Exceptions.PrendaException;
import Service.Clima.MiClima;

import java.util.Set;
import java.util.stream.Collectors;

public class Sugerencia {
    private Set<Prenda> atuendoSugerido;
    private MiClima climaActual;

    public Set<Prenda> generarSugerencia(Guardarropa guardarropa){
        validadorGuardarropaParaHacerSugerencia(guardarropa);
        this.atuendoSugerido.add(prendaSugerenciaAptaParaLaTemperaturaActual(
                guardarropa.getPrendasParaLaCategoria(Categoria.PARTE_SUPERIOR)));
        this.atuendoSugerido.add(prendaSugerenciaAptaParaLaTemperaturaActual(
                guardarropa.getPrendasParaLaCategoria(Categoria.PARTE_INFERIOR)));
        this.atuendoSugerido.add(prendaSugerenciaAptaParaLaTemperaturaActual(
                guardarropa.getPrendasParaLaCategoria(Categoria.CALZADO)));

        if (!guardarropa.getPrendasParaLaCategoria(Categoria.ACCESORIOS).isEmpty())
        this.atuendoSugerido.add(prendaSugerenciaAptaParaLaTemperaturaActual(
                guardarropa.getPrendasParaLaCategoria(Categoria.ACCESORIOS)));

        return this.atuendoSugerido;
    }
    Prenda prendaSugerenciaAptaParaLaTemperaturaActual(Set<Prenda> prendas){
        if (climaActual.getTemperatura() < 20 ) {
            prendas.stream().filter(prenda -> prenda.getEstadoClima().equals(EstadoClima.FRIO)
                    || prenda.getEstadoClima().equals(EstadoClima.CUALQUIERCLIMA));
        }else if (climaActual.getTemperatura() >= 20){
            prendas.stream().filter(prenda -> prenda.getEstadoClima().equals(EstadoClima.CALOR)
                    || prenda.getEstadoClima().equals(EstadoClima.CUALQUIERCLIMA));
        }
        if(prendas.isEmpty()){ throw new PrendaException("No hay ropa que se pueda sugerir para este clima"); }
        return prendas.stream().findAny().orElse(null);
    }
    private void validadorGuardarropaParaHacerSugerencia(Guardarropa guardarropa){
        if(guardarropa.getPrendasParaLaCategoria(Categoria.PARTE_SUPERIOR).isEmpty()
            || guardarropa.getPrendasParaLaCategoria(Categoria.PARTE_INFERIOR).isEmpty()
            || guardarropa.getPrendasParaLaCategoria(Categoria.CALZADO).isEmpty())
            throw new PrendaException("Error, el campo material esta vacio");
    }
}
