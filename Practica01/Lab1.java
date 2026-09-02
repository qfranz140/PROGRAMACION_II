import java.util.Random;

class Cronometro {
    private long inicia;
    private long finaliza;

    public Cronometro() {
        inicia = System.currentTimeMillis();
    }

    public void inicia() {
        inicia = System.currentTimeMillis();
    }

    public void detener() {
        finaliza = System.currentTimeMillis();
    }

    public long lapsoDeTiempo() {
        return finaliza - inicia;
    }

    public long getInicia() { return inicia; }
    public long getFinaliza() { return finaliza; }
}

class Ordenador { 
    private double[] lista = new double[100000];
    

    public Ordenador() { 
        this.lista = this.llenarAleatorio();
    }

    private double[] llenarAleatorio() {
        Random generador = new Random();
        for (int i = 0; i < lista.length; i++) {
            lista[i] = generador.nextDouble() * 100000;
        }
        return lista;
    }

    public void ordenacionPorSeleccion() {
        for (int i = 0; i < lista.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[j] < lista[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            double temp = lista[i];
            lista[i] = lista[indiceMenor];
            lista[indiceMenor] = temp;
        }
    }

    public double[] getLista() { 
        return lista; }
}

public class Lab1 { 
    
    public static void main(String[] args) {


        Ordenador ordenador = new Ordenador();

        Cronometro cronometro = new Cronometro();
        cronometro.inicia();
        ordenador.ordenacionPorSeleccion();
        cronometro.detener();

        System.out.println("Numeros ordenados: " + ordenador.getLista().length);
        System.out.println("Tiempo: " + cronometro.lapsoDeTiempo() + " ms");
    }
}