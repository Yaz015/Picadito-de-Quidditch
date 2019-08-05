package test;

import main.Cazador;
import main.Equipo;
import main.Guardián;
import main.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GuardiánTest {
    Guardián guardián;
    Cazador uncazador;
    SaetaDeFuego saetaDeFuego;
    Equipo griffindor=new Equipo();
    @BeforeEach
    void setUp(){
        saetaDeFuego=new SaetaDeFuego();
        griffindor=new Equipo();
        guardián=new Guardián(60,70,60,saetaDeFuego,griffindor);
    }

    @Test


    void testpuedeBloquear(){
        guardián.randomDeBloqueo().equals(3);
        assertTrue(guardián.puedeBloquear(uncazador));
    }
}