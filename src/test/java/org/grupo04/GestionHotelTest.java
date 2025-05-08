package org.grupo04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Clase de pruebas unitarias para la gestión de hoteles.
 * <p>
 * Prueba los métodos de la clase GestionHotel: añadir, obtener,
 * eliminar, cambiar nombre y listar hoteles.
 * </p>
 */
public class GestionHotelTest {

    /** Gestor de hoteles utilizado en las pruebas. */
    private GestionHotel gestor;

    /** Primer hotel de prueba. */
    private Hotel h1;

    /** Segundo hotel de prueba. */
    private Hotel h2;

    /**
     * Configuración inicial antes de cada prueba.
     * <p>
     * Crea una instancia de GestionHotel y dos hoteles de prueba,
     * y añade el primero al gestor.
     * </p>
     */
    @BeforeEach
    public void setUp() {
        gestor = new GestionHotel();
        h1 = new Hotel(10, "Hotel Sol", "Madrid");
        h2 = new Hotel(20, "Hotel Luna", "Barcelona");
        gestor.add(h1);
    }

    /**
     * Verifica que obtener un hotel con índice válido devuelve el hotel correcto.
     */
    @Test
    public void get_Valido() {
        assertSame(h1, gestor.get(0));
    }

    /**
     * Verifica que obtener con índice inválido devuelve null.
     */
    @Test
    public void get_NoValido() {
        assertNull(gestor.get(-1));
        assertNull(gestor.get(1));
    }

    /**
     * Verifica que añadir un hotel válido al gestor funciona correctamente.
     */
    @Test
    public void add_HotelValido() {
        assertTrue(gestor.add(h2));
        assertEquals(2, gestor.listarTodos().size());
        assertSame(h2, gestor.get(1));
    }

    /**
     * Verifica que no se permita añadir un hotel nulo.
     */
    @Test
    public void add_HotelNulo() {
        assertFalse(gestor.add(null));
        assertEquals(1, gestor.listarTodos().size());
    }

    /**
     * Verifica que eliminar un hotel con índice válido funciona correctamente.
     */
    @Test
    public void remove_Valido() {
        assertTrue(gestor.remove(0));
        assertEquals(0, gestor.listarTodos().size());
    }

    /**
     * Verifica que eliminar con índice inválido no modifica la lista.
     */
    @Test
    public void remove_NoValido() {
        assertFalse(gestor.remove(1));
        assertEquals(1, gestor.listarTodos().size());
    }

    /**
     * Verifica que cambiar el nombre de un hotel con índice válido funciona.
     */
    @Test
    public void cambiarName_Valido() {
        assertTrue(gestor.cambiarName(0, "Hotel Estrella"));
        assertEquals("Hotel Estrella", gestor.get(0).getName());
    }

    /**
     * Verifica que cambiar el nombre con índice inválido devuelve false.
     */
    @Test
    public void cambiarName_NoValido() {
        assertFalse(gestor.cambiarName(2, "Nombre X"));
    }

    /**
     * Verifica que listarTodos devuelve la lista completa de hoteles añadidos.
     */
    @Test
    public void listarTodos_ContieneTodos() {
        ArrayList<Hotel> lista = gestor.listarTodos();
        assertEquals(1, lista.size());
        assertSame(h1, lista.get(0));
    }
}