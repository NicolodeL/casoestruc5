package org.example;

import AnalisisGenomico.CombinacionesGeneticas;
import AnalisisGenomico.ConteoGenes;
import GestionInformacion.BusquedaLineal;
import GestionInformacion.OrganizacionDocumentos;
import HerramientaAnalisisNumerico.PontenciasyMaximos;
import HerramientaAnalisisNumerico.SumatorioyListado;
import GestionInformacion.BusquedaLineal;

import java.io.IOException;


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

        // Crear una instancia de OrganizacionDocumentos
        OrganizacionDocumentos organizacionDocumentos = new OrganizacionDocumentos();

        // Definir la ruta del archivo de entrada y la ruta del archivo de salida
        String rutaArchivoEntrada = "src/main/java/archivostxt/ordename.txt";
        String rutaArchivoSalida = "src/main/java/archivostxt/ordename2.txt";

        // Ordenar el archivo
        try {
            organizacionDocumentos.ordenarArchivo(rutaArchivoEntrada, rutaArchivoSalida);
            System.out.println("Archivo ordenado exitosamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al ordenar el archivo: " + e.getMessage());
        }

        BusquedaLineal busquedaLineal = new BusquedaLineal();
        try {
            busquedaLineal.buscarPalabra("src/main/java/archivostxt/Buscame.txt", "loro");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al buscar la palabra: " + e.getMessage());
        }

}
}