package test.java;

import main.java.Buscador;
import main.java.Equipo;
import main.java.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuscadorTest {
    Buscador buscador;
    SaetaDeFuego saetaDeFuego;
    Equipo griffindor;


    @BeforeEach
    void setUp() {
        saetaDeFuego=new SaetaDeFuego();
        griffindor=new Equipo();
        buscador= new Buscador(160,20,50,80,saetaDeFuego, griffindor);
    }

    @Test
    void testNivelManejoDeEscoba(){
        assertEquals(buscador.nivelManejoDeEscoba(),2 );
        // this.skill / this.peso
    }

    @Test
    void testVelocidadDelJugador(){
        assertEquals(buscador.velocidadDelJugador(), 200);//this.velocidadDeEscoba() * this.nivelManejoDeEscoba()
    }

    @Test
    void habilidad() {
        //su velocidad + sus skills + su nivel de reflejos * nivel de visión.
    }
}