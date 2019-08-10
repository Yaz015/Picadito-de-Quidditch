public class SaetaDeFuego implements Escoba {

    private String tipo="Saeta";

    public Integer velocidadEscoba(){
        return 100;
    }

    public String getTipo() {
        return tipo;
    }

    public void pierdeSalud() {

    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
