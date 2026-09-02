import java.util.Scanner;
public class Lab4Modular{
    public static double[] ingresarValores(int x){
        Scanner lee = new Scanner(System.in);
        double[] valores = new double[x];
        for(int i=0; i<x; i++){
            System.out.println("Ingrese el valor " + (i+1) + ":");
            valores[i] = lee.nextDouble();
        }
        lee.close();
        return valores;
        
    }
    public static double media(double[] valores, int x){
        double suma = 0;
        for(int j=0; j<x; j++){
            suma = suma + valores[j];
        }
        return suma / x;
    }
    public static double desviacion(double[] valores, int x){
        double numerador = 0;
        double media = media(valores, x);

        for(int k=0; k<x; k++){
            numerador = Math.pow((valores[k] - media), 2) + numerador;
        }
        return Math.sqrt(numerador / (x-1));
    }
    public static void main(String[] args) {
        System.out.println("Ingrese la cantidad de valores a ingresar");
        Scanner lee = new Scanner(System.in);
        int x = lee.nextInt();
        double[] valores = ingresarValores(x);
        System.out.println("El promedio es: " + media(valores, x));
        System.out.println("La desviación estándar es: " + desviacion(valores, x));
        lee.close();
    }
}