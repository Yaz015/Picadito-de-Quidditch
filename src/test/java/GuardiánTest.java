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
        guardián=new Guardián(100, 100, 100, saeta, griffindor);
        guardián1= new Guardián(10, 10, 10, saeta, griffindor);
    }

    @Test
    void testGolpeadoPorBludger() {
        guardián.golpeadoPorBludger();
        assertEquals(198, guardián.skill);
        guardián1.golpeadoPorBludger();
        assertEquals(198, guardián1.skill);
    }
    @Test
    void testLePasaElTrapo(){
        assertTrue(guardián.lePasaElTrapo(guardián1));
    }

    @Test
    void testVelocidadDelJugador(){
        assertEquals(200, guardián.velocidadDelJugador());
    }

    @Test
    void TestHabilidadGuardian(){
        assertEquals(2300, guardián1.habilidad());
        //su velocidad + sus skills + su nivel de reflejos + su fuerza.
    }

}