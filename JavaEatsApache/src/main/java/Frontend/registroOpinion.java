package Frontend;

import Backend.Serializacion;
import Backend.Global;
import Backend.Opinion;
import Backend.Restaurante;
import java.awt.Color;

/**
 * Ventana de registro de opinioón
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class registroOpinion extends javax.swing.JFrame {
    
    int RatonX, RatonY;
    int puntuacion = 0;
    Restaurante restaurante; 
    public registroOpinion(Restaurante res) {
        restaurante = res;
        initComponents();
        Global.frameSetUp(this, 500, 300);
        mostrarPuntuacion();
    }
    
    /**
     * Constructor vacio default
     */
    private registroOpinion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * masPuntuacion -> aumenta la puntuacion con el boton contador
     */
    public void masPuntuacion() {
        if (puntuacion < 5) {
            puntuacion++;
        }
    }
    /**
     * menosPuntuacion -> disminuye la puntuacion con el boton contador
     */
    public void menosPuntuacion() {
        if (puntuacion > 0) {
            puntuacion--;
        }
    }
    
    public void mostrarPuntuacion() {
        dniTexto1.setText(Integer.toString(puntuacion));
    }

    public void setPuntuacion(int n) {
        puntuacion = n;
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
        dniTexto = new javax.swing.JLabel();
        cifTexto = new javax.swing.JLabel();
        cifCampo = new javax.swing.JTextField();
        BotonRegistrar = new javax.swing.JButton();
        BotonLimpiar1 = new javax.swing.JButton();
        dniTexto1 = new javax.swing.JLabel();
        botonMas = new javax.swing.JButton();
        botonMas1 = new javax.swing.JButton();

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
                .addContainerGap(444, Short.MAX_VALUE)
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

        dniTexto.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        dniTexto.setForeground(new java.awt.Color(0, 0, 0));
        dniTexto.setText("Puntuación");
        dniTexto.setToolTipText("");

        cifTexto.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        cifTexto.setForeground(new java.awt.Color(0, 0, 0));
        cifTexto.setText("Pequeña reseña");
        cifTexto.setToolTipText("");

        cifCampo.setBackground(new java.awt.Color(246, 238, 249));
        cifCampo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        cifCampo.setForeground(new java.awt.Color(209, 211, 211));
        cifCampo.setText("Comentario (Opcional)");
        cifCampo.setActionCommand("<Not Set>");
        cifCampo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cifCampo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cifCampoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cifCampoFocusLost(evt);
            }
        });
        cifCampo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cifCampoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cifCampoMousePressed(evt);
            }
        });
        cifCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cifCampoActionPerformed(evt);
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

        dniTexto1.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        dniTexto1.setForeground(new java.awt.Color(0, 0, 0));
        dniTexto1.setText("n");
        dniTexto1.setToolTipText("");

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

        botonMas1.setBackground(new java.awt.Color(246, 238, 249));
        botonMas1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        botonMas1.setForeground(new java.awt.Color(0, 0, 0));
        botonMas1.setText("-");
        botonMas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonMas1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonMas1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonMas1MouseExited(evt);
            }
        });
        botonMas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(dniTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(botonMas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dniTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonMas1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Java))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cifTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(221, 221, 221)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eat, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cifCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Eat)
                    .addComponent(Java)
                    .addComponent(dniTexto)
                    .addComponent(botonMas)
                    .addComponent(dniTexto1)
                    .addComponent(botonMas1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cifTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cifCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(210, 210, 210))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void cifCampoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cifCampoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cifCampoMouseClicked

    private void cifCampoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cifCampoMousePressed
        Global.cleanWrite(cifCampo);
    }//GEN-LAST:event_cifCampoMousePressed

    private void cifCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cifCampoActionPerformed
        Global.cleanWrite(cifCampo);
    }//GEN-LAST:event_cifCampoActionPerformed

    private void BotonRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegistrarMouseClicked

    }//GEN-LAST:event_BotonRegistrarMouseClicked

    private void BotonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarActionPerformed
        String comment = (!cifCampo.getText().isEmpty() && cifCampo.getForeground().equals(Global.GRIS))? Global.EMPTY : cifCampo.getText();
        restaurante.addOpinion(new Opinion(puntuacion,comment));
        Serializacion.anexar(Global.RESTAURANT_FILE, restaurante);
        Global.panelAviso("Opinión publicada\nGracias por el feedback!");
        this.dispose();
    }//GEN-LAST:event_BotonRegistrarActionPerformed

    private void BotonLimpiar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLimpiar1MouseClicked
        setPuntuacion(0);
        mostrarPuntuacion();
        cifCampo.setText(Global.EMPTY);
    }//GEN-LAST:event_BotonLimpiar1MouseClicked

    private void BotonLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonLimpiar1ActionPerformed

    private void botonMasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMasMouseClicked
        masPuntuacion();
        mostrarPuntuacion();
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
        

    }//GEN-LAST:event_botonMasActionPerformed

    private void botonMas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMas1MouseClicked
        menosPuntuacion();
        mostrarPuntuacion();
    }//GEN-LAST:event_botonMas1MouseClicked

    private void botonMas1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMas1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMas1MouseEntered

    private void botonMas1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonMas1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMas1MouseExited

    private void botonMas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMas1ActionPerformed

    private void cifCampoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cifCampoFocusLost
        Global.deCleanWrite(cifCampo, "Comentario (Opcional)");
    }//GEN-LAST:event_cifCampoFocusLost

    private void cifCampoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cifCampoFocusGained
       Global.cleanWrite(cifCampo);
    }//GEN-LAST:event_cifCampoFocusGained

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
            java.util.logging.Logger.getLogger(registroOpinion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroOpinion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroOpinion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroOpinion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroOpinion().setVisible(true);
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
    private javax.swing.JButton botonMas1;
    private javax.swing.JTextField cifCampo;
    private javax.swing.JLabel cifTexto;
    private javax.swing.JLabel dniTexto;
    private javax.swing.JLabel dniTexto1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
