package Uniforme;

import Prenda.Prenda;

public class Uniforme {
    private Prenda prendaParteSuperior;
    private Prenda prendaParteInferior;
    private Prenda calzado;

    private Uniforme(Prenda prendaParteSuperior, Prenda prendaParteInferior, Prenda calzado){
        this.prendaParteSuperior = prendaParteSuperior;
        this.prendaParteInferior = prendaParteInferior;
        this.calzado = calzado;
    }

    public static Uniforme fabricar(Sastre sastre){
        return new Uniforme(sastre.fabricarParteSuperior(), sastre.fabricarParteInferior(), sastre.fabricarCalzado());
    }
}
