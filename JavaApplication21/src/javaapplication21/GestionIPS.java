import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestionIPS extends JFrame {

    private static final String ARCHIVO = "Archivo.csv";

    private JTextArea areaTexto;

    public GestionIPS() {
        super("Gestión IPS");

        // Crear cuadro de texto y agregarlo a un panel con scroll
        areaTexto = new JTextArea(50, 40);
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        // Crear botón para cargar el archivo CSV
        JButton cargarBoton = new JButton("Cargar El archivo CSV");
        cargarBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarArchivo();
            }
        });

        // Crear botón para generar gráficas
        JButton generarBoton = new JButton("Generar gráficas");
        generarBoton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarGraficas();
            }
        });

        // Agregar el botón y el cuadro de texto al panel principal
        JPanel panel = new JPanel();
        panel.add(cargarBoton);
        panel.add(generarBoton);
        panel.add(scrollPane);
        add(panel, BorderLayout.CENTER);

        // Crear barra de menú y agregar los elementos
        JMenuBar barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);

        JMenu menuFiltros = new JMenu("Filtros");
        barraMenu.add(menuFiltros);

        JMenuItem cargarFiltros = new JMenuItem("Cargar filtros");
        menuFiltros.add(cargarFiltros);

        JMenu menuExportar = new JMenu("Exportar");
        barraMenu.add(menuExportar);

        JMenuItem exportarCSV = new JMenuItem("Exportar a CSV");
        menuExportar.add(exportarCSV);

        // Agregar los oyentes de eventos para los elementos del menú
        cargarFiltros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarFiltros();
            }
        });

        exportarCSV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exportarCSV();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cargarArchivo() {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(ARCHIVO));
            String linea;
            areaTexto.setText("");

            // Leer línea por línea del archivo de texto
            while ((linea = lector.readLine()) != null) {
                areaTexto.append(linea + "\n");
            }

            // Cerrar el lector
            lector.close();
        } catch (IOException e) {
            areaTexto.setText("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void cargarFiltros() {
        // TODO: implementar lógica para cargar filtros dinámicamente
    }

    private void generarGraficas() {
        // TODO: implementar lógica para generar gráficas
    }

    private void exportarCSV() {
        try {
            FileWriter escritor = new FileWriter("informacion_exportada.csv");
            escritor.write(areaTexto.getText());
            escritor.close();
        } catch (IOException e) {
            areaTexto.setText("Error al exportar a CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestionIPS());
    }

    private static String leerArchivo(String archivo) throws IOException {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                builder.append(linea);
                builder.append('\n');
            }
        }

        return builder.toString();
    }
}