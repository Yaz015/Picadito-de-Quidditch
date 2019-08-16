import exceptions.NoTieneNiveldeReflejos;

import java.util.List;

public class Cazador extends Jugador {
    private Integer punteria;
    private Integer fuerza;
    Pelota quaffle;
    public Cazador( Integer punteria, Integer fuerza, Integer peso, Escoba escoba, Equipo equipo){
        super(peso, escoba, equipo);
        this.fuerza=fuerza;
        this.punteria=punteria;
    }

    public Integer habilidad(){
        return (this.punteria*this.fuerza)+super.skill+ this.velocidadDelJugador(); }

    public Integer velocidadDelJugador(){
        return (int)(this.velocidadDeEscoba() * this.nivelManejoDeEscoba()); }


    public Integer nivelDeReflejos;
    public Integer nivelDeReflejos() {
        return this.nivelDeReflejos=100;
    }

    public void intentarMeterGol(){
        if(super.equipo.equipoContrarioEvitaBloqueo(this)){
            this.pierdeBloqueo();
        }
        else this.meteGol();//evitar bloqueo
    }

    public Boolean puedeBloquear(Jugador jugador){
        return this.lePasaElTrapo(jugador);
    }

    public void pierdeBloqueo(){
        this.skill=skill-2;
    }

    public Boolean sosCazador(){
        return true;
    }

    public Boolean pierdeQuaffle(){ return !this.equipo.tenesQuaffle();}
    public Boolean tenesQuaffle(){ return this.equipo.tenesQuaffle();}

    public void golpeadoPorBludger(){
        super.skill=super.skill-2;
        if (super.escobaDelJugador.getTipo().equals("Nimbus")) {
            super.escobaDelJugador.pierdeSalud();
            this.pierdeQuaffle();
        }}

    public Boolean esBlancoUtil(){// es blanco util es igual a pierde la quaffle
        return !super.equipo.tenesQuaffle();
    }

    public void meteGol() {
        this.skill = this.skill + 5;
        super.equipo.puntosEquipo = super.equipo.puntosEquipo + 10;}

    public void noMeteGol() {
        this.skill = this.skill - 2;
        //super.equipo.equipoContrario.jugadorQueBloquea(this);
    }

    public void juegaContra(Equipo equipoContrario){
        if(this.tenesQuaffle().equals(true) && !equipoContrario.puedenBloquear(this)){
            this.meteGol();
            equipoContrario.getPelota();
        } else
        {this.noMeteGol();
        equipoContrario.getPelota();
        equipoContrario.jugadorQueBloquea(this);} }}

