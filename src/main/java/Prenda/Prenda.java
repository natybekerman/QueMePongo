package Prenda;

public class Prenda {
        private TipoPrenda tipoPrenda;
        private Color colorPrimario;
        private Color colorSecundario;
        private Material material;
        private Trama trama;
        private EstadoClima estadoClima;

    public Prenda(TipoPrenda tipoPrenda, Color colorPrimario, Color colorSecundario, Material material, Trama trama, EstadoClima estadoClima) {
        this.tipoPrenda = tipoPrenda;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.material = material;
        this.trama = trama;
        this.estadoClima = estadoClima;
    }

    public Categoria getCategoria(){ return this.tipoPrenda.getCategoria(); }
    public EstadoClima getEstadoClima(){ return this.estadoClima; }
}
