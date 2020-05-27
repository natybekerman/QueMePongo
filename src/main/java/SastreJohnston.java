public class SastreJohnston implements Sastre{

    public Prenda fabricarParteSuperior() {
        PrendaBorrador prendaBorrador = new PrendaBorrador(new TipoPrenda("Buzo", Categoria.PARTE_SUPERIOR));
        prendaBorrador.agregarColorPrimario(new Color(20, 7, 94));
        prendaBorrador.agregarMaterial(Material.LANA);
        return prendaBorrador.crearPrenda();
    }

    public Prenda fabricarCalzado() {
        PrendaBorrador prendaBorrador = new PrendaBorrador(new TipoPrenda("Zapatos", Categoria.CALZADO));
        prendaBorrador.agregarColorPrimario(new Color(5, 6, 7));
        prendaBorrador.agregarMaterial(Material.CUERO);
        return prendaBorrador.crearPrenda();
    }

    public Prenda fabricarParteInferior() {
        PrendaBorrador prendaBorrador = new PrendaBorrador(new TipoPrenda("Pantalon",Categoria.PARTE_INFERIOR));
        prendaBorrador.agregarColorPrimario(new Color(1, 1, 1));
        prendaBorrador.agregarMaterial(Material.ALGODON);
        return prendaBorrador.crearPrenda();
    }
}
