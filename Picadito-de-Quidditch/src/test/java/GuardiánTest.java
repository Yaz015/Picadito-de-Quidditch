package test.java;


import main.java.Equipo;
import main.java.Guardián;
import main.java.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;


class GuardiánTest {
    Guardián guardián;
    SaetaDeFuego saeta;
    Equipo griffindor;

    @BeforeEach
     void setUp(){
        saeta = new SaetaDeFuego();
    }
}