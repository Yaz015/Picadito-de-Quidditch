import exceptions.NoEsUtilGolpearGolpeadoresException;
import exceptions.NoTieneNiveldeReflejos;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Golpeador extends Jugador {
    private Integer fuerza;
    private Integer punteria;

    public Golpeador( Integer fuerza, Integer punteria, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Integer habilidad(){
        return super.skill+ this.velocidadDelJugador()+this.punteria+this.fuerza;
    }

    public Integer velocidadDelJugador(){
        return (int)(super.velocidadDeEscoba() * super.nivelManejoDeEscoba()); }

    public Boolean puedeBloquear(Jugador jugador){
        return this.esGroso();
    }

    public Integer nivelDeReflejos(){
        throw new NoTieneNiveldeReflejos(" El golpeador no tiene nivel de reflejo");}

    public Boolean sosCazador(){
        return false;
    }

    public Boolean esBlancoUtil(){
        return false;//No es útil golpear golpeadores.????
    }
    public void golpeadoPorBludger() {
        if (esBlancoUtil() == false)
            throw new NoEsUtilGolpearGolpeadoresException("No se puede golpear a golpeadores");
    }
       /* super.skill=super.skill-2;
        if (super.escobaDelJugador.getTipo().equals("Nimbus")) {
            super.escobaDelJugador.pierdeSalud();
        }*/
    public Integer randomGolpea(){
        List<Integer> rango = IntStream.range(1,9).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }
    public Boolean puedeGolpearAotro(Jugador jugador){
        if(this.punteria>this.equipo.getRandomBlancoUtilEquipoContrario().nivelDeReflejos() ||
                this.randomGolpea()==8){ return true;} else return false; }

    public void juegaContra(Equipo equipoContrario){
        //this.equipo.getRandomBlancoUtilEquipoContrario();
        if(this.puedeGolpearAotro(equipoContrario.getRandomBlancoUtil())); {
            equipoContrario.getRandomBlancoUtil().golpeadoPorBludger();
            super.skill=super.skill+1;
        }

    }
}
