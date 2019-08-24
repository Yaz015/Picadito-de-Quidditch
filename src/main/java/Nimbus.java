import java.util.Calendar;

public class Nimbus implements Escoba {

    private Integer anioDeFabricacion;
    private Integer porcentajeDeSalud;

    public Nimbus(Integer anioDeFabricacion, Integer porcentajeDeSalud){
        this.anioDeFabricacion = anioDeFabricacion;
        this.porcentajeDeSalud=porcentajeDeSalud;
    }
    /** Velocidad de la escoba, 80 menos la multiplicacion de los años de fabric. y su porcentaje de salud**/
    public Integer velocidadEscoba(){
        return (int)((80 - this.cantAniosDesdeFabricacion())*this.getPorcentajeDeSalud());
    }
    public Double getPorcentajeDeSalud(){
        return (double)this.porcentajeDeSalud/100;
    }

    public Integer cantAniosDesdeFabricacion(){
        return this.anioActual()-this.anioDeFabricacion;
    }
    /** El año actual en el calendario**/
    public Integer anioActual(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
    /**  Pierde salud si el jugador es golpeado por bludger**/
    public Integer pierdeSalud(){return
        this.porcentajeDeSalud=this.porcentajeDeSalud-10;
    }
}
