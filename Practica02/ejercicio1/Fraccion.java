package ejercicio1;

/**
* La Clase Fracci´on .
*
* @author Franz xd
* @version 1.0 03/03/2026
*
*/
public class Fraccion {
	// Atributos
	private int numerador;
	private int denominador;

	// M´etodos
	/**
	 * Construye una nueva fracci´on .
	 */
	public Fraccion() {
		this.numerador = 0;
		this.denominador = 1;
	}

	/**
	 * Construye una nueva fracci´on .
	 */
	public Fraccion(int n, int d) {
		this.numerador = n;
		this.denominador = d;
	}

	/**
	 * Comprueba si dos fracciones son iguales .
	 *
	 * @param o Object , otro objeto .
	 * @return true si las fracciones son iguales .
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Fraccion) {
			Fraccion f = (Fraccion) o;
			return f.numerador == this.numerador && f.denominador == this.denominador;
		} else
			return false;
	}

	/**
	 * Retorna la representaci´on de Cadena del objeto Fraccion .
	 *
	 * @return String , la fracci´on en formato de cadena .
	 */
	@Override
	public String toString() {
		return String.format(" %d/ %d", this.numerador, this.denominador);
	}

	/**
	 * Suma dos fracciones .
	 *
	 * @param o Fraccion , contiene la otra fraccion .
	 * @return Fraccion resultante .
	 */
	public Fraccion suma(Fraccion o) {
		int n = (this.numerador * o.denominador) + (this.denominador * o.numerador);
		int d = this.denominador * o.denominador;
		return new Fraccion(n, d);
	}

	/**
	 * Resta dos fracciones .
	 *
	 * @param o Fraccion , contiene la otra fracci´on .
	 * @return c Fraccion resultante .
	 */
	public Fraccion resta(Fraccion o) {
		Fraccion c = new Fraccion();
		c.numerador = (this.numerador * o.denominador) - (this.denominador * o.numerador);
		c.denominador = this.denominador * o.denominador;
		return c;
	}
    // Inciso a: Multiplica dos fracciones
    public Fraccion multiplica(Fraccion o) {
        int n = this.numerador * o.numerador;
        int d = this.denominador * o.denominador;
        return new Fraccion(n, d);
    }

    // Inciso b: Divide dos fracciones
    public Fraccion divide(Fraccion o) {
        int n = this.numerador * o.denominador;
        int d = this.denominador * o.numerador;
        return new Fraccion(n, d);
    }

    // Inciso c: Convierte la fracción a número decimal validando división entre 0
    public double convertirADecimal() {
        if (this.denominador == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
            return 0.0;
        }
        return (double) this.numerador / this.denominador;
    }

    // Inciso d: Verifica si esta fracción es la inversa de otra usando el método multiplica()
    public boolean esInverso(Fraccion o) {
        Fraccion producto = this.multiplica(o);
        return producto.convertirADecimal() == 1.0;
    }
    // Inciso e: Convierte una cadena con formato "a/b" en un objeto Fraccion
    public static Fraccion parseFraccion(String str) {
        String[] partes = str.trim().split("/");
        int n = Integer.parseInt(partes[0].trim());
        int d = Integer.parseInt(partes[1].trim());
        return new Fraccion(n, d);
    }

    // Método auxiliar para calcular el Máximo Común Divisor (MCD)
    private int mcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Inciso f: Retorna una nueva Fraccion simplificada hasta su forma irreducible
    public Fraccion simplifica() {
        int divisor = mcd(this.numerador, this.denominador);
        if (divisor == 0) {
            return new Fraccion(this.numerador, this.denominador);
        }
        return new Fraccion(this.numerador / divisor, this.denominador / divisor);
    }
}
