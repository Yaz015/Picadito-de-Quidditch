package test;

import main.java.Equipo;
import main.java.Golpeador;
import main.java.Nimbus;
import main.java.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GolpeadorTest {
    Golpeador golpeador1;
    Golpeador golpeador2;
    Nimbus nimbus;
    SaetaDeFuego saetaDeFuegoA;
    Equipo griffindor;
    Equipo slytheren;
    @BeforeEach
    void setUp(){
        slytheren=new Equipo();
        griffindor= new Equipo();
        saetaDeFuegoA= new SaetaDeFuego();
        nimbus=new Nimbus(1989,80);
        golpeador1= new Golpeador(5,5,50.0, saetaDeFuegoA, griffindor);
        golpeador2= new Golpeador(6,6,200.0, nimbus, slytheren);}


    @Test
    void testLepasaElTrapo(){
        assertFalse(golpeador2.lePasaElTrapo(golpeador1));

    }
    @Test
    void testHabilidad(){
        assertEquals(610,golpeador1.habilidad());
        assertEquals(268,golpeador2.habilidad());
    }
    @Test
    void testVelocidadBuscador(){
        assertEquals(400,golpeador1.velocidadDelJugador());
        assertEquals(56,golpeador2.velocidadDelJugador());}


}

