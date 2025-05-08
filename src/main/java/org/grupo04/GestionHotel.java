package org.grupo04;

import java.util.ArrayList;

public class GestionHotel {
    private ArrayList<Hotel> hoteles;

    public GestionHotel() {
        hoteles = new ArrayList<Hotel>();
    }

    /**
     * Para dar la info de un Hotel  en concreto
     * @param posicion La posición de la que se devolvera la información
     * @return Devolvera la información del hotel
     */
    public Hotel get(int posicion) {
        if (posicion < 0 || posicion >= hoteles.size()) {
            return null;
        }
        return hoteles.get(posicion);
    }

    /**
     * Añadir un nuevo hotel
     */
    public boolean add(Hotel hotel) {
        if (hotel == null) {
            return false;
        }
        return hoteles.add(hotel);
    }

    /**
     * Eliminar un hotel
     */
    public boolean remove(int posicion) {
        if (posicion < 0 || posicion >= hoteles.size()) {
            return false;
        }
        hoteles.remove(posicion);
        return true;
    }

    /**
     * Cambiar el nombre de un hotel
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
     * Listar todos los hoteles
     */
    public ArrayList<Hotel> listarTodos() {
        return hoteles;
    }
}


