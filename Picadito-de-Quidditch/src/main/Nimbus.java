package main;

import java.util.Calendar;

public class Nimbus implements Escoba{

    private Integer añoDeFabricacion;
    private Integer porcentajeDeSalud;

    Nimbus(Integer añoDeFabricacion, Integer porcentajeDeSalud){
        this.añoDeFabricacion=añoDeFabricacion;
        this.porcentajeDeSalud=porcentajeDeSalud;
    }
    public Double velocidadDeEscoba(){
        return (80.0-this.cantAñosDesdeFabricacion()*this.getPorcentajeDeSalud());
    }

    public Double getPorcentajeDeSalud(){
        return (this.porcentajeDeSalud/100.0);//Aca va dividido 100 pero la cuenta da cero.
    }

    public Integer añoACtual(){return
        Calendar.getInstance().get(Calendar.YEAR);}

    public Integer cantAñosDesdeFabricacion(){
            return añoACtual() -this.añoDeFabricacion;
        }}