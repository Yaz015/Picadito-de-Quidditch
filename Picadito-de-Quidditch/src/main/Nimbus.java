package main;

public class Nimbus implements Escoba{

    private Integer añoDeFabricacion;
    private Integer porcentajeDeSalud;

    public Integer velocidadEscoba(){
        return (80-this.cantAñosDesdeFabricacion())*this.porcentajeDeSalud();
    }

    public Integer porcentajeDeSalud(){
        return this.porcentajeDeSalud/100;
    }

    public Integer cantAñosDesdeFabricacion(){
        return 2019-this.añoDeFabricacion;
    }
}
