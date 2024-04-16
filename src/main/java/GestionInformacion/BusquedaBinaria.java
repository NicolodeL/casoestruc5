package GestionInformacion;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BusquedaBinaria {

    public boolean buscarPalabra(String rutaArchivo, String palabraBusqueda) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        int numLinea = 0;
        palabraBusqueda = palabraBusqueda.toLowerCase();

        while ((linea = reader.readLine()) != null) {
            numLinea++;
            String[] palabras = linea.split("\\s+");
            Arrays.sort(palabras);
            int resultado = Arrays.binarySearch(palabras, palabraBusqueda);
            if (resultado >= 0) {
                System.out.println("Palabra '" + palabraBusqueda + "' encontrada en la línea " + numLinea + ", palabra " + (resultado+1));
            }
        }
        reader.close();
        return false;
    }
}
