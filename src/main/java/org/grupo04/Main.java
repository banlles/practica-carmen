package org.grupo04;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		BBDD bbdd = new BBDD();
		
		Scanner entrada = new Scanner(System.in);
		if(bbdd.init()){
		System.out.println("Conexión a la base de datos exitosa.");
		boolean salir = false;
		do {
			boolean correcto = false;
			int gestion = 0;
			do {
				System.out.println(
						"Que quieres gestionar (introduce el numero): \n1.Empleados\n2.Reservas\n3.Hotel\n4.Salir");
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
                     		ArrayList<Empleado> lista2 = new ArrayList<Empleado>();
                             lista2 = BBDD.selectEmpleado();
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
                             ArrayList<Empleado> lista3 = new ArrayList<Empleado>();
                             lista3 = BBDD.selectEmpleado();
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
                             // Aquí iría la lógica para ver empleado.
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
                             // Lógica para crear una reserva.
                             break;
                         case 2:
                             System.out.println("Has seleccionado: Editar reserva.");
                             // Lógica para editar una reserva.
                             break;
                         case 3:
                             System.out.println("Has seleccionado: Cancelar reserva.");
                             // Lógica para cancelar una reserva.
                             break;
                         case 4:
                             System.out.println("Has seleccionado: Ver reserva.");
                             // Lógica para ver una reserva.
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
                             // Lógica para añadir un hotel.
                             break;
                         case 2:
                             System.out.println("Has seleccionado: Editar hotel.");
                             // Lógica para editar un hotel.
                             break;
                         case 3:
                             System.out.println("Has seleccionado: Eliminar hotel.");
                             // Lógica para eliminar un hotel.
                             break;
                         case 4:
                             System.out.println("Has seleccionado: Ver hotel.");
                             // Lógica para ver la información de un hotel.
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
