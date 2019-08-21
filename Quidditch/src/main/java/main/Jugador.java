package main;
//import main.jugador.exception.SinHabilidadException;

        import java.util.Calendar;
        import java.util.List;

public abstract class Jugador {
    protected Double peso;
    protected Escoba escobaDelJugador;
    protected Double skill;
    protected Equipo equipo;
    protected Integer turno=0;
    public List<Jugador> jugadores;


    Jugador(Double peso, Escoba escobaDelJugador,  Equipo equipo){
        this.peso=peso;
        this.escobaDelJugador=escobaDelJugador;
        this.skill=200.0;
        this.equipo= equipo;
    }
    public Escoba escobaDelJugador() {
        return this.escobaDelJugador;
    }

    public Double nivelManejoDeEscoba() {
        return skill / this.peso;
    }

    public Double velocidadDelJugador() {
        return escobaDelJugador.velocidadDeLaEscoba() * this.nivelManejoDeEscoba();
    }

    public Double habilidad(){
      /*  if(habilidad()==0)
            throw new SinHabilidadException("No es posible");
*/
        return velocidadDelJugador()+ skill;


    }
    /** Si un jugador le pasa el trapo a otro; esto sucede si es por lo menos el doble de
     habilidoso que el otro jugador.**/

    public Boolean lePasaElTrapo(Jugador jugador){return jugador.habilidad()*2.0<this.habilidad();}

    /**Si un jugador es groso, que se cumple si su habilidad es mayor al promedio de su
     equipo y su velocidad mayor a un valor arbitrario que a medida que el mercado de
     escobas mejora se actualiza para todos por igual.**/


    /*public Boolean esGroso() {
        return this.habilidad()>this.equipo.promedioDeHabilidades()
                && this.velocidadDelJugador()> this.mercadoDeEscobas.getNumeroAleatorio();

     */


    public Integer añoActual(){
        return Calendar.getInstance().get(Calendar.YEAR);}


    public Boolean tenerPelota(){
        return null;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Escoba getEscobaDelJugador() {
        return escobaDelJugador;
    }

    public void setEscobaDelJugador(Escoba escobaDelJugador) {
        this.escobaDelJugador = escobaDelJugador;
    }

    public Double getSkill() {
        return skill;
    }

    public void setSkill(Double skill) {
        this.skill = skill;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public abstract boolean sosCazador();

    public abstract boolean sosGuardian();

    public abstract boolean sosBuscador();

    public abstract boolean sosGolpeador();
}


