package main.java;

import java.util.Calendar;

public class Nimbus implements Escoba{

    private Integer añoDeFabricacion;
    private Integer porcentajeDeSalud;

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
}
