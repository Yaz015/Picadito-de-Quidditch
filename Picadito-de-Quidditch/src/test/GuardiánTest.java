package test;


import main.Guardián;
import main.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;


class GuardiánTest {
    Guardián guardián;
    SaetaDeFuego saeta;

    @BeforeEach
     void setUp(){
        saeta = new SaetaDeFuego();
        guardián=new Guardián(20, 390,10, 90, saeta);
    }
}