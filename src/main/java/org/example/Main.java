package org.example;

import AnalisisGenomico.CombinacionesGeneticas;
import AnalisisGenomico.ConteoGenes;
import HerramientaAnalisisNumerico.PontenciasyMaximos;


public class Main {
    public static void main(String[] args) {
        String dna = "ATGCGTATGTTGATG"; // Puedes reemplazar esto con tu cadena de ADN
        int count = ConteoGenes.contarGenes(dna);
        System.out.println("Número de genes: " + count);

        System.out.println("Combinaciones de genes de 3 letras:");
        CombinacionesGeneticas.calcularCombinaciones(3, "Aaa");

        // Llamada al método calcularPotencia
        double base = 2.0;
        int exponente = 3;
        double potencia = PontenciasyMaximos.calcularPotencia(base, exponente);
        System.out.println("Potencia: " + potencia);

        // Llamada al método encontrarMaximo
        double[] datos = {1.2, 3.4, 0.8, 5.6, 4.3};
        double maximo = PontenciasyMaximos.encontrarMaximo(datos);
        System.out.println("Máximo: " + maximo);

    }
}