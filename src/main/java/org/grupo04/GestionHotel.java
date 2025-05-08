package org.grupo04;

import java.util.ArrayList;

/**
 * Clase que gestiona una colección de hoteles.
 * Proporciona métodos para añadir, eliminar, modificar y listar hoteles.
 */
public class GestionHotel {
    /**
     * Lista interna que almacena los objetos Hotel.
     */
    private ArrayList<Hotel> hoteles;

    /**
     * Constructor que inicializa la lista de hoteles.
     */
    public GestionHotel() {
        hoteles = new ArrayList<Hotel>();
    }

    /**
     * Obtiene la información de un hotel en la posición indicada.
     *
     * @param posicion Índice de la lista de donde se obtendrá el hotel.
     * @return El objeto Hotel en la posición dada, o null si el índice es inválido.
     */
    public Hotel get(int posicion) {
        if (posicion < 0 || posicion >= hoteles.size()) {
            return null;
        }
        return hoteles.get(posicion);
    }

    /**
     * Añade un nuevo hotel a la colección.
     *
     * @param hotel Objeto Hotel a añadir; no puede ser null.
     * @return true si se añadió correctamente, false si el parámetro es null.
     */
    public boolean add(Hotel hotel) {
        if (hotel == null) {
            return false;
        }
        return hoteles.add(hotel);
    }

    /**
     * Elimina el hotel que se encuentra en la posición indicada.
     *
     * @param posicion Índice del hotel a eliminar.
     * @return true si se eliminó correctamente, false si el índice es inválido.
     */
    public boolean remove(int posicion) {
        if (posicion < 0 || posicion >= hoteles.size()) {
            return false;
        }
        hoteles.remove(posicion);
        return true;
    }

    /**
     * Cambia el nombre del hotel en la posición indicada.
     *
     * @param posicion Índice del hotel cuyo nombre se va a cambiar.
     * @param nuevoName Nuevo nombre que se asignará al hotel.
     * @return true si el nombre se cambió correctamente, false si el índice es inválido.
     */
    public boolean cambiarName(int posicion, String nuevoName) {
        Hotel hotel = get(posicion);
        if (hotel == null) {
            return false;
        }
        hotel.setName(nuevoName);
        return true;
    }

    /**
     * Devuelve la lista completa de hoteles.
     *
     * @return ArrayList con todos los objetos Hotel almacenados.
     */
    public ArrayList<Hotel> listarTodos() {
        return hoteles;
    }
}