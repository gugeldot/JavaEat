package Frontend;

import Backend.Comida;
import Backend.Cliente_Empresa;
import Backend.Cliente_Particular;
import Backend.Tarjeta;
import Backend.Direccion;
import java.awt.Color;
import Backend.Global;
import Backend.Serializacion;
import Backend.Venta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 * Panel de ventas
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class adminVentasWindow extends javax.swing.JFrame {

    int RatonX, RatonY;

    public adminVentasWindow() {
        initComponents();
        Global.frameSetUp(this, 1300, 700);
        Global.setTabla(300,50, tablaCP);
        mostrar();
    }

    /**
     * Encargado de mostrar y actualizar contenido de las tablas
     */
    public void mostrar() {
        ArrayList<Venta> datos = Serializacion.cargarEnMemoriaVenta(Global.VENTA_FILE);                // Cargar en memoria usuarios

        DefaultTableModel modelC = (DefaultTableModel) tablaCP.getModel();                                     // Cargar en memoria modelo de la tabla para actualizar metiendo nueva row

        modelC.setRowCount(0);                                                                          // Limpiar de todas las rows anteriores para actualizar

        for (Venta venta : datos) {
            ArrayList<Comida> comidas = venta.getComidas();
            String comidaTxt = "";
            for (Comida comida : comidas) {
                comidaTxt += "[" + comida.getTitulo() + "] ";
            }
            HashMap<String, Double> servs = venta.getServicios();
            String sevsTxt = "";
            for (Map.Entry<String, Double> entry : servs.entrySet()) {
                String key = entry.getKey();
                sevsTxt += "[" + key + "] ";
            }
            Object[] rowData = {venta.getFechaVenta(), venta.getMail(), venta.getRestaurant().getNombre(), comidaTxt, sevsTxt, venta.getPrecioFinal() + "Є"};
            modelC.addRow(rowData);
        }

    }

    /**
     * Encargado de mostrar y actualizar contenido de las tablas
     */
    public void mostrarFiltrado(String fechaRaw) {
        ArrayList<Venta> datos = Serializacion.cargarEnMemoriaVenta(Global.VENTA_FILE);                // Cargar en memoria usuarios

        DefaultTableModel modelC = (DefaultTableModel) tablaCP.getModel();                                     // Cargar en memoria modelo de la tabla para actualizar metiendo nueva row

        modelC.setRowCount(0);                                                                          // Limpiar de todas las rows anteriores para actualizar
        //Definir formato
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime fechaFiltro = LocalDateTime.parse(fechaRaw, formatter);

        for (Venta venta : datos) {

            LocalDateTime fechaComparar = LocalDateTime.parse(venta.getFechaVenta(), formatter);
            if (fechaComparar.isAfter(fechaFiltro)) {
                ArrayList<Comida> comidas = venta.getComidas();
                String comidaTxt = "";
                for (Comida comida : comidas) {
                    comidaTxt += "[" + comida.getTitulo() + "] ";
                }
                HashMap<String, Double> servs = venta.getServicios();
                String sevsTxt = "";
                for (Map.Entry<String, Double> entry : servs.entrySet()) {
                    String key = entry.getKey();
                    sevsTxt += "[" + key + "] ";
                }
                Object[] rowData = {venta.getFechaVenta(), venta.getMail(), venta.getRestaurant().getNombre(), comidaTxt, sevsTxt, venta.getPrecioFinal() + "Є"};
                modelC.addRow(rowData);
            }

           
        }

    }
    /**
     * Booleano para confiramr que la fecha sigue un formato 
     * @param input
     * @return 
     */
    public static boolean fechaValida(String input) {
        String dateFormat = "dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);

        try {
            sdf.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Nombre = new javax.swing.JTextField();
        BarraSuperior = new javax.swing.JPanel();
        botonExit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        particularesTexto = new javax.swing.JLabel();
        Java = new javax.swing.JLabel();
        Eat = new javax.swing.JLabel();
        particularesTexto1 = new javax.swing.JLabel();
        scrollCP = new javax.swing.JScrollPane();
        tablaCP = new javax.swing.JTable();
        BotonRegistrar = new javax.swing.JButton();
        particularesTexto2 = new javax.swing.JLabel();
        particularesTexto3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 238, 249));

        Nombre.setBackground(new java.awt.Color(246, 238, 249));
        Nombre.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        Nombre.setForeground(new java.awt.Color(209, 211, 211));
        Nombre.setText("Busca a partir de una fecha");
        Nombre.setActionCommand("<Not Set>");
        Nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NombreFocusLost(evt);
            }
        });
        Nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NombreMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NombreMousePressed(evt);
            }
        });
        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });

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
        particularesTexto.setText("Ventas");
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
        particularesTexto1.setText("Panel de Ventas");
        particularesTexto1.setToolTipText("");

        javax.swing.GroupLayout BarraSuperiorLayout = new javax.swing.GroupLayout(BarraSuperior);
        BarraSuperior.setLayout(BarraSuperiorLayout);
        BarraSuperiorLayout.setHorizontalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(particularesTexto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1076, Short.MAX_VALUE)
                .addComponent(botonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1)
            .addGroup(BarraSuperiorLayout.createSequentialGroup()
                .addGap(24, 24, 24)
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
                .addGroup(BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Eat)
                    .addComponent(Java)
                    .addComponent(particularesTexto)))
        );

        tablaCP.setBackground(new java.awt.Color(234, 223, 238));
        tablaCP.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        tablaCP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Autor", "Restaurante", "Comidas", "Servicios ", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false
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

        BotonRegistrar.setBackground(new java.awt.Color(246, 238, 249));
        BotonRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        BotonRegistrar.setText("Busca!");
        BotonRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonRegistrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotonRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotonRegistrarMouseExited(evt);
            }
        });
        BotonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarActionPerformed(evt);
            }
        });

        particularesTexto2.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        particularesTexto2.setForeground(new java.awt.Color(0, 0, 0));
        particularesTexto2.setText("Tiene que seguir formato");
        particularesTexto2.setToolTipText("");

        particularesTexto3.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        particularesTexto3.setForeground(new java.awt.Color(0, 0, 0));
        particularesTexto3.setText("\"dd-MM-yyyy HH:mm:ss\"");
        particularesTexto3.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(scrollCP, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonRegistrar)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(particularesTexto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(particularesTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(79, 79, 79))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollCP, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(particularesTexto2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(particularesTexto3)
                .addGap(0, 49, Short.MAX_VALUE))
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

    private void NombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreFocusGained
        Global.cleanWrite(Nombre);
    }//GEN-LAST:event_NombreFocusGained

    private void NombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreFocusLost
        Global.deCleanWrite(Nombre, "Busca a partir de una fecha");
    }//GEN-LAST:event_NombreFocusLost

    private void NombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreMouseClicked

    private void NombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreMousePressed
        Global.cleanWrite(Nombre);
    }//GEN-LAST:event_NombreMousePressed

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        Global.cleanWrite(Nombre);
    }//GEN-LAST:event_NombreActionPerformed

    private void BotonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarActionPerformed


    }//GEN-LAST:event_BotonRegistrarActionPerformed

    private void BotonRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegistrarMouseEntered
        BotonRegistrar.setForeground(Color.white);
        BotonRegistrar.setBackground(Color.BLUE);
    }//GEN-LAST:event_BotonRegistrarMouseEntered

    private void BotonRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegistrarMouseExited
        BotonRegistrar.setBackground(Global.ROSA);
        BotonRegistrar.setForeground(Color.black);
    }//GEN-LAST:event_BotonRegistrarMouseExited

    private void BotonRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegistrarMouseClicked
        String searchRaw = Nombre.getText().trim();
        if (fechaValida(searchRaw)) {
            mostrarFiltrado(searchRaw);
        }
        else if(!searchRaw.isEmpty() && Nombre.getForeground().equals(Global.GRIS)){
            mostrar();
        }
        else{
            Global.panelAviso("Fecha de formato incorrecto!");
        }
    }//GEN-LAST:event_BotonRegistrarMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminVentasWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JButton BotonRegistrar;
    private javax.swing.JLabel Eat;
    private javax.swing.JLabel Java;
    private javax.swing.JTextField Nombre;
    private javax.swing.JButton botonExit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel particularesTexto;
    private javax.swing.JLabel particularesTexto1;
    private javax.swing.JLabel particularesTexto2;
    private javax.swing.JLabel particularesTexto3;
    private javax.swing.JScrollPane scrollCP;
    private javax.swing.JTable tablaCP;
    // End of variables declaration//GEN-END:variables
}
