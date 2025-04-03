package org.grupo04;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

