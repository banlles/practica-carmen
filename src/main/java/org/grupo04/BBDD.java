package org.grupo04;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Clase para manejar la conexion y operaciones basicas
 * con la base de datos de empleados, reservas y hotel
 */
public class BBDD {
	private Connection conn;

	public static PreparedStatement selectEmpleados;
	public static PreparedStatement selectEmpleadosBase;
	public static PreparedStatement insertEmpleados;
	public static PreparedStatement updateEmpleados;
	public static PreparedStatement deleteEmpleados;

	public static PreparedStatement selectReservas;
	public static PreparedStatement selectReservasBase;
	public static PreparedStatement insertReservas;
	public static PreparedStatement updateReservas;
	public static PreparedStatement deleteReservas;

	public static PreparedStatement selectHotel;
	public static PreparedStatement selectHotelBase;
	public static PreparedStatement insertHotel;
	public static PreparedStatement updateHotel;
	public static PreparedStatement deleteHotel;

	/**
	 * Inicializa la conexion y prepara los statements SQL
	 * @return true si la conexion y preparacion fue exitosa, false si fallo
	 */
	public boolean init() {
		try {
			Properties p = loadPropertiesFile();
			if (p == null)
				return false;

			String strConn = (String) p.get("db.string_connection");
			System.out.println(strConn);
			conn = DriverManager.getConnection(strConn);

			selectEmpleados = conn.prepareStatement(
					"SELECT empleado_id, nombre, puesto, salario FROM empleados WHERE empleado_id = ?");
			selectEmpleadosBase = conn.prepareStatement("SELECT * FROM empleados");
			insertEmpleados = conn.prepareStatement(
					"INSERT INTO empleados (nombre, puesto, salario) VALUES (?, ?, ?)");
			updateEmpleados = conn.prepareStatement(
					"UPDATE empleados SET nombre = ?, puesto = ?, salario = ? WHERE empleado_id = ?");
			deleteEmpleados = conn.prepareStatement(
					"DELETE FROM empleados WHERE empleado_id = ?");

			selectReservas = conn.prepareStatement(
					"SELECT reserva_id, nombre_huesped, fecha_entrada, fecha_salida, numero_habitacion FROM reservas WHERE reserva_id = ?");
			selectReservasBase = conn.prepareStatement("SELECT * FROM reservas");
			insertReservas = conn.prepareStatement(
					"INSERT INTO reservas (nombre_huesped, fecha_entrada, fecha_salida, numero_habitacion) VALUES (?, ?, ?, ?)");
			updateReservas = conn.prepareStatement(
					"UPDATE reservas SET nombre_huesped = ?, fecha_entrada = ?, fecha_salida = ?, numero_habitacion = ? WHERE reserva_id = ?");
			deleteReservas = conn.prepareStatement(
					"DELETE FROM reservas WHERE nombre_huesped = ?");

			selectHotel = conn.prepareStatement(
					"SELECT habitaciones, name, location FROM hotel WHERE name = ?");
			selectHotelBase = conn.prepareStatement("SELECT * FROM hotel");
			insertHotel = conn.prepareStatement(
					"INSERT INTO hotel (habitaciones, name, location) VALUES (?, ?, ?)");
			updateHotel = conn.prepareStatement(
					"UPDATE hotel SET habitaciones = ?, name = ?, location = ? WHERE name = ?");
			deleteHotel = conn.prepareStatement(
					"DELETE FROM hotel WHERE name = ?");

			return true;
		} catch (SQLException e) {
			showError(e);
			unLoad();
			return false;
		}
	}

	/**
	 * Muestra informacion del error SQL por consola
	 * @param e excepcion lanzada por JDBC
	 */
	public static void showError(SQLException e) {
		System.out.println("Mensaje de error: " + e.getMessage());
		System.out.println("SQLState: " + e.getSQLState());
		System.out.println("VendorError: " + e.getErrorCode());
	}

	/**
	 * Cierra la conexion si esta abierta
	 */
	public void unLoad() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga el archivo de configuracion config.properties
	 * @return Properties con los valores cargados, null si fallo
	 */
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

