package main;



    public class QuidditchMain {
        public static void main(String[] args) {

            Equipo griffindor = new Equipo();
            Equipo  slytherin= new Equipo();


            SaetaDeFuego saeta1=new SaetaDeFuego();
            Nimbus nimbus2=new Nimbus(2019,20);
            Nimbus nimbus1=new Nimbus(1988,30);


            Buscador buscador1=new Buscador(20,50,70,saeta1,griffindor);
            Guardián guardian1= new Guardián(90,70,70,saeta1,griffindor);
            Golpeador golpeador1=new Golpeador(1000,707,600,saeta1,griffindor);
            Golpeador golpeador2=new Golpeador(60,50,60,nimbus1,griffindor);
            Cazador cazador1= new Cazador(70,80,50,nimbus1,griffindor);
            Cazador cazador2=new Cazador(40,80,70,saeta1,griffindor);
            Cazador cazador3=new Cazador(90,80,50,nimbus1,griffindor);


            Buscador buscador2=new Buscador(200,60,60,nimbus2,slytherin);
            Guardián guardian3=new Guardián(20,80,80,saeta1,slytherin);
            Golpeador golpeador3=new Golpeador(20,50, 70,nimbus1,slytherin);
            Golpeador golpeador4=new Golpeador(70,80,45,nimbus1,slytherin);
            Cazador cazador4= new Cazador(100,70,60,saeta1,slytherin);
            Cazador cazador5=new Cazador(40,150,50,nimbus2,slytherin);
            Cazador cazador6=new Cazador(90,70,80,nimbus1,slytherin);

            slytherin.agregarJugador(buscador2);
            slytherin.agregarJugador(guardian3);
            slytherin.agregarJugador(golpeador3);
            slytherin.agregarJugador(golpeador4);
            slytherin.agregarJugador(cazador4);
            slytherin.agregarJugador(cazador5);
            slytherin.agregarJugador(cazador6);



            MercadoDeEscobas mercadoDeEscobas1=new MercadoDeEscobas();
            cazador3.setMercadoDeEscobas(mercadoDeEscobas1);



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
            System.out.println(cazador3.esGroso());
            System.out.println(golpeador1.habilidad());
            System.out.println(golpeador2.habilidad());


            System.out.println(golpeador1.lePasaElTrapo(golpeador2));
            System.out.println(guardian1.randomDeBloqueo());
            System.out.println(guardian1.puedeBloquear(cazador1));
        }

    }




