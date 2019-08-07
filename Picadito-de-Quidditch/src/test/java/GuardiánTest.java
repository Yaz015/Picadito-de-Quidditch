
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GuardiánTest {
    Guardián guardián;
    SaetaDeFuego saeta;
    Equipo griffindor;
    Guardián guardián1;

    @BeforeEach
     void setUp(){
        saeta = new SaetaDeFuego();
        guardián=new Guardián(100, 100, 100, 100, saeta, griffindor);
        guardián1= new Guardián(10, 10, 10, 10, saeta, griffindor);
    }

    @Test
    void testLePasaElTrapo(){
        assertTrue(guardián.lePasaElTrapo(guardián1));
    }

    @Test
    void testVelocidadDelJugador(){
        assertEquals(100, guardián.velocidadDelJugador());
    }

    @Test
    void TestHabilidadGuardian(){
        assertEquals(400,guardián.habilidad());
    }
}