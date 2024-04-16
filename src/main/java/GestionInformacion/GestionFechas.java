package GestionInformacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class GestionFechas {
    private TreeSet<Date> fechas;
    private SimpleDateFormat formatoFecha;

    public GestionFechas() {
        fechas = new TreeSet<>();
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void agregarFecha(String fecha) {
        try {
            Date fechaConvertida = formatoFecha.parse(fecha);
            fechas.add(fechaConvertida);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. Usa dd/MM/yyyy");
        }
    }

    public List<String> listarFechas() {
        List<String> fechasListadas = new ArrayList<>();
        for (Date fecha : fechas) {
            fechasListadas.add(formatoFecha.format(fecha));
        }
        return fechasListadas;
    }

}
