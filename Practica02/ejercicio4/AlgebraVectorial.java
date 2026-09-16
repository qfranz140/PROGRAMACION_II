package ejercicio4;

public class AlgebraVectorial {
    // Atributos: Representación de vectores como arreglos simples [x, y, z]
    private double[] a;
    private double[] b;

    // Sobrecarga de Constructores
    public AlgebraVectorial() {
        this.a = new double[]{0.0, 0.0, 0.0};
        this.b = new double[]{0.0, 0.0, 0.0};
    }

    public AlgebraVectorial(double[] a, double[] b) {
        this.a = a;
        this.b = b;
    }

    // --- METODOS AUXILIARES MATEMATICOS ---
    private double productoPunto(double[] v1, double[] v2) {
        return (v1[0] * v2[0]) + (v1[1] * v2[1]) + (v1[2] * v2[2]);
    }

    private double norma(double[] v) {
        return Math.sqrt((v[0] * v[0]) + (v[1] * v[1]) + (v[2] * v[2]));
    }

    private double[] suma(double[] v1, double[] v2) {
        return new double[]{v1[0] + v2[0], v1[1] + v2[1], v1[2] + v2[2]};
    }

    private double[] resta(double[] v1, double[] v2) {
        return new double[]{v1[0] - v2[0], v1[1] - v2[1], v1[2] - v2[2]};
    }

    private double[] productoCruz(double[] v1, double[] v2) {
        double cx = (v1[1] * v2[2]) - (v1[2] * v2[1]);
        double cy = (v1[2] * v2[0]) - (v1[0] * v2[2]);
        double cz = (v1[0] * v2[1]) - (v1[1] * v2[0]);
        return new double[]{cx, cy, cz};
    }

    // --- SOBRECARGA DE METODOS: PERPENDICULAR ---

    // Inciso c: Perpendicular si a . b = 0
    public boolean perpendicular() {
        return Math.abs(productoPunto(this.a, this.b)) < 0.0001;
    }

    // Inciso a: Perpendicular si |a + b| = |a - b|
    public boolean perpendicular(double[] a, double[] b) {
        double normaSuma = norma(suma(a, b));
        double normaResta = norma(resta(a, b));
        return Math.abs(normaSuma - normaResta) < 0.0001;
    }

    // Inciso b: Perpendicular si |a - b| = |b - a|
    public boolean perpendicular(double[] a, double[] b, char modo) {
        double normaAB = norma(resta(a, b));
        double normaBA = norma(resta(b, a));
        return Math.abs(normaAB - normaBA) < 0.0001;
    }

    // Inciso d: Perpendicular si |a + b|^2 = |a|^2 + |b|^2
    public boolean perpendicular(double[] a, double[] b, boolean pitagoras) {
        double normaSumaCuadrado = Math.pow(norma(suma(a, b)), 2);
        double sumaCuadrados = Math.pow(norma(a), 2) + Math.pow(norma(b), 2);
        return Math.abs(normaSumaCuadrado - sumaCuadrados) < 0.0001;
    }

    // --- SOBRECARGA DE METODOS: PARALELA ---

    // Inciso f: Paralela si a x b = 0 (atributos)
    public boolean paralela() {
        return Math.abs(norma(productoCruz(this.a, this.b))) < 0.0001;
    }

    // Inciso f: Paralela si a x b = 0 (parametros)
    public boolean paralela(double[] a, double[] b) {
        return Math.abs(norma(productoCruz(a, b))) < 0.0001;
    }

    // Inciso e: Paralela si a = r * b
    public boolean paralela(double[] a, double[] b, double r) {
        double rb0 = r * b[0];
        double rb1 = r * b[1];
        double rb2 = r * b[2];
        return Math.abs(a[0] - rb0) < 0.0001 &&
               Math.abs(a[1] - rb1) < 0.0001 &&
               Math.abs(a[2] - rb2) < 0.0001;
    }

    // --- SOBRECARGA DE METODOS: PROYECCION ---

    // Inciso g: Proyección de a sobre b (atributos)
    public double[] proyeccion_de_a_sobre_b() {
        return proyeccion_de_a_sobre_b(this.a, this.b);
    }

    // Inciso g: Proyección de a sobre b (parámetros)
    public double[] proyeccion_de_a_sobre_b(double[] a, double[] b) {
        double punto = productoPunto(a, b);
        double normaBCuadrado = Math.pow(norma(b), 2);
        double escalar = punto / normaBCuadrado;

        return new double[]{escalar * b[0], escalar * b[1], escalar * b[2]};
    }

    // --- SOBRECARGA DE METODOS: COMPONENTE ---

    // Inciso h: Componente de a en b (atributos)
    public double componente_de_a_en_b() {
        return componente_de_a_en_b(this.a, this.b);
    }

    // Inciso h: Componente de a en b (parámetros)
    public double componente_de_a_en_b(double[] a, double[] b) {
        double punto = productoPunto(a, b);
        return punto / norma(b);
    }
}