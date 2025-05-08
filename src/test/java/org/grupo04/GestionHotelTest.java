// src/test/java/org/grupo04/GestionHotelTest.java
package org.grupo04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class GestionHotelTest {
    private GestionHotel gestor;
    private Hotel h1, h2;

    @BeforeEach
    public void setUp() {
        gestor = new GestionHotel();
        h1 = new Hotel(10, "Hotel Sol", "Madrid");
        h2 = new Hotel(20, "Hotel Luna", "Barcelona");
        gestor.add(h1);
    }

    @Test
    public void get_Valido() {
        assertSame(h1, gestor.get(0));
    }

    @Test
    public void get_NoValido() {
        assertNull(gestor.get(-1));
        assertNull(gestor.get(1));
    }

    @Test
    public void add_HotelValido() {
        assertTrue(gestor.add(h2));
        assertEquals(2, gestor.listarTodos().size());
        assertSame(h2, gestor.get(1));
    }

    @Test
    public void add_HotelNulo() {
        assertFalse(gestor.add(null));
        assertEquals(1, gestor.listarTodos().size());
    }

    @Test
    public void remove_Valido() {
        assertTrue(gestor.remove(0));
        assertEquals(0, gestor.listarTodos().size());
    }

    @Test
    public void remove_NoValido() {
        assertFalse(gestor.remove(1));
        assertEquals(1, gestor.listarTodos().size());
    }

    @Test
    public void cambiarName_Valido() {
        assertTrue(gestor.cambiarName(0, "Hotel Estrella"));
        assertEquals("Hotel Estrella", gestor.get(0).getName());
    }

    @Test
    public void cambiarName_NoValido() {
        assertFalse(gestor.cambiarName(2, "Nombre X"));
    }

    @Test
    public void listarTodos_ContieneTodos() {
        ArrayList<Hotel> lista = gestor.listarTodos();
        assertEquals(1, lista.size());
        assertSame(h1, lista.get(0));
    }
}
