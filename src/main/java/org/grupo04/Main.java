package org.grupo04;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BBDD bbdd = new BBDD();
		
		Scanner entrada = new Scanner(System.in); //prueba prueba
		if(bbdd.init()){
		System.out.println("Conexión a la base de datos exitosa.");
		boolean salir = false;
		do {
			boolean correcto = false;
			int gestion = 0;
			do {
				System.out.println("Que quieres gestionar (introduce el numero): \n1.Empleados\n2.Reservas\n3.Hotel\n4.Salir");
				if (entrada.hasNextInt()) {
					gestion = entrada.nextInt();

					if (gestion == 4) { 
						correcto = true;
						salir = true;
					} else if (gestion >= 1 && gestion <= 3) {
						correcto = true;
					} else {
						System.out.println("Este número no está en la lista.");
					}
				} else {
					System.out.println("Número incorrecto.");
					entrada.next();
				}
			} while (!correcto);

			if (!salir) {

				switch (gestion) {
					case 1:
						// Gestión de Empleados
						boolean correctoEmpleado = false;
						int gestionEmpleado = 0;
						do {
							System.out.println("Menú de gestión de Empleados (introduce el número): \n1. Introducir empleado\n2. Editar empleado\n3. Eliminar empleado\n4. Ver empleado");
							if (entrada.hasNextInt()) {
								gestionEmpleado = entrada.nextInt();
								if (gestionEmpleado >= 1 && gestionEmpleado <= 4) {
									correctoEmpleado = true;
								} else {
									System.out.println("Número no válido para la gestión de empleados.");
								}
							} else {
								System.out.println("Entrada no válida, introduce un número.");
								entrada.next();
							}
						} while (!correctoEmpleado);

						switch (gestionEmpleado) {
							case 1:
								System.out.println("Has seleccionado: Introducir empleado.");
								System.out.println("Introduce el nombre:");
								String nombre = entrada.next();
								System.out.println("Introduce el puesto:");
								String puesto = entrada.next();
								System.out.println("Introduce el salario:");
								double salario = entrada.nextDouble();
								Empleado empleado = new Empleado(-1, nombre, puesto, salario);
								empleado.persist();
								break;
							case 2:
								System.out.println("Has seleccionado: Editar empleado.");
								ArrayList<Empleado> lista2 = BBDD.selectEmpleado();
								for (int x = 0; x < lista2.size(); x++) {
									System.out.println(lista2.get(x).toString());
								}
								System.out.println("Introduce la id del empleado que quieres editar");
								int id2 = entrada.nextInt();
								System.out.println("Introduce el nombre:");
								String nombre2 = entrada.next();
								System.out.println("Introduce el puesto:");
								String puesto2 = entrada.next();
								System.out.println("Introduce el salario:");
								double salario2 = entrada.nextDouble();
								Empleado empleado2 = new Empleado(id2, nombre2, puesto2, salario2);
								empleado2.merge();
								break;
							case 3:
								System.out.println("Has seleccionado: Eliminar empleado.");
								ArrayList<Empleado> lista3 = BBDD.selectEmpleado();
								for (int x = 0; x < lista3.size(); x++) {
									System.out.println(lista3.get(x).toString());
								}
								System.out.println("Introduce la id del empleado que quieres Elimnar");
								int id3 = entrada.nextInt();
								Empleado empleado3 = new Empleado(id3, null, null, -1);
								empleado3.remove();
								break;
							case 4:
								System.out.println("Has seleccionado: Ver empleado.");
								System.out.println("Introduce la id del empleado que quieres ver sus datos");
								int id4 = entrada.nextInt();
								Empleado empleado4 = new Empleado(id4, null, null, -1);
								ArrayList<Empleado> empleadoInfo = empleado4.find();
								System.out.println(empleadoInfo.toString());
								break;
						}
						break;

					case 2:
						// Gestión de Reservas
						boolean correctoReserva = false;
						int gestionReserva = 0;
						do {
							System.out.println("Menú de gestión de Reservas (introduce el número): \n1. Crear reserva\n2. Editar reserva\n3. Cancelar reserva\n4. Ver reserva");
							if (entrada.hasNextInt()) {
								gestionReserva = entrada.nextInt();
								if (gestionReserva >= 1 && gestionReserva <= 4) {
									correctoReserva = true;
								} else {
									System.out.println("Número no válido para la gestión de reservas.");
								}
							} else {
								System.out.println("Entrada no válida, introduce un número.");
								entrada.next();
							}
						} while (!correctoReserva);

						switch (gestionReserva) {
							case 1:
								System.out.println("Has seleccionado: Crear reserva.");
								System.out.println("Introduce el nombre del huésped:");
								String nombreHuesped = entrada.next();
								System.out.println("Introduce la fecha de entrada (formato dd-mm-yyyy):");
								String fechaEntrada = entrada.next();
								System.out.println("Introduce la fecha de salida (formato dd-mm-yyyy):");
								String fechaSalida = entrada.next();
								System.out.println("Introduce el número de habitación:");
								int numeroHabitacion = entrada.nextInt();
								Reserva reserva = new Reserva(-1, nombreHuesped, fechaEntrada, fechaSalida, numeroHabitacion);
								reserva.persist();
								break;
							case 2:
								System.out.println("Has seleccionado: Editar reserva.");
								ArrayList<Reserva>  listaReserva = BBDD.selectReserva();
								System.out.println("Lista de reservas:");
								for (int x = 0; x < listaReserva.size(); x++) {
									System.out.println(listaReserva.get(x).toString());
								}
								System.out.println("Introduce la id de la reserva que quieres editar");
								int idReservaEditar = entrada.nextInt();
								System.out.println("Introduce el nombre del huésped:");
								String nombreHuespedEdit = entrada.next();
								System.out.println("Introduce la fecha de entrada (formato dd-mm-yyyy):");
								String fechaEntradaEdit = entrada.next();
								System.out.println("Introduce la fecha de salida (formato dd-mm-yyyy):");
								String fechaSalidaEdit = entrada.next();
								System.out.println("Introduce el número de habitación:");
								int numeroHabitacionEdit = entrada.nextInt();
								Reserva reservaEditar = new Reserva(idReservaEditar, nombreHuespedEdit, fechaEntradaEdit, fechaSalidaEdit, numeroHabitacionEdit);
								reservaEditar.merge();
								break;
							case 3:
								System.out.println("Has seleccionado: Cancelar reserva.");
								ArrayList<Reserva> listaReservaEliminar = BBDD.selectReserva();
								System.out.println("Lista de reservas:");
								for (int x = 0; x < listaReservaEliminar.size(); x++) {
									System.out.println(listaReservaEliminar.get(x).toString());
								}
								System.out.println("Introduce la id de la reserva que quieres cancelar");
								int idReservaCancelar = entrada.nextInt();
								System.out.println("Introduce el nombre del huésped:");
								String nombreHuespedCancelar = entrada.next();
								Reserva reservaCancelar = new Reserva(idReservaCancelar, nombreHuespedCancelar, null, null, -1);
								reservaCancelar.remove();
								break;
							case 4:
								System.out.println("Has seleccionado: Ver reserva.");
								System.out.println("Introduce la id de la reserva que quieres ver");
								int idReservaVer = entrada.nextInt();
								Reserva reservaVer = new Reserva(idReservaVer, null, null, null, -1);
								ArrayList<Reserva> reservaInfo = reservaVer.find();
								System.out.println(reservaInfo.toString());
								break;
						}
						break;

					case 3:
						// Gestión de Hotel
						boolean correctoHotel = false;
						int gestionHotel = 0;
						do {
							System.out.println("Menú de gestión de Hotel (introduce el número): \n1. Añadir hotel\n2. Editar hotel\n3. Eliminar hotel\n4. Ver hotel");
							if (entrada.hasNextInt()) {
								gestionHotel = entrada.nextInt();
								if (gestionHotel >= 1 && gestionHotel <= 4) {
									correctoHotel = true;
								} else {
									System.out.println("Número no válido para la gestión del hotel.");
								}
							} else {
								System.out.println("Entrada no válida, introduce un número.");
								entrada.next();
							}
						} while (!correctoHotel);

						switch (gestionHotel) {
							case 1:
								System.out.println("Has seleccionado: Añadir hotel.");
								System.out.println("Introduce el número de habitaciones:");
								int habitaciones = entrada.nextInt();
								System.out.println("Introduce el nombre del hotel:");
								String nameHotel = entrada.next();
								System.out.println("Introduce la ubicación del hotel:");
								String locationHotel = entrada.next();
								Hotel hotel = new Hotel(habitaciones, nameHotel, locationHotel);
								hotel.persist();
								break;
							case 2:
								System.out.println("Has seleccionado: Editar hotel.");
								ArrayList<Hotel> listaHotel = BBDD.selectHotel();
								System.out.println("Lista de hoteles:");
								for (int x = 0; x < listaHotel.size(); x++) {
									System.out.println(listaHotel.get(x).toString());
								}
								System.out.println("Introduce el nombre del hotel que deseas editar:");
								String hotelOriginal = entrada.next();
								System.out.println("Introduce el nuevo número de habitaciones:");
								int habitacionesEdit = entrada.nextInt();
								System.out.println("Introduce el nuevo nombre del hotel:");
								String nuevoNombre = entrada.next();
								System.out.println("Introduce la nueva ubicación del hotel:");
								String nuevaUbicacion = entrada.next();
								Hotel hotelEditar = new Hotel(habitacionesEdit, nuevoNombre, nuevaUbicacion);
								hotelEditar.merge();
								break;
							case 3:
								System.out.println("Has seleccionado: Eliminar hotel.");
								ArrayList<Hotel> listaHotelEliminar = BBDD.selectHotel();
								System.out.println("Lista de hoteles:");
								for (int x = 0; x < listaHotelEliminar.size(); x++) {
									System.out.println(listaHotelEliminar.get(x).toString());
								}
								System.out.println("Introduce el nombre del hotel que quieres eliminar:");
								String hotelEliminarNombre = entrada.next();
								Hotel hotelEliminar = new Hotel(0, hotelEliminarNombre, null);
								hotelEliminar.remove();
								break;
							case 4:
								System.out.println("Has seleccionado: Ver hotel.");
								System.out.println("Introduce el nombre del hotel que quieres ver:");
								String hotelVerNombre = entrada.next();
								Hotel hotelVer = new Hotel(0, hotelVerNombre, null);
								ArrayList<Hotel> hotelInfo = new ArrayList<Hotel>();
								hotelInfo = hotelVer.find();
								System.out.println(hotelInfo.toString());
								break;
						}
						break;
				}
			}
		} while (!salir);
		 } else {
		System.out.println("Error al conectar con la base de datos.");
		 }


	}

}
