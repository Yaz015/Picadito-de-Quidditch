package main.java;


import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;
    private List<Cazador>cazadores;

    public Cazador(Integer punteria, Integer fuerza, Double peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;}

    public Double habilidad(){
        return (this.punteria*this.fuerza)+(super.habilidad()); }

    public Pelota quaffle;


    public Boolean puedeBloquear(Jugador jugador) {return this.lePasaElTrapo(jugador).equals(true);}

    public Boolean esBloqueado(){ if (puedeBloquear(this).equals(true));
    return true;
    }
    public Integer randomPelota(){
        List<Integer> rango = IntStream.range(1,2).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }
    public void setPelota(Pelota quaffle) {
        this.quaffle=quaffle ;
    }
    public Boolean tenesPelota() {
        return this.randomPelota().equals(1);
    }

    public Jugador cazadorMasRapido() {
        return cazadores.stream().max(Comparator.comparing(j -> j.velocidadDelJugador())).get(); }





    /*public Boolean blancoUtil(){
        return  this.tenesPelota();
    }
    public Boolean haceGol() {
        if (!puedeBloquear(this)) {
            return true;}
        else return false;}*/
    }

