import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BuscadorTest {
    private Buscador buscador;
    private Buscador buscador1;
    private Buscador buscador2;
    private Equipo griffindor;
    private SaetaDeFuego saeta;
    private Nimbus nimbus;
    private Equipo slytheren;

    @BeforeEach
    void setUp() {
        saeta = new SaetaDeFuego();
        nimbus= new Nimbus(1989,80);
        griffindor = new Equipo();
        slytheren=new Equipo();
        buscador = new Buscador(110, 150, 90, saeta, griffindor);
        buscador1 = new Buscador(10, 10, 10, saeta, griffindor);
        buscador2= new Buscador(5,5,50,nimbus, slytheren);
    }
    @Test /** Este test da una excepcion porque si atrapa la snith termina el juego**/
    void TestAtrapaSnith(){
        buscador.atrapaSnitch();
        assertEquals(210, buscador.skill);
    }
    @Test
    void testGolpeadoPorBludger(){
        buscador.golpeadoPorBludger();
        assertEquals(198, buscador.skill);
        buscador2.golpeadoPorBludger();
        assertEquals(198, buscador2.skill);
        assertEquals(0.7, nimbus.getPorcentajeDeSalud());

    }
    @Test
    void testManejoDeEscoba() {
        assertEquals(2.2222222222222223, buscador.nivelManejoDeEscoba());
        //skills del jugador / su peso.
    }

    @Test
    void testVelocidadDelJugador() {
        assertEquals(222, buscador.velocidadDelJugador());
    }

    @Test
    void testHabilidad() {
        assertEquals(16922, buscador.habilidad());
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

  /*  @Test
    void testTurnos(){
        buscador.kilometros=5000;
        buscador.persiguiendoLaSnitch();
        buscador.buscandoLaSnitch();
        buscador.juegaContra(slytheren);
        assertEquals(1, buscador.getTurnosBuscando());
    }*/

}