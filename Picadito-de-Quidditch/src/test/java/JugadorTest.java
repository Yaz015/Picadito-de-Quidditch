package test.java;
import main.java.Equipo;
import main.java.Jugador;
import main.java.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {
    Jugador jugador;
    Jugador jugador1;
    SaetaDeFuego saetaDeFuego;
    Equipo griffindor;


    @BeforeEach
    void setUp() {
        saetaDeFuego=new SaetaDeFuego();
        griffindor=new Equipo();
    }

    @Test
    void testNivelManejoDeEscoba(){
        assertEquals(jugador.nivelManejoDeEscoba(),2 );
        // this.skill / this.peso
    }

    @Test
    void testVelocidadDelJugador(){
       // assertEquals(buscador.velocidadDelJugador(), 200);//this.velocidadDeEscoba() * this.nivelManejoDeEscoba()
    }

    @Test
    void habilidad() {
        //su velocidad + sus skills + su nivel de reflejos * nivel de visión.
    }

}