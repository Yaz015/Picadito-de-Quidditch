import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CazadorTest {
    Cazador cazador1;
    Cazador cazador2;
    SaetaDeFuego saeta;
    Nimbus nimbus;
    Equipo griffindor;
    Equipo slytheren;

    @BeforeEach
    void setUp() {
        slytheren = new Equipo();
        griffindor = new Equipo();
        saeta = new SaetaDeFuego();
        nimbus = new Nimbus(1989, 80);
        cazador1 = new Cazador(200,5, 5, 50, 40,saeta, griffindor);
        cazador2 = new Cazador(200,6, 6,200,30, nimbus, slytheren);
    }
    @Test
    void testTenesQuaffle(){
        assertFalse(cazador1.pierdeQuaffle());
    }

    @Test
    void testPierdeQuaffle() {
        assertFalse(cazador1.pierdeQuaffle());
    }

    @Test
    void testPuedeBloquear() {
        assertTrue(cazador1.puedeBloquear(cazador2));
    }

    @Test
    void testLepasaElTrapo() {
        assertTrue(cazador1.lePasaElTrapo(cazador2));
    }

    @Test
    void testHabilidad() {
        assertEquals(625, cazador1.habilidad());
        assertEquals(276, cazador2.habilidad());
        //su velocidad + sus skills + su puntería * su fuerza.
    }

    @Test
    void testVelocidadCazador() {
        assertEquals(400, cazador1.velocidadDelJugador());
        assertEquals(40, cazador2.velocidadDelJugador());
        //this.velocidadDeEscoba() * this.nivelManejoDeEscoba()
    }
}