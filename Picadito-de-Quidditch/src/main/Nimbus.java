package main;

import java.sql.Date;

public class Nimbus implements Escoba{

    private Integer añoDeFabricacion;
    private Integer porcentajeDeSalud;
    private Integer añoActual;

    Nimbus(Integer añoDeFabricacion, Integer añoActual, Integer porcentajeDeSalud){
        this.añoDeFabricacion=añoDeFabricacion;
        this.añoActual=añoActual;
        this.porcentajeDeSalud=porcentajeDeSalud;
    }

    public Integer velocidadEscoba(){
        return (80- this.cantAñosDesdeFabricacion())*this.getPorcentajeDeSalud();
    }

    public Integer getPorcentajeDeSalud(){
        return this.porcentajeDeSalud/100;
    }

    public Integer cantAñosDesdeFabricacion(){
        return this.añoActual-this.añoDeFabricacion;
    }

    //public Integer añoActual(){
    //   return new Date().getYear();} no se como funciona
}
