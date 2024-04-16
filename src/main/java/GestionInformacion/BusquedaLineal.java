package GestionInformacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BusquedaLineal {

    public void buscarPalabra(String rutaArchivo, String palabraBusqueda) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        int numLinea = 0;
        palabraBusqueda = palabraBusqueda.toLowerCase();

        while ((linea = reader.readLine()) != null) {
            numLinea++;
            String[] palabras = linea.split("\\s+");
            for (int i = 0; i < palabras.length; i++) {
                if (palabras[i].toLowerCase().equals(palabraBusqueda)) {
                    System.out.println("Palabra '" + palabraBusqueda + "' encontrada en la línea " + numLinea + ", palabra " + (i+1));
                }
            }
        }
        reader.close();
    }
}
