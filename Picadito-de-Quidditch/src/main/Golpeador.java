package main;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Golpeador extends Jugador {
    private Integer fuerza;
    private Integer punteria;
    private Jugador blancoUtilElegido;


    public Integer nivelDeReflejos() {
   return this.nivelDeReflejos();
    }

    Golpeador(Integer fuerza, Integer punteria, Integer peso, Escoba escobaDelJugador, Equipo equipo) {
        super(peso, escobaDelJugador, equipo);
        this.fuerza = fuerza;
        this.punteria = punteria;
    }

    public Integer habilidad() {
        return super.velocidadDelJugador() + this.getSkill() + this.punteria + this.fuerza;
    }

    public Boolean puedeBloquear(Cazador uncazador) {
        return this.esGroso();

    }

    public Boolean puedeGolpearAotro(Jugador jugador) {
        return  this.punteria>jugador.nivelDeReflejos() ||this.randomGolpea()>=8;
    }

    public Jugador elegirBlancoUtil() {
        Random rand = new Random();
        return this.getJugadores().get(rand.nextInt(getJugadores().size()));
    }
    public void setblancoUtilElegido(){
      this.blancoUtilElegido=this.elegirBlancoUtil();

    }

    public Integer randomGolpea() {
        List<Integer> rango = IntStream.range(1, 11).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }

    public void juegaContra(Equipo equipoContrario) {

      this.puedeGolpearAotro(equipoContrario.getRandomBlancoUtil()) ;
        {
            equipoContrario.getRandomBlancoUtilEquipoContrario().golpeadoPorBludger();
            super.skill = super.skill + 1;
        }

    }
        public Boolean turnoGolpeador () {
            return this.getEquipo().jugadorRandom().equals(this);
        }

        public Boolean esBlancoUtil(){
            return false;
        }
    }

