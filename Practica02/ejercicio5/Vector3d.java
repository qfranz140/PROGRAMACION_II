package ejercicio5;

public class Vector3d {
    // Atributos que representan las componentes (a1, a2, a3)
    private double a1;
    private double a2;
    private double a3;

    // Constructor sin argumentos (0, 0, 0)
    public Vector3d() {
        this.a1 = 0.0;
        this.a2 = 0.0;
        this.a3 = 0.0;
    }

    // Constructor con parametros
    public Vector3d(double a1, double a2, double a3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    // Métodos Getter
    public double getA1() {
        return this.a1;
    }

    public double getA2() {
        return this.a2;
    }

    public double getA3() {
        return this.a3;
    }

    // a) Suma de dos vectores: c = a + b
    public Vector3d suma(Vector3d b) {
        double c1 = this.a1 + b.getA1();
        double c2 = this.a2 + b.getA2();
        double c3 = this.a3 + b.getA3();
        return new Vector3d(c1, c2, c3);
    }

    // b) Multiplicación de un escalar r por un vector: b = r * a
    public Vector3d multiplicarEscalar(double r) {
        double b1 = r * this.a1;
        double b2 = r * this.a2;
        double b3 = r * this.a3;
        return new Vector3d(b1, b2, b3);
    }

    // c) Longitud de un vector: |a| = sqrt(a1^2 + a2^2 + a3^2)
    public double longitud() {
        return Math.sqrt((this.a1 * this.a1) + (this.a2 * this.a2) + (this.a3 * this.a3));
    }

    // d) Normal de un vector: b = a / |a|
    public Vector3d normal() {
        double lon = this.longitud();
        if (lon == 0) {
            return new Vector3d(0.0, 0.0, 0.0);
        }
        return new Vector3d(this.a1 / lon, this.a2 / lon, this.a3 / lon);
    }

    // e) Producto escalar: a . b = a1*b1 + a2*b2 + a3*b3
    public double productoEscalar(Vector3d b) {
        return (this.a1 * b.getA1()) + (this.a2 * b.getA2()) + (this.a3 * b.getA3());
    }

    // f) Producto vectorial: a x b = (a2*b3 - a3*b2, a3*b1 - a1*b3, a1*b2 - a2*b1)
    public Vector3d productoVectorial(Vector3d b) {
        double c1 = (this.a2 * b.getA3()) - (this.a3 * b.getA2());
        double c2 = (this.a3 * b.getA1()) - (this.a1 * b.getA3());
        double c3 = (this.a1 * b.getA2()) - (this.a2 * b.getA1());
        return new Vector3d(c1, c2, c3);
    }

    @Override
    public String toString() {
        return "(" + this.a1 + ", " + this.a2 + ", " + this.a3 + ")";
    }
}