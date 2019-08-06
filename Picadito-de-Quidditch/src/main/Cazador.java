package main;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;
    private Pelota quaffle;

    public Cazador( Integer punteria, Integer fuerza, Integer peso, Escoba escobaDelJugador,Equipo equipo){
        super(peso, escobaDelJugador,equipo);
        this.setFuerza(fuerza);
        this.setPunteria(punteria);
    }

    public Integer habilidad(){
        return this.velocidadDelJugador()+ this.getSkill() + this.getPunteria() * getFuerza();
    }

    public Boolean puedeBloquear(Cazador uncazador){
        return this.lePasaElTrapo(uncazador);
    }
// decidimos que si sale 1 tiene la pelota, sino no.
// Para eso hacemos un boolean  que responda a eso , llamando a un método que responde a un random

    public Integer randomPelota(){
           List<Integer> rango = IntStream.range(1,2).boxed().collect(Collectors.toList());
            Random rand = new Random();
            return rango.get(rand.nextInt(rango.size()));
    }
    public void setPelota(Pelota quaffle) {
        this.quaffle=quaffle ;
    }
    public Boolean tenesPelota(){
        return this.randomPelota().equals(1);

    }

    public Boolean blancoUtil(){
       return  this.tenesPelota();
    }

    public Integer getPunteria() {
        return punteria;
    }

    public void setPunteria(Integer punteria) {
        this.punteria = punteria;
    }

    public Integer getFuerza() {
        return fuerza;
    }

    public void setFuerza(Integer fuerza) {
        this.fuerza = fuerza;
    }

   // public Pelota getPelota() {
   //     return pelota;
   // }


}