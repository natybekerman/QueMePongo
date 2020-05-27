import java.util.Set;
import java.util.stream.Collectors;

public class Guardarropa {
    private Set<Prenda> prendasGuardadas;

    public Set<Prenda> getPrendasGuardadas() { return prendasGuardadas; }

    public void agregarPrenda(Prenda prenda){ prendasGuardadas.add(prenda); }

    public Set<Prenda> getPrendasParaLaCategoria(Categoria categoria){
        return this.prendasGuardadas.stream()
                .filter(prenda -> prenda.getCategoria().equals(categoria))
                .collect(Collectors.toSet());
    }
}
