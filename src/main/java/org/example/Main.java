package org.example;

import AnalisisGenomico.CombinacionesGeneticas;
import AnalisisGenomico.ConteoGenes;
import HerramientaAnalisisNumerico.PontenciasyMaximos;
import HerramientaAnalisisNumerico.SumatorioyListado;
import GestionInformacion.OrganizacionDocumentos;

public class Main {
    public static void main(String[] args) {
        String dna = "ATGCGTATGTTGATG"; // Puedes reemplazar esto con tu cadena de ADN
        int count = ConteoGenes.contarGenes(dna);
        System.out.println("Número de genes: " + count);

        System.out.println("Combinaciones de genes de 3 letras:");
        CombinacionesGeneticas.calcularCombinaciones(3, "Aaa");

        int suma = SumatorioyListado.calcularSuma(10);
        System.out.println("La suma de los primeros 10 números naturales es: " + suma);

        // Listar los números del 1 al 10
        System.out.println("Los números del 1 al 10 son:");
        SumatorioyListado.listarNumeros(1, 10);

        // Llamada al método calcularPotencia
        double base = 2.0;
        int exponente = 3;
        double potencia = PontenciasyMaximos.calcularPotencia(base, exponente);
        System.out.println("Potencia: " + potencia);

        // Llamada al método encontrarMaximo
        double[] datos = {1.2, 3.4, 0.8, 5.6, 4.3};
        double maximo = PontenciasyMaximos.encontrarMaximo(datos);
        System.out.println("Máximo: " + maximo);
        OrganizacionDocumentos<String> organizacionDocumentos = new OrganizacionDocumentos<>();

        // Crear un array de Strings para ordenar
        String[] array = {"z", "b", "a", "c"};

        // Ordenar el array
        organizacionDocumentos.sort(array);

        // Imprimir el array ordenado
        for (String s : array) {
            System.out.println(s);
        }
    }


    }
