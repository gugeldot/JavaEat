package Frontend;

import Backend.Serializacion;
import Backend.Global;
import Backend.Usuario;
import Backend.Comida;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Registro de comidas para nuevo restaurante
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class MiniRegistroRestaurante extends javax.swing.JFrame {

    int RatonX, RatonY;
    boolean particular;
    Usuario usuario;
    int filasDisponibles;
    ArrayList<String> ingredientes = new ArrayList<String>();
    Comida comida;

    public MiniRegistroRestaurante() {
        initComponents();
        Global.frameSetUp(this, 500, 300);

        BotonRegistrar.requestFocus();// Focus en boton de registrar (Mejora experiencia UI)

    }

    public static void deCleanWriteMOD(JTextField ventana, String text) {
        Color cf = ventana.getForeground();
        ventana.setText(text);
        ventana.setForeground(Global.GRIS);
    }
    
    /**
     * Mismo concepto que que {@link FormularioCreacionRestaurante#vaciarWindow()}
     */
    public void vaciarWindow() {
        deCleanWriteMOD(rellenarNombre, "Nombre");
        deCleanWriteMOD(rellenarPrecio, "Precio");
        deCleanWriteMOD(rellenarRuta, "Ruta");
        DefaultTableModel model = (DefaultTableModel) tablaIngredientes.getModel();
        model.setRowCount(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BarraSuperior = new javax.swing.JPanel();
        ExitButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Java = new javax.swing.JLabel();
        Eat = new javax.swing.JLabel();
        textoNombre = new javax.swing.JLabel();
        rellenarNombre = new javax.swing.JTextField();
        BotonRegistrar = new javax.swing.JButton();
        BotonLimpiar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        botonMas = new javax.swing.JButton();
        botonMenos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        textoPrecio = new javax.swing.JLabel();
        rellenarPrecio = new javax.swing.JTextField();
        textoruta = new javax.swing.JLabel();
        rellenarRuta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 300));
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        BarraSuperiorLayout.setVerticalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Java.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        Java.setForeground(new java.awt.Color(0, 0, 0));
        Java.setText("Java");
        Java.setToolTipText("");

        Eat.setFont(new java.awt.Font("Roboto Black", 1, 35)); // NOI18N
        Eat.setForeground(new java.awt.Color(255, 51, 51));
        Eat.setText("Eat");
        Eat.setToolTipText("");

        textoNombre.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoNombre.setForeground(new java.awt.Color(0, 0, 0));
        textoNombre.setText("Nombre Comida");
        textoNombre.setToolTipText("");

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

        BotonLimpiar1.setBackground(new java.awt.Color(246, 238, 249));
        BotonLimpiar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonLimpiar1.setForeground(new java.awt.Color(0, 0, 0));
        BotonLimpiar1.setText("Limpiar");
        BotonLimpiar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotonLimpiar1MouseClicked(evt);
            }
        });
        BotonLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLimpiar1ActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

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
        jPanel2.add(botonMas);

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
        jPanel2.add(botonMenos);

        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingredientes"
            }
        ));
        tablaIngredientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaIngredientes);

        textoPrecio.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoPrecio.setForeground(new java.awt.Color(0, 0, 0));
        textoPrecio.setText("Precio");
        textoPrecio.setToolTipText("");

        rellenarPrecio.setBackground(new java.awt.Color(246, 238, 249));
        rellenarPrecio.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        rellenarPrecio.setForeground(new java.awt.Color(209, 211, 211));
        rellenarPrecio.setText("Precio");
        rellenarPrecio.setActionCommand("<Not Set>");
        rellenarPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rellenarPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rellenarPrecioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rellenarPrecioFocusLost(evt);
            }
        });
        rellenarPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rellenarPrecioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rellenarPrecioMousePressed(evt);
            }
        });
        rellenarPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rellenarPrecioActionPerformed(evt);
            }
        });

        textoruta.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoruta.setForeground(new java.awt.Color(0, 0, 0));
        textoruta.setText("Ruta foto");
        textoruta.setToolTipText("");

        rellenarRuta.setBackground(new java.awt.Color(246, 238, 249));
        rellenarRuta.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        rellenarRuta.setForeground(new java.awt.Color(209, 211, 211));
        rellenarRuta.setText("Ruta");
        rellenarRuta.setActionCommand("<Not Set>");
        rellenarRuta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rellenarRuta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rellenarRutaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rellenarRutaFocusLost(evt);
            }
        });
        rellenarRuta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rellenarRutaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rellenarRutaMousePressed(evt);
            }
        });
        rellenarRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rellenarRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rellenarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rellenarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Java)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eat, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(BotonLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(textoruta, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rellenarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Eat)
                                .addComponent(Java))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textoNombre)
                                    .addComponent(rellenarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textoPrecio)
                                    .addComponent(rellenarPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoruta)
                            .addComponent(rellenarRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void BotonRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegistrarMouseClicked
        String nombreTxt = rellenarNombre.getText().trim();
        String precioTxt = rellenarPrecio.getText().trim();
        String rutaTxt = rellenarRuta.getText().trim();
        int rowNumero = tablaIngredientes.getRowCount();

        boolean cNombre = !nombreTxt.isEmpty() && !rellenarNombre.getForeground().equals(Global.GRIS);                                          //Esta relleno  (puede llamarse cualquier cosa)
        boolean cPrecio = precioTxt.matches("\\d*\\.?\\d+") && !precioTxt.matches("^-.*");                                               // Es un numero que puede ser double y no negativo
        boolean cRuta = !rutaTxt.isEmpty() && !rellenarRuta.getForeground().equals(Global.GRIS);                                             //Esta relleno  (puede llamarse cualquier cosa)
        boolean cRow = (rowNumero > 0);

        boolean check = cNombre && cPrecio && cRuta && cRow;

        if (check) {

            for (int row = 0; row < rowNumero; row++) {
                String nombreIngrediente = (String) tablaIngredientes.getValueAt(row, 0);
                ingredientes.add(nombreIngrediente);
            }

            comida = new Comida(nombreTxt, ingredientes, Double.parseDouble(precioTxt), rutaTxt);

            Serializacion.anexar(Global.FOOD_FILE, comida);
            this.dispose();

        } else {
            Global.panelAviso("Faltan datos por rellenar o no cumplen con las condiciones normales");
        }


    }//GEN-LAST:event_BotonRegistrarMouseClicked

    private void BotonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarActionPerformed

    }//GEN-LAST:event_BotonRegistrarActionPerformed

    private void BotonLimpiar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLimpiar1MouseClicked
        rellenarNombre.setText(Global.EMPTY);
        rellenarPrecio.setText(Global.EMPTY);
        rellenarRuta.setText(Global.EMPTY);
        DefaultTableModel model = (DefaultTableModel) tablaIngredientes.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_BotonLimpiar1MouseClicked

    private void BotonLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonLimpiar1ActionPerformed

    private void botonMasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasMouseClicked
        DefaultTableModel model = (DefaultTableModel) tablaIngredientes.getModel();
        filasDisponibles = model.getRowCount();
        Object[] rowData = {"Nombre del ingrediente (EDITAR)"};
        model.addRow(rowData);
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
    }//GEN-LAST:event_botonMasActionPerformed

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

    private void botonMenosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMenosMouseClicked
        DefaultTableModel model = (DefaultTableModel) tablaIngredientes.getModel();
        filasDisponibles = model.getRowCount();
        if (filasDisponibles > 0) {
            model.setRowCount(filasDisponibles - 1);
        }

    }//GEN-LAST:event_botonMenosMouseClicked

    private void rellenarPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarPrecioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rellenarPrecioMouseClicked

    private void rellenarPrecioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarPrecioMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_rellenarPrecioMousePressed

    private void rellenarPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rellenarPrecioActionPerformed

    }//GEN-LAST:event_rellenarPrecioActionPerformed

    private void rellenarRutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarRutaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rellenarRutaMouseClicked

    private void rellenarRutaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rellenarRutaMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_rellenarRutaMousePressed

    private void rellenarRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rellenarRutaActionPerformed
        Global.cleanWrite(rellenarRuta);
    }//GEN-LAST:event_rellenarRutaActionPerformed

    private void rellenarNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarNombreFocusGained
        Global.cleanWrite(rellenarNombre);
    }//GEN-LAST:event_rellenarNombreFocusGained

    private void rellenarNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarNombreFocusLost
        Global.deCleanWrite(rellenarNombre, "Nombre");
    }//GEN-LAST:event_rellenarNombreFocusLost

    private void rellenarPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarPrecioFocusGained
        Global.cleanWrite(rellenarPrecio);
    }//GEN-LAST:event_rellenarPrecioFocusGained

    private void rellenarPrecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarPrecioFocusLost
        Global.deCleanWrite(rellenarPrecio, "Precio");
    }//GEN-LAST:event_rellenarPrecioFocusLost

    private void rellenarRutaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarRutaFocusGained
        Global.cleanWrite(rellenarRuta);
    }//GEN-LAST:event_rellenarRutaFocusGained

    private void rellenarRutaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rellenarRutaFocusLost
        Global.deCleanWrite(rellenarRuta, "Ruta");
    }//GEN-LAST:event_rellenarRutaFocusLost

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
            java.util.logging.Logger.getLogger(MiniRegistroRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiniRegistroRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiniRegistroRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiniRegistroRestaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniRegistroRestaurante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JButton BotonLimpiar1;
    private javax.swing.JButton BotonRegistrar;
    private javax.swing.JLabel Eat;
    private javax.swing.JButton ExitButton;
    private javax.swing.JLabel Java;
    private javax.swing.JButton botonMas;
    private javax.swing.JButton botonMenos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField rellenarNombre;
    private javax.swing.JTextField rellenarPrecio;
    private javax.swing.JTextField rellenarRuta;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel textoPrecio;
    private javax.swing.JLabel textoruta;
    // End of variables declaration//GEN-END:variables
}
