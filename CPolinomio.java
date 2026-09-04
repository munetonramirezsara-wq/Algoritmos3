import java.util.Scanner;

public class CPolinomio {
	private static class Polinomio {
		private final int grado;
		private final int[] coeficientes;

		public Polinomio(int grado) {
			this.grado = grado;
			this.coeficientes = new int[grado + 1];
		}

		public void setCoeficiente(int indice, int valor) {
			if (indice >= 0 && indice <= grado) {
				coeficientes[indice] = valor;
			}
		}

		public int getCoeficiente(int indice) {
			if (indice >= 0 && indice <= grado) {
				return coeficientes[indice];
			}
			return 0;
		}

		public int evaluar(int x) {
			int resultado = 0;
			for (int i = 0; i <= grado; i++) {
				resultado = resultado * x + coeficientes[i];
			}
			return resultado;
		}
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		System.out.println("Polinomios");
		System.out.print("Ingrese el grado del polinomio: ");
		int grado = entrada.nextInt();

		Polinomio polinomio = new Polinomio(grado);
		for (int i = 0; i <= grado; i++) {
			System.out.print("Ingrese el coeficiente del termino de grado "
					+ (grado - i) + ": ");
			polinomio.setCoeficiente(i, entrada.nextInt());
		}

		System.out.print("El polinomio es: ");
		for (int i = 0; i <= grado; i++) {
			if (i > 0) {
				System.out.print(" + ");
			}

			System.out.print(polinomio.getCoeficiente(i));
			if (i < grado) {
				System.out.print("x^" + (grado - i));
			}
		}
		System.out.println();

		System.out.print("Ingrese el valor de x: ");
		int x = entrada.nextInt();
		System.out.println("El resultado del polinomio evaluado en x = "
				+ x + " es: " + polinomio.evaluar(x));

		entrada.close();
	}
}
