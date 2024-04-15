package org.example;

import AnalisisGenomico.ConteoGenes;

public class Main {
    public static void main(String[] args) {
        String dna = "ATGCGTATGTTGATG"; // Puedes reemplazar esto con tu cadena de ADN
        int count = ConteoGenes.contarGenes(dna);
        System.out.println("Número de genes: " + count);
    }
}