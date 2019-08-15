import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuscadorTest {
    private Buscador buscador;
    private Buscador buscador1;
    private Equipo griffindor;
    private SaetaDeFuego saeta;

    @BeforeEach
    void setUp() {
        saeta = new SaetaDeFuego();
        griffindor = new Equipo();
        buscador = new Buscador(100, 110, 150, 90, saeta, griffindor);
        buscador1 = new Buscador(10, 10, 10, 10, saeta, griffindor);
    }

    @Test
    void testManejoDeEscoba() {
        assertEquals(1.1111111111111112, buscador.nivelManejoDeEscoba());
        //skills del jugador / su peso.
    }

    @Test
    void testVelocidadDelJugador() {
        assertEquals(111, buscador.velocidadDelJugador());
    }

    @Test
    void testHabilidad() {
        assertEquals(16711, buscador.habilidad());
        //su velocidad + sus skills + su nivel de reflejos * nivel de visión
    }

    @Test
    void testLePasaElTrapo() {
        assertTrue(buscador.lePasaElTrapo(buscador1));
    }

    @Test
    void testEsGroso() {
        griffindor.agregarJugador(buscador);
        griffindor.agregarJugador(buscador1);
        assertTrue(buscador.esGroso());
    }

    @Test
    void testPuedeBloquear() {
        assertFalse(buscador.puedeBloquear(buscador));
    }

    @Test
    void testEsBlancoUtil(){
        assertTrue(buscador.esBlancoUtil());
    }

    @Test
    void testTurnos(){
        buscador.juega();
        assertEquals(1, buscador.getTurnosBuscando());
    }

    @Test
    void testPersiguiendoSnitchKilometros(){
        buscador.persiguiendoLaSnitch();
        assertEquals(69.375 ,buscador.getKilometros());
        //Kilometros() + velocidadDelJugador() / 1.6
    }

    @Test
    void testPersiguiendoLaSnitch(){
        buscador.setKilometros(5000.0);
        buscador.persiguiendoLaSnitch();
        assertEquals(110, buscador.skill);
    }

    @Test
    void testNoAtrapo(){
        buscador.setKilometros(4999.0-69.375);
        buscador.persiguiendoLaSnitch();
        assertEquals(100, buscador.skill);
    }

    @Test
    void testBuscandoSnitch(){
        buscador.randonNumeroSnitch().equals(buscador.habilidad()+buscador.getTurnosBuscando());
        buscador.buscandoLaSnitch();
        assertTrue(buscador.getEncontroSnitch());
    }

    @Test
    void atrapoSnitch(){
        buscador.atrapaSnitch();
        assertEquals(110, buscador.skill);
    }
}