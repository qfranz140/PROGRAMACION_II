package ejercicio4;

public class testAlgebraVectorial {
    public static void main(String[] args) {
        // Vectores declarados directamente como arreglos
        double[] v1 = {1.0, 0.0, 0.0};
        double[] v2 = {0.0, 1.0, 0.0};
        double[] v3 = {2.0, 0.0, 0.0};

        // Creación de objetos usando sobrecarga de constructores
        AlgebraVectorial algebra1 = new AlgebraVectorial();
        AlgebraVectorial algebra2 = new AlgebraVectorial(v1, v2);

        System.out.println("Perpendicular en algebra1 (vacio): " + algebra1.perpendicular());
        
        // Pruebas de Perpendicularidad
        System.out.println("c) a . b = 0: " + algebra2.perpendicular());
        System.out.println("a) |a+b| = |a-b|: " + algebra2.perpendicular(v1, v2));
        System.out.println("b) |a-b| = |b-a|: " + algebra2.perpendicular(v1, v2, 'b'));
        System.out.println("d) Pitagoras: " + algebra2.perpendicular(v1, v2, true));

        // Pruebas de Paralelismo
        System.out.println("f) a x b = 0: " + algebra2.paralela(v1, v3));
        System.out.println("e) a = r * b: " + algebra2.paralela(v3, v1, 2.0));

        // Pruebas de Proyección
        double[] proy = algebra2.proyeccion_de_a_sobre_b();
        System.out.println("g) Proyeccion de v1 sobre v2: (" + proy[0] + ", " + proy[1] + ", " + proy[2] + ")");

        // Pruebas de Componente
        System.out.println("h) Componente de v1 en v2: " + algebra2.componente_de_a_en_b());
    }
}