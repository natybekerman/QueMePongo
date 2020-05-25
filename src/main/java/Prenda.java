public class Prenda {
        private TipoPrenda tipoPrenda;
        private Color colorPrimario;
        private Color colorSecundario;
        private Material material;
        private Trama trama;

    public Prenda(TipoPrenda tipoPrenda, Color colorPrimario, Color colorSecundario, Material material, Trama trama) {
        this.tipoPrenda = tipoPrenda;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.material = material;
        this.trama = trama;
    }

    public Categoria getCategoria(){ return this.tipoPrenda.getCategoria(); }
}
