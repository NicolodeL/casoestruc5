package InterfazVisual;

import AnalisisGenomico.ConteoGenes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz {
    private JFrame frame;
    private JTextField dnaTextField;
    private JTextArea resultTextArea;

    public Interfaz() {
        frame = new JFrame("Analizador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel de análisis genómico
        JPanel genomicAnalysisPanel = new JPanel();
        genomicAnalysisPanel.setLayout(new BoxLayout(genomicAnalysisPanel, BoxLayout.Y_AXIS));

        dnaTextField = new JTextField();
        JButton analyzeButton = new JButton("Analizar ADN");
        resultTextArea = new JTextArea();

        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analyzeDNA();
            }
        });

        genomicAnalysisPanel.add(new JLabel("Introduce la cadena de ADN:"));
        genomicAnalysisPanel.add(dnaTextField);
        genomicAnalysisPanel.add(analyzeButton);
        genomicAnalysisPanel.add(new JLabel("Resultado:"));
        genomicAnalysisPanel.add(resultTextArea);

        tabbedPane.addTab("Análisis Genómico", genomicAnalysisPanel);

        // Aquí puedes agregar más pestañas para las otras funcionalidades

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private void analyzeDNA() {
        String dna = dnaTextField.getText();
        int count = ConteoGenes.contarGenes(dna);
        resultTextArea.setText("Número de genes: " + count);
    }

    public static void main(String[] args) {
        new Interfaz();
    }
}