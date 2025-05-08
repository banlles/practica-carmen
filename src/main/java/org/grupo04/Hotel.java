package org.grupo04;

import java.util.ArrayList;

public class Hotel {
    private int habitaciones;
    private String name;
    private String location;

    public Hotel() {
    	
    }

	public Hotel(int habitaciones, String name, String location) {
        this.habitaciones = habitaciones;
        this.name = name;
        this.location = location;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getName() { return name; }

    /**
     * Este server sirve para añadir el nombre del Hotel y se compreba que el nombre no contenga ningún caracter que no sean Letras
     * @param name El nombre que se le asignara al Hotel
     */
    public void setName(String name) {
        if (name.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no puede contener números");
        }
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public ArrayList<Hotel> find() {
    	return BBDD.find(this);
    }
    
    public boolean persist() {
    	return BBDD.persist(this);
    }
    
    public boolean merge () {
    	return BBDD.merge(this);
    }
    
    public boolean remove () {
    	return BBDD.remove(this);
    }
    
    @Override
	public String toString() {
		return "Hotel [habitaciones=" + habitaciones + ", name=" + name + ", location=" + location + "]";
	}
}

