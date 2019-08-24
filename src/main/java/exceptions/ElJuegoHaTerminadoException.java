package exceptions;

public class ElJuegoHaTerminadoException extends RuntimeException {
    /** EL juego termino si el buscador atrapa snith**/
    public ElJuegoHaTerminadoException(String msj) {
    super(msj);}
}
