package org.grupo04;

import java.util.ArrayList;

/**
 * Clase que representa un hotel.
 * Contiene información sobre el número de habitaciones,
 * el nombre y la ubicación, y proporciona métodos
 * para operaciones de búsqueda y persistencia en la BBDD.
 */
public class Hotel {
    /**
     * Número de habitaciones disponibles en el hotel.
     */
    private int habitaciones;
    /**
     * Nombre del hotel.
     */
    private String name;
    /**
     * Ubicación del hotel.
     */
    private String location;

    /**
     * Constructor por defecto.
     * Inicializa un objeto Hotel sin valores.
     */
    public Hotel() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param habitaciones Número de habitaciones del hotel.
     * @param name Nombre del hotel.
     * @param location Ubicación del hotel.
     */
    public Hotel(int habitaciones, String name, String location) {
        this.habitaciones = habitaciones;
        this.name = name;
        this.location = location;
    }

    /**
     * Obtiene el número de habitaciones del hotel.
     *
     * @return Número de habitaciones.
     */
    public int getHabitaciones() {
        return habitaciones;
    }


    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    /**
     * Obtiene el nombre del hotel.
     *
     * @return Nombre del hotel.
     */
    public String getName() { return name; }

    /**
     * Establece el nombre del hotel verificando que no contenga dígitos.
     *
     * @param name Nombre a asignar al hotel.
     * @throws IllegalArgumentException Si el nombre contiene números.
     */
    public void setName(String name) {
        if (name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no puede contener números");
        }
        this.name = name;
    }

    /**
     * Obtiene la ubicación del hotel.
     *
     * @return Ubicación del hotel.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Establece la ubicación del hotel.
     *
     * @param location Nueva ubicación.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Busca hoteles en la base de datos que coincidan con este objeto.
     *
     * @return Lista de hoteles encontrados.
     */
    public ArrayList<Hotel> find() {
        return BBDD.find(this);
    }

    /**
     * Persiste este hotel en la base de datos.
     *
     * @return true si se guardó correctamente, false en caso contrario.
     */
    public boolean persist() {
        return BBDD.persist(this);
    }

    /**
     * Actualiza este hotel en la base de datos.
     *
     * @return true si se actualizó correctamente, false en caso contrario.
     */
    public boolean merge () {
        return BBDD.merge(this);
    }

    /**
     * Elimina este hotel de la base de datos.
     *
     * @return true si se eliminó correctamente, false en caso contrario.
     */
    public boolean remove () {
        return BBDD.remove(this);
    }

    /**
     * Representación en cadena del objeto Hotel.
     *
     * @return String con los detalles del hotel.
     */
    @Override
    public String toString() {
        return "Hotel [habitaciones=" + habitaciones + ", name=" + name + ", location=" + location + "]";
    }
}