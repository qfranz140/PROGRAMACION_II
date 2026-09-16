package ejercicio3;

public class TestMiPunto {
    public static void main(String[] args) {
        // Creación de los puntos (0, 0) y (10, 30.5)
        MiPunto p1 = new MiPunto();
        MiPunto p2 = new MiPunto(10, 30.5);

        // Cálculo y muestra de la distancia
        double distancia = p1.distancia(p2);
        System.out.println("Distancia entre p1 y p2: " + distancia);
    }
}