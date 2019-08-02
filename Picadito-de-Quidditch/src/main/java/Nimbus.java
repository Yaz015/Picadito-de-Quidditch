package main.java;

import java.util.Calendar;

public class Nimbus implements Escoba{

    private Integer añoDeFabricacion;
    private Integer porcentajeDeSalud;

    Nimbus(Integer añoDeFabricacion, Integer porcentajeDeSalud){
        this.añoDeFabricacion=añoDeFabricacion;
        this.porcentajeDeSalud=porcentajeDeSalud;
    }

    public Integer velocidadEscoba(){
        return (80 - this.cantAñosDesdeFabricacion())*this.getPorcentajeDeSalud();
    }

    public Integer getPorcentajeDeSalud(){
        return this.porcentajeDeSalud/100;
    }

    public Integer cantAñosDesdeFabricacion(){
        return this.añoActual()-this.añoDeFabricacion;
    }

    public Integer añoActual(){
        return Calendar.getInstance().get(Calendar.YEAR);}
}
