package Frontend;

import Backend.Serializacion;
import Backend.Global;
import Backend.Direccion;
import Backend.Cliente_Empresa;
import Backend.Cliente_Particular;
import java.awt.Color;
import Backend.Tarjeta;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 * Panel Usuarios por admin
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class adminUserWindow extends javax.swing.JFrame {

    int RatonX, RatonY;

    boolean seleccionandoTabla1 = false;
    /**
     * Setup del Jframe, incluye listeners para las tablas
     */
    public adminUserWindow() {
        initComponents();
        Global.frameSetUp(this, 800, 700);

        Global.setTabla(200, tablaCP);
        Global.setTabla(200, tablaCE);

        mostrar();                                       //Rellenar tabla particulares 

        // De aqui para abajo es un listener para que no se seleccionen una fila de cada una de las tablas a la vez y asi borrar solo un usuario a la vez
        tablaCP.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    // Para evitar que en una tabla se pueda hacer Ctrl+(Click a filas)
        tablaCE.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ListSelectionModel modeloSeleccion1 = tablaCP.getSelectionModel();
        ListSelectionModel modeloSeleccion2 = tablaCE.getSelectionModel();

        modeloSeleccion1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                // Verificar si la selección ha cambiado y si no se está seleccionando la tabla2
                //getValueIsADjusting rompe cuando hay mas de una tabla. Añadimos booleano extra para mantener consistencia (seleccion en una tabla evita seleccion en otra)
                if (!e.getValueIsAdjusting() && !seleccionandoTabla1) {
                    // Deseleccionar la tabla2
                    modeloSeleccion2.clearSelection();
                    seleccionandoTabla1 = true;
                }
            }
        });

        modeloSeleccion2.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                // Verificar si la selección ha cambiado y si no se está seleccionando la tabla1
                if (!e.getValueIsAdjusting() && seleccionandoTabla1) {
                    // Deseleccionar la tabla1
                    modeloSeleccion1.clearSelection();
                    seleccionandoTabla1 = false;
                }
            }
        });

    }
    /**
     * Encargado de mostrar y actualizar contenido de las tablas
     */
    public void mostrar() {
        HashMap<String, Object> datos = Serializacion.cargarEnMemoria(Global.USER_FILE);                // Cargar en memoria usuarios

        DefaultTableModel modelC = (DefaultTableModel) tablaCP.getModel();                                     // Cargar en memoria modelo de la tabla para actualizar metiendo nueva row
        DefaultTableModel modelE = (DefaultTableModel) tablaCE.getModel();

        modelC.setRowCount(0);                                                                          // Limpiar de todas las rows anteriores para actualizar
        modelE.setRowCount(0);

        for (Map.Entry<String, Object> usuario : datos.entrySet()) {                                          // Organizarlos en un set para poder iterarlos 
            String quienEs = String.valueOf(usuario.getKey().charAt(usuario.getKey().length() - 1));        // Saber su caracter especial (P o E) recortando ultimo char de la key -> Serializacion.creadorKey
            if (quienEs.equals("P")) {
                Cliente_Particular cp = (Cliente_Particular) usuario.getValue();                              //Convertir usuario a Cliente_Particular para aplicar sus métodos
                Direccion d = cp.getDireccion();                                                              //Necesitabamos la conversion para los atributos diferenciadores de clientes
                Tarjeta t = cp.getTarjetaCredito();
                Object[] rowData = {cp.getNombre(), cp.getMail(), cp.getClave(), d.getCalle(), d.getNumero(), d.getCodigoPostal(), d.getCiudad(), t.getTitular(), t.getNumero(), t.getCaducidad(), cp.getTelefono(), cp.getDNI()};
                modelC.addRow(rowData);
            } else {  // Equivalente quienEs.equals("E")
                Cliente_Empresa cp = (Cliente_Empresa) usuario.getValue();
                Direccion d = cp.getDireccion();
                Tarjeta t = cp.getTarjetaCredito();
                Object[] rowData = {cp.getNombre(), cp.getMail(), cp.getClave(), d.getCalle(), d.getNumero(), d.getCodigoPostal(), d.getCiudad(), t.getTitular(), t.getNumero(), t.getCaducidad(), cp.getTelefono(), cp.getCif(), cp.getWeb()};
                modelE.addRow(rowData);
            }
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
        Java = new javax.swing.JLabel();
        Eat = new javax.swing.JLabel();
        particularesTexto1 = new javax.swing.JLabel();
        scrollCP = new javax.swing.JScrollPane();
        tablaCP = new javax.swing.JTable();
        scrollCE = new javax.swing.JScrollPane();
        tablaCE = new javax.swing.JTable();
        empresasTexto = new javax.swing.JLabel();
        botonBorrar = new javax.swing.JButton();
        botonClean = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 238, 249));

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
        particularesTexto.setText("Particulares");
        particularesTexto.setToolTipText("");

        Java.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        Java.setForeground(new java.awt.Color(0, 0, 0));
        Java.setText("Java");
        Java.setToolTipText("");

        Eat.setFont(new java.awt.Font("Roboto Black", 1, 35)); // NOI18N
        Eat.setForeground(new java.awt.Color(255, 51, 51));
        Eat.setText("Eat");
        Eat.setToolTipText("");

        particularesTexto1.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        particularesTexto1.setForeground(new java.awt.Color(0, 0, 0));
        particularesTexto1.setText("Panel de Usuario");
        particularesTexto1.setToolTipText("");

        javax.swing.GroupLayout BarraSuperiorLayout = new javax.swing.GroupLayout(BarraSuperior);
        BarraSuperior.setLayout(BarraSuperiorLayout);
        BarraSuperiorLayout.setHorizontalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(particularesTexto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1)
            .addGroup(BarraSuperiorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(particularesTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Java)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Eat, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
                .addGroup(BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(particularesTexto)
                    .addGroup(BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Eat)
                        .addComponent(Java))))
        );

        tablaCP.setBackground(new java.awt.Color(234, 223, 238));
        tablaCP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Mail", "Clave", "Calle", "Número", "Código Postal", "Ciudad", "Titular [Tarjeta]", "Número  [Tarjeta]", "Fecha Caducidad  [Tarjeta]", "Teléfono", "DNI"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCP.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaCP.getTableHeader().setReorderingAllowed(false);
        scrollCP.setViewportView(tablaCP);

        tablaCE.setBackground(new java.awt.Color(234, 223, 238));
        tablaCE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Mail", "Clave", "Calle", "Número", "Código Postal", "Ciudad", "Titular [Tarjeta]", "Número  [Tarjeta]", "Fecha Caducidad  [Tarjeta]", "Teléfono", "CIF", "Web"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCE.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaCE.getTableHeader().setReorderingAllowed(false);
        scrollCE.setViewportView(tablaCE);

        empresasTexto.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        empresasTexto.setForeground(new java.awt.Color(0, 0, 0));
        empresasTexto.setText("Empresas");
        empresasTexto.setToolTipText("");

        botonBorrar.setBackground(new java.awt.Color(246, 238, 249));
        botonBorrar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        botonBorrar.setForeground(new java.awt.Color(0, 0, 0));
        botonBorrar.setText("Borrar  Seleccionado");
        botonBorrar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                botonBorrarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                botonBorrarFocusLost(evt);
            }
        });
        botonBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBorrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonBorrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonBorrarMouseExited(evt);
            }
        });
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonClean.setBackground(new java.awt.Color(246, 238, 249));
        botonClean.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        botonClean.setForeground(new java.awt.Color(0, 0, 0));
        botonClean.setText("Limpiar selección");
        botonClean.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                botonCleanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                botonCleanFocusLost(evt);
            }
        });
        botonClean.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCleanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCleanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonCleanMouseExited(evt);
            }
        });
        botonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(empresasTexto)
                            .addComponent(scrollCP, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonClean, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollCE, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollCP, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(empresasTexto)
                .addGap(18, 18, 18)
                .addComponent(scrollCE, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBorrar)
                    .addComponent(botonClean))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

        botonExit.setBackground(Global.ROSA);
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
   /**
    * Borrar usuario
    * @param mail 
    */
    public void borrado(String mail) {
        int opcion = Global.panelDecisionSN("¿Deseas borrar al usuario " + mail + "?", "Borrado de usuario", Global.SI, Global.NO);
        switch (opcion) {
            case JOptionPane.YES_OPTION: {
                Serializacion.borrarUsuario(Global.USER_FILE, mail);
                break;
            }
            default:
                break;
        }
    }
    /**
    *
    * 
    * 
    */
    private void botonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBorrarMouseClicked
        int filaCP = tablaCP.getSelectedRow();
        int filaCE = tablaCE.getSelectedRow();
        String mail;
            
        if (filaCP != -1 || filaCE != -1) {
            if (filaCE == -1) { //  = Seleccion en fila CP
                TableModel cp = tablaCP.getModel();
                mail = (String) cp.getValueAt(filaCP, 1);

            } else {           // = Seleccion en fila CE
                TableModel ce = tablaCE.getModel();
                mail = (String) ce.getValueAt(filaCE, 1);

            }
            
            if (!mail.equals("admin@javaeat.com")) {
                borrado(mail);
                mostrar();
            } else {
                Global.panelAviso("No se puede borrar a un administrador");

            }
        }


    }//GEN-LAST:event_botonBorrarMouseClicked

    private void botonBorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBorrarMouseEntered
        botonBorrar.setForeground(Color.white);
        botonBorrar.setBackground(Color.red);
    }//GEN-LAST:event_botonBorrarMouseEntered

    private void botonBorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBorrarMouseExited
        botonBorrar.setBackground(Global.ROSA);
        botonBorrar.setForeground(Color.black);
    }//GEN-LAST:event_botonBorrarMouseExited

    private void botonBorrarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonBorrarFocusGained

    }//GEN-LAST:event_botonBorrarFocusGained

    private void botonBorrarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonBorrarFocusLost

    }//GEN-LAST:event_botonBorrarFocusLost

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonCleanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonCleanFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCleanFocusGained

    private void botonCleanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonCleanFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCleanFocusLost

    private void botonCleanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCleanMouseClicked
        tablaCP.clearSelection();
        tablaCE.clearSelection();
    }//GEN-LAST:event_botonCleanMouseClicked

    private void botonCleanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCleanMouseEntered
        botonClean.setForeground(Color.white);
        botonClean.setBackground(Color.red);
    }//GEN-LAST:event_botonCleanMouseEntered

    private void botonCleanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCleanMouseExited
        botonClean.setBackground(Global.ROSA);
        botonClean.setForeground(Color.black);
    }//GEN-LAST:event_botonCleanMouseExited

    private void botonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCleanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCleanActionPerformed

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
            java.util.logging.Logger.getLogger(adminUserWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminUserWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminUserWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminUserWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminUserWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JLabel Eat;
    private javax.swing.JLabel Java;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonClean;
    private javax.swing.JButton botonExit;
    private javax.swing.JLabel empresasTexto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel particularesTexto;
    private javax.swing.JLabel particularesTexto1;
    private javax.swing.JScrollPane scrollCE;
    private javax.swing.JScrollPane scrollCP;
    private javax.swing.JTable tablaCE;
    private javax.swing.JTable tablaCP;
    // End of variables declaration//GEN-END:variables
}
