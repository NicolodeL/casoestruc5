package HerramientaAnalisisNumerico;

public class SumatorioyListado {

    // Método recursivo para calcular la suma de números naturales
    public static int calcularSuma(int n) {
        if (n <= 0) {
            return 0;
        } else {
            return n + calcularSuma(n - 1);
        }
    }

    // Método recursivo para listar los números en un rango dado
    public static void listarNumeros(int inicio, int fin) {
        if (inicio > fin) {
            return;
        } else {
            System.out.println(inicio);
            listarNumeros(inicio + 1, fin);
        }
    }
}
