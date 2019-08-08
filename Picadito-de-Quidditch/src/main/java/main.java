package main.java;

import main.java.Buscador;
import main.java.Cazador;
import main.java.Equipo;
import main.java.Guardián;

import javax.swing.plaf.synth.SynthLookAndFeel;

public class main {
    public static void main(String[] args){


            Equipo griffindor = new Equipo();
            Equipo  slytherin= new Equipo();

            Pelota quaffle=new Pelota();

            SaetaDeFuego saeta1=new SaetaDeFuego();
            Nimbus nimbus2=new Nimbus(2019,20);
            Nimbus nimbus1=new Nimbus(1988,30);


            Buscador buscador1=new Buscador(20,50,70.0,saeta1,griffindor);
            Guardián guardian1= new Guardián(90,70,70.0,saeta1,griffindor);
            Golpeador golpeador1=new Golpeador(1000,707,600.0,saeta1,griffindor);
            Golpeador golpeador2=new Golpeador(60,50,60.0,nimbus1,griffindor);
            Cazador cazador1= new Cazador(70,80,50.0,nimbus1,griffindor);
            Cazador cazador2=new Cazador(40,80,70.0,saeta1,griffindor);
            Cazador cazador3=new Cazador(90,80,50.0,nimbus1,griffindor);

            cazador1.setNombre("Cazador 1");
            cazador2.setNombre("Cazador 2");
            cazador3.setNombre("Cazador 3");

            Buscador buscador2=new Buscador(200,60,60.0,nimbus2,slytherin);
            Guardián guardian3=new Guardián(20,80,80.0,saeta1,slytherin);
            Golpeador golpeador3=new Golpeador(20,50, 70.0,nimbus1,slytherin);
            Golpeador golpeador4=new Golpeador(70,80,45.0,nimbus1,slytherin);
            Cazador cazador4= new Cazador(100,70,60.0,saeta1,slytherin);
            Cazador cazador5=new Cazador(40,150,50.0,nimbus2,slytherin);
            Cazador cazador6=new Cazador(90,70,80.0,nimbus1,slytherin);
            cazador4.setNombre("Cazador 4");
            cazador5.setNombre("Cazador 5");
            cazador6.setNombre("Cazador 6");


            slytherin.agregarJugador(buscador2);
            slytherin.agregarJugador(guardian3);
            slytherin.agregarJugador(golpeador3);
            slytherin.agregarJugador(golpeador4);
            slytherin.agregarJugador(cazador4);
            slytherin.agregarJugador(cazador5);
            slytherin.agregarJugador(cazador6);



            MercadoDeEscobas mercadoDeEscobas1=new MercadoDeEscobas();
            cazador3.getMercadoDeEscobas();



            System.out.println(golpeador1.habilidad());


            griffindor.agregarJugador(golpeador1);
            griffindor.agregarJugador(golpeador2);
            griffindor.agregarJugador(cazador1);
            griffindor.agregarJugador(cazador2);
            griffindor.agregarJugador(cazador3);
            griffindor.agregarJugador(guardian1);
            griffindor.agregarJugador(buscador1);

            System.out.println(griffindor.sumaDeHabilidadesDeJugadores());
            System.out.println(griffindor.cantDeJugadoresEnEquipo());
            System.out.println(griffindor.promedioDeHabilidades());
            System.out.println(golpeador1.lePasaElTrapo(cazador1));
            //System.out.println(cazador3.esGroso());
            System.out.println(golpeador1.habilidad());
            System.out.println(golpeador2.habilidad());


            System.out.println(golpeador1.lePasaElTrapo(golpeador2));
            System.out.println(guardian1.randomDeBloqueo());
            System.out.println(guardian1.puedeBloquear(cazador1));
            System.out.println(griffindor.jugadorRandom());


            System.out.println(griffindor.jugadorCazadorRapidoDelEquipo());
            System.out.println(cazador1.tenesPelota());
            System.out.println(cazador1.skill);
            System.out.println(griffindor.puntosEquipo);
            System.out.println(cazador1.puedeBloquear(cazador4));
            System.out.println(cazador4.tenesPelota());
            griffindor.turnoCazador(cazador4);
            System.out.println(cazador4.skill);
            System.out.println(griffindor.puntosEquipo);
            System.out.println(cazador1.skill);
            System.out.println(slytherin.puntosEquipo);
            System.out.println(griffindor.jugadorCazadorRapidoDelEquipo().getNombre());
            System.out.println((cazador2.skill));}

    }
