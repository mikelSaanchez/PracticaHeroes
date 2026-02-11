import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		// Se ha aplicado en todo el documento la regla de nombres con sentido y que se puedan pronunciar.
		
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Heroe> heroes = new ArrayList<Heroe>();

		boolean salir = false;
		do {
			System.out.println("\n=== EL ORÁCULO DEL CAMPAMENTO MESTIZO ===");
            System.out.println("1. Reclutar nuevo héroe: ");
            System.out.println("2. Consultar linaje (Buscar héroes por Dios): ");
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
				System.out.println("=== Consultar Linaje ===");
				
				break;
			case 3:
				System.out.println("=== Enseñar Nueva Habilidad ===");
				
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

}
