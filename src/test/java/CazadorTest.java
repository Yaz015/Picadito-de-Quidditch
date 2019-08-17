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
        cazador1 = new Cazador(5, 5, 50, saeta, griffindor);
        cazador2 = new Cazador(6, 6, 200, nimbus, slytheren);
    }
    @Test
    void testTenesQuaffle(){
        assertFalse(cazador1.pierdeQuaffle());
    }

    @Test
    void testJuegaContra() {
        //cazador1.equipo.getPelota().equals(quaffle);
        griffindor.agregarJugador(cazador1);
        cazador1.skill = cazador1.skill + 5;
        griffindor.puntosEquipo = griffindor.puntosEquipo + 100;
        cazador1.juegaContra(slytheren);
        cazador1.equipo.tenesQuaffle();
        cazador1.meteGol(slytheren);
        slytheren.puedenBloquear(cazador1).equals(false);

        assertEquals(110, griffindor.puntosEquipo);
        assertEquals(205, cazador1.skill);
        //assertEquals(110, griffindor.puntosEquipo);
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
        assertEquals(292, cazador2.habilidad());
    }

    @Test
    void testVelocidadCazador() {
        assertEquals(400, cazador1.velocidadDelJugador());
        assertEquals(56, cazador2.velocidadDelJugador());
    }

}
