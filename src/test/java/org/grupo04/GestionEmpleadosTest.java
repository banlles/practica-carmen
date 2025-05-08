// src/test/java/org/grupo04/GestionEmpleadoTest.java
package org.grupo04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class GestionEmpleadosTest {
    private GestionEmpleados gestor;
    private Empleado e1, e2;

    @BeforeEach
    public void setUp() {
        gestor = new GestionEmpleados();
        e1 = new Empleado(1, "Ana", "Recepcionista", 2000.0);
        e2 = new Empleado(2, "Luis", "Cocinero", 1800.5);
        gestor.add(e1);
        gestor.add(e2);
    }

    @Test
    public void get_Valido() {
        assertSame(e1, gestor.get(0));
        assertSame(e2, gestor.get(1));
    }

    @Test
    public void get_NoValido() {
        assertNull(gestor.get(-1));
        assertNull(gestor.get(2));
    }

    @Test
    public void add_EmpleadoValido() {
        Empleado e3 = new Empleado(3, "Carlos", "Limpieza", 1500.0);
        assertTrue(gestor.add(e3));
        assertEquals(3, gestor.listarTodos().size());
        assertSame(e3, gestor.get(2));
    }

    @Test
    public void add_EmpleadoNulo() {
        assertFalse(gestor.add(null));
        assertEquals(2, gestor.listarTodos().size());
    }

    @Test
    public void remove_Valido() {
        assertTrue(gestor.remove(0));
        assertEquals(1, gestor.listarTodos().size());
        assertSame(e2, gestor.get(0));
    }

    @Test
    public void remove_NoValido() {
        assertFalse(gestor.remove(5));
        assertEquals(2, gestor.listarTodos().size());
    }

    @Test
    public void cambiarNombre_Valido() {
        assertTrue(gestor.cambiarNombre(1, "María"));
        assertEquals("María", gestor.get(1).getNombre());
    }

    @Test
    public void cambiarNombre_NoValido() {
        assertFalse(gestor.cambiarNombre(-1, "X"));
    }

    @Test
    public void listarTodos_ContieneTodos() {
        ArrayList<Empleado> lista = gestor.listarTodos();
        assertEquals(2, lista.size());
        assertSame(e1, lista.get(0));
        assertSame(e2, lista.get(1));
    }
}
