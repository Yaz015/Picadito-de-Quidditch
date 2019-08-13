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

    public Boolean sosCazador(){
        return false;
    }
    public Boolean sosBuscador(){return false;}


    public Boolean esBlancoUtil(){
        return false;//No es útil golpear golpeadores.????
    }
    public void golpeadoPorBludger(){
        super.skill=super.skill-2;
        if (super.escobaDelJugador.getTipo().equals("Nimbus")) {
            super.escobaDelJugador.pierdeSalud();
        }}

    public void juega(){
        //cuando juega elige un blanco útil
    }
}
