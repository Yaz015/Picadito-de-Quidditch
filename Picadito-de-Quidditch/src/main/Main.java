package main;

public class Main {
    public static void main(String[] args){

        SaetaDeFuego saeta = new SaetaDeFuego();
        Equipo griffindor = new Equipo();

        Cazador cazador1 = new Cazador(63, 34, 54, 80, saeta, griffindor);

        Buscador buscador = new Buscador(30, 32, 49, 75, saeta, griffindor);

        System.out.println(cazador1.lePasaElTrapo(buscador));
    }
}
