import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Heroe {

	private int id;
	private String nombre;
	private String linaje;
	private String[] habilidades = new String[4];
	private int numAtaques;

	public void pedirDatos(ArrayList<Heroe> heroes) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		int idHeroe = -1;
		do {
			try {
				System.out.println("Introduce el número del heroe que quiera añadir(1-100): ");
				idHeroe = Integer.parseInt(leer.readLine());
				if (idHeroe < 1 || idHeroe > 100)
					System.out.println("El numero tiene que ser entre 1 y 100");
			} catch (NumberFormatException | IOException e) {
				System.out.println("Intoduce solo numeros");
				idHeroe = -1;
			}
		} while (estaRepetido(heroes, idHeroe) || idHeroe < 1 || idHeroe > 100);
		System.out.println("Asignado el id " + idHeroe);
		id = idHeroe;

		boolean datosOK = false;
		while (!datosOK) {

			try {

				System.out.print("Introduce el nombre del Heroe: ");
				nombre = leer.readLine();

				System.out.println("Introduce el linaje: ");
				linaje = leer.readLine();


				datosOK = true;
			} catch (IOException e) {
				System.out.println("Has introducido mal algún dato, crack");
				e.printStackTrace();
			}

		}
	}

	private boolean estaRepetido(ArrayList<Heroe> heroes, int idHeroe) {
		for (int i = 0; i < (heroes.size()); i++) {
			if (heroes.get(i).getId() == idHeroe) {
				System.err.println("El ID esta repetido. Introduce otro");
				return true;
			}

		}
		return false;

	}

	public int getId() {
		return id;
	}

}
