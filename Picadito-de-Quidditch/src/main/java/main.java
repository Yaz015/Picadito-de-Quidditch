package main.java;

import main.java.Buscador;
import main.java.Cazador;
import main.java.Equipo;
import main.java.Guardián;

public class main {
    public static void main(String[] args){
        Nimbus nimbus1=new Nimbus(1970,80);
        SaetaDeFuego saetaDeFuego1=new SaetaDeFuego();
        Equipo griffindor = new Equipo();
        Equipo slytheren= new Equipo();

        //saetaDeFuego1.velocidadDeEscoba();
        Cazador cazadorEquipoAzul1= new Cazador(5,5,50.0, saetaDeFuego1, griffindor);
        Buscador buscadorEquipoRojo4= new Buscador(10,12,65.0,nimbus1, griffindor);
        //Guardián guardiánEquipoAzul= new Guardián(5,6,65.0,nimbus1, slytheren);

        //cazadorEquipoAzul.esGroso();
        cazadorEquipoAzul1.habilidad();
        //System.out.println(cazadorEquipoAzul.esGroso());
        System.out.println(cazadorEquipoAzul1.nivelManejoDeEscoba());
        System.out.println(buscadorEquipoRojo4.nivelManejoDeEscoba());
        System.out.println(nimbus1.velocidadDeLaEscoba());
        System.out.println(saetaDeFuego1.velocidadDeLaEscoba());
        System.out.println(cazadorEquipoAzul1.velocidadDelJugador());
        System.out.println(buscadorEquipoRojo4.velocidadDelJugador());
        System.out.println(cazadorEquipoAzul1.habilidad());
        //System.out.println(buscadorEquipoRojo4.habilidad());
        //System.out.println(guardiánEquipoAzul.habilidad());
        //System.out.println(cazadorEquipoAzul1.lePasaElTrapo(guardiánEquipoAzul));
        griffindor.agregarJugador(cazadorEquipoAzul1);
        griffindor.agregarJugador(buscadorEquipoRojo4);
        //slytheren.agregarJugador(guardiánEquipoAzul);
        System.out.println(griffindor.cantDeJugadoresEnEquipo()+ "cant de jugadores en equipo");
        System.out.println(griffindor.promedioDeHabilidades()+" promedio de jugadores en equipo");
       // System.out.println(guardiánEquipoAzul.getRandomElement());
        //System.out.println(guardiánEquipoAzul.puedeBloquear(cazadorEquipoAzul1));

    }}