	/**
	 * Busca empleados por ID segun filtro
	 * @param filtroBusqueda Empleado con ID a buscar
	 * @return lista de Empleado que cumplen el filtro
	 */
	public static ArrayList<Empleado> find(Empleado filtroBusqueda) {
		ArrayList<Empleado> lista = new ArrayList<>();
		try {
			BBDD.selectEmpleados.setInt(1, filtroBusqueda.getEmpleadoId());
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
		return lista;
	}

	/**
	 * Obtiene todos los empleados
	 * @return lista completa de Empleado
	 */
	public static ArrayList<Empleado> selectEmpleado() {
		ArrayList<Empleado> lista = new ArrayList<>();
		try {
			ResultSet rs = BBDD.selectEmpleadosBase.executeQuery();
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
		return lista;
	}

	/**
	 * Inserta un nuevo empleado en la BBDD
	 * @param usuarioInsertar Empleado a insertar
	 * @return true si se inserto correctamente, false si fallo
	 */
	public static boolean persist(Empleado usuarioInsertar) {
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

	/**
	 * Actualiza datos de un empleado existente
	 * @param usuarioEditar Empleado con nuevos datos
	 * @return true si la actualizacion fue exitosa, false en caso contrario
	 */
	public static boolean merge(Empleado usuarioEditar) {
		try {
			BBDD.updateEmpleados.setString(1, usuarioEditar.getNombre());
			BBDD.updateEmpleados.setString(2, usuarioEditar.getPuesto());
			BBDD.updateEmpleados.setDouble(3, usuarioEditar.getSalario());
			BBDD.updateEmpleados.setDouble(4, usuarioEditar.getEmpleadoId());
			BBDD.updateEmpleados.executeUpdate();
			return true;
		} catch (SQLException e) {
			BBDD.showError(e);
			return false;
		}
	}

	/**
	 * Elimina un empleado de la BBDD
	 * @param usuarioEliminar Empleado a eliminar
	 * @return true si se elimino correctamente, false si hubo error
	 */
	public static boolean remove(Empleado usuarioEliminar) {
		try {
			BBDD.deleteEmpleados.setInt(1, usuarioEliminar.getEmpleadoId());
			BBDD.deleteEmpleados.executeUpdate();
			return true;
		} catch (SQLException e) {
			BBDD.showError(e);
			return false;
		}
	}

	/**
	 * Busca reservas por ID segun filtro
	 * @param filtroBusqueda Reserva con ID a buscar
	 * @return lista de Reserva que cumplen el filtro
	 */
	public static ArrayList<Reserva> find(Reserva filtroBusqueda) {
		ArrayList<Reserva> lista = new ArrayList<>();
		try {
			BBDD.selectReservas.setInt(1, filtroBusqueda.getReservaId());
			ResultSet rs = BBDD.selectReservas.executeQuery();
			while (rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setReservaId(rs.getInt("reserva_id"));
				reserva.setNombreHuesped(rs.getString("nombre_huesped"));
				reserva.setFechaEntrada(rs.getString("fecha_entrada"));
				reserva.setFechaSalida(rs.getString("fecha_salida"));
				reserva.setNumeroHabitacion(rs.getInt("numero_habitacion"));
				lista.add(reserva);
			}
		} catch (SQLException e) {
			BBDD.showError(e);
		}
		return lista;
	}

	/**
	 * Obtiene todas las reservas
	 * @return lista completa de Reserva
	 */
	public static ArrayList<Reserva> selectReserva() {
		ArrayList<Reserva> lista = new ArrayList<>();
		try {
			ResultSet rs = BBDD.selectReservasBase.executeQuery();
			while (rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setReservaId(rs.getInt("reserva_id"));
				reserva.setNombreHuesped(rs.getString("nombre_huesped"));
				reserva.setFechaEntrada(rs.getString("fecha_entrada"));
				reserva.setFechaSalida(rs.getString("fecha_salida"));
				reserva.setNumeroHabitacion(rs.getInt("numero_habitacion"));
				lista.add(reserva);
			}
		} catch (SQLException e) {
			BBDD.showError(e);
		}
		return lista;
	}

	/**
	 * Inserta una nueva reserva en la BBDD
	 * @param usuarioInsertar Reserva a insertar
	 * @return true si la insercion fue exitosa, false en caso de error
	 */
	public static boolean persist(Reserva usuarioInsertar) {
		try {
			BBDD.insertReservas.setString(1, usuarioInsertar.getNombreHuesped());
			BBDD.insertReservas.setString(2, usuarioInsertar.getFechaEntrada());
			BBDD.insertReservas.setString(3, usuarioInsertar.getFechaSalida());
			BBDD.insertReservas.setInt(4, usuarioInsertar.getNumeroHabitacion());
			BBDD.insertReservas.executeUpdate();
			return true;
		} catch (SQLException e) {
			BBDD.showError(e);
			return false;
		}
	}

	/**
	 * Actualiza datos de una reserva existente
	 * @param usuarioEditar Reserva con nuevos datos
	 * @return true si la actualizacion fue correcta, false en caso contrario
	 */
	public static boolean merge(Reserva usuarioEditar) {
		try {
			BBDD.updateReservas.setString(1, usuarioEditar.getNombreHuesped());
			BBDD.updateReservas.setString(2, usuarioEditar.getFechaEntrada());
			BBDD.updateReservas.setString(3, usuarioEditar.getFechaSalida());
			BBDD.updateReservas.setInt(4, usuarioEditar.getNumeroHabitacion());
			BBDD.updateReservas.setInt(5, usuarioEditar.getReservaId());
			BBDD.updateReservas.executeUpdate();
			return true;
		} catch (SQLException e) {
			BBDD.showError(e);
			return false;
		}
	}

	/**
	 * Elimina una reserva de la BBDD
	 * @param usuarioEliminar Reserva a eliminar
	 * @return true si se elimino correctamente, false en caso de fallo
	 */
	public static boolean remove(Reserva usuarioEliminar) {
		try {
			BBDD.deleteReservas.setString(1, usuarioEliminar.getNombreHuesped());
			BBDD.deleteReservas.executeUpdate();
			return true;
		} catch (SQLException e) {
			BBDD.showError(e);
			return false;
		}
	}

	/**
	 * Busca hoteles por nombre segun filtro
	 * @param filtroBusqueda Hotel con nombre a buscar
	 * @return lista de Hotel que cumplen el filtro
	 */
	public static ArrayList<Hotel> find(Hotel filtroBusqueda) {
		ArrayList<Hotel> lista = new ArrayList<>();
		try {
			BBDD.selectHotel.setString(1, filtroBusqueda.getName());
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
		return lista;
	}

	/**
	 * Obtiene todos los hoteles
	 * @return lista completa de Hotel
	 */
	public static ArrayList<Hotel> selectHotel() {
		ArrayList<Hotel> lista = new ArrayList<>();
		try {
			ResultSet rs = BBDD.selectHotelBase.executeQuery();
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
		return lista;
	}

	/**
	 * Inserta un nuevo hotel en la BBDD
	 * @param usuarioInsertar Hotel a insertar
	 * @return true si la insercion fue exitosa, false en caso de fallo
	 */
	public static boolean persist(Hotel usuarioInsertar) {
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

	/**
	 * Actualiza datos de un hotel existente
	 * @param usuarioEditar Hotel con nuevos datos
	 * @return true si la actualizacion fue exitosa, false en caso contrario
	 */
	public static boolean merge(Hotel usuarioEditar) {
		try {
			BBDD.updateHotel.setInt(1, usuarioEditar.getHabitaciones());
			BBDD.updateHotel.setString(2, usuarioEditar.getName());
			BBDD.updateHotel.setString(3, usuarioEditar.getLocation());
			BBDD.updateHotel.setString(4, usuarioEditar.getName());
			BBDD.updateHotel.executeUpdate();
			return true;
		} catch (SQLException e) {
			BBDD.showError(e);
			return false;
		}
	}

	/**
	 * Elimina un hotel de la BBDD
	 * @param usuarioEliminar Hotel a eliminar
	 * @return true si se elimino correctamente, false en caso de fallo
	 */
	public static boolean remove(Hotel usuarioEliminar) {
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