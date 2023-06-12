package Backend;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * Clase encargada de conservar variables globales y procesos muy comunes en el
 * proyecto
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class Global {

    /**
     * * Constante global
     */
    public static String USER_FILE = "usuarios.dat";
    /**
     * * Constante global
     */
    public static String CONFIG_FILE = "config.dat";
    /**
     * * Constante global
     */
    public static String RESTAURANT_FILE = "restaurante.dat";
    /**
     * * Constante global
     */
    public static String FOOD_FILE = ".comidasRegistro.dat";
    /**
     * * Constante global
     */
    public static String VENTA_FILE = "ventas.dat";
    /**
     * * Constante global
     */
    public static String EMPTY = "";
    /**
     * * Constante global
     */
    public static String SI = "Sí";
    /**
     * * Constante global
     */
    public static String NO = "No";
    /**
     * * Constante global
     */
    public static Color GRIS = new Color(209, 211, 211);
    /**
     * * Constante global
     */
    public static Color ROSA = new Color(246, 238, 249);
    /**
     * * Constante global de dígitos del codigo postal
     */
    public static int CP = 2;                           // Puesto a dos por comodidad

    /**
     * Procedimento común inicial que determina centrado,dimensiones
     * especificas, borde de la ventana... etc Hace uso de metodos de JFrame y
     * de BorderFactory.
     *
     * @param frame El propio Jframe al que se le aplica.
     * @param width Ancho de la ventana.
     * @param height Alto de la ventana.
     */
    public static void frameSetUp(JFrame frame, int width, int height) {
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black));   // Annadir borde 
        frame.setSize(width, height);
        frame.pack(); // Ajusta el tamaño de la ventana
        frame.setLocationRelativeTo(null); // Centra la ventana
        frame.setResizable(true); // Bloquea la capacidad de cambiar el tamaño
    }

    /**
     * Procedimiento común de iniciar una ventana y saltar a otra. Hace uso
     * demetodos de JFrame.
     *
     * Relacionado con: Frontend.Login
     *
     * @param destino Ventana que se inicia (Se declara com new
     * NommbrDelFrame()).
     *
     * @param origen Ventana que se cierra.
     */
    public static void frameJump(JFrame destino, JFrame origen) {
        destino.setVisible(true);
        origen.dispose();
    }

    /**
     * Procedimiento común de iniciar una ventana. Hace uso demetodos de JFrame.
     *
     * Relacionado con: Frontend.Login
     *
     * @param destino
     */
    public static void frameJumpW(JFrame destino) {
        destino.setVisible(true);
    }

    /**
     * Encargada de limpiar de dejar una caja de texto vacía y con fuente a
     * negro (En el GUI significa que lo que has escrito pasa de ser un
     * placeholder a los datos de usuario). Hace uso de metodos de JTextField.
     *
     *
     * @param ventana Textfield al que se le aplica.
     */
    //Solo para casos en los que placeholder value == value introducido por usuario --> añadimos capa extra (evita que placeholder se tome como entrada de usuario)
    public static void cleanWrite(JTextField ventana) {
        Color cf = ventana.getForeground();
        if (!cf.equals(Color.BLACK)) {
            ventana.setText(Global.EMPTY);
            ventana.setForeground(Color.BLACK);
        }
    }

    /**
     * Sobrecarga de metodo de {@link #cleanWrite(javax.swing.JTextField)}
     * Hace uso de metodos de JComboBox.
     *
     */
    public static void cleanWrite(JComboBox ventana) {
        Color cf = ventana.getForeground();
        if (!cf.equals(Color.BLACK)) {
            ventana.setForeground(Color.BLACK);
        }
    }

    /**
     * Antagonista de {@link #cleanWrite(javax.swing.JTextField)}, se
     * utiliza para reponer el placeholder de la caja de texto si esta no ha
     * sido rellenada con nada. Hace uso de metodos de JTextField. Relacionado
     * con: Frontend.Login
     *
     * @param ventana Textfield al que se le aplica.
     * @param text Placeholder.
     */
    public static void deCleanWrite(JTextField ventana, String text) {
        Color cf = ventana.getForeground();
        if (ventana.getText().isEmpty() && !cf.equals(Global.GRIS)) {
            ventana.setText(text);
            ventana.setForeground(Global.GRIS);
        }
    }

    /**
     * Sobrecarga de metodo de
     * {@link #deCleanWrite(javax.swing.JTextField, java.lang.String)}
     * Hace uso de metodos de JPasswordField.
     *
     */
    public static void deCleanWrite(JPasswordField ventana, String text) {
        Color cf = ventana.getForeground();
        String pass = new String(ventana.getPassword());
        if (pass.isEmpty() && !cf.equals(Global.GRIS)) {
            ventana.setText(text);
            ventana.setForeground(Global.GRIS);
        }
    }

    /**
     * Sobrecarga de metodo de
     * {@link Global#deCleanWrite(javax.swing.JTextField, java.lang.String)}
     * Pone como selección por defecto el elemento[0] Hace uso de metodos de
     * JComboBox.
     *
     */
    public static void deCleanWrite(JComboBox ventana, String text) {
        Color grisSinEditar = new Color(209, 211, 211);
        Color cf = ventana.getForeground();
        if ((ventana.getSelectedIndex() == 0) && !cf.equals(grisSinEditar)) {
            ventana.setSelectedIndex(0);
            ventana.setForeground(grisSinEditar);
        }
    }

    /**
     * Función para facilitar legibilidad de crear un panel de dialogo.
     * Relacionado con: Frontend.Login
     *
     * @param frase La pregunta.
     * @param titulo Titulo de la ventana.
     * @param si Frase para seleccionar si.
     * @param no Frase para seleccionar no.
     * @return Devuelve el entero para hacer el switch con el código que se
     * necesite.
     */
    public static int panelDecisionSN(String frase, String titulo, String si, String no) {
        return JOptionPane.showOptionDialog(null, frase, titulo, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{si, no}, "Sí");
    }

    /**
     * Función para facilitar legibilidad de crear un panel de aviso.
     * Relacionado con: Frontend.Login
     *
     * @param frase Texto que deseas plasmar en la ventana.
     */
    public static void panelAviso(String frase) {
        JOptionPane.showMessageDialog(null, frase, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Se le introduce un dni y devuelve si es valido (bool) conforme a los
     * criterios de la letra y extensión. Relacionado con:
     * Frontend.MiniRegistro
     *
     * @param dni El propio dni en string numero+letra
     * @return Booleano de si es válido o no.
     */
    public static boolean dniValido(String dni) {
        dni = dni.trim().toUpperCase();
        if (dni.length() != 9) {
            return false;
        }

        String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
        char letra = dni.charAt(8);

        String numeros = dni.substring(0, 8);

        if (!numeros.matches("[0-9]+")) {
            return false;
        }

        int indice = Integer.parseInt(numeros) % 23;

        return letra == LETRAS.charAt(indice);
    }

    /**
     * Se le introduce un cif y devuelve si es valido (bool) conforme a los
     * criterios de la letra y extensión. Relacionado con:
     * Frontend.MiniRegistro
     *
     * @param cif El propio cif.
     * @return Booleano de si es válido o no.
     */
    public static boolean cifValido(String cif) {
        // Verificar que la longitud del CIF sea de 9 caracteres
        // Utilizo los returns y no un booleano para asi hacer que termine el proceso cuanto antes
        if (cif.length() != 9) {
            return false;
        }

        // Obtener el primer carácter del CIF
        char primerCaracter = cif.charAt(0);

        // Verificar que el primer carácter sea una letra
        if (!Character.isLetter(primerCaracter)) {
            return false;
        }

        // Verificar que los siguientes 7 caracteres sean dígitos
        for (int i = 1; i <= 7; i++) {
            char caracter = cif.charAt(i);
            if (!Character.isDigit(caracter)) {
                return false;
            }
        }

        // Verificar que el último carácter sea una letra o un dígito
        char ultimoCaracter = cif.charAt(8);
        if (!Character.isLetterOrDigit(ultimoCaracter)) {
            return false;
        }

        return true;
    }

    /**
     * Procedimiento comú inicial de acordar longitud de las columnas, esencial
     * para lectura de la tabla y forzar aparición del autoscroll horizontal.
     * 
     *
     * @param tamano Longitud de la columna.
     * @param tabla Tabla a aplicar.
     */
    public static void setTabla(int tamano, JTable tabla) {
        // Prefija en todas las columnas un tamano minimo, esencial para que se lea bien y autoscroll horizontal
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int columnCount = model.getColumnCount();
        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
            TableColumn column = tabla.getColumnModel().getColumn(columnIndex);
            column.setMinWidth(tamano);
        }
    }

    /**
     * Sobrecarga de método de {@link #setTabla(int, javax.swing.JTable)} con
     * annadido de alto de la celda.
     *
     * @param ancho
     * @param alto
     * @param tabla
     */
    public static void setTabla(int ancho, int alto, JTable tabla) {
        // Prefija en todas las columnas un tamano minimo, esencial para que se lea bien y autoscroll horizontal
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int columnCount = model.getColumnCount();
        for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
            TableColumn column = tabla.getColumnModel().getColumn(columnIndex);
            column.setMinWidth(ancho);
            tabla.setRowHeight(alto);
        }
    }

    /**
     * Encargado de borrar un archivo de inicio de sesión .dat. Realmente no lo
     * borra al no ser posible porque Windows lo protege al estar en uso por el
     * propio programa en lectura. Se pone un objeto vacio, longitud minima (7
     * bytes), si es mayor a 7 tiene contenido, si no nada.
     *
     * @see Frontend.loginInicial#init()
     * @param filename Archivo a borrar.
     * @throws IOException Si archivo vacio/inexistente
     */
    public static void borrarConfig(String filename) throws IOException {
        File fl = new File(filename);
        if (fl.exists()) {                                      // Eliminar config de inicio automatico
            try {
                FileOutputStream fos = new FileOutputStream(Global.CONFIG_FILE);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(Global.EMPTY);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!fl.exists()) {
                System.out.println("Config: Archivo borrado correctamente");
            }

        }
    }
}
