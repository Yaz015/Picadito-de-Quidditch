import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Guardian extends Jugador{
    private Integer nivelDeReflejos;
    private Integer fuerza;

    public Guardian(Integer nivelDeReflejos, Integer fuerza, Integer peso, Escoba escobaDelJugador, Equipo equipo){
        super( peso,escobaDelJugador, equipo);
        this.nivelDeReflejos=nivelDeReflejos;
        this.fuerza=fuerza;
    }
    public Integer nivelDeReflejos() {
        return this.nivelDeReflejos();
    }
    public Integer habilidad(){
        return super.velocidadDelJugador()+ super.getSkill() +this.nivelDeReflejos+this.fuerza;
    }


    public Integer randomDeBloqueo(){
        List<Integer> rango = IntStream.range(1,4).boxed().collect(Collectors.toList());
        Random rand = new Random();
        return rango.get(rand.nextInt(rango.size()));
    }
    //
    public Boolean puedeBloquear(Jugador uncazador){
        return this.randomDeBloqueo().equals(3);
    }


    public Boolean esBlancoUtil(){
        return !this.getEquipo().tenesQuaffle();
    }

    public void juega(){

    }

}
