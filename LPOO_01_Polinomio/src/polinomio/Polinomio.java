package polinomio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Polinomio {

	private Integer coeficiente;
	private Integer exponente;
	private static Scanner input = new Scanner(System.in);
	static List<Polinomio> polinomio = new ArrayList<>();
	static List<Polinomio> polinomio2 = new ArrayList<>();
	static List<Polinomio> resultado = new ArrayList<>();
	static Integer cant_monomios;

	public void setCoeficiente(Integer coeficiente) {
		this.coeficiente = coeficiente;
	}

	public void setExponente(Integer exponente) {
		this.exponente = exponente;
	}

	public Polinomio(Integer coeficiente_1, Integer exponente_1) {
		// TODO Auto-generated constructor stub
		this.coeficiente = coeficiente_1;
		this.exponente = exponente_1;
	}

	///////////////////////////////////////////////////
	public Integer getCoeficiente() {
		return coeficiente;
	}

	public Integer getExponente() {
		return exponente;
	}

	/////////////////////////////////////////////////////
	// INICIO POLINOMIO 1
	public static void solicitud() {
		System.out.println("Ingrese la cantidad de monomios a manejar: ");
		cant_monomios = input.nextInt();
		for (int i = 0; i < cant_monomios; i++) {
			ingresoLista();
		}
		simplificar();
		impresion();
	}

	public static void impresion() {
		System.out.println("\n########################################");
		System.out.println("\nImpresion de polinomio_1\n");
		for (Polinomio per : polinomio) {
			System.out.print(per + " + ");

		}
		System.out.print(0);
		System.out.println("\n########################################");
	}

	public static void ingresoLista() {
		Integer coeficiente_1;
		Integer exponente_1;
		System.out.println("Ingrese el  valor del coeficiente: ");
		coeficiente_1 = input.nextInt();
		System.out.println("Ingrese el  valor del exponente: ");
		exponente_1 = input.nextInt();

		polinomio.add(new Polinomio(coeficiente_1, exponente_1));
	}

	@Override
	public String toString() {
		return "(" + coeficiente + " X^" + exponente + ") ";
	}

	public static void simplificar() {
		for (int i = 0; i < polinomio.size(); i++) {
			for (int x = i + 1; x < polinomio.size(); x++) {
				// if (x < polinomio.size() ) {

				if (polinomio.get(i).getExponente() == polinomio.get(x).getExponente()) {
					polinomio.get(i)
							.setCoeficiente(polinomio.get(i).getCoeficiente() + polinomio.get(x).getCoeficiente());
					if (i < polinomio.size() - 1)
						polinomio.remove(x);

				}
				// }
			}

		}
	}
	// FIN POLINOMIO 1

	//////////////////////////////////////////////////////////////////////////////////// 7
	///////////////////////////////////////////////////////////////////////////////////// 7
	public static void solicitud2() {
		System.out.println("Ingrese la cantidad de monomios a manejar: ");
		cant_monomios = input.nextInt();
		for (int i = 0; i < cant_monomios; i++) {
			ingresoLista2();
		}
		simplificar2();
		impresion2();
	}

	public static void ingresoLista2() {
		Integer coeficiente_2;
		Integer exponente_2;
		System.out.println("Ingrese el  valor del coeficiente: ");
		coeficiente_2 = input.nextInt();
		System.out.println("Ingrese el  valor del exponente: ");
		exponente_2 = input.nextInt();

		polinomio2.add(new Polinomio(coeficiente_2, exponente_2));
	}

	public static void simplificar2() {
		for (int i = 0; i < polinomio2.size(); i++) {
			for (int x = i + 1; x < polinomio2.size(); x++) {
				// if (x < polinomio.size() ) {

				if (polinomio2.get(i).getExponente() == polinomio2.get(x).getExponente()) {
					polinomio2.get(i)
							.setCoeficiente(polinomio2.get(i).getCoeficiente() + polinomio2.get(x).getCoeficiente());
					if (i < polinomio2.size() - 1)
						polinomio2.remove(x);

				}
				// }
			}

		}
	}

	public static void impresion2() {
		System.out.println("\n########################################");
		System.out.println("\nImpresion de polinomio_2\n");
		for (Polinomio per : polinomio2) {
			System.out.print(per + " + ");

		}
		System.out.print(0);
		System.out.println("\n########################################");
	}

	///////////////////////////////////////////////////////////////// 7
	///////////////////////////////////////////////////////////////// 7
	public static void union2Polinomios() {
		for (int i = 0; i < polinomio.size(); i++) {
			resultado.add(polinomio.get(i));
		}

		for (int i = 0; i < polinomio2.size(); i++) {
			resultado.add(polinomio2.get(i));
		}
	}

	public static void multiplicacion() {
		for (int i = 0; i < polinomio.size(); i++) {

			for (int x = 0; x < polinomio2.size(); x++) {
				resultado.add(new Polinomio(polinomio.get(i).getCoeficiente() * polinomio2.get(x).getCoeficiente(),
						polinomio.get(i).getExponente() + polinomio2.get(x).getExponente()));
			}
		}
		suma();
	}

	public static void suma() {
		for (int i = 0; i < resultado.size(); i++) {
			for (int x = i + 1; x < resultado.size(); x++) {
				// if (x < polinomio.size() ) {

				if (resultado.get(i).getExponente() == resultado.get(x).getExponente()) {
					resultado.get(i)
							.setCoeficiente(resultado.get(i).getCoeficiente() + resultado.get(x).getCoeficiente());
					if (i < resultado.size() - 1)
						resultado.remove(x);

				}
				// }
			}

		}
	}

	public static void resta() {
		for (int i = 0; i < resultado.size(); i++) {
			for (int x = i + 1; x < resultado.size(); x++) {
				// if (x < polinomio.size() ) {

				if (resultado.get(i).getExponente() == resultado.get(x).getExponente()) {
					resultado.get(i)
							.setCoeficiente(resultado.get(i).getCoeficiente() - resultado.get(x).getCoeficiente());
					if (i < resultado.size() - 1)
						resultado.remove(x);

				}
				// }
			}

		}
	}

	public static void impresion3_Resultado() {
		System.out.println("\n########################################");
		System.out.println("\nImpresion de resultado: \n");
		for (Polinomio per : resultado) {
			if (per.getCoeficiente() != 0)
			System.out.print(per + " + ");

		}
		System.out.print(0);
		System.out.println("\n########################################");
	}
	///
	public static void simplificarGeneral(List<Polinomio> lstPolinomio) {
		for (int i = 0; i < lstPolinomio.size(); i++) {
			for (int x = i + 1; x < lstPolinomio.size(); x++) {

				if (lstPolinomio.get(i).getExponente() == lstPolinomio.get(x).getExponente()) {
					lstPolinomio.get(i)
							.setCoeficiente(lstPolinomio.get(i).getCoeficiente() + lstPolinomio.get(x).getCoeficiente());
					if (i < lstPolinomio.size() - 1)
						lstPolinomio.remove(x);

				}
				// }
			}

		}
	}
////////////////
	public static void division() {
		impresion();
		impresion2();
		
		for (int i = 0; i < polinomio.size(); i++) {
			for (int x = 0; x < polinomio2.size(); x++) {
				ordenarpolinomio();
					if (polinomio2.get(0).getExponente() > polinomio.get(i).getExponente()) {
						break;
					} else {
						resultado.add(
								new Polinomio((int) polinomio.get(i).getCoeficiente() / (int) polinomio2.get(x).getCoeficiente(),
										polinomio.get(i).getExponente() - polinomio2.get(x).getExponente()));
						System.out.println("RESULTADO: "+ resultado);
						polinomio.add(
								new Polinomio(-1 * (int)(resultado.get(i).getCoeficiente() * polinomio2.get(x).getCoeficiente()  ),
										polinomio2.get(x).getExponente() + resultado.get(i).getExponente() ));
						System.out.println("POLIGONO: "+ polinomio);
						simplificar();
						simplificar2();
					}

			}

		}
		
		simplificarGeneral(resultado);

	}
	//////////////////////////////////////////////////////// 77
	public static void ordenarpolinomio() {
		Collections.sort(polinomio, new Comparator<Polinomio>() {
			@Override
			public int compare(Polinomio tb2, Polinomio tb1) {

				return tb1.getExponente().compareTo(tb2.getExponente());

			}
		});
	}

	public static void ordenarpolinomio2() {
		Collections.sort(polinomio2, new Comparator<Polinomio>() {
			@Override
			public int compare(Polinomio tb2, Polinomio tb1) {

				return tb1.getExponente().compareTo(tb2.getExponente());

			}
		});
	}

	public static void ordenarResultado() {
		Collections.sort(resultado, new Comparator<Polinomio>() {
			@Override
			public int compare(Polinomio tb2, Polinomio tb1) {

				return tb1.getExponente().compareTo(tb2.getExponente());

			}
		});
	}

	///////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opc;
		solicitud();
		solicitud2();

		System.out.println("Menu de Opciones" 
				+ "\n 1.- Simplificar el 1er polinomio"
				+ "\n 2.- Simplificar el 1er polinomio"
				+ "\n 3.- Suma de polinomios" 
				+ "\n 4.- Resta de polinomios"
				+ "\n 5.- Multiplicacion de polinomios" 
				+ "\n 6.- Division de polinomios" 
				+ "\n !n°- Salir"
				+ "\n ¿Que opcion desea ingresar?  ");
		opc = input.nextInt();

		switch (opc) {
		case 1:
			simplificar();
			break;
		case 2:
			simplificar2();
			break;
		case 3:
			// opcion suma
			union2Polinomios();
			suma(); // necesita metodo union2Polinomios();
			ordenarResultado();
			impresion3_Resultado();

			break;
		case 4:
			resta();// necesita metodo union2Polinomios();

			ordenarResultado();
			impresion3_Resultado();

			break;
		case 5:

			multiplicacion();// metodo autonomo

			ordenarResultado();
			impresion3_Resultado();

			break;
		case 6:
			System.out.println("Seguimos trabajando en ello... Solo acepta divisiones con residuo cero");
			division();
			ordenarResultado();
			impresion3_Resultado();
			
			
			break;

		default:
			break;
		}

	}
}
