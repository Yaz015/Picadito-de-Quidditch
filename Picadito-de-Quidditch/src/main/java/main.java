package main.java;

import main.java.Buscador;
import main.java.Cazador;
import main.java.Equipo;
import main.java.Guardián;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args){


            Equipo griffindor = new Equipo();
            Equipo  slytherin= new Equipo();

            Pelota quaffle=new Pelota();
            quaffle.setNombrePelota("Quaffle");

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

            List<Jugador> jugadoresSlytherin= new ArrayList<>();
            jugadoresSlytherin.add(buscador2);
            jugadoresSlytherin.add(guardian3);
            jugadoresSlytherin.add(golpeador3);
            jugadoresSlytherin.add(golpeador4);
            jugadoresSlytherin.add(cazador4);
            jugadoresSlytherin.add(cazador5);
            jugadoresSlytherin.add(cazador6);

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

            List<Jugador> jugadoresGriffindor= new ArrayList<>();
            jugadoresGriffindor.add(golpeador1);
            jugadoresGriffindor.add(golpeador2);
            jugadoresGriffindor.add(cazador1);
            jugadoresGriffindor.add(cazador2);
            jugadoresGriffindor.add(cazador3);
            jugadoresGriffindor.add(guardian1);
            jugadoresGriffindor.add(buscador1);

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

            griffindor.agregarJugadores(jugadoresGriffindor);
            slytherin.agregarJugadores(jugadoresSlytherin);


            System.out.println(slytherin.jugadorCazadorRapidoDelEquipo().getNombre()+" Cazador mas rapido");
            cazador2.setPelota(quaffle);
            //System.out.println(cazador1.agarraQuaffle(quaffle).getPelota() + " Agarra quaffle");
            System.out.println(cazador1.skill);
            System.out.println(griffindor.puntosEquipo);
            griffindor.jugadorCazadorRapidoDelEquipo();
            System.out.println(slytherin.jugadorCazadorRapidoDelEquipo().getNombre());
            cazador1.jugaContra(slytherin);
            //System.out.println(cazador4.puedeBloquear(cazador2)+ " bloqueo");
            System.out.println(slytherin.puedenBloquear(cazador1)+ " Bloqueo");
            System.out.println(griffindor.tenesQuaffle()+ " tenes pelota");
            System.out.println(cazador1.skill+" Skill cazador1");
            System.out.println(griffindor.puntosEquipo+ " puntos ");

            System.out.println(cazador4.skill+ " Skill cazador 4");
            System.out.println(slytherin.puntosEquipo+ " puntos");
            //System.out.println(cazador1.pierdePelota());
            //System.out.println(griffindor.tenesQuaffle());
           // System.out.println(slytherin.tenesQuaffle());




    }}
