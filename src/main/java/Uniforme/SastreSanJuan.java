package Uniforme;

import Prenda.*;

public class SastreSanJuan implements Sastre{

    public Prenda fabricarParteSuperior() {
        PrendaBorrador prendaBorrador = new PrendaBorrador(new TipoPrenda("Remera", Categoria.PARTE_SUPERIOR));
        prendaBorrador.agregarColorPrimario(new Color(10, 20, 30));
        prendaBorrador.agregarMaterial(Material.ALGODON);
        return prendaBorrador.crearPrenda();
    }

    public Prenda fabricarCalzado() {
        PrendaBorrador prendaBorrador = new PrendaBorrador(new TipoPrenda("Zapas depor", Categoria.CALZADO));
        prendaBorrador.agregarColorPrimario(new Color(25, 25, 25));
        prendaBorrador.agregarMaterial(Material.TELA);
        return prendaBorrador.crearPrenda();
    }

    public Prenda fabricarParteInferior() {
        PrendaBorrador prendaBorrador = new PrendaBorrador(new TipoPrenda("Short", Categoria.PARTE_INFERIOR));
        prendaBorrador.agregarColorPrimario(new Color(11, 22, 33));
        prendaBorrador.agregarMaterial(Material.ALGODON);
        return prendaBorrador.crearPrenda();
    }
}
