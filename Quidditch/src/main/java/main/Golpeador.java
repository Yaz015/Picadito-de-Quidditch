package main;

import exception.NoEsUtilGolpearGolpeadoresException;



public class Golpeador extends Jugador {
    protected Double punteria;
    protected Double fuerza;

    Golpeador(Double peso, Escoba escobaDelJugador, Equipo equipo) {
        super(peso, escobaDelJugador, equipo);
    }
    public Double habilidad(){
        return velocidadDelJugador() + super.skill + punteria + fuerza;
    }

    @Override
    public boolean sosCazador() {
        return false;
    }

    @Override
    public boolean sosGuardian() {
        return false;
    }

    @Override
    public boolean sosBuscador() {
        return false;
    }

    @Override
    public boolean sosGolpeador() {
        return true;
    }

    public Boolean turnoGolpeador(Jugador jugador){
        return null;
    }


    public Boolean esBlancoUtil(){
        if(esBlancoUtil()==false)
            throw new NoEsUtilGolpearGolpeadoresException("No se puede golpear a golpeadores");

        return null;
    }

}
//Golpeadores: su velocidad + sus skills + su puntería + su fuerza.
/*
El golpeador cuando juega elige un blanco útil (ver 4.b) del equipo contrario al azar. Si puede golpear a
su blanco, el mismo sufre los efectos de ser golpeado por una bludger (ver 4.c) y el golpeador sube
sus skills en 1. Para poder golpear al otro debe cumplirse que la puntería del golpeador sea mayor que el
nivel de reflejos del blanco o si saca por lo menos 8 en un random de 1 a 10. No pasa nada si pifia.
 */