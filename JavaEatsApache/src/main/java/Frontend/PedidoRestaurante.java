package Frontend;

import Backend.Comida;
import Backend.Restaurante;
import Backend.Global;
import Backend.Serializacion;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import Backend.Venta;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 * Ventana para la relizacion de un pedido por un restaurante
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class PedidoRestaurante extends javax.swing.JFrame {

    int RatonX, RatonY, filasDisponibles;
    String nombreRestaurante;
    String email;
    public PedidoRestaurante(String nombreRestaurante, String email) {

        initComponents();
        //Escalar variables para acceso a todos los metodos
        this.nombreRestaurante = nombreRestaurante;
        this.email = email;

        Restaurante restaurant = Serializacion.getRestaurante(Global.RESTAURANT_FILE, nombreRestaurante);
        boolean disponibleCamarero = restaurant.getCatering().hayCamareros();
        boolean disponibleCocinero = restaurant.getCatering().hayCocineros();
        boolean disponibleDecoracion = restaurant.getCatering().hayDeco();
        boolean disponibleEspacio = restaurant.getCatering().hayEP();

        Global.frameSetUp(this, WIDTH, HEIGHT);

        mostrarC(restaurant);

        //Modelos y listado formateo de tablas
        ListSelectionModel modeloC = tablaC.getSelectionModel();
        ListenerSeleccionComida(modeloC);

        Global.setTabla(139, 50, tablaC);
        Global.setTabla(122, 50, tablaC1);
        Global.setTabla(150, 50, tablaI);

        tablaC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    // Para evitar que en una tabla se pueda hacer Ctrl+(Click a filas)
        tablaI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   // Para evitar que en una tabla se pueda hacer Ctrl+(Click a filas)
        tablaC1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Para evitar que en una tabla se pueda hacer Ctrl+(Click a filas)

        // Texto "adaptable"
        tituloRestaurante.setText("Carta de " + nombreRestaurante);
        gdeText.setText("Gastos de envío: " + restaurant.getGastosEnvio() + "€");

        // Mostrar si tiene catering los servicios disponibles a poder pedir
        if (Backend.Serializacion.esParticular(Global.USER_FILE, email) || !restaurant.isServicioCatering()) {
            jPanel3.setVisible(false);
            textoCatering.setVisible(false);
            txtE.setVisible(false);
        } else {
            if (!disponibleCamarero) {
                jCheckBox5.setVisible(false);
            } else if (!disponibleCocinero) {
                jCheckBox4.setVisible(false);
            } else if (!disponibleDecoracion) {
                jCheckBox6.setVisible(false);
            } else if (!disponibleEspacio) {
                jCheckBox7.setVisible(false);
            }
            txtE.setVisible(true);
        }

    }

    /**
     * Constructor vacio por defecto generado
     */
    private PedidoRestaurante() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Detecta cuando el usuario esta seleccionado una comida para mostrar sus
     * ingredientes
     *
     * @param modeloC
     */
    public void ListenerSeleccionComida(ListSelectionModel modeloC) {
        modeloC.addListSelectionListener(new ListSelectionListener() {                                          // Listener de seleccion comida

            public void valueChanged(ListSelectionEvent e) {
                int MAXSIZE = 27;
                int filaC = tablaC.getSelectedRow();

                if (filaC != -1) {

                    TableModel C = tablaC.getModel();
                    Restaurante res = Serializacion.getRestaurante(Global.RESTAURANT_FILE, nombreRestaurante);

                    String nombreComida = (String) C.getValueAt(filaC, encontrarIndice(tablaC, "Nombre"));
                    Comida comida = Serializacion.getComida(res, nombreComida);
                    mostrarI(comida);

                    String str = "Ingredientes de '" + nombreComida + "'";

                    if (str.length() > MAXSIZE) {
                        String strin = str.substring(0, MAXSIZE);               // Mecanismo basico para que no llene toda la pantalla
                        str = strin + "...";
                    }
                    textoIngredientes.setText(str);
                } else {
                    clearModel(tablaI);
                    textoIngredientes.setText("Ingredientes");
                }

            }
        }
        );
    }

    /**
     * Encuentra el indice de una columna según el nombre de columna en tabla
     *
     * @param table Tabla
     * @param nombreColumnaBuscada Nombre de busqueda.
     * @return
     */
    public int encontrarIndice(JTable table, String nombreColumnaBuscada) {
        TableColumnModel columnModel = table.getColumnModel();
        int columnCount = columnModel.getColumnCount();

        for (int i = 0; i < columnCount; i++) {
            TableColumn column = columnModel.getColumn(i);
            if (column.getHeaderValue().equals(nombreColumnaBuscada)) {
                return i;
            }
        }

        return -1; // Retorna -1 si no se encontró la columna
    }

    /**
     * Vacia una tabla de filas
     *
     * @param table
     */
    public void clearModel(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    /**
     * Muestra exclusivamente tabla Comidas
     */
    public void mostrarC(Restaurante res) {
        DefaultTableModel model = (DefaultTableModel) tablaC.getModel();
        ArrayList<Comida> comidas = res.getComidas();

        model.setRowCount(0);
        for (Comida comida : comidas) {                                          // Organizarlos en un set para poder iterarlos 
            Object[] rowData = {comida.getTitulo(), comida.getPrecio(), comida.getRutaFotografia()};
            model.addRow(rowData);
        }
    }

    /**
     * Muestra exclusivamente tabla Ingredientes
     */
    public void mostrarI(Comida comida) {
        DefaultTableModel model = (DefaultTableModel) tablaI.getModel();
        ArrayList<String> ingredientes = comida.getIngredientes();

        model.setRowCount(0);
        for (String ingrediente : ingredientes) {                                          // Organizarlos en un set para poder iterarlos 
            Object[] rowData = {ingrediente};
            model.addRow(rowData);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BarraSuperior = new javax.swing.JPanel();
        botonExit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        particularesTexto = new javax.swing.JLabel();
        particularesTexto1 = new javax.swing.JLabel();
        tituloRestaurante = new javax.swing.JLabel();
        scrollIngredientes = new javax.swing.JScrollPane();
        tablaI = new javax.swing.JTable();
        textoIngredientes = new javax.swing.JLabel();
        scrollComida = new javax.swing.JScrollPane();
        tablaC = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        textoComidas1 = new javax.swing.JLabel();
        textoCantidadTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        scrollComida1 = new javax.swing.JScrollPane();
        tablaC1 = new javax.swing.JTable();
        botonMenos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        textoCatering = new javax.swing.JLabel();
        Eat = new javax.swing.JLabel();
        Java = new javax.swing.JLabel();
        txtE = new javax.swing.JLabel();
        gdeText = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        textoComidas2 = new javax.swing.JLabel();
        botonMas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1330, 556));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(246, 238, 249));
        jPanel1.setMinimumSize(new java.awt.Dimension(1330, 556));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1330, 556));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        botonExit.setBackground(new java.awt.Color(246, 238, 249));
        botonExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonExit.setForeground(new java.awt.Color(0, 0, 0));
        botonExit.setText("X");
        botonExit.setFocusable(false);
        botonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonExitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonExitMousePressed(evt);
            }
        });
        botonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExitActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        particularesTexto.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        particularesTexto.setForeground(new java.awt.Color(0, 0, 0));
        particularesTexto.setToolTipText("");

        particularesTexto1.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        particularesTexto1.setForeground(new java.awt.Color(0, 0, 0));
        particularesTexto1.setText("Realización de pedido");
        particularesTexto1.setToolTipText("");

        javax.swing.GroupLayout BarraSuperiorLayout = new javax.swing.GroupLayout(BarraSuperior);
        BarraSuperior.setLayout(BarraSuperiorLayout);
        BarraSuperiorLayout.setHorizontalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraSuperiorLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(particularesTexto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(BarraSuperiorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(BarraSuperiorLayout.createSequentialGroup()
                        .addComponent(particularesTexto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1058, Short.MAX_VALUE)
                        .addComponent(botonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        BarraSuperiorLayout.setVerticalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addGroup(BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BarraSuperiorLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(botonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BarraSuperiorLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(particularesTexto1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(particularesTexto)
                .addGap(63, 63, 63))
        );

        jPanel1.add(BarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 60));

        tituloRestaurante.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        tituloRestaurante.setForeground(new java.awt.Color(0, 0, 0));
        tituloRestaurante.setText("Comidas");
        tituloRestaurante.setToolTipText("");
        jPanel1.add(tituloRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 330, 40));

        scrollIngredientes.setBackground(new java.awt.Color(246, 238, 249));

        tablaI.setBackground(new java.awt.Color(234, 223, 238));
        tablaI.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        tablaI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaI.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaI.getTableHeader().setReorderingAllowed(false);
        scrollIngredientes.setViewportView(tablaI);

        jPanel1.add(scrollIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 202, 150, 207));

        textoIngredientes.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoIngredientes.setForeground(new java.awt.Color(0, 0, 0));
        textoIngredientes.setText("Ingredientes");
        textoIngredientes.setToolTipText("");
        textoIngredientes.setAutoscrolls(true);
        jPanel1.add(textoIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 146, 139, -1));

        scrollComida.setBackground(new java.awt.Color(246, 238, 249));

        tablaC.setBackground(new java.awt.Color(234, 223, 238));
        tablaC.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        tablaC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Ruta fotografia"
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
        tablaC.getTableHeader().setReorderingAllowed(false);
        scrollComida.setViewportView(tablaC);

        jPanel1.add(scrollComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 202, 417, 207));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 185, 1278, 11));

        textoComidas1.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoComidas1.setForeground(new java.awt.Color(0, 0, 0));
        textoComidas1.setText("Comidas seleccionadas");
        textoComidas1.setToolTipText("");
        textoComidas1.setAutoscrolls(true);
        jPanel1.add(textoComidas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 146, 340, -1));

        textoCantidadTotal.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoCantidadTotal.setForeground(new java.awt.Color(0, 0, 0));
        textoCantidadTotal.setToolTipText("");
        textoCantidadTotal.setAutoscrolls(true);
        textoCantidadTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(textoCantidadTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(708, 669, 335, 27));

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 415, 77, -1));

        scrollComida1.setBackground(new java.awt.Color(246, 238, 249));

        tablaC1.setBackground(new java.awt.Color(234, 223, 238));
        tablaC1.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        tablaC1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio", "Ruta fotografia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaC1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaC1.getTableHeader().setReorderingAllowed(false);
        scrollComida1.setViewportView(tablaC1);

        jPanel1.add(scrollComida1, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 202, 400, 207));

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
        jPanel1.add(botonMenos, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 420, 81, -1));

        jButton1.setBackground(new java.awt.Color(246, 238, 249));
        jButton1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Hacer pedido");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 488, 199, 40));

        jPanel3.setBackground(new java.awt.Color(246, 238, 249));

        jCheckBox4.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox4.setText("Servicio de cocineros (1000  €)");
        jCheckBox4.setContentAreaFilled(false);
        jCheckBox4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jCheckBox4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox4.setPreferredSize(new java.awt.Dimension(140, 23));

        jCheckBox5.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox5.setText("Servicio de camareros (800  €)");
        jCheckBox5.setContentAreaFilled(false);
        jCheckBox5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jCheckBox5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox5.setPreferredSize(new java.awt.Dimension(140, 23));

        jCheckBox6.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox6.setText("Servicio de decoracion (500  €)");
        jCheckBox6.setContentAreaFilled(false);
        jCheckBox6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jCheckBox6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        jCheckBox7.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox7.setText("Espacio privado (1000  €)");
        jCheckBox7.setContentAreaFilled(false);
        jCheckBox7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jCheckBox7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jCheckBox7.setPreferredSize(new java.awt.Dimension(140, 23));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, -1, -1));

        textoCatering.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoCatering.setForeground(new java.awt.Color(0, 0, 0));
        textoCatering.setText("Servicios del catering");
        textoCatering.setToolTipText("");
        textoCatering.setAutoscrolls(true);
        jPanel1.add(textoCatering, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 140, 208, 40));

        Eat.setFont(new java.awt.Font("Roboto Black", 1, 35)); // NOI18N
        Eat.setForeground(new java.awt.Color(255, 51, 51));
        Eat.setText("Eat");
        Eat.setToolTipText("");
        jPanel1.add(Eat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1232, 66, 55, -1));

        Java.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        Java.setForeground(new java.awt.Color(0, 0, 0));
        Java.setText("Java");
        Java.setToolTipText("");
        jPanel1.add(Java, new org.netbeans.lib.awtextra.AbsoluteConstraints(1157, 71, -1, -1));

        txtE.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        txtE.setForeground(new java.awt.Color(0, 0, 0));
        txtE.setText("Al ser empresa 10% de descuento!");
        txtE.setToolTipText("");
        txtE.setAutoscrolls(true);
        jPanel1.add(txtE, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, 392, 38));

        gdeText.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        gdeText.setForeground(new java.awt.Color(0, 0, 0));
        gdeText.setText("Gastos de envío");
        gdeText.setToolTipText("");
        gdeText.setAutoscrolls(true);
        jPanel1.add(gdeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 415, 260, 29));

        jButton2.setBackground(new java.awt.Color(246, 238, 249));
        jButton2.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Opinar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 490, 199, 38));

        textoComidas2.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoComidas2.setForeground(new java.awt.Color(0, 0, 0));
        textoComidas2.setText("Comidas");
        textoComidas2.setToolTipText("");
        jPanel1.add(textoComidas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

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
        jPanel1.add(botonMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 77, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_botonExitMouseClicked

    private void botonExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExitMouseEntered
        botonExit.setBackground(Color.red);
        botonExit.setForeground(Color.white);
    }//GEN-LAST:event_botonExitMouseEntered

    private void botonExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExitMouseExited
        Color color = new Color(246, 238, 249);
        botonExit.setBackground(color);
        botonExit.setForeground(Color.black);
    }//GEN-LAST:event_botonExitMouseExited

    private void botonExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExitMousePressed

    }//GEN-LAST:event_botonExitMousePressed

    private void botonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonExitActionPerformed

    private void BarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - RatonX, y - RatonY);
    }//GEN-LAST:event_BarraSuperiorMouseDragged

    private void BarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMousePressed
        RatonX = evt.getX();
        RatonY = evt.getY();
    }//GEN-LAST:event_BarraSuperiorMousePressed

    private void botonMasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasMouseClicked

    }//GEN-LAST:event_botonMasMouseClicked

    private void botonMasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasMouseEntered
        botonMas.setForeground(Color.white);
        botonMas.setBackground(Color.green);
    }//GEN-LAST:event_botonMasMouseEntered

    private void botonMasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasMouseExited
        botonMas.setBackground(Global.ROSA);
        botonMas.setForeground(Color.black);
    }//GEN-LAST:event_botonMasMouseExited

    private void botonMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMasActionPerformed
        // TODO add your handling code here:

        int filaC = tablaC.getSelectedRow();
        TableModel C = tablaC.getModel();
        DefaultTableModel C1 = (DefaultTableModel) tablaC1.getModel();
        Object[] rowData = new Object[C.getColumnCount()];
        if (filaC != -1) {
            for (int col = 0; col < C.getColumnCount(); col++) {
                rowData[col] = C.getValueAt(filaC, col);
            }
            C1.addRow(rowData);

        }


    }//GEN-LAST:event_botonMasActionPerformed

    private void botonMenosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenosMouseClicked
        DefaultTableModel model = (DefaultTableModel) tablaC1.getModel();
        filasDisponibles = model.getRowCount();
        if (filasDisponibles > 0) {
            model.setRowCount(filasDisponibles - 1);
        }
    }//GEN-LAST:event_botonMenosMouseClicked

    private void botonMenosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenosMouseEntered
        botonMenos.setForeground(Color.white);
        botonMenos.setBackground(Color.red);
    }//GEN-LAST:event_botonMenosMouseEntered

    private void botonMenosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenosMouseExited
        botonMenos.setBackground(Global.ROSA);
        botonMenos.setForeground(Color.black);
    }//GEN-LAST:event_botonMenosMouseExited

    private void botonMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMenosActionPerformed
    /*
*
*    
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:    
        TableModel model = tablaC1.getModel();
        boolean estaVacio = model.getRowCount() == 0;
        if (!estaVacio) {

            String fechaS = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            Restaurante restaurante = Serializacion.getRestaurante(Global.RESTAURANT_FILE, nombreRestaurante); //Obtener objeto restaurante a aprtir de nombreRestaurante
            HashMap<String, Object> clientes = Serializacion.cargarEnMemoria(Global.USER_FILE);
            HashMap<String, Double> serviciosSeleccionadosPorUser = new HashMap<String, Double>();
            double precioTotal = 0.0;

            boolean servicioCocinero = jCheckBox4.isSelected();
            boolean servicioCamarero = jCheckBox5.isSelected();
            boolean servicioDecoracion = jCheckBox6.isSelected();
            boolean espacioPrivado = jCheckBox7.isSelected();
            boolean disponibleCamarero = restaurante.getCatering().hayCamareros();
            boolean disponibleCocinero = restaurante.getCatering().hayCocineros();
            boolean disponibleDecoracion = restaurante.getCatering().hayDeco();
            boolean disponibleEspacio = restaurante.getCatering().hayEP();

            ArrayList<Comida> comidas = new ArrayList<>(); //Almacen de las comidas pedidas en la tabla de comidas pedidas

            HashMap<String, Double> servicios = restaurante.getCatering().getServicios(); // Comprobamos los servicios disponibles en el restaurante

            boolean esParticular = Serializacion.esParticular(Global.USER_FILE, email);
            double descuento;
            int indice = 0;
            int rowCount = model.getRowCount();

            //Itero sobre las 
            //Itero sobre todas las columnas de cada fila para almacenar las comidas e ir sumando sus precios
            for (int row = 0; row < rowCount; row++) {
                String nombreComida = (String) model.getValueAt(row, indice);
                Comida comida = Serializacion.getComida(restaurante, nombreComida);
                comidas.add(comida);
                double precio = comida.getPrecio();
                precioTotal += precio;

            }
            //Compruebo si los servicios contratados están disponibles 
            if (servicioCocinero && disponibleCocinero) {
                precioTotal += servicios.get("Cocineros");
                serviciosSeleccionadosPorUser.put("Cocineros", 1000.0);
            }
            if (servicioCamarero && disponibleCamarero) {
                precioTotal += servicios.get("Camareros");
                serviciosSeleccionadosPorUser.put("Camareros", 800.0);
            }
            if (servicioDecoracion && disponibleDecoracion) {
                precioTotal += servicios.get("Decoración");
                serviciosSeleccionadosPorUser.put("Decoración", 500.0);
            }
            if (espacioPrivado && disponibleEspacio) {
                precioTotal += servicios.get("Espacio Privado");
                serviciosSeleccionadosPorUser.put("Espacio Privado", 1000.0);
            }

            descuento = esParticular ? 0.0 : 0.1;   // If ternario para aplicar descuento
            precioTotal += restaurante.getGastosEnvio();

            precioTotal = precioTotal - precioTotal * descuento;

            // Redondeo a decimales de el precio
            BigDecimal bd = new BigDecimal(precioTotal);
            bd = bd.setScale(2, RoundingMode.HALF_UP);

            precioTotal = bd.doubleValue();

            double resultado = bd.doubleValue();
            Venta nuevaVenta = new Venta(fechaS, restaurante, comidas, email, precioTotal, serviciosSeleccionadosPorUser);

            int opcion0 = Global.panelDecisionSN("¿Quieres finalizar y pagar el pedido? A pagar: " + precioTotal + "Є", "Finalizar pedido", Global.SI, Global.NO);
            switch (opcion0) {
                case JOptionPane.YES_OPTION -> {
                    // Formato de fecha
                    String fechaHoraActualString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss"));
                    // Biblioteca para directorio absoluto a escritorio
                    FileSystemView fsv = FileSystemView.getFileSystemView();
                    String escritorioPath = fsv.getHomeDirectory().getPath();
                    String filename = escritorioPath + "\\factura_" + fechaHoraActualString + ".txt";

                    Serializacion.anexar(Global.VENTA_FILE, nuevaVenta);

                    Serializacion.emitirFactura(nuevaVenta, precioTotal, filename);
                    Global.panelAviso("Ya tienes tu factura! Ruta: " + filename);

                    int opcion = Global.panelDecisionSN("Pedido realizado. ¿Desea continuar pidiendo?", "Continuar comprando", Global.SI, "No, salir de JavaEat");
                    switch (opcion) {
                        case JOptionPane.YES_OPTION -> {
                            
                           
                            this.dispose();
                        }

                        case JOptionPane.NO_OPTION -> {

                            System.exit(0);

                        }
                    }

                }

            }
        } else {
            Global.panelAviso("No se puede hacer pedidos vacíos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setForeground(Color.white);
        jButton1.setBackground(Color.blue);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(Global.ROSA);
        jButton1.setForeground(Color.black);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setForeground(Color.white);
        jButton2.setBackground(Color.orange);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setBackground(Global.ROSA);
        jButton2.setForeground(Color.black);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Restaurante res = Serializacion.getRestaurante(Global.RESTAURANT_FILE, nombreRestaurante);
        Global.frameJumpW(new registroOpinion(res));
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PedidoRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoRestaurante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JLabel Eat;
    private javax.swing.JLabel Java;
    private javax.swing.JButton botonExit;
    private javax.swing.JButton botonMas;
    private javax.swing.JButton botonMenos;
    private javax.swing.JLabel gdeText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel particularesTexto;
    private javax.swing.JLabel particularesTexto1;
    private javax.swing.JScrollPane scrollComida;
    private javax.swing.JScrollPane scrollComida1;
    private javax.swing.JScrollPane scrollIngredientes;
    private javax.swing.JTable tablaC;
    private javax.swing.JTable tablaC1;
    private javax.swing.JTable tablaI;
    private javax.swing.JLabel textoCantidadTotal;
    private javax.swing.JLabel textoCatering;
    private javax.swing.JLabel textoComidas1;
    private javax.swing.JLabel textoComidas2;
    private javax.swing.JLabel textoIngredientes;
    private javax.swing.JLabel tituloRestaurante;
    private javax.swing.JLabel txtE;
    // End of variables declaration//GEN-END:variables
}
