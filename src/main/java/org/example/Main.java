package org.example;

import AnalisisGenomico.CombinacionesGeneticas;
import AnalisisGenomico.ConteoGenes;

import java.util.Scanner;

import static HerramientaAnalisisNumerico.SumatorioyListado.Fibonacci.*;

public class Main {
    public static void main(String[] args) {
        String dna = "ATGCGTATGTTGATG"; // Puedes reemplazar esto con tu cadena de ADN
        int count = ConteoGenes.contarGenes(dna);
        System.out.println("Número de genes: " + count);

        System.out.println("Combinaciones de genes de 3 letras:");
        CombinacionesGeneticas.calcularCombinaciones(3, "Aaa");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] result = matrixMultiplication(fib(n), baseFibNumbers);
        System.out.println("Fib(" + n + ") = " + result[1][0]);
        sc.close();
    }
}