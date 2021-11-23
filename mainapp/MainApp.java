package mainapp;

import java.util.ArrayList;
import java.util.Scanner;

import models.CuentaCorriente;
import models.Persona;

public class MainApp {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Persona> arrayPersonas = new ArrayList<Persona>();

	public static void main(String[] args) {

		int nCuenta = 1;
		System.out.println("----- ARCHIVOS DE LA BANCA -----\n");
		String opc = "";
		
		do {
			System.out
					.println("Elije una opción: \na. Añadir persona\nb. Elegir persona\nc. Borrar persona \nd. Salir");
			opc = sc.nextLine();
			menu(opc, nCuenta);
			if (opc.equals("a")) {
				nCuenta++;
			}
		} while (!opc.equals("d"));

	}

	/**
	 * Muestra un menú y permite interactuar con todas las opciones que se pueden hacer dentro del banco.
	 * @param opc La opción que introduce el usuario por teclado
	 * @param nCuenta Número de cuenta de cada usuario que se introduce
	 */
	public static void menu(String opc, int nCuenta) {
		boolean opValida = true;
		do {
			switch (opc) {
			case "a": //Añadimos una nueva persona
				System.out.println("Introduce el nombre del tiular: ");
				String nombre = sc.nextLine();

				System.out.println("Introduce los apellidos del tiular: ");
				String apellidos = sc.nextLine();

				System.out.println("Introduce el DNI del titular: ");
				String dni = sc.nextLine();

				System.out.println("Introduce el sueldo del tiular: ");
				int sueldo = Integer.parseInt(sc.nextLine());

				arrayPersonas.add(new Persona(nombre, apellidos, dni, sueldo, null));

				System.out.println("El número de cuenta es: " + (nCuenta));
				Persona p = arrayPersonas.get(nCuenta - 1);
				CuentaCorriente cuenta = new CuentaCorriente(nCuenta, p);
				p.setCuentaX(cuenta);

				break;

			case "b": // Elegimos una persona y mostramos un syubmenú con el que podemos interactuar con la cuenta
				boolean op2Valida = true;

				for (Persona x : arrayPersonas) {
					CuentaCorriente c = x.getCuentaX();
					System.out.println(c.getNumeroCuenta() + ". " + x.getDni() + " " + x.getNombre());
				}

				System.out.println("Elige una persona: ");
				int indice = Integer.parseInt(sc.nextLine());
				if (indice <= arrayPersonas.size()) {

					Persona seleccionada = arrayPersonas.get(indice - 1);

					do { 
						op2Valida = true;
						System.out.println(
								"Elije que quieres hacer: \n  i. Cobrar sueldo\n ii. Sacar pasta\niii. Subir sueldo\n iv. Mostrar detalles de la persona\n  v. Salir");

						String opc2 = sc.nextLine();
						switch (opc2) {
						case "i": // Cobramos el sueldo
							System.out.println("Has cobrado el sueldo.");
							seleccionada.cobrarSueldo();
							break;

						case "ii": // Sacamos dinero de la cuenta seleccionada
							System.out.println("Introduce cuanta pasta quieres sacar.");
							double cantidad = Integer.parseInt(sc.nextLine());

							if (cantidad < seleccionada.getCuentaX().getSaldo()) {
								seleccionada.sacarPasta(cantidad);
							} else {
								System.out
										.println("No tienes suficiente dinero para sacar. Intenta que te paguen antes");
							}

							break;

						case "iii": // Subimos el sueldo de una cuenta
							System.out.println("Introduce tu nuevo sueldo: ");
							double sueldonuevo = Integer.parseInt(sc.nextLine());
							if (sueldonuevo > seleccionada.getSueldo()) {
								seleccionada.subirSueldo(sueldonuevo);
							} else {
								System.out.println(
										"Tienes que introducir un sueldo mayor al que ya tienes sino no te merece la pena el cambio.");
							}
							break;

						case "iv": // Mostramos los datos de la cuenta seleccionada
							System.out.println(seleccionada + "\n");
							break;

						case "v": // Salimos del submenú
							op2Valida = false;
							break;
						default:
							System.out.println("\nIntroduce una opcion válida.\n");
							op2Valida = false;
							break;
						}
					} while (op2Valida);
				} else {
					System.out.println("La persona seleccionada no existe.");
				}

				break;

			case "c": // Borramos una persona del registro
				for (Persona x : arrayPersonas) {
					CuentaCorriente c = x.getCuentaX();
					System.out.println(c.getNumeroCuenta() + ". " + x);
				}

				System.out.println("Selecciona a una persona para eliminar: ");
				int indice1 = Integer.parseInt(sc.nextLine());
				System.out.println("Se ha borrado la cuenta " + indice1 + ".");
				arrayPersonas.remove(indice1 - 1);

				break;

			case "d": // Salimos del menú y con esta opción también termina el programa
				System.out.println("Gracias y adios <3");
				break;

			default:
				opValida = false;
				System.out.println("\nIntroduce una opción válida\n");
				break;
			}
		} while (!opValida);
	}

}
