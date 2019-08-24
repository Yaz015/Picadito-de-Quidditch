import java.util.Random;
public class Guardian extends Jugador {
    private Integer nivelDeReflejos;
    private Integer fuerza;
    private Integer randomNumber = 3;


    public Guardian(Integer skill, Integer nivelDeReflejos, Integer fuerza, Integer peso, Escoba escoba, Equipo equipo) {
        super(peso, escoba, skill, equipo);
        this.setNivelDeReflejos(nivelDeReflejos);
        this.fuerza = fuerza;
    }

    public Integer getNivelDeReflejos() {
        return nivelDeReflejos;
    }

    public void setNivelDeReflejos(Integer nivelDeReflejos) {
        this.nivelDeReflejos = nivelDeReflejos;
    }
    /** Su habilidad es skill + velocidad del jugador, seteados en clase padre Jugadpr. Mas nivel de reflejo y fuerza**/
    public Integer habilidad() {
        return super.habilidad() + this.getNivelDeReflejos() + this.fuerza;
    }
    /**Puede bloquear si sale 3 en un random **/
    public Boolean puedeBloquear(Jugador jugador) {
        this.setRandomNumber();
        return 3 == this.getRandomNumber();
    }

    public void setRandomNumber() {
        Random ran = new Random();
        this.setRandomNumber((int) (ran.nextDouble() * 3) + 1);
    }

    /**Metodo sos Jugador**/
    public Boolean sosCazador() {
        return false;
    }

    public Boolean sosBuscador() {
        return false;
    }

    public Boolean sosGuardian() {
        return true;
    }

    public Boolean sosGolpeador() {
        return false;
    }

    public Integer getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(Integer randomNumber) {
        this.randomNumber = randomNumber;
    }

    /**
     * Es blanco util si si equipo no tiene pelota
     **/
    public Boolean esBlancoUtil() {
        return !this.equipo.tenesQuafflee();
    }

    /**
     * El guardian solo bloquea
     **/
    public void juega() {
    }

    public void eligeUnBlancoUtil() {
        this.equipo.getRandomBlancoUtilEquipoContrario();
    }

}