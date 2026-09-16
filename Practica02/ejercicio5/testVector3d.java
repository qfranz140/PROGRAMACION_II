package ejercicio5;

public class testVector3d {
    public static void main(String[] args) {
        // Creación de dos vectores de prueba
        Vector3d a = new Vector3d(1.0, 2.0, 3.0);
        Vector3d b = new Vector3d(4.0, 5.0, 6.0);

        System.out.println("Vector a = " + a);
        System.out.println("Vector b = " + b);

        // a) Suma
        System.out.println("a) Suma (a + b) = " + a.suma(b));

        // b) Multiplicación escalar
        System.out.println("b) Escalar (2 * a) = " + a.multiplicarEscalar(2.0));

        // c) Longitud
        System.out.println("c) Longitud |a| = " + a.longitud());

        // d) Normal
        System.out.println("d) Normal de a = " + a.normal());

        // e) Producto escalar
        System.out.println("e) Producto escalar (a . b) = " + a.productoEscalar(b));

        // f) Producto vectorial
        System.out.println("f) Producto vectorial (a x b) = " + a.productoVectorial(b));
    }
}