
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestionIPS extends JFrame {
    public GestionIPS() {
        super("Gestión IPS");

        JTextArea textArea = new JTextArea(20, 40);
        add(textArea);

        String archivo = "indice_de_informacion_clasificada_y_reservada_2021.csv";

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;

            // Leer línea por línea del archivo de texto
            int n = 100;
            while ((linea = lector.readLine()) != null && --n>0) {
                textArea.append(linea + "\n");
            }

            // Cerrar el lector
            lector.close();
        } catch (IOException e) {
            textArea.setText("Error al leer el archivo: " + e.getMessage());
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GestionIPS();
    }
} 