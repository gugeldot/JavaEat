package Frontend;

import Backend.Serializacion;
import Backend.Global;
import Backend.Cliente_Particular;
import Backend.Cliente_Empresa;
import Backend.Usuario;
import java.awt.Color;

/**
 * MiniRegistro de usuario como empresa o particular
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class MiniRegistro extends javax.swing.JFrame {

    int RatonX, RatonY;
    boolean particular;
    Usuario usuario;
    
    
    public MiniRegistro(boolean esParticular, Usuario user) {
        initComponents();
        Global.frameSetUp(this, 500, 300);

        BotonRegistrar.requestFocus();// Focus en boton de registrar (Mejora experiencia UI)

        particular = esParticular;      // Escalar las dos variables accesibles al resto de la clase
        usuario = user;
        /**
         * Dependiendo de si el usuario va a ser particular o empresa se muestran unas cosas u otras
         */
        if (esParticular) {                      // Adecuacion campos a ingresar
            cifTexto.setVisible(false);
            cifCampo.setVisible(false);
            webTexto.setVisible(false);
            webCampo.setVisible(false);
        } else {
            dniTexto.setVisible(false);
            dniCampo.setVisible(false);
        }
    }
    /**
     * Constructor vacio por defecto generado
     */
    private MiniRegistro() {
        throw new UnsupportedOperationException("Error: Arrancado sin argumentos de inicio"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        dniCampo = new javax.swing.JTextField();
        cifTexto = new javax.swing.JLabel();
        cifCampo = new javax.swing.JTextField();
        webTexto = new javax.swing.JLabel();
        webCampo = new javax.swing.JTextField();
        BotonRegistrar = new javax.swing.JButton();
        BotonLimpiar1 = new javax.swing.JButton();

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
        dniTexto.setText("DNI");
        dniTexto.setToolTipText("");

        dniCampo.setBackground(new java.awt.Color(246, 238, 249));
        dniCampo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        dniCampo.setForeground(new java.awt.Color(209, 211, 211));
        dniCampo.setText("DNI");
        dniCampo.setActionCommand("<Not Set>");
        dniCampo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        dniCampo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dniCampoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dniCampoMousePressed(evt);
            }
        });
        dniCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniCampoActionPerformed(evt);
            }
        });

        cifTexto.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        cifTexto.setForeground(new java.awt.Color(0, 0, 0));
        cifTexto.setText("CIF");
        cifTexto.setToolTipText("");

        cifCampo.setBackground(new java.awt.Color(246, 238, 249));
        cifCampo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        cifCampo.setForeground(new java.awt.Color(209, 211, 211));
        cifCampo.setText("CIF");
        cifCampo.setActionCommand("<Not Set>");
        cifCampo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        webTexto.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        webTexto.setForeground(new java.awt.Color(0, 0, 0));
        webTexto.setText("Web");
        webTexto.setToolTipText("");

        webCampo.setBackground(new java.awt.Color(246, 238, 249));
        webCampo.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        webCampo.setForeground(new java.awt.Color(209, 211, 211));
        webCampo.setText("Web");
        webCampo.setActionCommand("<Not Set>");
        webCampo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        webCampo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                webCampoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                webCampoMousePressed(evt);
            }
        });
        webCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                webCampoActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Java))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dniTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dniCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(webTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(webCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cifTexto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cifCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Eat, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Eat)
                    .addComponent(Java))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dniTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dniCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cifTexto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cifCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(webTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(webCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(194, 194, 194))
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

    private void dniCampoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dniCampoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dniCampoMouseClicked

    private void dniCampoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dniCampoMousePressed
        Global.cleanWrite(dniCampo);
    }//GEN-LAST:event_dniCampoMousePressed

    private void dniCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniCampoActionPerformed
        Global.cleanWrite(dniCampo);
    }//GEN-LAST:event_dniCampoActionPerformed

    private void cifCampoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cifCampoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cifCampoMouseClicked

    private void cifCampoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cifCampoMousePressed
        Global.cleanWrite(cifCampo);
    }//GEN-LAST:event_cifCampoMousePressed

    private void cifCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cifCampoActionPerformed
        Global.cleanWrite(cifCampo);
    }//GEN-LAST:event_cifCampoActionPerformed

    private void webCampoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webCampoMouseClicked

    }//GEN-LAST:event_webCampoMouseClicked

    private void webCampoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webCampoMousePressed
        Global.cleanWrite(webCampo);
    }//GEN-LAST:event_webCampoMousePressed

    private void webCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_webCampoActionPerformed
        Global.cleanWrite(webCampo);
    }//GEN-LAST:event_webCampoActionPerformed

    private void BotonRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonRegistrarMouseClicked

    }//GEN-LAST:event_BotonRegistrarMouseClicked

    private void BotonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarActionPerformed
        if (particular) {
            try {
                String dniTxt = dniCampo.getText();
                boolean cdni = Global.dniValido(dniTxt);
                if (cdni) {
                    Cliente_Particular cP = new Cliente_Particular(usuario, dniTxt);
                    Serializacion.anexar(Global.USER_FILE, cP);
                    this.dispose();
                } else {
                    Global.panelAviso("DNI no valido");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                String cifTxt = cifCampo.getText();
                String webTxt = webCampo.getText();
                boolean cCif = Global.cifValido(cifTxt);
                boolean cWeb = webTxt.matches(".+\\..+");
                if (cCif && cWeb){
                    Cliente_Empresa cE = new Cliente_Empresa(usuario, cifTxt, webTxt);
                    Serializacion.anexar(Global.USER_FILE, cE);
                    this.dispose();
                }
                else{
                    Global.panelAviso("CIF o Web no valido");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_BotonRegistrarActionPerformed

    private void BotonLimpiar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLimpiar1MouseClicked
        cifCampo.setText(Global.EMPTY);
        dniCampo.setText(Global.EMPTY);
        webCampo.setText(Global.EMPTY);
    }//GEN-LAST:event_BotonLimpiar1MouseClicked

    private void BotonLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonLimpiar1ActionPerformed

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
            java.util.logging.Logger.getLogger(MiniRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiniRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiniRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiniRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniRegistro().setVisible(true);
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
    private javax.swing.JTextField cifCampo;
    private javax.swing.JLabel cifTexto;
    private javax.swing.JTextField dniCampo;
    private javax.swing.JLabel dniTexto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField webCampo;
    private javax.swing.JLabel webTexto;
    // End of variables declaration//GEN-END:variables
}
