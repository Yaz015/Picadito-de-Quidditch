package test.java;


import main.java.Equipo;
import main.java.Guardián;
import main.java.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GuardiánTest {
    Guardián guardián;
    SaetaDeFuego saeta;
    Equipo griffindor;

    @BeforeEach
     void setUp(){
        saeta = new SaetaDeFuego();
        guardián = new Guardián(90, 40, 40, 90, saeta, griffindor);
    }

    @Test
    void testNivelDeManejoDeEscoba(){
        assertEquals(guardián.nivelManejoDeEscoba(), 1);
    }
}