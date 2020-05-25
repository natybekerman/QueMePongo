public class TipoPrenda {

    private Categoria categoria;
    private String nombre;

    public TipoPrenda(String nombre, Categoria categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Categoria getCategoria(){ return this.categoria; }
}
