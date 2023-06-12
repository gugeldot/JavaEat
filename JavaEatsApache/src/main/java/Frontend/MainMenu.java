package Frontend;

import Backend.Serializacion;
import Backend.Global;
import Backend.Direccion;
import Backend.Comida;
import Backend.Restaurante;
import Backend.Cliente_Empresa;
import Backend.Cliente_Particular;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.*;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class MainMenu extends javax.swing.JFrame {

    String CP_usuario;
    String email;
    int RatonX, RatonY;
    Cliente_Particular clientp;
    Cliente_Empresa cliente;

    public MainMenu(String mail) {
        initComponents();
        //Escalar variable para que accedan todos los metodos
        email = mail;

        Global.frameSetUp(this, 1051, 557);

        Global.setTabla(170, 50, tablaR);

        tablaR.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    // Para evitar que en una tabla se pueda hacer Ctrl+(Click a filas)

        mostrarT(tablaR, Global.RESTAURANT_FILE);

        textoDir.setText(Global.EMPTY);
        tipoE.setHorizontalAlignment(SwingConstants.RIGHT);

        String texto = (!Serializacion.esParticular(Global.USER_FILE, mail)) ? "Modo empresa" : "Modo particular";
        tipoE.setText(texto);

        ListenerMostrarDireccion();
        ListenerEntrarRestaurante();

    }

    /**
     * Muestra la dirección en una caja de texto de un restaurante seleccionado
     */
    public void ListenerMostrarDireccion() {
        tablaR.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filaR = tablaR.getSelectedRow();
                    if (filaR != -1) {
                        TableModel R = tablaR.getModel();
                        String nombreRestaurante = (String) R.getValueAt(filaR, encontrarIndice(tablaR, "Nombre"));
                        String dir = Serializacion.getRestaurante(Global.RESTAURANT_FILE, nombreRestaurante).getDireccion().toString();

                        textoDir.setText("Dirección: " + dir);
                    }

                }
            }
        });
    }

    /**
     * Al hacer doble click sobre un restaurante abre la ventana
     * {@link PedidoRestaurante}
     */
    public void ListenerEntrarRestaurante() {
        tablaR.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = tablaR.getSelectedRow();
                    if (selectedRow != -1) {
                        TableModel R = tablaR.getModel();
                        int filaR = tablaR.getSelectedRow();

                        if (filaR != -1) {
                            String nombreRestaurante = (String) R.getValueAt(filaR, encontrarIndice(tablaR, "Nombre"));
                            Global.frameJumpW(new PedidoRestaurante(nombreRestaurante, email));
                        }
                    }
                }
            }
        });
    }

    /**
     * Constructor vacio por defecto generado
     */
    private MainMenu() {
        throw new UnsupportedOperationException("Error: Arrancado sin argumentos de inicio"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Encuentra el indice de una columna según el nombre
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

    public void mostrarT(JTable table, String filename) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();                                     // Cargar en memoria modelo de la tabla para actualizar metiendo nueva row
        HashMap<String, Object> datos = Serializacion.cargarEnMemoria(filename);                            // Cargar en memoria 
        model.setRowCount(0);                                                                             // Limpiar de todas las rows anteriores para actualizar

        for (Map.Entry<String, Object> restaurante : datos.entrySet()) {                                          // Organizarlos en un set para poder iterarlos 
            //Creo 2 variables de CP: 1 almacena el CP del usuario, otra el CP del restaurante
            if (!Serializacion.esParticular(Global.USER_FILE, email)) {
                cliente = Serializacion.getClienteEmpresa(Global.USER_FILE, email);
                CP_usuario = cliente.getDireccion().getCodigoPostal().substring(0, Global.CP);
            } else {
                clientp = Serializacion.getClienteParticular(Global.USER_FILE, email);
                CP_usuario = clientp.getDireccion().getCodigoPostal().substring(0, Global.CP);
            }

            //La tabla debe mostrar unicamente aquellos restaurantes cuyos CP coincidan en los primeros 4 digitos con el CP del usuario    
            Restaurante resT = (Restaurante) restaurante.getValue();
            Direccion dRes = resT.getDireccion();
            //compruebo que los 4 primeros digitos del CP entre usuario y restaurantes coincidan
            if (CP_usuario.equals(dRes.getCodigoPostal().substring(0, 2))) {
                Object[] rowData = {resT.getNombre(), resT.getEspecialidad(), resT.getCalificacion(), resT.getGastosEnvio(), resT.getTiempoMedioEnvio(), resT.isServicioCatering()};
                model.addRow(rowData);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        scrollR = new javax.swing.JScrollPane();
        tablaR = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        button2 = new java.awt.Button();
        checkbox1 = new java.awt.Checkbox();
        textoDir = new javax.swing.JLabel();
        Java = new javax.swing.JLabel();
        Eat = new javax.swing.JLabel();
        textoComidas = new javax.swing.JLabel();
        tipoE = new javax.swing.JLabel();
        BarraSuperior = new javax.swing.JPanel();
        ExitButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        botonCS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1054, 588));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo.setBackground(new java.awt.Color(246, 238, 249));
        Fondo.setMinimumSize(new java.awt.Dimension(1054, 588));
        Fondo.setPreferredSize(new java.awt.Dimension(1054, 588));

        jPanel2.setBackground(new java.awt.Color(246, 238, 249));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        scrollR.setBackground(new java.awt.Color(246, 238, 249));

        tablaR.setBackground(new java.awt.Color(234, 223, 238));
        tablaR.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tablaR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Especialidad", "Calificación Global", "Gastos de Envío", "Tiempo de envio", "Tiene Servicio Catering"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaR.getTableHeader().setReorderingAllowed(false);
        scrollR.setViewportView(tablaR);

        jPanel2.add(scrollR);

        jPanel1.setBackground(new java.awt.Color(246, 238, 249));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTextPane1.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTextPane1.setText("¿Problemas eligiendo restaurante? Utiliza esto ->");
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane1);

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtro de busqueda", "Relevancia", "Tiempo de envio", "Servicio de catering" }));
        jComboBox1.setMinimumSize(new java.awt.Dimension(150, 30));
        jComboBox1.setPreferredSize(new java.awt.Dimension(150, 30));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);

        jPanel3.setBackground(new java.awt.Color(246, 238, 249));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 153, 51));
        jTextField2.setText("¿Que te apetece comer hoy?");
        jTextField2.setToolTipText("");
        jTextField2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField2.setMinimumSize(new java.awt.Dimension(6, 40));
        jTextField2.setPreferredSize(new java.awt.Dimension(200, 30));
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField2MousePressed(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField2);

        button2.setBackground(new java.awt.Color(255, 255, 255));
        button2.setLabel("Buscar");
        button2.setMinimumSize(new java.awt.Dimension(54, 30));
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel3.add(button2);

        checkbox1.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        checkbox1.setLabel("Servicio de catering : Sí / No");
        jPanel3.add(checkbox1);

        textoDir.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        textoDir.setForeground(new java.awt.Color(0, 0, 0));
        textoDir.setText("Dirección:");
        textoDir.setToolTipText("");

        Java.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        Java.setForeground(new java.awt.Color(0, 0, 0));
        Java.setText("Java");
        Java.setToolTipText("");

        Eat.setFont(new java.awt.Font("Roboto Black", 1, 35)); // NOI18N
        Eat.setForeground(new java.awt.Color(255, 51, 51));
        Eat.setText("Eat");
        Eat.setToolTipText("");

        textoComidas.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoComidas.setForeground(new java.awt.Color(0, 0, 0));
        textoComidas.setText("Comidas");
        textoComidas.setToolTipText("");

        tipoE.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        tipoE.setForeground(new java.awt.Color(0, 0, 0));
        tipoE.setText("tipo");
        tipoE.setToolTipText("");

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(textoDir, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201)
                        .addComponent(tipoE, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Java)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eat))))
            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FondoLayout.createSequentialGroup()
                    .addGap(490, 490, 490)
                    .addComponent(textoComidas)
                    .addContainerGap(491, Short.MAX_VALUE)))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Eat)
                    .addComponent(Java)
                    .addComponent(tipoE)
                    .addComponent(textoDir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FondoLayout.createSequentialGroup()
                    .addGap(282, 282, 282)
                    .addComponent(textoComidas)
                    .addContainerGap(282, Short.MAX_VALUE)))
        );

        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 61, 1060, 530));

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

        botonCS.setBackground(new java.awt.Color(246, 238, 249));
        botonCS.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        botonCS.setForeground(new java.awt.Color(0, 0, 0));
        botonCS.setText("Cerrar Sesión");
        botonCS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonCSMouseExited(evt);
            }
        });
        botonCS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BarraSuperiorLayout = new javax.swing.GroupLayout(BarraSuperior);
        BarraSuperior.setLayout(BarraSuperiorLayout);
        BarraSuperiorLayout.setHorizontalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonCS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 883, Short.MAX_VALUE)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        BarraSuperiorLayout.setVerticalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCS, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(BarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1057, -1));

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
        System.exit(0);
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

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        // TODO add your handling code here:
        if (jTextField2.getText().isBlank()) {
            jTextField2.setText("¿Qué te apetece comer hoy?");
        }
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        // TODO add your handling code here:
        jTextField2.setText(Global.EMPTY);
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseEntered

    private void jTextField2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField2MouseExited

    private void jTextField2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MousePressed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void botonCSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCSMouseClicked
        int opcion = Global.panelDecisionSN("¿Deseas concluir la sesión?", "Cierre de sesión", Global.SI, Global.NO);
        switch (opcion) {
            case JOptionPane.YES_OPTION: {
                try {
                    Global.frameJump(new loginInicial(), this);
                    Global.borrarConfig(Global.CONFIG_FILE);
                   
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            default:
                // El usuario cerró la ventana emergente o presionó la tecla Escape
                System.out.println(Global.EMPTY);
                break;
        }
    }//GEN-LAST:event_botonCSMouseClicked

    private void botonCSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCSMouseEntered
        botonCS.setForeground(Color.red);
    }//GEN-LAST:event_botonCSMouseEntered

    private void botonCSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCSMouseExited
        botonCS.setForeground(Color.black);
    }//GEN-LAST:event_botonCSMouseExited

    private void botonCSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCSActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botonCSActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        //Compruebo filtro de busqueda
        String comboBox = String.valueOf(jComboBox1.getSelectedItem());
        //Compruebo si el servicio de catering está marcado o no 
        boolean cateringBool = checkbox1.getState();

        String comidaBuscada = jTextField2.getText();
        DefaultTableModel model = (DefaultTableModel) tablaR.getModel();                                     // Cargar en memoria modelo de la tabla para actualizar metiendo nueva row
        HashMap<String, Object> datos = Serializacion.cargarEnMemoria(Global.RESTAURANT_FILE);                            // Cargar en memoria 
        // Limpiar de todas las rows anteriores para actualiza        
        //Convierto HashMap a ArrayList para poder operar sobre el y ordenarlo segun el interes
        ArrayList<Map.Entry<String, Object>> restaurantesCalificacion = new ArrayList<>(datos.entrySet());
        model.setRowCount(0);
        //Parte de implementación de algoritmos de búsqueda por relevancia, tiempo medio de envío, catering disponible(si/no)...

        if (cateringBool) {
            switch (comboBox) {
                case "Relevancia" -> {
                    //Llamo al metodo sort , que utiliza el metodo compare para reordenar el array a mi gusto ->en base a calificacion
                    Collections.sort(restaurantesCalificacion, new Comparator<Map.Entry<String, Object>>() {
                        @Override
                        public int compare(Map.Entry<String, Object> entry1, Map.Entry<String, Object> entry2) {
                            // Assuming "calificacion" is a Double attribute in the Object
                            Restaurante rest1 = (Restaurante) entry1.getValue();
                            Restaurante rest2 = (Restaurante) entry2.getValue();
                            Double calificacion1 = rest1.getCalificacion();
                            Double calificacion2 = rest2.getCalificacion();
                            // Sort in descending order
                            return Double.compare(calificacion2, calificacion1);
                        }
                    });
                    //Array temporal para evitar duplicados en display de restaurantes
                    ArrayList<String> restauranteSeleccionado = new ArrayList<>();
                    //Iteramos sobre los restaurantes buscando todos los que ofrezcan la comida en cuestion y los mostramos
                    for (Map.Entry<String, Object> restaurante : restaurantesCalificacion) {
                        Restaurante restaurantObj = (Restaurante) restaurante.getValue();
                        ArrayList<Comida> comidas = restaurantObj.getComidas();
                        ArrayList<String> nombresComida = new ArrayList();

                        //Ahora recortamos los nombres de las comidas, para filtrar por ellas
                        for (Comida comida : comidas) {

                            nombresComida.add(comida.getTitulo());
                        }
                        boolean cateringSiNo = restaurantObj.isServicioCatering();
                        //Recorro arraylist con bucle foreach, comparo cadena a cadena cualquier aparicion de la comida buscada en cuestion
                        Restaurante resT = (Restaurante) restaurante.getValue();
                        Direccion dRes = resT.getDireccion();
                        Object[] rowData = {resT.getNombre(), resT.getEspecialidad(), resT.getCalificacion(), resT.getGastosEnvio(), resT.getTiempoMedioEnvio(), resT.isServicioCatering()};
                        String nombreRes = resT.getNombre();
                        if (comidaBuscada.equals("¿Que te apetece comer hoy?") && cateringSiNo && !restauranteSeleccionado.contains(nombreRes)) {
                            restauranteSeleccionado.add(nombreRes);
                            model.addRow(rowData);
                        } else {
                            for (String comida : nombresComida) {

                                if (comida.toLowerCase().contains(comidaBuscada.toLowerCase()) && cateringSiNo && !restauranteSeleccionado.contains(nombreRes)) {
                                    restauranteSeleccionado.add(nombreRes);
                                    model.addRow(rowData);
                                }
                            }

                        }

                    }
                }
                case "Tiempo medio de envio" -> {
                    //Ahora preparo el array para filtro de tiempo medio de envio. Tomo el HashMap de nuevo, y aplico algoritmo con diferente atributo
                    ArrayList<Map.Entry<String, Object>> restaurantesTiempoMedio = new ArrayList<>(datos.entrySet());
                    Collections.sort(restaurantesCalificacion, new Comparator<Map.Entry<String, Object>>() {
                        @Override
                        public int compare(Map.Entry<String, Object> entry1, Map.Entry<String, Object> entry2) {

                            Restaurante rest1 = (Restaurante) entry1.getValue();
                            Restaurante rest2 = (Restaurante) entry2.getValue();
                            int calificacion1 = rest1.getTiempoMedioEnvio();
                            int calificacion2 = rest2.getTiempoMedioEnvio();
                            // Ordenar ascendente
                            return Integer.compare(calificacion1, calificacion2);
                        }
                    });
                    //Array temporal para evitar duplicados en display de restaurantes
                    ArrayList<String> restauranteSeleccionado = new ArrayList<>();
                    //Iteramos sobre los restaurantes buscando todos los que ofrezcan la comida en cuestion y los mostramos
                    for (Map.Entry<String, Object> restaurante : restaurantesTiempoMedio) {
                        Restaurante restaurantObj = (Restaurante) restaurante.getValue();
                        ArrayList<Comida> comidas = restaurantObj.getComidas();
                        ArrayList<String> nombresComida = new ArrayList();

                        //Ahora recortamos los nombres de las comidas, para filtrar por ellas
                        for (Comida comida : comidas) {
                            nombresComida.add(comida.getTitulo());
                        }
                        boolean cateringSiNo = restaurantObj.isServicioCatering();
                        //Recorro arraylist con bucle foreach, comparo cadena a cadena cualquier aparicion de la comida buscada en cuestion
                        Restaurante resT = (Restaurante) restaurante.getValue();
                        Direccion dRes = resT.getDireccion();
                        Object[] rowData = {resT.getNombre(), resT.getEspecialidad(), resT.getCalificacion(), resT.getGastosEnvio(), resT.getTiempoMedioEnvio(), resT.isServicioCatering()};
                        String nombreRes = resT.getNombre();
                        if (comidaBuscada.equals("¿Que te apetece comer hoy?") && cateringSiNo && !restauranteSeleccionado.contains(nombreRes)) {
                            restauranteSeleccionado.add(nombreRes);
                            model.addRow(rowData);
                        } else {
                            for (String comida : nombresComida) {
                                if (comida.toLowerCase().contains(comidaBuscada.toLowerCase()) && cateringSiNo && !restauranteSeleccionado.contains(nombreRes)) {
                                    restauranteSeleccionado.add(nombreRes);
                                    model.addRow(rowData);
                                }
                            }
                            ;
                        }

                    }
                }
                default -> {
                    //Array temporal para evitar duplicados en display de restaurantes
                    ArrayList<String> restauranteSeleccionado = new ArrayList<>();
                    //Iteramos sobre los restaurantes buscando todos los que ofrezcan la comida en cuestion y los mostramos
                    for (Map.Entry<String, Object> restaurante : restaurantesCalificacion) {
                        Restaurante restaurantObj = (Restaurante) restaurante.getValue();
                        ArrayList<Comida> comidas = restaurantObj.getComidas();
                        ArrayList<String> nombresComida = new ArrayList();

                        //Ahora recortamos los nombres de las comidas, para filtrar por ellas
                        for (Comida comida : comidas) {
                            nombresComida.add(comida.getTitulo());
                        }
                        //Recorro arraylist con bucle foreach, comparo cadena a cadena cualquier aparicion de la comida buscada en cuestion
                        boolean cateringSiNo = restaurantObj.isServicioCatering();
                        Restaurante resT = (Restaurante) restaurante.getValue();
                        Direccion dRes = resT.getDireccion();
                        Object[] rowData = {resT.getNombre(), resT.getEspecialidad(), resT.getCalificacion(), resT.getGastosEnvio(), resT.getTiempoMedioEnvio(), resT.isServicioCatering()};
                        String nombreRes = resT.getNombre();
                        if (comidaBuscada.equals("¿Que te apetece comer hoy?") && cateringSiNo && !restauranteSeleccionado.contains(nombreRes)) {
                            restauranteSeleccionado.add(nombreRes);
                            model.addRow(rowData);
                        } else {
                            for (String comida : nombresComida) {
                                if (comida.toLowerCase().contains(comidaBuscada.toLowerCase()) && cateringSiNo && !restauranteSeleccionado.contains(nombreRes)) {
                                    restauranteSeleccionado.add(nombreRes);
                                    model.addRow(rowData);
                                }
                            }

                        }

                    }
                }

            }

        } else {
            switch (comboBox) {
                case "Relevancia" -> {
                    //Llamo al metodo sort , que utiliza el metodo compare para reordenar el array a mi gusto ->en base a calificacion
                    Collections.sort(restaurantesCalificacion, new Comparator<Map.Entry<String, Object>>() {
                        @Override
                        public int compare(Map.Entry<String, Object> entry1, Map.Entry<String, Object> entry2) {
                            // Assuming "calificacion" is a Double attribute in the Object
                            Restaurante rest1 = (Restaurante) entry1.getValue();
                            Restaurante rest2 = (Restaurante) entry2.getValue();
                            Double calificacion1 = rest1.getCalificacion();
                            Double calificacion2 = rest2.getCalificacion();
                            // Sort in descending order
                            return Double.compare(calificacion2, calificacion1);
                        }
                    });
                    //Array temporal para evitar duplicados en display de restaurantes
                    ArrayList<String> restauranteSeleccionado = new ArrayList<>();
                    //Iteramos sobre los restaurantes buscando todos los que ofrezcan la comida en cuestion y los mostramos
                    for (Map.Entry<String, Object> restaurante : restaurantesCalificacion) {
                        Restaurante restaurantObj = (Restaurante) restaurante.getValue();
                        ArrayList<Comida> comidas = restaurantObj.getComidas();
                        ArrayList<String> nombresComida = new ArrayList();

                        //Ahora recortamos los nombres de las comidas, para filtrar por ellas
                        for (Comida comida : comidas) {

                            nombresComida.add(comida.getTitulo());
                        }
                        //Recorro arraylist con bucle foreach, comparo cadena a cadena cualquier aparicion de la comida buscada en cuestion
                        Restaurante resT = (Restaurante) restaurante.getValue();
                        Direccion dRes = resT.getDireccion();
                        Object[] rowData = {resT.getNombre(), resT.getEspecialidad(), resT.getCalificacion(), resT.getGastosEnvio(), resT.getTiempoMedioEnvio(), resT.isServicioCatering()};
                        String nombreRes = resT.getNombre();
                        if (comidaBuscada.equals("¿Que te apetece comer hoy?") && !restauranteSeleccionado.contains(nombreRes)) {
                            restauranteSeleccionado.add(nombreRes);
                            model.addRow(rowData);
                        } else {
                            for (String comida : nombresComida) {
                                if (comida.toLowerCase().contains(comidaBuscada.toLowerCase()) && !restauranteSeleccionado.contains(nombreRes)) {
                                    restauranteSeleccionado.add(nombreRes);
                                    model.addRow(rowData);
                                }
                            }

                        }

                    }
                }
                case "Tiempo medio de envio" -> {
                    //Ahora preparo el array para filtro de tiempo medio de envio. Tomo el HashMap de nuevo, y aplico algoritmo con diferente atributo
                    ArrayList<Map.Entry<String, Object>> restaurantesTiempoMedio = new ArrayList<>(datos.entrySet());
                    Collections.sort(restaurantesCalificacion, new Comparator<Map.Entry<String, Object>>() {
                        @Override
                        public int compare(Map.Entry<String, Object> entry1, Map.Entry<String, Object> entry2) {

                            Restaurante rest1 = (Restaurante) entry1.getValue();
                            Restaurante rest2 = (Restaurante) entry2.getValue();
                            int calificacion1 = rest1.getTiempoMedioEnvio();
                            int calificacion2 = rest2.getTiempoMedioEnvio();
                            // Ordenar ascendente
                            return Integer.compare(calificacion1, calificacion2);
                        }
                    });
                    //Array temporal para evitar duplicados en display de restaurantes
                    ArrayList<String> restauranteSeleccionado = new ArrayList<>();
                    //Iteramos sobre los restaurantes buscando todos los que ofrezcan la comida en cuestion y los mostramos
                    for (Map.Entry<String, Object> restaurante : restaurantesTiempoMedio) {
                        Restaurante restaurantObj = (Restaurante) restaurante.getValue();
                        ArrayList<Comida> comidas = restaurantObj.getComidas();
                        ArrayList<String> nombresComida = new ArrayList();

                        //Ahora recortamos los nombres de las comidas, para filtrar por ellas
                        for (Comida comida : comidas) {
                            nombresComida.add(comida.getTitulo());
                        }
                        Restaurante resT = (Restaurante) restaurante.getValue();
                        Direccion dRes = resT.getDireccion();
                        Object[] rowData = {resT.getNombre(), resT.getEspecialidad(), resT.getCalificacion(), resT.getGastosEnvio(), resT.getTiempoMedioEnvio(), resT.isServicioCatering()};
                        String nombreRes = resT.getNombre();
                        //Recorro arraylist con bucle foreach, comparo cadena a cadena cualquier aparicion de la comida buscada en cuestion

                        if (comidaBuscada.equals("¿Que te apetece comer hoy?") && !restauranteSeleccionado.contains(nombreRes)) {
                            restauranteSeleccionado.add(nombreRes);
                            model.addRow(rowData);
                        } else {
                            for (String comida : nombresComida) {
                                if (comida.toLowerCase().contains(comidaBuscada.toLowerCase()) && !restauranteSeleccionado.contains(nombreRes)) {
                                    restauranteSeleccionado.add(nombreRes);
                                    model.addRow(rowData);
                                }
                            }
                            ;
                        }

                    }
                }
                case "Servicio de catering" -> {
                    //Array temporal para evitar duplicados en display de restaurantes
                    ArrayList<String> restauranteSeleccionado = new ArrayList<>();
                    //Iteramos sobre los restaurantes buscando todos los que ofrezcan la comida en cuestion y los mostramos
                    for (Map.Entry<String, Object> restaurante : restaurantesCalificacion) {
                        Restaurante restaurantObj = (Restaurante) restaurante.getValue();
                        ArrayList<Comida> comidas = restaurantObj.getComidas();
                        ArrayList<String> nombresComida = new ArrayList();

                        //Ahora recortamos los nombres de las comidas, para filtrar por ellas
                        for (Comida comida : comidas) {
                            nombresComida.add(comida.getTitulo());
                        }
                        Restaurante resT = (Restaurante) restaurante.getValue();
                        Direccion dRes = resT.getDireccion();
                        Object[] rowData = {resT.getNombre(), resT.getEspecialidad(), resT.getCalificacion(), resT.getGastosEnvio(), resT.getTiempoMedioEnvio(), resT.isServicioCatering()};
                        String nombreRes = resT.getNombre();
                        //Recorro arraylist con bucle foreach, comparo cadena a cadena cualquier aparicion de la comida buscada en cuestion
                        boolean cateringSiNo = restaurantObj.isServicioCatering();
                        if (comidaBuscada.equals("¿Que te apetece comer hoy?") && cateringSiNo && !restauranteSeleccionado.contains(nombreRes)) {
                            restauranteSeleccionado.add(nombreRes);
                            model.addRow(rowData);
                        } else {
                            for (String comida : nombresComida) {
                                if (comida.toLowerCase().contains(comidaBuscada.toLowerCase()) && cateringSiNo && !restauranteSeleccionado.contains(nombreRes)) {
                                    restauranteSeleccionado.add(nombreRes);
                                    model.addRow(rowData);
                                }
                            }

                        }

                    }
                }
                default -> {
                    //Array temporal para evitar duplicados en display de restaurantes
                    ArrayList<String> restauranteSeleccionado = new ArrayList<>();
                    //Iteramos sobre los restaurantes buscando todos los que ofrezcan la comida en cuestion y los mostramos
                    for (Map.Entry<String, Object> restaurante : restaurantesCalificacion) {
                        Restaurante restaurantObj = (Restaurante) restaurante.getValue();
                        ArrayList<Comida> comidas = restaurantObj.getComidas();
                        ArrayList<String> nombresComida = new ArrayList();

                        //Ahora recortamos los nombres de las comidas, para filtrar por ellas
                        for (Comida comida : comidas) {
                            nombresComida.add(comida.getTitulo());
                        }
                        //Recorro arraylist con bucle foreach, comparo cadena a cadena cualquier aparicion de la comida buscada en cuestion
                        Restaurante resT = (Restaurante) restaurante.getValue();
                        Direccion dRes = resT.getDireccion();
                        Object[] rowData = {resT.getNombre(), resT.getEspecialidad(), resT.getCalificacion(), resT.getGastosEnvio(), resT.getTiempoMedioEnvio(), resT.isServicioCatering()};
                        String nombreRes = resT.getNombre();
                        if (comidaBuscada.equals("¿Que te apetece comer hoy?") && !restauranteSeleccionado.contains(nombreRes)) {
                            restauranteSeleccionado.add(nombreRes);
                            model.addRow(rowData);
                        } else {
                            for (String comida : nombresComida) {
                                if (comida.toLowerCase().contains(comidaBuscada.toLowerCase()) && !restauranteSeleccionado.contains(nombreRes)) {
                                    restauranteSeleccionado.add(nombreRes);
                                    model.addRow(rowData);
                                }
                            }

                        }

                    }
                }
            }
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JLabel Eat;
    private javax.swing.JButton ExitButton;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Java;
    private javax.swing.JButton botonCS;
    private java.awt.Button button2;
    private java.awt.Checkbox checkbox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JScrollPane scrollR;
    private javax.swing.JTable tablaR;
    private javax.swing.JLabel textoComidas;
    private javax.swing.JLabel textoDir;
    private javax.swing.JLabel tipoE;
    // End of variables declaration//GEN-END:variables
/**
     * Utilizado para convertir hashmap a arraylist
     *
     * @param <K>
     * @param <V>
     */
    class Pair<K, V> {

        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
