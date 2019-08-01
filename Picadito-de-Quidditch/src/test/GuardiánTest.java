package test;


import main.Equipo;
import main.Guardián;
import main.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;


class GuardiánTest {
    Guardián guardián;
    SaetaDeFuego saeta;
    Equipo griffindor;

    @BeforeEach
     void setUp(){
        saeta = new SaetaDeFuego();
        guardián= new Guardián(20, 390,10, 90, saeta, griffindor);
    }
}