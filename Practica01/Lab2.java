import java.util.Scanner;

class Ecuacion {

    private double a;
    private double b;
    private double c;
    private double d;
    private double f;
    private double e;

    private double difp;
    private double difx;
    private double dify;

    public Ecuacion(double a, double b, double c, double d, double e, double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.difp = this.diferencia(this.a, this.b, this.c, this.d);
        this.difx = this.diferenciax(this.b, this.d, this.e, this.f);
        this.dify = this.diferenciay(this.a, this.c, this.e, this.f);

    }
    private double diferencia( double a, double b, double c, double d){
        double diferencia = (a*d)-(b*c);
        return diferencia;
    }
    private double diferenciax( double b, double d, double e, double f){
        double diferenciax = (e*d) - (b*f);
        return diferenciax;
    }
    private double diferenciay( double a, double c, double e, double f){
        double diferenciay = (a*f) - (e*c);
        return diferenciay;
    }
    public boolean tieneSolucion(){
        return difp != 0;
    }
    public double  getX(){
        return this.difx/this.difp;
    
    }
    public double  getY(){
        return this.dify/this.difp;

    }  
}
public class Lab2{
    public static void main(String[] args) {
  
        Scanner lee = new Scanner(System.in);
        System.out.println("Ingresese a,b,c,d,e,f:");
        double a = lee.nextDouble();
        double b = lee.nextDouble();
        double c = lee.nextDouble();
        double d = lee.nextDouble();
        double e = lee.nextDouble();
        double f = lee.nextDouble();
        Ecuacion ecuacion = new Ecuacion(a, b, c, d, e, f);
        
        if (ecuacion.tieneSolucion()){
            System.out.println("x=" + ecuacion.getX());
            System.out.println("y=" + ecuacion.getY());
        }
        else {
            System.out.println("No tiene solucion");
        }
        lee.close();
    }
}
