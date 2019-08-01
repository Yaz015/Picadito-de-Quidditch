package main;

public class main {
    public static void main(String[] args){
        Nimbus nimbus1=new Nimbus(1970,1);
        SaetaDeFuego saetaDeFuego1=new SaetaDeFuego();
        saetaDeFuego1.velocidadDeEscoba();
        Cazador cazadorEquipoAzul= new Cazador(5, 5,2, saetaDeFuego1);
        Buscador buscadorEquipoRojo4= new Buscador(5,4,3,nimbus1);
        //cazadorEquipoAzul.esGroso();
        cazadorEquipoAzul.habilidad();
        //System.out.println(cazadorEquipoAzul.esGroso());
        System.out.println(cazadorEquipoAzul.nivelManejoDeEscoba());
        System.out.println(buscadorEquipoRojo4.nivelManejoDeEscoba());
        System.out.println(nimbus1.velocidadDeEscoba());
        System.out.println(saetaDeFuego1.velocidadDeEscoba());
        System.out.println(cazadorEquipoAzul.velocidadDelJugador());
        System.out.println(buscadorEquipoRojo4.velocidadDelJugador());
        System.out.println(cazadorEquipoAzul.habilidad());
        System.out.println(buscadorEquipoRojo4.habilidad());
        System.out.println(cazadorEquipoAzul.lePasaElTrapo(buscadorEquipoRojo4));


    }
}