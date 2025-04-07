package org.grupo04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import java.io.InputStream;
import java.io.IOException;

public class BBDD {
    private Connection conn;
    
    public static PreparedStatement selectEmpleados;
    public static PreparedStatement insertEmpleados;
    public static PreparedStatement updateEmpleados;
    public static PreparedStatement deleteEmpleados;
    
    
    
    public static PreparedStatement selectHotel;
    public static PreparedStatement insertHotel;
    public static PreparedStatement updateHotel;
    public static PreparedStatement deleteHotel;



    public boolean init() {
        try {
        	
            Properties p = loadPropertiesFile();
            if (p == null) return false;

            String strConn = (String) p.get("db.string_connection");
            System.out.println(strConn);
            conn = DriverManager.getConnection(strConn);
            selectEmpleados = conn.prepareStatement("SELECT empleado_id, nombre, puesto, salario FROM empleados WHERE empleado_id = ? AND nombre = ? AND puesto = ? ");
            insertEmpleados = conn.prepareStatement("INSERT INTO empleados (nombre, puesto, salario) VALUES (?, ?, ?");
            updateEmpleados = conn.prepareStatement("UPDATE empleados SET nombre = ?, puesto = ?, salario = ? WHERE empleado_id = ?");
			deleteEmpleados = conn.prepareStatement("DELETE FROM empleados WHERE nombre = ?");
			
			
			selectHotel = conn.prepareStatement(
                    "SELECT habitaciones, name, location FROM hotel WHERE habitaciones = ? AND name = ?");
            insertHotel = conn.prepareStatement("INSERT INTO hotel (habitaciones, name, location) VALUES (?, ?, ?");
            updateHotel = conn
                    .prepareStatement("UPDATE hotel SET habitaciones = ?, name = ?, location = ? WHERE name = ?");
            deleteHotel = conn.prepareStatement("DELETE FROM hotel WHERE name = ?");

            return true;
        } catch (SQLException e) {
            showError(e);
            unLoad();
            return false;
        }
    }

    public static void showError(SQLException e) {
        System.out.println("Mensaje de error: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }

    public void unLoad() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Properties loadPropertiesFile() {
        Properties p = new Properties();
        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            p.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return p;
    }

    public static Empleado[] find(Empleado filtroBusqueda) {
        ArrayList<Empleado> lista = new ArrayList<Empleado>();
        try {
        	BBDD.selectEmpleados.setInt(1, filtroBusqueda.getEmpleadoId());
        	BBDD.selectEmpleados.setString(2, filtroBusqueda.getNombre());
        	BBDD.selectEmpleados.setString(3, filtroBusqueda.getPuesto());
        	BBDD.selectEmpleados.setDouble(4, filtroBusqueda.getSalario());

        	ResultSet rs = BBDD.selectEmpleados.executeQuery();
			while (rs.next()) {
	        	Empleado empleado = new Empleado();
	        	empleado.setEmpleadoId(rs.getInt("empleado_id"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setPuesto(rs.getString("puesto"));
				empleado.setSalario(rs.getDouble("salario"));
				lista.add(empleado);
			}
        } catch (SQLException e) {
        	BBDD.showError(e);
		}
        return (Empleado[])lista.toArray();
    }


    public static boolean Persist(Empleado usuarioInsertar) {
    	try {
        	BBDD.insertEmpleados.setString(1, usuarioInsertar.getNombre());
        	BBDD.insertEmpleados.setString(2, usuarioInsertar.getPuesto());
        	BBDD.insertEmpleados.setDouble(3, usuarioInsertar.getSalario());
        	BBDD.insertEmpleados.executeUpdate();
        	return true;
        } catch (SQLException e) {
        	BBDD.showError(e);
    		return false;
		}
    }

  
    public static boolean Merge(Empleado usuarioEditar) {
    	try {
        	BBDD.updateEmpleados.setString(1, usuarioEditar.getNombre());
        	BBDD.updateEmpleados.setString(2, usuarioEditar.getPuesto());
        	BBDD.updateEmpleados.setDouble(3, usuarioEditar.getSalario());
        	BBDD.insertEmpleados.setDouble(4, usuarioEditar.getEmpleadoId());
        	BBDD.updateEmpleados.executeUpdate();
        	return true;
        } catch (SQLException e) {
        	BBDD.showError(e);
    		return false;
		}
    }

   
    public static boolean Remove(Empleado usuarioEliminar) {
    	try {
        	BBDD.deleteEmpleados.setString(1, usuarioEliminar.getNombre());
        	BBDD.deleteEmpleados.executeUpdate();
        	return true;
        } catch (SQLException e) {
        	BBDD.showError(e);
    		return false;
		}
    }
    
    
    public static Hotel[] find(Hotel filtroBusqueda) {
        ArrayList<Hotel> lista = new ArrayList<Hotel>();
        try {
            BBDD.selectHotel.setInt(1, filtroBusqueda.getHabitaciones());
            BBDD.selectHotel.setString(2, filtroBusqueda.getName());
            BBDD.selectHotel.setString(3, filtroBusqueda.getLocation());

            ResultSet rs = BBDD.selectHotel.executeQuery();
            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setHabitaciones(rs.getInt("habitaciones"));
                hotel.setName(rs.getString("name"));
                hotel.setLocation(rs.getString("location"));
                lista.add(hotel);
            }
        } catch (SQLException e) {
            BBDD.showError(e);
        }
        return (Hotel[]) lista.toArray();
    }

    public static boolean Persist(Hotel usuarioInsertar) {
        try {
            BBDD.insertHotel.setInt(1, usuarioInsertar.getHabitaciones());
            BBDD.insertHotel.setString(2, usuarioInsertar.getName());
            BBDD.insertHotel.setString(3, usuarioInsertar.getLocation());
            BBDD.insertHotel.executeUpdate();
            return true;
        } catch (SQLException e) {
            BBDD.showError(e);
            return false;
        }
    }

    public static boolean Merge(Hotel usuarioEditar) {
        try {
            BBDD.updateHotel.setInt(1, usuarioEditar.getHabitaciones());
            BBDD.updateHotel.setString(2, usuarioEditar.getName());
            BBDD.updateHotel.setString(3, usuarioEditar.getLocation());
            BBDD.insertHotel.setString(4, usuarioEditar.getName());
            BBDD.updateHotel.executeUpdate();
            return true;
        } catch (SQLException e) {
            BBDD.showError(e);
            return false;
        }
    }

    public static boolean Remove(Hotel usuarioEliminar) {
        try {
            BBDD.deleteHotel.setString(1, usuarioEliminar.getName());
            BBDD.deleteHotel.executeUpdate();
            return true;
        } catch (SQLException e) {
            BBDD.showError(e);
            return false;
        }
    }
}
