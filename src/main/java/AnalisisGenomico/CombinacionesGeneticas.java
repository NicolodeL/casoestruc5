package AnalisisGenomico;

public class CombinacionesGeneticas {
    public static void calcularCombinaciones(int n, String combinacion) {
        if (n == 0) {
            System.out.println(combinacion);
            return;
        }

        calcularCombinaciones(n - 1, combinacion + 'A');
        calcularCombinaciones(n - 1, combinacion + 'a');
    }
}
