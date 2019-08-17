public class SaetaDeFuego implements Escoba {

    private String tipo="Saeta";

    public Integer velocidadEscoba(){
        return 100;
    }

    public String getTipo() {
        return tipo;
    }

    public void pierdeSalud() { //NO tiene porcentaje de Salud

    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
