package org.grupo04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Clase de pruebas unitarias para la gestión de empleados.
 * Comprueba el correcto funcionamiento de la clase GestionEmpleados,
 * incluyendo métodos get, add, remove, cambiarNombre y listarTodos.
 */
public class GestionEmpleadosTest {
    /**
     * Instancia del gestor que se testeará.
     */
    private GestionEmpleados gestor;
    /**
     * Empleados de ejemplo para las pruebas.
     */
    private Empleado e1, e2;

    /**
     * Configura el entorno de prueba antes de cada test.
     * Inicializa el gestor y añade dos empleados de ejemplo.
     */
    @BeforeEach
    public void setUp() {
        gestor = new GestionEmpleados();
        e1 = new Empleado(1, "Ana", "Recepcionista", 2000.0);
        e2 = new Empleado(2, "Luis", "Cocinero", 1800.5);
        gestor.add(e1);
        gestor.add(e2);
    }

    /**
     * Verifica que los índices válidos devuelvan los empleados correctos.
     */
    @Test
    public void get_Valido() {
        assertSame(e1, gestor.get(0));
        assertSame(e2, gestor.get(1));
    }

    /**
     * Verifica que índices inválidos retornen null.
     */
    @Test
    public void get_NoValido() {
        assertNull(gestor.get(-1));
        assertNull(gestor.get(2));
    }

    /**
     * Comprueba que añadir un empleado válido funciona correctamente.
     * Se espera true, tamaño incrementado y empleado accesible.
     */
    @Test
    public void add_EmpleadoValido() {
        Empleado e3 = new Empleado(3, "Carlos", "Limpieza", 1500.0);
        assertTrue(gestor.add(e3));
        assertEquals(3, gestor.listarTodos().size());
        assertSame(e3, gestor.get(2));
    }

    /**
     * Comprueba que añadir un empleado nulo devuelve false
     * y no modifica la colección.
     */
    @Test
    public void add_EmpleadoNulo() {
        assertFalse(gestor.add(null));
        assertEquals(2, gestor.listarTodos().size());
    }

    /**
     * Verifica que eliminar por índice válido funciona correctamente,
     * reduciendo el tamaño y desplazando elementos.
     */
    @Test
    public void remove_Valido() {
        assertTrue(gestor.remove(0));
        assertEquals(1, gestor.listarTodos().size());
        assertSame(e2, gestor.get(0));
    }

    /**
     * Verifica que eliminar con índice inválido devuelve false
     * y no modifica la colección.
     */
    @Test
    public void remove_NoValido() {
        assertFalse(gestor.remove(5));
        assertEquals(2, gestor.listarTodos().size());
    }

    /**
     * Comprueba el cambio de nombre válido de un empleado.
     */
    @Test
    public void cambiarNombre_Valido() {
        assertTrue(gestor.cambiarNombre(1, "María"));
        assertEquals("María", gestor.get(1).getNombre());
    }

    /**
     * Verifica que cambiar nombre con índice inválido devuelve false.
     */
    @Test
    public void cambiarNombre_NoValido() {
        assertFalse(gestor.cambiarNombre(-1, "X"));
    }

    /**
     * Verifica que listarTodos devuelve todos los empleados añadidos.
     */
    @Test
    public void listarTodos_ContieneTodos() {
        ArrayList<Empleado> lista = gestor.listarTodos();
        assertEquals(2, lista.size());
        assertSame(e1, lista.get(0));
        assertSame(e2, lista.get(1));
    }
}