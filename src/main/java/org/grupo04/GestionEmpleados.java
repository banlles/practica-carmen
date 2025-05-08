package org.grupo04;

import java.util.ArrayList;

/**
 * Clase que gestiona una colección de empleados.
 * Proporciona métodos para añadir, eliminar, modificar y listar empleados.
 */
public class GestionEmpleados {
    /**
     * Lista interna que almacena los objetos Empleado.
     */
    private ArrayList<Empleado> empleados;

    /**
     * Constructor que inicializa la lista de empleados.
     */
    public GestionEmpleados() {
        empleados = new ArrayList<Empleado>();
    }

    /**
     * Obtiene la información de un empleado en la posición indicada.
     *
     * @param posicion Índice de la lista de donde se obtendrá el empleado.
     * @return El objeto Empleado en la posición dada, o null si el índice es inválido.
     */
    public Empleado get(int posicion) {
        if (posicion < 0 || posicion >= empleados.size()) {
            return null;
        }
        return empleados.get(posicion);
    }

    /**
     * Añade un nuevo empleado a la colección.
     *
     * @param empleado Objeto Empleado a añadir; no puede ser null.
     * @return true si se añadió correctamente, false si el parámetro es null.
     */
    public boolean add(Empleado empleado) {
        if (empleado == null) {
            return false;
        }
        return empleados.add(empleado);
    }

    /**
     * Elimina el empleado que se encuentra en la posición indicada.
     *
     * @param posicion Índice del empleado a eliminar.
     * @return true si se eliminó correctamente, false si el índice es inválido.
     */
    public boolean remove(int posicion) {
        if (posicion < 0 || posicion >= empleados.size()) {
            return false;
        }
        empleados.remove(posicion);
        return true;
    }

    /**
     * Cambia el nombre del empleado en la posición indicada.
     *
     * @param posicion Índice del empleado cuyo nombre se va a cambiar.
     * @param nuevoNombre Nuevo nombre que se asignará al empleado.
     * @return true si el nombre se cambió correctamente, false si el índice es inválido.
     */
    public boolean cambiarNombre(int posicion, String nuevoNombre) {
        Empleado e = get(posicion);
        if (e == null) {
            return false;
        }
        e.setNombre(nuevoNombre);
        return true;
    }

    /**
     * Devuelve la lista completa de empleados.
     *
     * @return ArrayList con todos los objetos Empleado almacenados.
     */
    public ArrayList<Empleado> listarTodos() {
        return empleados;
    }
}