package InterfazVisual;

import AnalisisGenomico.CombinacionesGeneticas;
import AnalisisGenomico.ConteoGenes;
import GestionInformacion.BusquedaBinaria;
import GestionInformacion.BusquedaLineal;
import GestionInformacion.GestionFechas;
import GestionInformacion.OrganizacionDocumentos;
import HerramientaAnalisisNumerico.PontenciasyMaximos;
import HerramientaAnalisisNumerico.SumatorioyListado;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Interfaz {
    private JFrame frame;
    private JTextField dnaTextField;
    private JTextArea resultTextArea;
    private JTextField numTextField;
    private JTextArea numResultTextArea;
    private JTextField fileInputTextField;
    private JTextField fileOutputTextField;
    private JTextArea fileResultTextArea;
    private JTextField combTextField;
    private JTextArea combResultTextArea;
    private JTextField baseTextField;
    private JTextField exponentTextField;
    private JTextArea powerResultTextArea;
    private JTextField binarySearchTextField;
    private JTextArea binarySearchResultTextArea;
    private JTextField linearSearchTextField;
    private JTextArea linearSearchResultTextArea;
    private JTextField fechaTextField;
    private JTextArea fechaResultTextArea;
    private GestionFechas gestionFechas;

    public Interfaz() {
        frame = new JFrame("Analizador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel de análisis genómico
        JPanel genomicAnalysisPanel = createGenomicAnalysisPanel();
        tabbedPane.addTab("Análisis Genómico", genomicAnalysisPanel);

        // Panel de análisis numérico
        JPanel numericAnalysisPanel = createNumericAnalysisPanel();
        tabbedPane.addTab("Análisis Numérico", numericAnalysisPanel);

        // Panel de gestión de información
        JPanel infoManagementPanel = createInfoManagementPanel();
        tabbedPane.addTab("Gestión de Información", infoManagementPanel);

        // Panel de combinaciones genéticas
        JPanel geneticCombinationsPanel = createGeneticCombinationsPanel();
        tabbedPane.addTab("Combinaciones Genéticas", geneticCombinationsPanel);

        // Panel de potencias y máximos
        JPanel powerAndMaxPanel = createPowerAndMaxPanel();
        tabbedPane.addTab("Potencias y Máximos", powerAndMaxPanel);

        // Panel de búsqueda binaria
        JPanel binarySearchPanel = createBinarySearchPanel();
        tabbedPane.addTab("Búsqueda Binaria", binarySearchPanel);

        // Panel de búsqueda lineal
        JPanel linearSearchPanel = createLinearSearchPanel();
        tabbedPane.addTab("Búsqueda Lineal", linearSearchPanel);

        frame.add(tabbedPane);
        frame.setVisible(true);

        // Panel de gestión de fechas
        JPanel fechaPanel = createFechaPanel();
        tabbedPane.addTab("Gestión de Fechas", fechaPanel);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private JPanel createGenomicAnalysisPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        dnaTextField = new JTextField();
        JButton analyzeButton = new JButton("Analizar ADN");
        resultTextArea = new JTextArea();

        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzeDNA();
            }
        });

        panel.add(new JLabel("Introduce la cadena de ADN:"));
        panel.add(dnaTextField);
        panel.add(analyzeButton);
        panel.add(new JLabel("Resultado:"));
        panel.add(resultTextArea);

        return panel;
    }

    private JPanel createNumericAnalysisPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        numTextField = new JTextField();
        JButton calculateButton = new JButton("Calcular Suma");
        numResultTextArea = new JTextArea();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSum();
            }
        });

        panel.add(new JLabel("Introduce un número:"));
        panel.add(numTextField);
        panel.add(calculateButton);
        panel.add(new JLabel("Resultado:"));
        panel.add(numResultTextArea);

        return panel;
    }

    private JPanel createInfoManagementPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        fileInputTextField = new JTextField();
        fileOutputTextField = new JTextField();
        JButton sortButton = new JButton("Ordenar Archivo");
        fileResultTextArea = new JTextArea();

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortFile();
            }
        });

        panel.add(new JLabel("Ruta del archivo de entrada:"));
        panel.add(fileInputTextField);
        panel.add(new JLabel("Ruta del archivo de salida:"));
        panel.add(fileOutputTextField);
        panel.add(sortButton);
        panel.add(new JLabel("Resultado:"));
        panel.add(fileResultTextArea);

        return panel;
    }

    private JPanel createGeneticCombinationsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        combTextField = new JTextField();
        JButton calculateButton = new JButton("Calcular Combinaciones");
        combResultTextArea = new JTextArea();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateCombinations();
            }
        });

        panel.add(new JLabel("Introduce un número:"));
        panel.add(combTextField);
        panel.add(calculateButton);
        panel.add(new JLabel("Resultado:"));
        panel.add(combResultTextArea);

        return panel;
    }

    private JPanel createPowerAndMaxPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        baseTextField = new JTextField();
        exponentTextField = new JTextField();
        JButton calculateButton = new JButton("Calcular Potencia");
        powerResultTextArea = new JTextArea();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatePower();
            }
        });

        panel.add(new JLabel("Introduce la base:"));
        panel.add(baseTextField);
        panel.add(new JLabel("Introduce el exponente:"));
        panel.add(exponentTextField);
        panel.add(calculateButton);
        panel.add(new JLabel("Resultado:"));
        panel.add(powerResultTextArea);

        return panel;
    }

    private JPanel createBinarySearchPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        binarySearchTextField = new JTextField();
        JButton searchButton = new JButton("Buscar Palabra");
        binarySearchResultTextArea = new JTextArea();

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                binarySearch();
            }
        });

        panel.add(new JLabel("Introduce la palabra a buscar:"));
        panel.add(binarySearchTextField);
        panel.add(searchButton);
        panel.add(new JLabel("Resultado:"));
        panel.add(binarySearchResultTextArea);

        return panel;
    }

    private JPanel createLinearSearchPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        linearSearchTextField = new JTextField();
        JButton searchButton = new JButton("Buscar Palabra");
        linearSearchResultTextArea = new JTextArea();

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                linearSearch();
            }
        });

        panel.add(new JLabel("Introduce la palabra a buscar:"));
        panel.add(linearSearchTextField);
        panel.add(searchButton);
        panel.add(new JLabel("Resultado:"));
        panel.add(linearSearchResultTextArea);

        return panel;
    }

    private JPanel createFechaPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        fechaTextField = new JTextField();
        JButton addButton = new JButton("Agregar Fecha");
        fechaResultTextArea = new JTextArea();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarFecha();
            }
        });

        JButton listButton = new JButton("Listar Fechas");
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarFechas();
            }
        });

        panel.add(new JLabel("Introduce la fecha (dd/MM/yyyy):"));
        panel.add(fechaTextField);
        panel.add(addButton);
        panel.add(listButton);
        panel.add(new JLabel("Fechas:"));
        panel.add(fechaResultTextArea);

        return panel;
    }

    private void analyzeDNA() {
        String dna = dnaTextField.getText();
        int count = ConteoGenes.contarGenes(dna);
        resultTextArea.setText("Número de genes: " + count);
    }

    private void calculateSum() {
        int num = Integer.parseInt(numTextField.getText());
        int sum = SumatorioyListado.calcularSuma(num);
        numResultTextArea.setText("La suma de los primeros " + num + " números naturales es: " + sum);
    }

    private void sortFile() {
        String inputFile = fileInputTextField.getText();
        String outputFile = fileOutputTextField.getText();
        OrganizacionDocumentos organizacionDocumentos = new OrganizacionDocumentos();
        try {
            organizacionDocumentos.ordenarArchivo(inputFile, outputFile);
            fileResultTextArea.setText("Archivo ordenado exitosamente.");
        } catch (IOException e) {
            fileResultTextArea.setText("Ocurrió un error al ordenar el archivo: " + e.getMessage());
        }
    }

    private void calculateCombinations() {
        int num = Integer.parseInt(combTextField.getText());
        CombinacionesGeneticas.calcularCombinaciones(num, "");
        combResultTextArea.setText("Combinaciones calculadas. Consulta la consola para ver los resultados.");
    }

    private void calculatePower() {
        double base = Double.parseDouble(baseTextField.getText());
        int exponent = Integer.parseInt(exponentTextField.getText());
        double power = PontenciasyMaximos.calcularPotencia(base, exponent);
        powerResultTextArea.setText("La potencia es: " + power);
    }

    private void binarySearch() {
        String word = binarySearchTextField.getText();
        BusquedaBinaria busquedaBinaria = new BusquedaBinaria();
        try {
            boolean found = busquedaBinaria.buscarPalabra("src/main/java/archivostxt/ordename2.txt", word);
            binarySearchResultTextArea.setText(found ? "Palabra encontrada." : "Palabra no encontrada.");
        } catch (IOException e) {
            binarySearchResultTextArea.setText("Ocurrió un error al buscar la palabra: " + e.getMessage());
        }
    }

    private void linearSearch() {
        String word = linearSearchTextField.getText();
        BusquedaLineal busquedaLineal = new BusquedaLineal();
        try {
            boolean found = busquedaLineal.buscarPalabra("src/main/java/archivostxt/Buscame.txt", word);
            linearSearchResultTextArea.setText(found ? "Palabra encontrada." : "Palabra no encontrada.");
        } catch (IOException e) {
            linearSearchResultTextArea.setText("Ocurrió un error al buscar la palabra: " + e.getMessage());
        }
    }

    private void agregarFecha() {
        String fecha = fechaTextField.getText();
        gestionFechas.agregarFecha(fecha);
        fechaTextField.setText("");
    }

    private void listarFechas() {
        fechaResultTextArea.setText("");
        for (String fecha : gestionFechas.listarFechas()) {
            fechaResultTextArea.append(fecha + "\n");
        }
    }

    public static void main(String[] args) {
        new Interfaz();
    }


}