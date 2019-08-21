import java.util.Random;
public class Guardián extends Jugador {
    private Integer nivelDeReflejos;
    private Integer fuerza;
    private Integer randomNumber = 3;


    public Guardián(Integer nivelDeReflejos, Integer fuerza, Integer peso, Escoba escoba, Equipo equipo) {
        super(peso, escoba, equipo);
        this.nivelDeReflejos = nivelDeReflejos;
        this.fuerza = fuerza;
    }

    public Integer habilidad() {
        return (super.skill + this.velocidadDelJugador()) + this.nivelDeReflejos * this.fuerza;
    }

    public Integer velocidadDelJugador() {
        return (int) (super.velocidadDeEscoba() * super.nivelManejoDeEscoba());
    }
    /** Bloquea si sale un 3 en el random**/
    public Boolean puedeBloquear(Jugador jugador) {
        this.setRandomNumber();
        return 3 == this.getRandomNumber();
    }

    public void setRandomNumber() {
        Random ran = new Random();
        this.setRandomNumber((int) (ran.nextDouble() * 3) + 1);
    }
    /**No es cazador, para metodo de cazador jugador mas rapidp**/
    public Boolean sosCazador() {
        return false;
    }
    /** Todos los jugadores pierden 2 de skill y %de salud si es nimbus, esta en clase padre**/
    public void golpeadoPorBludger() {
        super.golpeadoPorBludger();}

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }
    /** Es blanco util si su equipo no tiene la quaffle**/
    public Boolean esBlancoUtil() {
        return !this.equipo.tenesQuaffle();
    }

    public void eligeUnBlancoUtil() {
        this.equipo.getRandomBlancoUtilEquipoContrario();
    }

    public Integer nivelDeReflejos() {
        return this.nivelDeReflejos;
    }
    /** No juega, solo bloquea en su turno**/
    public void juegaContra(){this.puedeBloquear(equipo.equipoContrario.jugador);
    // Para mi aca va excepcion

    }}
