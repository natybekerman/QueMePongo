import Exceptions.PrendaException;

public class PrendaBorrador {
    private TipoPrenda tipoPrenda;
    private Color colorPrimario;
    private Color colorSecundario;
    private Material material;
    private Trama trama;

    public PrendaBorrador(TipoPrenda tipoPrenda){
        if(tipoPrenda == null) { throw new PrendaException("Error, el campo tipo de la prenda esta vacio"); }
        this.tipoPrenda = tipoPrenda;
        this.trama = Trama.LISA;
    }

    public void agregarColorPrimario(Color colorPrimario){
        if (colorPrimario == null) throw new PrendaException("Error, el campo color primario esta vacio");
        this.colorPrimario = colorPrimario;
    }

    public void agregarColorSecundario(Color colorSecundario){
        this.colorSecundario = colorSecundario;
    }

    public void agregarMaterial(Material material){
        if (material == null) throw new PrendaException("Error, el campo material esta vacio");
        this.material = material;
    }

    public void agregarTrama(Trama trama){
        if (trama == null)
        {
            this.trama = Trama.LISA;
        }
        else
        {
            this.trama = trama;
        }
    }

    public Prenda crearPrenda(){
        return new Prenda(tipoPrenda, colorPrimario, colorSecundario, material, trama);
    }

}
