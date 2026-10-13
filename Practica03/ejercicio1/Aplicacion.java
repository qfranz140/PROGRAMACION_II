package ejercicio1;

public class Aplicacion {
    public static void main(String[] args) {
        String n = "flipper";
        CriaturaMarina elementos[] = { new Calamar(n), new Delfin(n), new Mamifero(n), new CriaturaMarina(n), new Ballena(n)};
        for (int i = 0; i < elementos.length; i++) {
            System.out.println(elementos[i]);
            elementos[i].metodo1();
            elementos[i].metodo2();
            System.out.println();
        }
    }
}