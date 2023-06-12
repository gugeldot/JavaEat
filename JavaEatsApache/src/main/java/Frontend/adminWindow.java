
package Frontend;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JOptionPane;
import Backend.Global;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Panel de control general del admin
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class adminWindow extends javax.swing.JFrame {

    int RatonX, RatonY;
    

    public adminWindow() {
        initComponents();
        Global.frameSetUp(this, 1000, 800);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BarraSuperior = new javax.swing.JPanel();
        botonExit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        botonCS = new javax.swing.JButton();
        particularesTexto = new javax.swing.JLabel();
        Eat = new javax.swing.JLabel();
        Java = new javax.swing.JLabel();
        botonUsuarios = new javax.swing.JButton();
        botonVentas = new javax.swing.JButton();
        botonRestaurantes = new javax.swing.JButton();
        particularesTexto1 = new javax.swing.JLabel();
        particularesTexto2 = new javax.swing.JLabel();
        particularesTexto3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        particularesTexto.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        particularesTexto.setForeground(new java.awt.Color(0, 0, 0));
        particularesTexto.setText("Panel Administrador");
        particularesTexto.setToolTipText("");

        Eat.setFont(new java.awt.Font("Roboto Black", 1, 35)); // NOI18N
        Eat.setForeground(new java.awt.Color(255, 51, 51));
        Eat.setText("Eat");
        Eat.setToolTipText("");

        Java.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        Java.setForeground(new java.awt.Color(0, 0, 0));
        Java.setText("Java");
        Java.setToolTipText("");

        javax.swing.GroupLayout BarraSuperiorLayout = new javax.swing.GroupLayout(BarraSuperior);
        BarraSuperior.setLayout(BarraSuperiorLayout);
        BarraSuperiorLayout.setHorizontalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(BarraSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BarraSuperiorLayout.createSequentialGroup()
                        .addComponent(botonCS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(BarraSuperiorLayout.createSequentialGroup()
                        .addComponent(particularesTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Java)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eat, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        BarraSuperiorLayout.setVerticalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BarraSuperiorLayout.createSequentialGroup()
                        .addComponent(botonCS, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Eat)
                    .addComponent(Java)
                    .addComponent(particularesTexto))
                .addContainerGap())
        );

        botonUsuarios.setBackground(new java.awt.Color(246, 238, 249));
        botonUsuarios.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        botonUsuarios.setForeground(new java.awt.Color(0, 0, 0));
        botonUsuarios.setText("Usuarios");
        botonUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonUsuariosMouseExited(evt);
            }
        });
        botonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUsuariosActionPerformed(evt);
            }
        });

        botonVentas.setBackground(new java.awt.Color(246, 238, 249));
        botonVentas.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        botonVentas.setForeground(new java.awt.Color(0, 0, 0));
        botonVentas.setText("Ventas");
        botonVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonVentasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonVentasMouseExited(evt);
            }
        });

        botonRestaurantes.setBackground(new java.awt.Color(246, 238, 249));
        botonRestaurantes.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        botonRestaurantes.setForeground(new java.awt.Color(0, 0, 0));
        botonRestaurantes.setText("Restaurante");
        botonRestaurantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonRestaurantesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonRestaurantesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonRestaurantesMouseExited(evt);
            }
        });

        particularesTexto1.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        particularesTexto1.setForeground(new java.awt.Color(0, 0, 0));
        particularesTexto1.setText("Consulta de usuarios");
        particularesTexto1.setToolTipText("");

        particularesTexto2.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        particularesTexto2.setForeground(new java.awt.Color(0, 0, 0));
        particularesTexto2.setText("Consulta de ventas");
        particularesTexto2.setToolTipText("");

        particularesTexto3.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        particularesTexto3.setForeground(new java.awt.Color(0, 0, 0));
        particularesTexto3.setText("Consulta de restaurantes");
        particularesTexto3.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(particularesTexto3)
                    .addComponent(botonRestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(particularesTexto2)
                    .addComponent(particularesTexto1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botonVentas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(particularesTexto1)
                .addGap(18, 18, 18)
                .addComponent(botonUsuarios)
                .addGap(18, 18, 18)
                .addComponent(particularesTexto3)
                .addGap(18, 18, 18)
                .addComponent(botonRestaurantes)
                .addGap(18, 18, 18)
                .addComponent(particularesTexto2)
                .addGap(18, 18, 18)
                .addComponent(botonVentas)
                .addContainerGap(196, Short.MAX_VALUE))
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
                System.out.println("");
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

    private void BarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - RatonX, y - RatonY);
    }//GEN-LAST:event_BarraSuperiorMouseDragged

    private void BarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMousePressed
        RatonX = evt.getX();
        RatonY = evt.getY();
    }//GEN-LAST:event_BarraSuperiorMousePressed

    private void botonUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUsuariosMouseClicked
        botonUsuarios.setForeground(Color.blue);
        botonVentas.setForeground(Color.BLACK);
        botonRestaurantes.setForeground(Color.BLACK);
        adminUserWindow auw = new adminUserWindow();
        auw.setVisible(true);
    }//GEN-LAST:event_botonUsuariosMouseClicked

    private void botonUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUsuariosMouseEntered

    }//GEN-LAST:event_botonUsuariosMouseEntered

    private void botonUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonUsuariosMouseExited

    }//GEN-LAST:event_botonUsuariosMouseExited

    private void botonVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVentasMouseClicked
       botonUsuarios.setForeground(Color.BLACK);
        botonVentas.setForeground(Color.blue);
        botonRestaurantes.setForeground(Color.BLACK);
        adminVentasWindow avw = new adminVentasWindow();
        avw.setVisible(true);
    }//GEN-LAST:event_botonVentasMouseClicked

    private void botonVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVentasMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botonVentasMouseEntered

    private void botonVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonVentasMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botonVentasMouseExited

    private void botonRestaurantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRestaurantesMouseClicked
        botonUsuarios.setForeground(Color.BLACK);
        botonVentas.setForeground(Color.BLACK);
        botonRestaurantes.setForeground(Color.blue);
        
        adminRestaurantesWindow arw;
        try {
            arw = new adminRestaurantesWindow();
            arw.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(adminWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botonRestaurantesMouseClicked

    private void botonRestaurantesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRestaurantesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRestaurantesMouseEntered

    private void botonRestaurantesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonRestaurantesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRestaurantesMouseExited

    private void botonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonUsuariosActionPerformed

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
            java.util.logging.Logger.getLogger(adminWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new adminWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JLabel Eat;
    private javax.swing.JLabel Java;
    private javax.swing.JButton botonCS;
    private javax.swing.JButton botonExit;
    private javax.swing.JButton botonRestaurantes;
    private javax.swing.JButton botonUsuarios;
    private javax.swing.JButton botonVentas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel particularesTexto;
    private javax.swing.JLabel particularesTexto1;
    private javax.swing.JLabel particularesTexto2;
    private javax.swing.JLabel particularesTexto3;
    // End of variables declaration//GEN-END:variables
}
