import java.util.Scanner;

class Estadistica{
    public int x;
    public double[] valores = new double[x];

    public Estadistica(int x){
        this.x = x;
        this.valores = this.ingresarValores();
    }
    public double[] ingresarValores(){
        Scanner lee = new Scanner(System.in);
        double[] valores = new double[x];
        for(int i=0; i<x; i++){
            System.out.println("Ingrese el valor " + (i+1) + ":");
            valores[i] = lee.nextDouble();
        }
        lee.close();
        return valores;
    }
    public double media(){
        double suma = 0;
        for(int j=0; j<x; j++){
            suma = suma +valores[j];
        }
        return suma / x;
    }
    public double desviacion(){
        double numerador = 0;      

        for(int k=0; k<x; k++){
            numerador = Math.pow((valores[k]- media()), 2) + numerador;  
        }
        return Math.sqrt(numerador / (x-1));
    }
    @Override
    public String toString(){
        String resultadoString = "";
        resultadoString += "El promedio es: " + media() + "\n";
        resultadoString += "La desviación estándar es: " + desviacion();
        return resultadoString;
    }

}
public class Lab4{
    public static void main(String[] args) {
        System.out.println("Ingrese la cantidad de valores a ingresar");
        Scanner lee = new Scanner(System.in);
        int x = lee.nextInt();
        Estadistica estadistica = new Estadistica(x);
        System.out.println(estadistica);
        lee.close();
    }
}