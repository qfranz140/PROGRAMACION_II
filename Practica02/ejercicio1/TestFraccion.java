package ejercicio1;

public class TestFraccion {
    public static void main(String[] args) {
        // Objetos de prueba
        Fraccion f1 = new Fraccion(1, 4);
        Fraccion f2 = new Fraccion(4, 3);
        Fraccion f3 = new Fraccion(4, 1);
        Fraccion f4 = new Fraccion(14, 28);

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        // Operaciones base
        System.out.println("suma = " + f1.suma(f2));
        System.out.println("resta = " + f1.resta(f2));

        // Inciso a: Multiplicación
        System.out.println("multiplica = " + f1.multiplica(f2));

        // Inciso b: División
        System.out.println("divide = " + f1.divide(f2));

        // Inciso c: Convertir a decimal
        System.out.println("f1 a decimal = " + f1.convertirADecimal());

        // Inciso d: Verificar si es inverso
        System.out.println("¿f1 es inverso de f3? = " + f1.esInverso(f3));

        // Inciso e: Parsear String a Fraccion
        Fraccion fParsed = Fraccion.parseFraccion("-7/5");
        System.out.println(" Fraccion paseada " + fParsed);

        // Inciso f: Simplificar fracción
        System.out.println("f4 simplificada = " + f4.simplifica());
    }
}