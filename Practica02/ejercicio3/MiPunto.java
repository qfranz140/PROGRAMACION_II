package ejercicio3;

public class MiPunto {
    // Atributos
    private double x;
    private double y;

    // Constructor sin argumentos (0, 0)
    public MiPunto() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor con coordenadas especificadas
    public MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Métodos Getter
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    // Método para calcular la distancia a otro objeto MiPunto
    public double distancia(MiPunto p) {
        double dx = this.x - p.getX();
        double dy = this.y - p.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Método para calcular la distancia a coordenadas x e y especificadas
    public double distancia(double x, double y) {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}