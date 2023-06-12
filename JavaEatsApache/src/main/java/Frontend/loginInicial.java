package Frontend;

import Backend.Global;
import Backend.LoginConfig;
import Backend.Cliente_Empresa;
import Backend.Cliente_Particular;
import java.awt.Color;
import Backend.Serializacion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 * Ventana Jframe de inicio de sesión
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class loginInicial extends javax.swing.JFrame {

    int RatonX, RatonY;

    public loginInicial() {

        initComponents();
        Global.frameSetUp(this, 1000, 800);
        BotonAceptar.requestFocusInWindow();  // Focus en boton de aceptar (Mejora experiencia UI)

    }

    /**
     * Elige a que ventana saltar según tipo de usuario Uso metodo:
     * {@link Backend.Global#frameJump(javax.swing.JFrame, javax.swing.JFrame)}
     *
     * @param usuario
     * @param pass
     */
    public void arrancarMainMenu(String usuario, String pass) {
        if (usuario.equals("admin@javaeat.com") && pass.equals("admin")) {
            Global.frameJump(new adminWindow(), this);
            System.out.println("Login: Sesion iniciada con <" + usuario + "> [Admin]");
        } else if (Serializacion.esParticular(Global.USER_FILE, usuario)) {
            String actual = Serializacion.getClienteParticular(Global.USER_FILE, usuario).getMail();
            Global.frameJump(new MainMenu(actual), this);
            System.out.println("Login: Sesion iniciada con <" + usuario + "> [Particular]");
        } else {
            String actual = Serializacion.getClienteEmpresa(Global.USER_FILE, usuario).getMail();
            Global.frameJump(new MainMenu(actual), this);
            System.out.println("Login: Sesion iniciada con <" + usuario + "> [Empresa]");
        }

    }

    /**
     * Crea archivo de persistencia de inicio de sesión
     *
     * @see #BotonAceptarActionPerformed(java.awt.event.ActionEvent)
     * @param filename
     * @param login
     */
    public static void crearLogin(String filename, LoginConfig login) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(login);
            System.out.println("Login: Creado config para <" + login.getMail() + ">");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Función sustituta de .setVisible true. Si ve que existe archivo de 
     * persistencia salta directamente a la ventana que le corresponda
     */
    public void init() {
        // Configuración de la ventana, componentes y lógica inicial aquí
        File fl = new File(Global.CONFIG_FILE);
        if (fl.exists() && fl.length() > 7) {
            /*
            fl.length() > 7 -> Utilizado para cuando no se quiere utilizar el archivo de config despues de haber salido de sesion (el archivo esta protegido por procesos de java y no puede borrarse) 
                               se sobreescribe el archivo con un solo string "", esto ocupa 7 bytes exactos y una sola entrada del config mucho mas (mas o menos 120 bytes).
                               El archivo config realmente existe siempre, pero solo se utiliza cuando supera los 7 bytes.
             */
            System.out.print("Login: Archivo " + Global.CONFIG_FILE + " existente, iniciando sesión automáticamente\n\t|-> ");
            LoginConfig loginGuardado = Serializacion.cargarEnMemoriaLogin(Global.CONFIG_FILE);
            arrancarMainMenu(loginGuardado.getMail(), loginGuardado.getPasswd());

        } else {
            this.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator4 = new javax.swing.JSeparator();
        fondo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TextoCrearCuenta = new javax.swing.JLabel();
        correoLlenarTexto = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        claveLlenarTexto = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        BotonCrearCuenta = new javax.swing.JButton();
        BotonLimpiar = new javax.swing.JButton();
        BarraSuperior = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        BotonAceptar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        checkBox = new javax.swing.JCheckBox();

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        fondo.setBackground(new java.awt.Color(246, 238, 249));
        fondo.setMinimumSize(new java.awt.Dimension(600, 567));
        fondo.setPreferredSize(new java.awt.Dimension(600, 567));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 60)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Java");
        jLabel5.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Roboto Black", 1, 75)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("Eat");
        jLabel2.setToolTipText("");

        TextoCrearCuenta.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        TextoCrearCuenta.setForeground(new java.awt.Color(0, 0, 0));
        TextoCrearCuenta.setText("¿No tienes una cuenta creada? ");
        TextoCrearCuenta.setToolTipText("");

        correoLlenarTexto.setBackground(new java.awt.Color(246, 238, 249));
        correoLlenarTexto.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        correoLlenarTexto.setForeground(new java.awt.Color(209, 211, 211));
        correoLlenarTexto.setText("Correo Electrónico");
        correoLlenarTexto.setBorder(null);
        correoLlenarTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                correoLlenarTextoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                correoLlenarTextoFocusLost(evt);
            }
        });
        correoLlenarTexto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correoLlenarTextoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                correoLlenarTextoMousePressed(evt);
            }
        });
        correoLlenarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoLlenarTextoActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        claveLlenarTexto.setBackground(new java.awt.Color(246, 238, 249));
        claveLlenarTexto.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        claveLlenarTexto.setForeground(new java.awt.Color(209, 211, 211));
        claveLlenarTexto.setText("jPasswordField1");
        claveLlenarTexto.setBorder(null);
        claveLlenarTexto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                claveLlenarTextoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                claveLlenarTextoFocusLost(evt);
            }
        });
        claveLlenarTexto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                claveLlenarTextoMousePressed(evt);
            }
        });
        claveLlenarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                claveLlenarTextoActionPerformed(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        BotonCrearCuenta.setBackground(new java.awt.Color(246, 238, 249));
        BotonCrearCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonCrearCuenta.setForeground(new java.awt.Color(0, 0, 0));
        BotonCrearCuenta.setText("Crear Cuenta");
        BotonCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearCuentaActionPerformed(evt);
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

        jButton1.setBackground(new java.awt.Color(246, 238, 249));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("X");
        jButton1.setFocusable(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout BarraSuperiorLayout = new javax.swing.GroupLayout(BarraSuperior);
        BarraSuperior.setLayout(BarraSuperiorLayout);
        BarraSuperiorLayout.setHorizontalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraSuperiorLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(368, 368, 368))
        );
        BarraSuperiorLayout.setVerticalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Inicia Sesión");
        jLabel6.setToolTipText("");

        BotonAceptar.setBackground(new java.awt.Color(246, 238, 249));
        BotonAceptar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonAceptar.setForeground(new java.awt.Color(0, 0, 0));
        BotonAceptar.setText("Aceptar");
        BotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarActionPerformed(evt);
            }
        });

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        checkBox.setBackground(new java.awt.Color(246, 238, 249));
        checkBox.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        checkBox.setText("Mantener Inicio de Sesión");
        checkBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                checkBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                checkBoxFocusLost(evt);
            }
        });
        checkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextoCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                                        .addComponent(BotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(checkBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(BotonCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(claveLlenarTexto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(correoLlenarTexto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(476, 476, 476)))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addComponent(BarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(35, 35, 35)
                .addComponent(correoLlenarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(claveLlenarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoCrearCuenta)
                    .addComponent(BotonCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fondoLayout.createSequentialGroup()
                    .addGap(268, 268, 268)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(269, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed

        String usuario = correoLlenarTexto.getText().trim();
        String pass = new String(claveLlenarTexto.getPassword()).trim();
        boolean checkBoxActivada = checkBox.isSelected();

        Color colorUsuario = correoLlenarTexto.getForeground();
        Color colorPasswd = claveLlenarTexto.getForeground();

        if (usuario.isEmpty() || pass.isEmpty() || colorUsuario.equals(Global.GRIS) || colorPasswd.equals(Global.GRIS)) {
            Global.panelAviso("Alguno de los campos esta vacío ");
        } else {
            try {
                if (Serializacion.puedeLogin(Global.USER_FILE, usuario, pass)) {
                    if (checkBoxActivada) {
                        LoginConfig login = new LoginConfig(usuario, pass);
                        crearLogin(Global.CONFIG_FILE, login);
                    } else {
                        Global.borrarConfig(Global.CONFIG_FILE);
                    }
                    
                    arrancarMainMenu(usuario, pass);
                } else {
                    JOptionPane.showMessageDialog(null, "Datos no encontrados, revise sus credenciales o registrese");
                    claveLlenarTexto.setText(Global.EMPTY);
                    Global.deCleanWrite(claveLlenarTexto, "jPasswordField1");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_BotonAceptarActionPerformed

    private void BarraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMousePressed
        RatonX = evt.getX();
        RatonY = evt.getY();
    }//GEN-LAST:event_BarraSuperiorMousePressed

    private void BarraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraSuperiorMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - RatonX, y - RatonY);
    }//GEN-LAST:event_BarraSuperiorMouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed

    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(Global.ROSA);
        jButton1.setForeground(Color.black);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setBackground(Color.red);
        jButton1.setForeground(Color.white);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButton1MouseClicked

    private void BotonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonLimpiarActionPerformed

    private void BotonLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLimpiarMouseClicked
        correoLlenarTexto.setText(Global.EMPTY);
        claveLlenarTexto.setText(Global.EMPTY);
        checkBox.setSelected(false);
        checkBox.setForeground(Global.GRIS);
    }//GEN-LAST:event_BotonLimpiarMouseClicked

    private void BotonCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearCuentaActionPerformed
        String usuario = correoLlenarTexto.getText();
        String pass = new String(claveLlenarTexto.getPassword());

        Color colorUsuario = correoLlenarTexto.getForeground();
        Color colorPasswd = claveLlenarTexto.getForeground();

        if (usuario.isEmpty() || colorUsuario.equals(Global.GRIS)) {
            usuario = Global.EMPTY;
        }
        if (pass.isEmpty() || colorPasswd.equals(Global.GRIS)) {
            pass = Global.EMPTY;
        }

        try {
            if (!usuario.isEmpty() || !pass.isEmpty()) {
                int opcion = Global.panelDecisionSN(("¿Deseas utilizar los datos introducidos para el registro?" + "\nUsuario: " + usuario + "\nClave: " + pass), "Datos de registro", Global.SI, "No, registrar desde cero");
                switch (opcion) {
                    case JOptionPane.YES_OPTION: {
                        // Opcion "Si"
                        FormularioCreacionCuenta fcc = new FormularioCreacionCuenta(usuario, pass);
                        fcc.setVisible(true);
                        break;
                    }
                    case JOptionPane.NO_OPTION: {
                        // Opcion "No"
                        FormularioCreacionCuenta fcc = new FormularioCreacionCuenta(Global.EMPTY, Global.EMPTY);
                        fcc.setVisible(true);
                        break;
                    }
                    default:
                        System.out.println("Ventana cerrada sin seleccionar ninguna opción.");
                        break;
                }
            } else {
                FormularioCreacionCuenta fcc = new FormularioCreacionCuenta(Global.EMPTY, Global.EMPTY);
                fcc.setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_BotonCrearCuentaActionPerformed

    private void claveLlenarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_claveLlenarTextoActionPerformed

    }//GEN-LAST:event_claveLlenarTextoActionPerformed

    private void claveLlenarTextoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_claveLlenarTextoMousePressed
        Global.cleanWrite(claveLlenarTexto);
    }//GEN-LAST:event_claveLlenarTextoMousePressed

    private void claveLlenarTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_claveLlenarTextoFocusLost
        Global.deCleanWrite(claveLlenarTexto, "jPasswordField1");
    }//GEN-LAST:event_claveLlenarTextoFocusLost

    private void claveLlenarTextoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_claveLlenarTextoFocusGained
        Global.cleanWrite(claveLlenarTexto);
    }//GEN-LAST:event_claveLlenarTextoFocusGained

    private void correoLlenarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoLlenarTextoActionPerformed

    }//GEN-LAST:event_correoLlenarTextoActionPerformed

    private void correoLlenarTextoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoLlenarTextoMousePressed
        Global.cleanWrite(correoLlenarTexto);
    }//GEN-LAST:event_correoLlenarTextoMousePressed

    private void correoLlenarTextoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoLlenarTextoMouseClicked

    }//GEN-LAST:event_correoLlenarTextoMouseClicked

    private void correoLlenarTextoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoLlenarTextoFocusLost
        Global.deCleanWrite(correoLlenarTexto, "Correo Electrónico");
    }//GEN-LAST:event_correoLlenarTextoFocusLost

    private void correoLlenarTextoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_correoLlenarTextoFocusGained
        Global.cleanWrite(correoLlenarTexto);
    }//GEN-LAST:event_correoLlenarTextoFocusGained

    private void checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxActionPerformed

    private void checkBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_checkBoxFocusLost
        if (!checkBox.isSelected()) {
            checkBox.setForeground(Global.GRIS);
        }
    }//GEN-LAST:event_checkBoxFocusLost

    private void checkBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_checkBoxFocusGained
        if (checkBox.isSelected()) {
            checkBox.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_checkBoxFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                loginInicial login = new loginInicial();                        // Normalmente no se arrancara desde aqui pero se menciona para que sea estable
                login.init();
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JButton BotonAceptar;
    private javax.swing.JButton BotonCrearCuenta;
    private javax.swing.JButton BotonLimpiar;
    private javax.swing.JLabel TextoCrearCuenta;
    private javax.swing.JCheckBox checkBox;
    private javax.swing.JPasswordField claveLlenarTexto;
    private javax.swing.JTextField correoLlenarTexto;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
