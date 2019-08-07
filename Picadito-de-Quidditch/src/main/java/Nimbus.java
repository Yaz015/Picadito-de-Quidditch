package main.java;

import main.java.Escoba;

import java.util.Calendar;

public class Nimbus implements Escoba {

    private Integer añoDeFabricacion;
    private Integer porcentajeDeSalud;

    public Nimbus(Integer añoDeFabricacion, Integer porcentajeDeSalud){
        this.añoDeFabricacion=añoDeFabricacion;
        this.porcentajeDeSalud=porcentajeDeSalud;
    }
    public Double velocidadDeLaEscoba(){
        return (80- cantAñosDesdeFabricacion()*getPorcentajeDeSalud());
    }

    public Double getPorcentajeDeSalud(){
        return this.porcentajeDeSalud/100.0;
    }

    public Integer añoACtual(){return
        Calendar.getInstance().get(Calendar.YEAR);}

    public Integer cantAñosDesdeFabricacion(){
            return añoACtual() -this.añoDeFabricacion;
        }}