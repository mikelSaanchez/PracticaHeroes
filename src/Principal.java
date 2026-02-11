import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws IOException {

		// Se ha aplicado en todo el documento la regla de nombres con sentido y que se
		// puedan pronunciar.

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Heroe> heroes = new ArrayList<Heroe>();

		boolean salir = false;
		do {
			System.out.println("\n=== EL ORÁCULO DEL CAMPAMENTO MESTIZO ===");
			System.out.println("1. Reclutar nuevo héroe: ");
			System.out.println("2. Mostrar todos los heroes : ");
			System.out.println("3. Bendición divina (Enseñar nueva habilidad)");
			System.out.println("4. Ascender al Olimpo (Salir)");
			System.out.print("¿Qué desea consultar, mortal?: ");

			int opcion = -1;
			boolean datosOK = false;
			while (!datosOK) {
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}

			switch (opcion) {
			case 1:
				System.out.println("=== Reclutar Nuevo Heroe ===");
				añadirNuevoHeroe(heroes);
				break;
			case 2:
				System.out.println("=== Mostrar Dioses por Id ===");
				mostrarHeroes(heroes);
				break;
			case 3:
				System.out.println("=== Enseñar Nueva Habilidad ===");
				enseñarHabilidad(heroes);
				break;
			case 4:
				System.out.println("¡Saliendo del Olympo!");
				salir = true;
				break;
			default:
				System.out.println("Opción no válida");
			}
		} while (!salir);

	}

	private static void añadirNuevoHeroe(ArrayList<Heroe> heroes) {
		Heroe nuevoHeroe = new Heroe();
		nuevoHeroe.pedirDatos(heroes);
		heroes.add(nuevoHeroe);
	}

	private static void mostrarHeroes(ArrayList<Heroe> heroes) throws IOException {
		int idBuscar = pedirID();
		boolean enc = false;
		for (Heroe heroeAMostrar : heroes) {
			if (heroeAMostrar.getId() == idBuscar) {
				heroeAMostrar.mostrarDatos();
				;
				enc = true;
			}
		}
		if (!enc) {
			System.out.println("No se ha el heroe.");
		}
	}

	public static int pedirID() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID del heroe : ");
				idABuscar = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
		return idABuscar;
	}

	private static void enseñarHabilidad(ArrayList<Heroe> heroes) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int idBuscar = pedirID();

		for (Heroe heroeAñdirHabilidad : heroes) {
			if (heroeAñdirHabilidad.getId() == idBuscar) {

				System.out.println("Introduce el nombre del nuevo ataque de: " + heroeAñdirHabilidad.getNombre());
				String nuevoAtaque = leer.readLine();

				if (heroeAñdirHabilidad.enseñarHabilidad(nuevoAtaque)) {
					System.out.println(heroeAñdirHabilidad.getNombre() + " ha aprendido " + nuevoAtaque);
				}
			}
		}
	}
}
