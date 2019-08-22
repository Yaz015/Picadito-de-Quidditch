import java.util.Calendar;

public class Nimbus implements Escoba{
    private Integer añoDeFabricacion;
    private Integer porcentajeDeSalud;


    Nimbus(Integer añoDeFabricacion, Integer porcentajeDeSalud) {
        this.setAñoDeFabricacion(añoDeFabricacion);
        this.añoActual();
        this.setPorcentajeDeSalud(porcentajeDeSalud);
    }


    public Integer velocidadEscoba() {
        return (80 - this.cantAñosDesdeFabricacion()) * this.getPorcentajeDeSalud();
    }

    public Integer getPorcentajeDeSalud() {
        return this.porcentajeDeSalud / 100;
    }

    public Integer añoActual() {
        return Calendar.getInstance().get(Calendar.YEAR);

    }


    public Integer cantAñosDesdeFabricacion() {
        return añoActual() - this.getAñoDeFabricacion();
    }

    public Integer getAñoDeFabricacion() {
        return añoDeFabricacion;
    }

    public void setAñoDeFabricacion(Integer añoDeFabricacion) {
        this.añoDeFabricacion = añoDeFabricacion;
    }

    public void setPorcentajeDeSalud(Integer porcentajeDeSalud) {
        this.porcentajeDeSalud = porcentajeDeSalud;
    }
    //public Integer añoActual(){
    //   return new Date().getYear();} no se como funciona

    public void escobaGolpeada() {
        this.porcentajeDeSalud=this.porcentajeDeSalud-10;

    }
}
