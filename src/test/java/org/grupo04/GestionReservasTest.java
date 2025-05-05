package org.grupo04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class GestionReservasTest {
    private GestionReservas gestor;
    private Reserva r1, r2;

    @BeforeEach
    public void setUp() {
        gestor = new GestionReservas();
        r1 = new Reserva(1, "Ana", "2025-06-01", "2025-06-05", 101);
        r2 = new Reserva(2, "Luis", "2025-07-10", "2025-07-15", 102);
        gestor.add(r1);
        gestor.add(r2);
    }

    @Test
    public void Añadir_Reserva_Validaa() {
        // Añadimos una reserva y miramos si se añade vien
        Reserva r3 = new Reserva(3, "Carlos", "2025-08-01", "2025-08-04", 103);
        assertTrue(gestor.add(r3));
        assertEquals(3, gestor.listarTodas().size());
    }

    @Test
    public void Añadir_Reserva_Nulaa() {
        // No deveria poderse añadir una reserva null
        assertFalse(gestor.add(null));
        assertEquals(2, gestor.listarTodas().size());
    }

    @Test
    public void Obtener_Reserva_Con_Posicion_Buena() {
        assertSame(r1, gestor.get(0));
        assertSame(r2, gestor.get(1));
    }

    @Test
    public void Obtener_Reserva_Con_Posicion_Mal() {
        assertNull(gestor.get(-1));
        assertNull(gestor.get(5));
    }

    @Test
    public void Eliminar_Reserva_OK() {
        assertTrue(gestor.remove(0));
        assertEquals(1, gestor.listarTodas().size());
        assertSame(r2, gestor.get(0));
    }

    @Test
    public void Eliminar_Reserva_Que_No_Existe() {
        assertFalse(gestor.remove(999));
        assertEquals(2, gestor.listarTodas().size());
    }

    @Test
    public void Cambiar_Fecha_Entrada_OK() {
        assertTrue(gestor.cambiarFechaEntrada(0, "2025-06-02"));
        assertEquals("2025-06-02", gestor.get(0).getFechaEntrada());
    }

    @Test
    public void Cambiar_Fecha_Entrada_Fail() {
        assertFalse(gestor.cambiarFechaEntrada(100, "2025-06-02"));
    }

    @Test
    public void Cambiar_Salida_OK() {
        assertTrue(gestor.cambiarFechaSalida(1, "2025-07-16"));
        assertEquals("2025-07-16", gestor.get(1).getFechaSalida());
    }

    @Test
    public void Cambiar_Salida_No_Valida() {
        assertFalse(gestor.cambiarFechaSalida(-2, "2025-07-16"));
    }

    @Test
    public void Numero_Habitacion_OK() {
        assertEquals(101, gestor.getNumeroHabitacion(0));
        assertEquals(102, gestor.getNumeroHabitacion(1));
    }

    @Test
    public void Numero_Habitacion_Mal() {
        assertEquals(-1, gestor.getNumeroHabitacion(999));
    }

    @Test
    public void Listar_Reservas_Exixtentes() {
        ArrayList<Reserva> lista = gestor.listarTodas();
        assertEquals(2, lista.size());
        assertSame(r1, lista.get(0));
        assertSame(r2, lista.get(1));
    }
}

