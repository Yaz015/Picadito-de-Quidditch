import java.util.Calendar;

public class Nimbus implements Escoba {

    private Integer anioDeFabricacion;
    private Integer porcentajeDeSalud;

    public Nimbus(Integer anioDeFabricacion, Integer porcentajeDeSalud){
        this.anioDeFabricacion = anioDeFabricacion;
        this.porcentajeDeSalud=porcentajeDeSalud;
    }

    public Integer velocidadEscoba(){
        return (int)((80 - this.cantAniosDesdeFabricacion())*this.getPorcentajeDeSalud());
    }

    public Double getPorcentajeDeSalud(){
        return (double)this.porcentajeDeSalud/100;
    }

    public Integer cantAniosDesdeFabricacion(){
        return this.anioActual()-this.anioDeFabricacion;
    }

    public Integer anioActual(){
        return Calendar.getInstance().get(Calendar.YEAR);}

    public void pierdeSalud(){
        this.porcentajeDeSalud=this.porcentajeDeSalud-10;
    }
}
