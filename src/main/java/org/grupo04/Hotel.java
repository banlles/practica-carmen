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
    
    public Hotel[] find() {
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

