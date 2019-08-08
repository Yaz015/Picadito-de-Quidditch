package test;

import main.java.Equipo;
import main.java.Guardián;
import main.java.Jugador;
import main.java.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.BeforeEach;

//import static org.junit.jupiter.api.Assertions.*;

class GuardiánTest {
    Guardián guardián;
    SaetaDeFuego saeta;
    Equipo griffindor;
    Guardián guardián1;

    @BeforeEach
    void setUp(){
        saeta = new SaetaDeFuego();
        guardián=new Guardián(300, 100, 100.0, saeta, griffindor);
        guardián1= new Guardián(10, 10, 10.0, saeta, griffindor);
        guardián.skill=200.0;
        guardián1.skill=200.0;
        // saeta.velocidadDeLaEscoba()
    }
    @Test
    void testHabilidad(){
        assertEquals(1410, guardián1.habilidad());
        assertEquals(30900,guardián.habilidad());
    }
    @Test
    void testLePasaElTrapo(){

        assertTrue(guardián.lePasaElTrapo(guardián1));
    }

    @Test
    void testVelocidadDelJugador(){
        assertEquals(102, guardián.velocidadDelJugador());
        assertEquals(120, guardián1.velocidadDelJugador());
    }

    @Test
    void TestHabilidadGuardian(){
        assertEquals(600, guardián.habilidad());
        //su velocidad + sus skills + su nivel de reflejos + su fuerza.
    }}