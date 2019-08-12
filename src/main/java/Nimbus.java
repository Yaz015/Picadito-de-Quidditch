import java.util.Calendar;

public class Nimbus implements Escoba {

    private Integer añoDeFabricacion;
    private Integer porcentajeDeSalud;
    private String tipo="Nimbua";

    public Nimbus(Integer añoDeFabricacion, Integer porcentajeDeSalud){
        this.añoDeFabricacion=añoDeFabricacion;
        this.porcentajeDeSalud=porcentajeDeSalud;
    }

    public Integer velocidadEscoba(){
        return (int)((80 - this.cantAñosDesdeFabricacion())*this.getPorcentajeDeSalud());
    }

    public Double getPorcentajeDeSalud(){
        return (double)this.porcentajeDeSalud/100;
    }

    public Integer cantAñosDesdeFabricacion(){
        return this.añoActual()-this.añoDeFabricacion;
    }

    public Integer añoActual(){
        return Calendar.getInstance().get(Calendar.YEAR);}

    @Override
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void pierdeSalud(){
        this.porcentajeDeSalud=this.porcentajeDeSalud-10;
    }
}
