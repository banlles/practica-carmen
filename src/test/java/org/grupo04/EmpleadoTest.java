package org.grupo04;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para la clase Empleado.
 * Verifica el comportamiento de los métodos setter y getter de nombre,
 * incluyendo validaciones de formato.
 */
public class EmpleadoTest {
    /**
     * Instancia de Empleado utilizada en las pruebas.
     */
    private Empleado emp;

    /**
     * Configura el entorno de prueba antes de cada test.
     * Inicializa un nuevo objeto Empleado.
     */
    @BeforeEach
    public void setUp() {
        emp = new Empleado();
    }

    /**
     * Verifica que setNombre acepte un nombre válido sin números.
     * Se espera que el getter devuelva exactamente el nombre establecido.
     */
    @Test
    public void setNombre_Valido() {
        emp.setNombre("Maria");
        assertEquals("Maria", emp.getNombre());
    }

    /**
     * Verifica que setNombre lance IllegalArgumentException al contener dígitos.
     * Se espera que al pasar un nombre con un número, se produzca la excepción.
     */
    @Test
    public void setNombre_ContieneNumero() {
        assertThrows(IllegalArgumentException.class, () -> {
            emp.setNombre("Maria2");
        });
    }
}

