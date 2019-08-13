import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CazadorTest {
    Cazador cazador1;
    Cazador cazador2;
    SaetaDeFuego saeta;
    Nimbus nimbus;
    Equipo griffindor;
    Equipo slytheren;
   @BeforeEach
   void setUp(){
        slytheren=new Equipo();
        griffindor= new Equipo();
        saeta= new SaetaDeFuego();
        nimbus=new Nimbus(1989,80);
        cazador1= new Cazador(5,5,50, saeta, griffindor);
        cazador2= new Cazador(6,6,200, nimbus, slytheren);}


    @Test
    void testLepasaElTrapo(){
       assertTrue(cazador1.lePasaElTrapo(cazador2));

    }
    @Test
    void testHabilidad(){
       assertEquals(625,cazador1.habilidad());
       assertEquals(292,cazador2.habilidad());
    }
    @Test
    void testVelocidadCazador(){
       assertEquals(400,cazador1.velocidadDelJugador());
       assertEquals(56,cazador2.velocidadDelJugador());}


}
