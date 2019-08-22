import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuardianTest {
    Guardian guardián;
    Cazador uncazador;
    SaetaDeFuego saeta;
    Equipo griffindor=new Equipo();
    Guardian guardián1;
    @BeforeEach
    void setUp(){
        saeta=new SaetaDeFuego();
        griffindor=new Equipo();
        guardián=new Guardian(100, 100,100,saeta,griffindor);
        guardián1= new Guardian(10, 10, 10, saeta, griffindor);
        uncazador=new Cazador(10,10,10,saeta,griffindor);
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
        assertEquals(400, guardián.habilidad());
        //su velocidad + sus skills + su nivel de reflejos + su fuerza.
    }

    @Test


    void testpuedeBloquear(){
        guardián.randomDeBloqueo().equals(3);
        assertTrue(guardián.puedeBloquear(uncazador));
    }
}

