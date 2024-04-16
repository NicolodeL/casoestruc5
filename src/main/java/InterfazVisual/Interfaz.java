package InterfazVisual;

import AnalisisGenomico.ConteoGenes;
import HerramientaAnalisisNumerico.PontenciasyMaximos;
import HerramientaAnalisisNumerico.SumatorioyListado;
import GestionInformacion.OrganizacionDocumentos;

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

    public static void main(String[] args) {
        new Interfaz();
    }
}