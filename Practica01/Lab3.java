import java.util.Scanner;

class EcuacionSegundoGrado{

    private double a;
    private double b;
    private double c;

    public EcuacionSegundoGrado(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;

    }
    public double getDiscriminante (){
        return Math.pow( this.b, 2) - (4 * this.a *  this.c);
    }
    public double getRaiz1() {
        if (getDiscriminante() < 0) {
            return 0;
        }
        return (-this.b + Math.sqrt(getDiscriminante()))/ (2 * this.a);
    }
    public double getRaiz2() {
    if (getDiscriminante() < 0) {
        return 0;
    }
    return (-this.b - Math.sqrt(getDiscriminante()))/ (2 * this.a);
    }
    @Override
    public String toString(){
        String resultadoString;
    if (getDiscriminante() < 0 ){
            resultadoString = "La ecuacion no tiene raices reales";
            }
            else{
                if (getDiscriminante() == 0 ){
                    resultadoString = "Solo tiene una raiz: " + getRaiz1();
                }
                else{
                    resultadoString = "Sus raices son: Raíz 1: " + getRaiz1() + ", Raíz 2: " + getRaiz2();
                }
            };
    return  resultadoString;
        }
    }
public class Lab3{
    public static void main(String[] args) {
  
        Scanner lee = new Scanner(System.in);
        System.out.println("Resolver una ecuacion de segundo Grado");
        System.out.println( "Ingrese las variables a,b,c");
        double a = lee.nextDouble();
        double b = lee.nextDouble();
        double c = lee.nextDouble();
        EcuacionSegundoGrado ec1 = new EcuacionSegundoGrado(a,b,c);
        System.out.println(ec1);
        lee.close();
    }
}

// en python un metodo se declara como privado ponieno doble guion bajo en la clase __