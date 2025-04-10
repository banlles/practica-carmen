package org.grupo04;

public class Empleado {
    private int empleadoId;
    private String nombre;
    private String puesto;
    private double salario;

    public Empleado () {
    	
    }
    public Empleado(int empleadoId, String nombre, String puesto, double salario) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public Empleado[] find() {
    	return BBDD.find(this);
    }
    
    public boolean persist() {
    	return BBDD.Persist(this);
    }
    
    public boolean merge () {
    	return BBDD.merge(this);
    }
    
    public boolean remove () {
    	return BBDD.remove(this);
    }
    
	@Override
	public String toString() {
		return "Empleado [empleadoId=" + empleadoId + ", nombre=" + nombre + ", puesto=" + puesto + ", salario="
				+ salario + "]";
	}
}
