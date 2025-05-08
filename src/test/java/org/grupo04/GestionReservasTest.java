package org.grupo04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Clase de pruebas unitarias para la gestión de reservas.
 * <p>
 * Prueba los métodos de la clase GestionReservas: añadir, obtener,
 * eliminar, cambiar fechas y listar reservas.
 * </p>
 */
public class GestionReservasTest {

    /** Gestor de reservas utilizado en las pruebas. */
    private GestionReservas gestor;

    /** Primera reserva de prueba. */
    private Reserva r1;

    /** Segunda reserva de prueba. */
    private Reserva r2;

    /**
     * Configuración inicial antes de cada prueba.
     * <p>
     * Crea una instancia de GestionReservas y dos reservas de prueba,
     * y las añade al gestor.
     * </p>
     */
    @BeforeEach
    public void setUp() {
        gestor = new GestionReservas();
        r1 = new Reserva(1, "Ana", "2025-06-01", "2025-06-05", 101);
        r2 = new Reserva(2, "Luis", "2025-07-10", "2025-07-15", 102);
        gestor.add(r1);
        gestor.add(r2);
    }

    /**
     * Verifica que añadir una reserva válida funciona correctamente.
     */
    @Test
    public void Añadir_Reserva_Validaa() {
        // Añadimos una reserva y comprobamos si se añade bien
        Reserva r3 = new Reserva(3, "Carlos", "2025-08-01", "2025-08-04", 103);
        assertTrue(gestor.add(r3));
        assertEquals(3, gestor.listarTodas().size());
    }

    /**
     * Verifica que no se permite añadir una reserva nula.
     */
    @Test
    public void Añadir_Reserva_Nulaa() {
        // No debería poderse añadir una reserva null
        assertFalse(gestor.add(null));
        assertEquals(2, gestor.listarTodas().size());
    }

    /**
     * Verifica que eliminar una reserva con índice válido funciona.
     */
    @Test
    public void Eliminar_Reserva_OK() {
        assertTrue(gestor.remove(0));
        assertEquals(1, gestor.listarTodas().size());
        assertSame(r2, gestor.get(0));
    }

    /**
     * Verifica que eliminar una reserva que no existe no afecta la lista.
     */
    @Test
    public void Eliminar_Reserva_Que_No_Existe() {
        assertFalse(gestor.remove(999));
        assertEquals(2, gestor.listarTodas().size());
    }

    /**
     * Verifica que cambiar la fecha de entrada con índice válido funciona.
     */
    @Test
    public void Cambiar_Fecha_Entrada_OK() {
        assertTrue(gestor.cambiarFechaEntrada(0, "2025-06-02"));
        assertEquals("2025-06-02", gestor.get(0).getFechaEntrada());
    }

    /**
     * Verifica que cambiar la fecha de entrada con índice inválido devuelve false.
     */
    @Test
    public void Cambiar_Fecha_Entrada_Fail() {
        assertFalse(gestor.cambiarFechaEntrada(100, "2025-06-02"));
    }

    /**
     * Verifica que cambiar la fecha de salida con índice válido funciona.
     */
    @Test
    public void Cambiar_Salida_OK() {
        assertTrue(gestor.cambiarFechaSalida(1, "2025-07-16"));
        assertEquals("2025-07-16", gestor.get(1).getFechaSalida());
    }

    /**
     * Verifica que cambiar la fecha de salida con índice inválido devuelve false.
     */
    @Test
    public void Cambiar_Salida_No_Valida() {
        assertFalse(gestor.cambiarFechaSalida(-2, "2025-07-16"));
    }

    /**
     * Verifica que listar todas las reservas devuelve la lista completa.
     */
    @Test
    public void Listar_Reservas_Exixtentes() {
        ArrayList<Reserva> lista = gestor.listarTodas();
        assertEquals(2, lista.size());
        assertSame(r1, lista.get(0));
        assertSame(r2, lista.get(1));
    }
}