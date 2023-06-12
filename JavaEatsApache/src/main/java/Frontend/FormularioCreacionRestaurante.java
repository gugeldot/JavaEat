package Frontend;

import Backend.Serializacion;
import Backend.Global;
import Backend.Direccion;
import Backend.Catering;
import Backend.Comida;
import Backend.Opinion;
import Backend.Restaurante;
import java.awt.*;
import static Frontend.MiniRegistroRestaurante.deCleanWriteMOD;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Ventana Jframe encargada de registro de restaurante
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class FormularioCreacionRestaurante extends javax.swing.JFrame {

    int RatonX, RatonY;

    ArrayList<Comida> comidasPotenciales = new ArrayList<Comida>();
    MiniRegistroRestaurante mrr = new MiniRegistroRestaurante();

    public FormularioCreacionRestaurante() throws IOException {
        initComponents();

        Global.frameSetUp(this, 998, 630);
        Global.setTabla(200, tablaComida);

        esconderCatering();
        Serializacion.crearFicheroComidas(Global.FOOD_FILE);
        Serializacion.limpiarFicheroComidas(Global.FOOD_FILE);

        Serializacion.limpiarFicheroComidas(Global.FOOD_FILE);

        mrr.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                mostrarComidas();
            }
        });
    }

    /**
     * Muestra todas las comidas disponibles que se han creado en
     * {@link MiniRegistroRestaurante}
     */
    public void mostrarComidas() {
        ArrayList<Comida> comidas = Serializacion.cargarEnMemoriaComidas(Global.FOOD_FILE);
        DefaultTableModel modelCo = (DefaultTableModel) tablaComida.getModel();
        modelCo.setRowCount(0);

        for (Comida comida : comidas) {
            String nombre = comida.getTitulo();
            Double precio = comida.getPrecio();
            String ruta = comida.getRutaFotografia();
            Object[] rowData = {nombre, precio, ruta};
            modelCo.addRow(rowData);
        }
    }

    /**
     * Si checkBox de catering activada aparecen las opciones de catering
     */
    public void esconderCatering() {
        boolean check = checkBoxCatering.isSelected();
        checkCamareros.setVisible(check);
        checkCocineros.setVisible(check);
        checkDeco.setVisible(check);
        checkEspacio.setVisible(check);
    }

    /**
     * Al instanciar al inicio de {@link adminRestaurantesWindow} la ventana y
     * establecer un listener cuando la ventana se cierre para refrescar los
     * restaurantes disponible se necesita un metodo para hacer como si la
     * ventana "se hubiese iniciado nueva"
     */
    public void vaciarWindow() throws IOException {
        deCleanWriteMOD(rellenarNombre, "Nombre");
        deCleanWriteMOD(rellenarCIF, "CIF");
        deCleanWriteMOD(rellenarEspecialidad, "Especialidad");
        deCleanWriteMOD(rellenarTDE, "Tiempo de envío");
        deCleanWriteMOD(rellenarGDE, "Gastos de envio");
        deCleanWriteMOD(dCP, "Código Postal");
        deCleanWriteMOD(dCalle, "Calle");
        deCleanWriteMOD(dCiudad, "Ciudad");
        deCleanWriteMOD(dNumero, "Número");
        checkBoxCatering.setSelected(false);
        checkCamareros.setVisible(false);
        checkCocineros.setVisible(false);
        checkDeco.setVisible(false);
        checkEspacio.setVisible(false);
        Serializacion.limpiarFicheroComidas(Global.FOOD_FILE);
        mostrarComidas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Fondo = new javax.swing.JPanel();
        BarraSuperior = new javax.swing.JPanel();
        ExitButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Eat = new javax.swing.JLabel();
        Registro = new javax.swing.JLabel();
        Java = new javax.swing.JLabel();
        SeparadorInferior = new javax.swing.JSeparator();
        Java2 = new javax.swing.JLabel();
        rellenarNombre = new javax.swing.JTextField();
        textoCIF = new javax.swing.JLabel();
        rellenarCIF = new javax.swing.JTextField();
        textoEspecialidad = new javax.swing.JLabel();
        rellenarEspecialidad = new javax.swing.JTextField();
        textoTDE = new javax.swing.JLabel();
        rellenarTDE = new javax.swing.JTextField();
        Java7 = new javax.swing.JLabel();
        dCalle = new javax.swing.JTextField();
        BotonRegistrar = new javax.swing.JButton();
        BotonLimpiar = new javax.swing.JButton();
        Java8 = new javax.swing.JLabel();
        Java9 = new javax.swing.JLabel();
        dNumero = new javax.swing.JTextField();
        Java10 = new javax.swing.JLabel();
        dCP = new javax.swing.JTextField();
        Java11 = new javax.swing.JLabel();
        dCiudad = new javax.swing.JTextField();
        textoGDE = new javax.swing.JLabel();
        rellenarGDE = new javax.swing.JTextField();
        textoComida = new javax.swing.JLabel();
        scrollComida = new javax.swing.JScrollPane();
        tablaComida = new javax.swing.JTable();
        textoCatering = new javax.swing.JLabel();
        checkBoxCatering = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        botonMas = new javax.swing.JButton();
        botonMenos = new javax.swing.JButton();
        checkCamareros = new javax.swing.JCheckBox();
        checkDeco = new javax.swing.JCheckBox();
        checkCocineros = new javax.swing.JCheckBox();
        checkEspacio = new javax.swing.JCheckBox();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(998, 630));
        setUndecorated(true);

        Fondo.setBackground(new java.awt.Color(246, 238, 249));
        Fondo.setMinimumSize(new java.awt.Dimension(998, 630));
        Fondo.setPreferredSize(new java.awt.Dimension(998, 630));

        BarraSuperior.setBackground(new java.awt.Color(246, 238, 249));
        BarraSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarraSuperiorMouseDragged(evt);
            }
        });
        BarraSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarraSuperiorMousePressed(evt);
            }
        });

        ExitButton.setBackground(new java.awt.Color(246, 238, 249));
        ExitButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ExitButton.setForeground(new java.awt.Color(0, 0, 0));
        ExitButton.setText("X");
        ExitButton.setFocusable(false);
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExitButtonMousePressed(evt);
            }
        });
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout BarraSuperiorLayout = new javax.swing.GroupLayout(BarraSuperior);
        BarraSuperior.setLayout(BarraSuperiorLayout);
        BarraSuperiorLayout.setHorizontalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addContainerGap(927, Short.MAX_VALUE)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        BarraSuperiorLayout.setVerticalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Eat.setFont(new java.awt.Font("Roboto Black", 1, 35)); // NOI18N
        Eat.setForeground(new java.awt.Color(255, 51, 51));
        Eat.setText("Eat");
        Eat.setToolTipText("");

        Registro.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        Registro.setForeground(new java.awt.Color(0, 0, 0));
        Registro.setText("Registro de restaurante");
        Registro.setToolTipText("");

        Java.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        Java.setForeground(new java.awt.Color(0, 0, 0));
        Java.setText("Java");
        Java.setToolTipText("");

        SeparadorInferior.setForeground(new java.awt.Color(0, 0, 0));

        Java2.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java2.setForeground(new java.awt.Color(0, 0, 0));
        Java2.setText("Nombre");
        Java2.setToolTipText("");

        rellenarNombre.setBackground(new java.awt.Color(246, 238, 249));
        rellenarNombre.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        rellenarNombre.setForeground(new java.awt.Color(209, 211, 211));
        rellenarNombre.setText("Nombre");
        rellenarNombre.setActionCommand("<Not Set>");
        rellenarNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rellenarNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rellenarNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rellenarNombreFocusLost(evt);
            }
        });
        rellenarNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rellenarNombreMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rellenarNombreMousePressed(evt);
            }
        });
        rellenarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rellenarNombreActionPerformed(evt);
            }
        });

        textoCIF.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoCIF.setForeground(new java.awt.Color(0, 0, 0));
        textoCIF.setText("CIF");
        textoCIF.setToolTipText("");

        rellenarCIF.setBackground(new java.awt.Color(246, 238, 249));
        rellenarCIF.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        rellenarCIF.setForeground(new java.awt.Color(209, 211, 211));
        rellenarCIF.setText("CIF");
        rellenarCIF.setActionCommand("<Not Set>");
        rellenarCIF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rellenarCIF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rellenarCIFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rellenarCIFFocusLost(evt);
            }
        });
        rellenarCIF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rellenarCIFMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rellenarCIFMousePressed(evt);
            }
        });
        rellenarCIF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rellenarCIFActionPerformed(evt);
            }
        });

        textoEspecialidad.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoEspecialidad.setForeground(new java.awt.Color(0, 0, 0));
        textoEspecialidad.setText("Especialidad");
        textoEspecialidad.setToolTipText("");

        rellenarEspecialidad.setBackground(new java.awt.Color(246, 238, 249));
        rellenarEspecialidad.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        rellenarEspecialidad.setForeground(new java.awt.Color(209, 211, 211));
        rellenarEspecialidad.setText("Especialidad");
        rellenarEspecialidad.setActionCommand("<Not Set>");
        rellenarEspecialidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rellenarEspecialidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rellenarEspecialidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rellenarEspecialidadFocusLost(evt);
            }
        });
        rellenarEspecialidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rellenarEspecialidadMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rellenarEspecialidadMousePressed(evt);
            }
        });
        rellenarEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rellenarEspecialidadActionPerformed(evt);
            }
        });

        textoTDE.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoTDE.setForeground(new java.awt.Color(0, 0, 0));
        textoTDE.setText("Tiempo de envío (en minutos)");
        textoTDE.setToolTipText("");

        rellenarTDE.setBackground(new java.awt.Color(246, 238, 249));
        rellenarTDE.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        rellenarTDE.setForeground(new java.awt.Color(209, 211, 211));
        rellenarTDE.setText("Tiempo de envío");
        rellenarTDE.setActionCommand("<Not Set>");
        rellenarTDE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rellenarTDE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rellenarTDEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rellenarTDEFocusLost(evt);
            }
        });
        rellenarTDE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rellenarTDEMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rellenarTDEMousePressed(evt);
            }
        });
        rellenarTDE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rellenarTDEActionPerformed(evt);
            }
        });

        Java7.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java7.setForeground(new java.awt.Color(0, 0, 0));
        Java7.setText("Direccion");
        Java7.setToolTipText("");

        dCalle.setBackground(new java.awt.Color(246, 238, 249));
        dCalle.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        dCalle.setForeground(new java.awt.Color(209, 211, 211));
        dCalle.setText("Calle");
        dCalle.setActionCommand("<Not Set>");
        dCalle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dCalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dCalleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dCalleFocusLost(evt);
            }
        });
        dCalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dCalleMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dCalleMousePressed(evt);
            }
        });
        dCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dCalleActionPerformed(evt);
            }
        });

        BotonRegistrar.setBackground(new java.awt.Color(246, 238, 249));
        BotonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        BotonRegistrar.setText("Registrar");
        BotonRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRegistrarMouseClicked(evt);
            }
        });
        BotonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarActionPerformed(evt);
            }
        });

        BotonLimpiar.setBackground(new java.awt.Color(246, 238, 249));
        BotonLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        BotonLimpiar.setText("Limpiar");
        BotonLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonLimpiarMouseClicked(evt);
            }
        });
        BotonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLimpiarActionPerformed(evt);
            }
        });

        Java8.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java8.setForeground(new java.awt.Color(0, 0, 0));
        Java8.setText("Calle");
        Java8.setToolTipText("");

        Java9.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java9.setForeground(new java.awt.Color(0, 0, 0));
        Java9.setText("Número");
        Java9.setToolTipText("");

        dNumero.setBackground(new java.awt.Color(246, 238, 249));
        dNumero.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        dNumero.setForeground(new java.awt.Color(209, 211, 211));
        dNumero.setText("Número");
        dNumero.setActionCommand("<Not Set>");
        dNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dNumeroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dNumeroFocusLost(evt);
            }
        });
        dNumero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dNumeroMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dNumeroMousePressed(evt);
            }
        });
        dNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dNumeroActionPerformed(evt);
            }
        });

        Java10.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java10.setForeground(new java.awt.Color(0, 0, 0));
        Java10.setText("Código Postal");
        Java10.setToolTipText("");

        dCP.setBackground(new java.awt.Color(246, 238, 249));
        dCP.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        dCP.setForeground(new java.awt.Color(209, 211, 211));
        dCP.setText("Código Postal");
        dCP.setActionCommand("<Not Set>");
        dCP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dCP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dCPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dCPFocusLost(evt);
            }
        });
        dCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dCPMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dCPMousePressed(evt);
            }
        });
        dCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dCPActionPerformed(evt);
            }
        });

        Java11.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java11.setForeground(new java.awt.Color(0, 0, 0));
        Java11.setText("Ciudad");
        Java11.setToolTipText("");

        dCiudad.setBackground(new java.awt.Color(246, 238, 249));
        dCiudad.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        dCiudad.setForeground(new java.awt.Color(209, 211, 211));
        dCiudad.setText("Ciudad");
        dCiudad.setActionCommand("<Not Set>");
        dCiudad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dCiudad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dCiudadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dCiudadFocusLost(evt);
            }
        });
        dCiudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dCiudadMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dCiudadMousePressed(evt);
            }
        });
        dCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dCiudadActionPerformed(evt);
            }
        });

        textoGDE.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoGDE.setForeground(new java.awt.Color(0, 0, 0));
        textoGDE.setText("Gastos de envío");
        textoGDE.setToolTipText("");

        rellenarGDE.setBackground(new java.awt.Color(246, 238, 249));
        rellenarGDE.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        rellenarGDE.setForeground(new java.awt.Color(209, 211, 211));
        rellenarGDE.setText("Gastos de envio");
        rellenarGDE.setActionCommand("<Not Set>");
        rellenarGDE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rellenarGDE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rellenarGDEFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rellenarGDEFocusLost(evt);
            }
        });
        rellenarGDE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rellenarGDEMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rellenarGDEMousePressed(evt);
            }
        });
        rellenarGDE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rellenarGDEActionPerformed(evt);
            }
        });

        textoComida.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoComida.setForeground(new java.awt.Color(0, 0, 0));
        textoComida.setText("Comida");
        textoComida.setToolTipText("");

        tablaComida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Ruta Foto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaComida.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        scrollComida.setViewportView(tablaComida);

        textoCatering.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoCatering.setForeground(new java.awt.Color(0, 0, 0));
        textoCatering.setText("Catering");
        textoCatering.setToolTipText("");

        checkBoxCatering.setBackground(new java.awt.Color(246, 238, 249));
        checkBoxCatering.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        checkBoxCatering.setText("Tiene catering");
        checkBoxCatering.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkBoxCateringMouseClicked(evt);
            }
        });
        checkBoxCatering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxCateringActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        botonMas.setBackground(new java.awt.Color(246, 238, 249));
        botonMas.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        botonMas.setForeground(new java.awt.Color(0, 0, 0));
        botonMas.setText("+");
        botonMas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonMasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonMasMouseExited(evt);
            }
        });
        botonMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMasActionPerformed(evt);
            }
        });
        jPanel1.add(botonMas);

        botonMenos.setBackground(new java.awt.Color(246, 238, 249));
        botonMenos.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        botonMenos.setForeground(new java.awt.Color(0, 0, 0));
        botonMenos.setText("-");
        botonMenos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMenosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonMenosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonMenosMouseExited(evt);
            }
        });
        botonMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenosActionPerformed(evt);
            }
        });
        jPanel1.add(botonMenos);

        checkCamareros.setBackground(new java.awt.Color(246, 238, 249));
        checkCamareros.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        checkCamareros.setForeground(new java.awt.Color(0, 0, 0));
        checkCamareros.setText("Camareros (800)");
        checkCamareros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkCamarerosMouseClicked(evt);
            }
        });

        checkDeco.setBackground(new java.awt.Color(246, 238, 249));
        checkDeco.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        checkDeco.setForeground(new java.awt.Color(0, 0, 0));
        checkDeco.setText("Decoración (500)");
        checkDeco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkDecoMouseClicked(evt);
            }
        });

        checkCocineros.setBackground(new java.awt.Color(246, 238, 249));
        checkCocineros.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        checkCocineros.setForeground(new java.awt.Color(0, 0, 0));
        checkCocineros.setText("Cocineros (1000)");
        checkCocineros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkCocinerosMouseClicked(evt);
            }
        });

        checkEspacio.setBackground(new java.awt.Color(246, 238, 249));
        checkEspacio.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        checkEspacio.setForeground(new java.awt.Color(0, 0, 0));
        checkEspacio.setText("Espacio Privado (1000)");
        checkEspacio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkEspacioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(BarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(SeparadorInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(680, 680, 680)
                        .addComponent(BotonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(Java2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(textoCIF, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(rellenarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(rellenarCIF, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoGDE, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rellenarGDE, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Java7, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(Java8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(Java9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(dCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(Java11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110)
                                .addComponent(Java10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(dCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dCP, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(scrollComida, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(textoComida, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoCatering, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkBoxCatering, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkEspacio, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkCamareros, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkDeco, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(checkCocineros, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(textoEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(textoTDE, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(rellenarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(rellenarTDE, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Java)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Eat, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(BarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Eat)
                        .addComponent(Java))
                    .addComponent(Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(SeparadorInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Java2)
                            .addComponent(textoCIF))
                        .addGap(6, 6, 6)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rellenarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rellenarCIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoEspecialidad)
                            .addComponent(textoTDE))
                        .addGap(6, 6, 6)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rellenarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rellenarTDE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(textoGDE)
                                .addGap(6, 6, 6)
                                .addComponent(rellenarGDE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Java7)
                                .addGap(6, 6, 6)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Java8)
                                    .addComponent(Java9))
                                .addGap(4, 4, 4)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Java11)
                                    .addComponent(Java10))
                                .addGap(6, 6, 6)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textoComida)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(scrollComida, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(BotonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(textoCatering)
                        .addGap(2, 2, 2)
                        .addComponent(checkBoxCatering)
                        .addGap(12, 12, 12)
                        .addComponent(checkCamareros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkDeco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkCocineros)
                        .addGap(6, 6, 6)
                        .addComponent(checkEspacio)))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitButtonMouseClicked

    private void ExitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseEntered
        ExitButton.setBackground(Color.red);
        ExitButton.setForeground(Color.white);
    }//GEN-LAST:event_ExitButtonMouseEntered

    private void ExitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseExited

        ExitButton.setBackground(Global.ROSA);
        ExitButton.setForeground(Color.black);
    }//GEN-LAST:event_ExitButtonMouseExited

    private void ExitButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMousePressed

    }//GEN-LAST:event_ExitButtonMousePressed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void BarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - RatonX, y - RatonY);
    }//GEN-LAST:event_BarraSuperiorMouseDragged

    private void BarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMousePressed
        RatonX = evt.getX();
        RatonY = evt.getY();
    }//GEN-LAST:event_BarraSuperiorMousePressed

    private void rellenarNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarNombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rellenarNombreMouseClicked

    private void rellenarNombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarNombreMousePressed
        Global.cleanWrite(rellenarNombre);
    }//GEN-LAST:event_rellenarNombreMousePressed

    private void rellenarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rellenarNombreActionPerformed
        Global.cleanWrite(rellenarNombre);
    }//GEN-LAST:event_rellenarNombreActionPerformed

    private void rellenarCIFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarCIFMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rellenarCIFMouseClicked

    private void rellenarCIFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarCIFMousePressed
        Global.cleanWrite(rellenarCIF);
    }//GEN-LAST:event_rellenarCIFMousePressed

    private void rellenarCIFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rellenarCIFActionPerformed
        Global.cleanWrite(rellenarCIF);
    }//GEN-LAST:event_rellenarCIFActionPerformed

    private void rellenarEspecialidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarEspecialidadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rellenarEspecialidadMouseClicked

    private void rellenarEspecialidadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarEspecialidadMousePressed
        Global.cleanWrite(rellenarEspecialidad);
    }//GEN-LAST:event_rellenarEspecialidadMousePressed

    private void rellenarEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rellenarEspecialidadActionPerformed
        Global.cleanWrite(rellenarEspecialidad);
    }//GEN-LAST:event_rellenarEspecialidadActionPerformed

    private void rellenarTDEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarTDEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rellenarTDEMouseClicked

    private void rellenarTDEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarTDEMousePressed
        Global.cleanWrite(rellenarTDE);
    }//GEN-LAST:event_rellenarTDEMousePressed

    private void rellenarTDEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rellenarTDEActionPerformed
        Global.cleanWrite(rellenarTDE);
    }//GEN-LAST:event_rellenarTDEActionPerformed

    private void dCalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dCalleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dCalleMouseClicked

    private void dCalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dCalleMousePressed
        Global.cleanWrite(dCalle);
    }//GEN-LAST:event_dCalleMousePressed

    private void dCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dCalleActionPerformed
        Global.cleanWrite(dCalle);
    }//GEN-LAST:event_dCalleActionPerformed

    private void BotonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarActionPerformed

        String nombreTxt = rellenarNombre.getText().trim();
        String cifTxt = rellenarCIF.getText().trim();
        String espTxt = rellenarEspecialidad.getText().trim();
        String tdeTxt = rellenarTDE.getText().trim();
        String gdeTxt = rellenarGDE.getText().trim();

        //Campos de direccion
        String dCalleTxt = dCalle.getText().trim();
        String dNumeroTxt = dNumero.getText().trim();
        String dCPTxt = dCP.getText().trim();
        String dCiudadTxt = dCiudad.getText().trim();

        // Criterios de registro por campo                                                                                              // Regex
        boolean cNombre = !nombreTxt.isEmpty() && !rellenarNombre.getForeground().equals(Global.GRIS);                                      //Esta relleno  (puede llamarse cualquier cosa)
        boolean cCif = Global.cifValido(cifTxt);                                                                                      //Es un cif valido
        boolean cEsp = !espTxt.isEmpty() && !rellenarEspecialidad.getForeground().equals(Global.GRIS);                               //Esta relleno  (puede llamarse cualquier cosa)
        boolean cTde = tdeTxt.matches("^[1-9]\\d*$");                                                                               // Es un numero que puede ser double y no negativo
        boolean cGde = gdeTxt.matches("\\d*\\.?\\d+") && !gdeTxt.matches("^-.*");                                                 // Es un numero que puede ser double y no negativo

        // Criterios de direccion
        boolean cdCalle = dCalleTxt.matches("\\D+") && !dCalle.getForeground().equals(Global.GRIS);                      // Solo tiene letras
        boolean cdNumero = dNumeroTxt.matches("\\d+");                                                                         // Solo numeros
        boolean cdCP = dCPTxt.matches("\\d+") && dCPTxt.length() == 5;                                                          // Solo compuesto por numeros (REGEX) y 5 digitos (Espana) 
        boolean cdCiudad = !dCiudadTxt.isEmpty() && !dCiudad.getForeground().equals(Global.GRIS);                             //Esta relleno (puede llamarse cualquier cosa)
        boolean cDireccion = cdCalle && cdNumero && cdCP && cdCiudad;

        boolean rowsComida = (tablaComida.getModel().getRowCount() > 0);                                                           // Tiene que haber minimo una comida

        boolean checkCondiciones = cNombre && cCif && cEsp && cTde && cGde && cDireccion && rowsComida;

        try {
            if (Serializacion.estaEnBdRestaurante(Global.RESTAURANT_FILE, nombreTxt)) {
                Global.panelAviso("Restaurante Registrado, utilize otro");
            } else if (!checkCondiciones) {
                Global.panelAviso("Faltan datos por rellenar o no cumplen con las condiciones normales");
            } else {
                int opcion = Global.panelDecisionSN("¿Se registrar este restaurante?", "Registro restaurante", Global.SI, Global.NO);
                switch (opcion) {
                    case JOptionPane.YES_OPTION:
                        Direccion nuevadireccion = new Direccion(dCalleTxt, dNumeroTxt, dCPTxt, dCiudadTxt);
                        ArrayList<Opinion> opiniones = new ArrayList<Opinion>();
                        opiniones.add(new Opinion(0, ""));

                        ArrayList<Comida> comidas = Serializacion.cargarEnMemoriaComidas(Global.FOOD_FILE);

                        if (checkBoxCatering.isSelected()) {
                            Catering cat = new Catering(checkCamareros.isSelected(), checkCocineros.isSelected(), checkDeco.isSelected(), checkEspacio.isSelected());
                            Restaurante res = new Restaurante(cifTxt, nombreTxt, nuevadireccion, espTxt, Double.parseDouble(gdeTxt), Integer.parseInt(tdeTxt), opiniones, comidas, cat);
                            Serializacion.anexar(Global.RESTAURANT_FILE, res);
                        } else {
                            Catering cat = new Catering(false, false, false, false);
                            Restaurante res = new Restaurante(cifTxt, nombreTxt, nuevadireccion, espTxt, Double.parseDouble(gdeTxt), Integer.parseInt(tdeTxt), opiniones, comidas, cat);
                            Serializacion.anexar(Global.RESTAURANT_FILE, res);
                        }
                        this.dispose();
                        break;
                    default:

                        System.out.println("Registro: Edicion cancelada");
                        break;
                }

            };
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_BotonRegistrarActionPerformed

    private void BotonLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLimpiarMouseClicked
        rellenarNombre.setText(Global.EMPTY);
        rellenarCIF.setText(Global.EMPTY);
        rellenarEspecialidad.setText(Global.EMPTY);
        rellenarTDE.setText(Global.EMPTY);
        rellenarGDE.setText(Global.EMPTY);
        dCalle.setText(Global.EMPTY);
        dCP.setText(Global.EMPTY);
        dCiudad.setText(Global.EMPTY);
        dNumero.setText(Global.EMPTY);
        checkBoxCatering.setSelected(false);
        esconderCatering();

    }//GEN-LAST:event_BotonLimpiarMouseClicked

    private void BotonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonLimpiarActionPerformed

    private void dNumeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dNumeroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dNumeroMouseClicked

    private void dNumeroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dNumeroMousePressed
        Global.cleanWrite(dNumero);
    }//GEN-LAST:event_dNumeroMousePressed

    private void dNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dNumeroActionPerformed
        Global.cleanWrite(dNumero);
    }//GEN-LAST:event_dNumeroActionPerformed

    private void dCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dCPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dCPMouseClicked

    private void dCPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dCPMousePressed
        Global.cleanWrite(dCP);
    }//GEN-LAST:event_dCPMousePressed

    private void dCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dCPActionPerformed
        Global.cleanWrite(dCP);
    }//GEN-LAST:event_dCPActionPerformed

    private void dCiudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dCiudadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dCiudadMouseClicked

    private void dCiudadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dCiudadMousePressed
        Global.cleanWrite(dCiudad);
    }//GEN-LAST:event_dCiudadMousePressed

    private void dCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dCiudadActionPerformed
        Global.cleanWrite(dCiudad);
    }//GEN-LAST:event_dCiudadActionPerformed

    private void rellenarNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarNombreFocusGained
        Global.cleanWrite(rellenarNombre);
    }//GEN-LAST:event_rellenarNombreFocusGained

    private void rellenarCIFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarCIFFocusGained
        Global.cleanWrite(rellenarCIF);
    }//GEN-LAST:event_rellenarCIFFocusGained

    private void rellenarEspecialidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarEspecialidadFocusGained
        Global.cleanWrite(rellenarEspecialidad);
    }//GEN-LAST:event_rellenarEspecialidadFocusGained

    private void rellenarTDEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarTDEFocusGained
        Global.cleanWrite(rellenarTDE);
    }//GEN-LAST:event_rellenarTDEFocusGained

    private void dCalleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dCalleFocusGained
        Global.cleanWrite(dCalle);
    }//GEN-LAST:event_dCalleFocusGained

    private void dNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dNumeroFocusGained
        Global.cleanWrite(dNumero);
    }//GEN-LAST:event_dNumeroFocusGained

    private void dCPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dCPFocusGained
        Global.cleanWrite(dCP);
    }//GEN-LAST:event_dCPFocusGained

    private void dCiudadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dCiudadFocusGained
        Global.cleanWrite(dCiudad);
    }//GEN-LAST:event_dCiudadFocusGained

    private void rellenarNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarNombreFocusLost
        Global.deCleanWrite(rellenarNombre, "Nombre");
    }//GEN-LAST:event_rellenarNombreFocusLost

    private void rellenarCIFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarCIFFocusLost
        Global.deCleanWrite(rellenarCIF, "CIF");
    }//GEN-LAST:event_rellenarCIFFocusLost

    private void rellenarEspecialidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarEspecialidadFocusLost
        Global.deCleanWrite(rellenarEspecialidad, "Especialidad");
    }//GEN-LAST:event_rellenarEspecialidadFocusLost

    private void rellenarTDEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarTDEFocusLost
        Global.deCleanWrite(rellenarTDE, "Tiempo de envío");

    }//GEN-LAST:event_rellenarTDEFocusLost

    private void dCalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dCalleFocusLost
        Global.deCleanWrite(dCalle, "Calle");
    }//GEN-LAST:event_dCalleFocusLost

    private void dNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dNumeroFocusLost
        Global.deCleanWrite(dNumero, "Número");
    }//GEN-LAST:event_dNumeroFocusLost

    private void dCPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dCPFocusLost
        Global.deCleanWrite(dCP, "Código Postal");
    }//GEN-LAST:event_dCPFocusLost

    private void dCiudadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dCiudadFocusLost
        Global.deCleanWrite(dCiudad, "Ciudad");
    }//GEN-LAST:event_dCiudadFocusLost

    private void rellenarGDEFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarGDEFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_rellenarGDEFocusGained

    private void rellenarGDEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarGDEFocusLost
        Global.deCleanWrite(rellenarGDE, "Gastos de envío");
    }//GEN-LAST:event_rellenarGDEFocusLost

    private void rellenarGDEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarGDEMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rellenarGDEMouseClicked

    private void rellenarGDEMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarGDEMousePressed
        Global.cleanWrite(rellenarGDE);
    }//GEN-LAST:event_rellenarGDEMousePressed

    private void rellenarGDEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rellenarGDEActionPerformed
        Global.cleanWrite(rellenarGDE);
    }//GEN-LAST:event_rellenarGDEActionPerformed

    private void checkBoxCateringMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBoxCateringMouseClicked
        esconderCatering();
    }//GEN-LAST:event_checkBoxCateringMouseClicked

    private void botonMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMasActionPerformed

    private void botonMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMenosActionPerformed

    private void checkBoxCateringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxCateringActionPerformed
        esconderCatering();
    }//GEN-LAST:event_checkBoxCateringActionPerformed

    private void botonMasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasMouseEntered
        botonMas.setForeground(Color.white);
        botonMas.setBackground(Color.green);
    }//GEN-LAST:event_botonMasMouseEntered

    private void botonMasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasMouseExited
        botonMas.setBackground(Global.ROSA);
        botonMas.setForeground(Color.black);
    }//GEN-LAST:event_botonMasMouseExited

    private void botonMenosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenosMouseEntered
        botonMenos.setForeground(Color.white);
        botonMenos.setBackground(Color.red);
    }//GEN-LAST:event_botonMenosMouseEntered

    private void botonMenosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenosMouseExited
        botonMenos.setBackground(Global.ROSA);
        botonMenos.setForeground(Color.black);
    }//GEN-LAST:event_botonMenosMouseExited

    private void botonMasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasMouseClicked
        mrr.setVisible(true);
        mrr.vaciarWindow();
    }//GEN-LAST:event_botonMasMouseClicked

    private void checkCamarerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkCamarerosMouseClicked

    }//GEN-LAST:event_checkCamarerosMouseClicked

    private void checkDecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkDecoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_checkDecoMouseClicked

    private void checkCocinerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkCocinerosMouseClicked

    }//GEN-LAST:event_checkCocinerosMouseClicked

    private void checkEspacioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkEspacioMouseClicked

    }//GEN-LAST:event_checkEspacioMouseClicked

    private void BotonRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegistrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonRegistrarMouseClicked

    private void botonMenosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenosMouseClicked
        int filaR = tablaComida.getSelectedRow();
        if (filaR != -1) {
            TableModel R = tablaComida.getModel();

            String nombre = (String) R.getValueAt(filaR, 0);

            Serializacion.borrarComida(Global.FOOD_FILE, nombre);
            mostrarComidas();

        }

    }//GEN-LAST:event_botonMenosMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FormularioCreacionRestaurante().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FormularioCreacionRestaurante.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JButton BotonLimpiar;
    private javax.swing.JButton BotonRegistrar;
    private javax.swing.JLabel Eat;
    private javax.swing.JButton ExitButton;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Java;
    private javax.swing.JLabel Java10;
    private javax.swing.JLabel Java11;
    private javax.swing.JLabel Java2;
    private javax.swing.JLabel Java7;
    private javax.swing.JLabel Java8;
    private javax.swing.JLabel Java9;
    private javax.swing.JLabel Registro;
    private javax.swing.JSeparator SeparadorInferior;
    private javax.swing.JButton botonMas;
    private javax.swing.JButton botonMenos;
    private javax.swing.JCheckBox checkBoxCatering;
    private javax.swing.JCheckBox checkCamareros;
    private javax.swing.JCheckBox checkCocineros;
    private javax.swing.JCheckBox checkDeco;
    private javax.swing.JCheckBox checkEspacio;
    private javax.swing.JTextField dCP;
    private javax.swing.JTextField dCalle;
    private javax.swing.JTextField dCiudad;
    private javax.swing.JTextField dNumero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField rellenarCIF;
    private javax.swing.JTextField rellenarEspecialidad;
    private javax.swing.JTextField rellenarGDE;
    private javax.swing.JTextField rellenarNombre;
    private javax.swing.JTextField rellenarTDE;
    private javax.swing.JScrollPane scrollComida;
    private javax.swing.JTable tablaComida;
    private javax.swing.JLabel textoCIF;
    private javax.swing.JLabel textoCatering;
    private javax.swing.JLabel textoComida;
    private javax.swing.JLabel textoEspecialidad;
    private javax.swing.JLabel textoGDE;
    private javax.swing.JLabel textoTDE;
    // End of variables declaration//GEN-END:variables
}
