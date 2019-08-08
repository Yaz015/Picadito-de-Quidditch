package test;

import main.java.Buscador;
import main.java.Equipo;
import main.java.Nimbus;
import main.java.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuscadorTest {
    Buscador buscador1;
    Buscador buscador2;
    SaetaDeFuego saetaDeFuegoA;
    Nimbus nimbus;
    Equipo griffindor;
    Equipo slytheren;
    @BeforeEach
    void setUp(){
        slytheren=new Equipo();
        griffindor= new Equipo();
        saetaDeFuegoA= new SaetaDeFuego();
        nimbus=new Nimbus(1989,80);
        buscador1= new Buscador(5,5,50.0, saetaDeFuegoA, griffindor);
        buscador2= new Buscador(6,6,200.0, nimbus, slytheren);}


    @Test
    void testLepasaElTrapo(){
        assertTrue(buscador1.lePasaElTrapo(buscador2));

    }
    @Test
    void testHabilidad(){
        assertEquals(625,buscador1.habilidad());
        assertEquals(292,buscador2.habilidad());
    }
    @Test
    void testVelocidadBuscador(){
        assertEquals(400,buscador1.velocidadDelJugador());
        assertEquals(56,buscador2.velocidadDelJugador());}


}

