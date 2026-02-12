import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) throws IOException {
		//Usar nombres que se puedan pronunciar:
		// Se ha aplicado en todo el documento la regla de nombres que se puedan pronunciar.
		
		//Usar nombres que revelen las intenciones:
		//Se ha aplicado en todo el documento la regla de valores que digan lo que son.

		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Dios> dioses = new ArrayList<Dios>();

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
				//Excepciones en lugar de códigos de error.
				try {
					opcion = Integer.parseInt(leer.readLine());
					datosOK = true;
				} catch (NumberFormatException | IOException e) {
					System.err.println("Solo puedes introducir números");
				}
			}
			//Instrucciones switch: 
			//Se llama a los metodos para que no quede todo el codigo en cada caso y se vea mas limpio
			switch (opcion) {
			case 1:
				System.out.println("=== Reclutar Nuevo Heroe ===");
				añadirNuevoDios(dioses);
				break;
			case 2:
				System.out.println("=== Mostrar Dioses por Id ===");
				mostrarDios(dioses);
				break;
			case 3:
				System.out.println("=== Enseñar Nueva Habilidad ===");
				enseñarHabilidad(dioses);
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
	//Argumentos de funciones:
	// El nombre de los metodos dicen lo que hacen
	private static void añadirNuevoDios(ArrayList<Dios> dioses) {
		Dios nuevoHeroe = new Dios();
		nuevoHeroe.pedirDatos(dioses);
		dioses.add(nuevoHeroe);
	}

	private static void mostrarDios(ArrayList<Dios> dioses) throws IOException {
		//Evitar valores mágicos:
		//Todas las variables tienen un valor.
		int idBuscar = pedirID();
		boolean enc = false;
		for (Dios heroeAMostrar : dioses) {
			if (heroeAMostrar.getId() == idBuscar) {
				heroeAMostrar.mostrarDatos();
	
				enc = true;
			}
		}
		if (!enc) {
			System.out.println("No se ha encontrado el dios.");
		}
	}

	public static int pedirID() throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		//Reducir el alcance de las variables:
		//Mueren en el mismo metodo, aun que se utilizen en mas de ellos, para evitar confusiones.
		boolean datosOK = false;
		int idABuscar = -1;
		while (!datosOK) {
			try {
				System.out.println("Introduce el ID del dios : ");
				idABuscar = Integer.parseInt(leer.readLine());
				datosOK = true;
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
		return idABuscar;
	}

	private static void enseñarHabilidad(ArrayList<Dios> dioses) throws IOException {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
		int idBuscar = pedirID();
		boolean enc = false;
		for (Dios diosAñdirHabilidad : dioses) {
			if (diosAñdirHabilidad.getId() == idBuscar) {

				System.out.println("Introduce el nombre del nuevo ataque de: " + diosAñdirHabilidad.getNombre());
				String nuevoAtaque = leer.readLine();
				enc = true;
				if (diosAñdirHabilidad.enseñarHabilidad(nuevoAtaque)) {
					System.out.println(diosAñdirHabilidad.getNombre() + " ha aprendido " + nuevoAtaque);
				}
			}
		}
		if (!enc) {
			System.out.println("No se ha encontrado el dios.");
		}
	}
}
