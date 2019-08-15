import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GuardianTest {
    Guardian guardian;
    SaetaDeFuego saeta;
    Equipo griffindor;
    Guardian guardian1;

    @BeforeEach
     void setUp(){
        saeta = new SaetaDeFuego();
        guardian =new Guardian(100, 100, 100, 100, saeta, griffindor);
        guardian1 = new Guardian(10, 10, 10, 10, saeta, griffindor);
    }

    @Test
    void testLePasaElTrapo(){
        assertTrue(guardian.lePasaElTrapo(guardian1));
    }

    @Test
    void testVelocidadDelJugador(){
        assertEquals(100, guardian.velocidadDelJugador());
    }

    @Test
    void TestHabilidadGuardian(){
        assertEquals(400, guardian.habilidad());
        //su velocidad + sus skills + su nivel de reflejos + su fuerza.
    }
}