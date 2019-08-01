package test;

import main.Buscador;
import main.Equipo;
import main.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuscadorTest {
    Buscador buscador;
     SaetaDeFuego saetaDeFuego;
     Equipo griffindor;


    @BeforeEach
    void setUp() {
        saetaDeFuego=new SaetaDeFuego();
        griffindor=new Equipo();
        buscador= new Buscador(30,20,50,80,saetaDeFuego, griffindor);
    }

    @Test
    void habilidad() {
        //su velocidad + sus skills + su nivel de reflejos * nivel de visión.
    }
}