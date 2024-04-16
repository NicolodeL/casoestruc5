package HerramientaAnalisisNumerico;

public class PontenciasyMaximos {

    // Método para calcular potencias mediante multiplicaciones sucesivas
    public static double calcularPotencia(double base, int exponente) {
        double resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }
        return resultado;
    }

    // Método para encontrar el valor máximo en un conjunto de datos numéricos
    public static double encontrarMaximo(double[] datos) {
        double maximo = datos[0];
        for (int i = 1; i < datos.length; i++) {
            if (datos[i] > maximo) {
                maximo = datos[i];
            }
        }
        return maximo;
    }
}
