import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JugadorTest {
    Jugador jugador;
    Jugador jugador1;
    SaetaDeFuego saetaDeFuego;
    Equipo griffindor;


    @BeforeEach
    void setUp() {
        jugador=mock(Jugador.class);
        jugador1=mock(Jugador.class);
        saetaDeFuego=new SaetaDeFuego();
        griffindor=new Equipo();
    }

    @Test
    void testLePasaElTrapo(){
        when(jugador1.habilidad()).thenReturn(1000);
        when(jugador.habilidad()).thenReturn(10);
        assertTrue(jugador1.lePasaElTrapo(jugador));
    }

    @Test
    void testNivelManejoDeEscoba(){
    }

    @Test
    void testVelocidadDelJugador() {
        // assertEquals(buscador.velocidadDelJugador(), 200);//this.velocidadDeEscoba() * this.nivelManejoDeEsco}
    }
}
