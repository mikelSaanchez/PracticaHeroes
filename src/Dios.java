import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dios {

	private int id;
	private String nombre;
	private String linaje;
	private String[] habilidades = new String[5];
	private int numHabilidades;

	public void pedirDatos(ArrayList<Dios> heroes) {
		BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

		int idDios = -1;
		do {
			try {
				System.out.println("Introduce el número del heroe que quiera añadir(1-100): ");
				idDios = Integer.parseInt(leer.readLine());
				if (idDios < 1 || idDios > 100)
					System.out.println("El numero tiene que ser entre 1 y 100");
			} catch (NumberFormatException | IOException e) {
				System.out.println("Intoduce solo numeros");
				idDios = -1;
			}
		} while (estaRepetido(heroes, idDios) || idDios < 1 || idDios > 100);
		System.out.println("Asignado el id " + idDios);
		id = idDios;

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

	private boolean estaRepetido(ArrayList<Dios> heroes, int idHeroe) {
		// Preferir código legible frente a código ingenioso:
		// Podriamos hacer un metodo mas complejo para comprobar que el ID esta repetido
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

	public void mostrarDatos() {

		System.out.println("Id: " + id);
		System.out.println("-------------");
		System.out.println("Nombre: " + nombre);
		System.out.println("Linaje: " + linaje);

		for (int i = 0; i < numHabilidades; i++) {
			System.out.println("Habilidades: " + habilidades[i] + " ,");
		}

	}

	public String getNombre() {
		return nombre;
	}

	public boolean enseñarHabilidad(String habilidad) {

		if (numHabilidades < 5) {

			habilidades[numHabilidades] = habilidad;
			numHabilidades++;

			return true;

		} else {

			return false;
		}

	}

}
