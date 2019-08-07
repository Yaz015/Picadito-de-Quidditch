
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.omg.CORBA.UserException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EquipoTest {
    Equipo griffindor;
    Equipo slytheren;
    Cazador cazador;
    Buscador buscador;

    @BeforeEach
    void setUp(){
        griffindor = new Equipo();
        slytheren = new Equipo();
        cazador=mock(Cazador.class);
        buscador=mock(Buscador.class);

    }

    @Test
    void testSumadeHabilidades(){
        griffindor.agregarJugador(buscador);
        griffindor.agregarJugador(cazador);
        when(buscador.habilidad()).thenReturn(50);
        when(cazador.habilidad()).thenReturn(10);
        assertEquals(60 ,griffindor.sumaDeHabilidadesDeJugadores());
    }

    @Test
    void testPromedioDeHabilidades(){
        griffindor.agregarJugador(jugador1);
        griffindor.agregarJugador(jugador2);
        when(jugador1.habilidad()).thenReturn(50);
        when(jugador2.habilidad()).thenReturn(10);
        assertEquals(30, griffindor.promedioDeHabilidades());
    }

    @Test
    void testTieneJugadorEstrella(){
        slytheren.agregarJugador(jugador2);
        griffindor.agregarJugador(jugador1);
        when(jugador2.habilidad()).thenReturn(100);
        when(jugador1.habilidad()).thenReturn(30);
        assertTrue(slytheren.tieneJugadorEstrella(griffindor));
    }

    @Test
    void testCantJugadoresEnEquipo(){
        griffindor.agregarJugador(jugador1);
        griffindor.agregarJugador(jugador2);
        assertEquals(2, griffindor.cantDeJugadoresEnEquipo());
    }

    @Test
    void testForListaVacia(){
        griffindor.cantDeJugadoresEnEquipo();
    }

}