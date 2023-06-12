package Frontend;

import Backend.Serializacion;
import Backend.Global;
import Backend.Tarjeta;
import Backend.Direccion;
import Backend.Usuario;
import java.awt.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * Ventana Jframe encargada de registro de usuario
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class FormularioCreacionCuenta extends javax.swing.JFrame {

    int RatonX, RatonY;

    public FormularioCreacionCuenta(String mail, String pass) {
        initComponents();

        Global.frameSetUp(this, 735, 530);
        
        /**
         * Rellena automaticamente los datos del login si quiere registrarse
         */
        if (!mail.equals(Global.EMPTY)) {
            Email.setForeground(Color.black);
            Email.setText(mail);
        }
        if (!pass.equals(Global.EMPTY)) {
            Clave.setForeground(Color.black);
            Clave.setText(pass);
        }

        BotonRegistrar.requestFocus();  // Focus en boton de registrar (Mejora experiencia UI)
    }
    
    /**
     * Constructor por defecto si no se pasasn parametros
     */
    private FormularioCreacionCuenta() {
        throw new UnsupportedOperationException("Error: Arrancado sin argumentos de inicio"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Encargado de obtener los digitos antes del punto (en el JComboBox de mes)
     * @param cadena
     * @return 
     */
    public static String obtenerDigitos(String cadena) {
        String[] partes = cadena.split("\\.");
        if (partes.length > 0) {
            String primerParte = partes[0].trim();
            return primerParte.replaceAll("[^0-9]", Global.EMPTY);
        }
        return "";
    }
    
    /**
     * Arrancada de minimenu que finaliza registro decidiendo si es empresa
     * o cliente y completando el registro.
     * @param esParticular
     * @param user 
     */
    public void arrancarMiniMenu(boolean esParticular, Usuario user) {
        // Se utiliza en BotonRegistrar para decidir si es empresa o particular parte final registro
        MiniRegistro mr = new MiniRegistro(esParticular, user);
        mr.setVisible(true);
        mr.addWindowListener(new WindowAdapter() {                      //Listener si se cierra miniRegistro para cerrar Forumlario
            @Override
            public void windowClosed(WindowEvent e) {
                FormularioCreacionCuenta.this.dispose();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Fondo = new javax.swing.JPanel();
        BarraSuperior = new javax.swing.JPanel();
        ExitButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Eat = new javax.swing.JLabel();
        Registro = new javax.swing.JLabel();
        Java = new javax.swing.JLabel();
        SeparadorInferior = new javax.swing.JSeparator();
        Java2 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        Java3 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        Java4 = new javax.swing.JLabel();
        Clave = new javax.swing.JTextField();
        Java5 = new javax.swing.JLabel();
        Telefono = new javax.swing.JTextField();
        Java6 = new javax.swing.JLabel();
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
        Java12 = new javax.swing.JLabel();
        tarjetaTitular = new javax.swing.JTextField();
        Java13 = new javax.swing.JLabel();
        tarjetaNumero = new javax.swing.JTextField();
        Java14 = new javax.swing.JLabel();
        tarjetaAno = new javax.swing.JTextField();
        tarjetaSelectorMes = new javax.swing.JComboBox<>();

        jLabel3.setFont(new java.awt.Font("Roboto Black", 1, 45)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Eat");
        jLabel3.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Registro");
        jLabel5.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(735, 530));
        setUndecorated(true);

        Fondo.setBackground(new java.awt.Color(246, 238, 249));
        Fondo.setMinimumSize(new java.awt.Dimension(735, 530));
        Fondo.setPreferredSize(new java.awt.Dimension(735, 530));

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
            .addGroup(BarraSuperiorLayout.createSequentialGroup()
                .addGroup(BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                        .addGap(0, 679, Short.MAX_VALUE)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        BarraSuperiorLayout.setVerticalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Eat.setFont(new java.awt.Font("Roboto Black", 1, 35)); // NOI18N
        Eat.setForeground(new java.awt.Color(255, 51, 51));
        Eat.setText("Eat");
        Eat.setToolTipText("");

        Registro.setFont(new java.awt.Font("Roboto Black", 1, 30)); // NOI18N
        Registro.setForeground(new java.awt.Color(0, 0, 0));
        Registro.setText("Registro");
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

        Nombre.setBackground(new java.awt.Color(246, 238, 249));
        Nombre.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        Nombre.setForeground(new java.awt.Color(209, 211, 211));
        Nombre.setText("Nombre");
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

        Java3.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java3.setForeground(new java.awt.Color(0, 0, 0));
        Java3.setText("Email");
        Java3.setToolTipText("");

        Email.setBackground(new java.awt.Color(246, 238, 249));
        Email.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        Email.setForeground(new java.awt.Color(209, 211, 211));
        Email.setText("Email");
        Email.setActionCommand("<Not Set>");
        Email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailFocusLost(evt);
            }
        });
        Email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmailMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EmailMousePressed(evt);
            }
        });
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        Java4.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java4.setForeground(new java.awt.Color(0, 0, 0));
        Java4.setText("Clave");
        Java4.setToolTipText("");

        Clave.setBackground(new java.awt.Color(246, 238, 249));
        Clave.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        Clave.setForeground(new java.awt.Color(209, 211, 211));
        Clave.setText("Clave");
        Clave.setActionCommand("<Not Set>");
        Clave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Clave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ClaveFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ClaveFocusLost(evt);
            }
        });
        Clave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClaveMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ClaveMousePressed(evt);
            }
        });
        Clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClaveActionPerformed(evt);
            }
        });

        Java5.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java5.setForeground(new java.awt.Color(0, 0, 0));
        Java5.setText("Teléfono");
        Java5.setToolTipText("");

        Telefono.setBackground(new java.awt.Color(246, 238, 249));
        Telefono.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        Telefono.setForeground(new java.awt.Color(209, 211, 211));
        Telefono.setText("Teléfono");
        Telefono.setActionCommand("<Not Set>");
        Telefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Telefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TelefonoFocusLost(evt);
            }
        });
        Telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TelefonoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TelefonoMousePressed(evt);
            }
        });
        Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TelefonoActionPerformed(evt);
            }
        });

        Java6.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java6.setForeground(new java.awt.Color(0, 0, 0));
        Java6.setText("Tarjeta ");
        Java6.setToolTipText("");

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

        Java12.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java12.setForeground(new java.awt.Color(0, 0, 0));
        Java12.setText("Titular");
        Java12.setToolTipText("");

        tarjetaTitular.setBackground(new java.awt.Color(246, 238, 249));
        tarjetaTitular.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tarjetaTitular.setForeground(new java.awt.Color(209, 211, 211));
        tarjetaTitular.setText("Titular");
        tarjetaTitular.setActionCommand("<Not Set>");
        tarjetaTitular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tarjetaTitular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tarjetaTitularFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tarjetaTitularFocusLost(evt);
            }
        });
        tarjetaTitular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tarjetaTitularMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tarjetaTitularMousePressed(evt);
            }
        });
        tarjetaTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaTitularActionPerformed(evt);
            }
        });

        Java13.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java13.setForeground(new java.awt.Color(0, 0, 0));
        Java13.setText("Número");
        Java13.setToolTipText("");

        tarjetaNumero.setBackground(new java.awt.Color(246, 238, 249));
        tarjetaNumero.setFont(new java.awt.Font("Roboto Black", 1, 16)); // NOI18N
        tarjetaNumero.setForeground(new java.awt.Color(209, 211, 211));
        tarjetaNumero.setText("Número");
        tarjetaNumero.setToolTipText("");
        tarjetaNumero.setActionCommand("<Not Set>");
        tarjetaNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tarjetaNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tarjetaNumeroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tarjetaNumeroFocusLost(evt);
            }
        });
        tarjetaNumero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tarjetaNumeroMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tarjetaNumeroMousePressed(evt);
            }
        });
        tarjetaNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaNumeroActionPerformed(evt);
            }
        });

        Java14.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        Java14.setForeground(new java.awt.Color(0, 0, 0));
        Java14.setText("Fecha Caducidad");
        Java14.setToolTipText("");

        tarjetaAno.setBackground(new java.awt.Color(246, 238, 249));
        tarjetaAno.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tarjetaAno.setForeground(new java.awt.Color(209, 211, 211));
        tarjetaAno.setText("Año");
        tarjetaAno.setActionCommand("<Not Set>");
        tarjetaAno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tarjetaAno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tarjetaAnoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tarjetaAnoFocusLost(evt);
            }
        });
        tarjetaAno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tarjetaAnoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tarjetaAnoMousePressed(evt);
            }
        });
        tarjetaAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaAnoActionPerformed(evt);
            }
        });

        tarjetaSelectorMes.setBackground(new java.awt.Color(246, 238, 249));
        tarjetaSelectorMes.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        tarjetaSelectorMes.setForeground(new java.awt.Color(209, 211, 211));
        tarjetaSelectorMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "1. Enero", "2. Febrero", "3. Marzo", "4. Abril", "5. Mayo", "6. Junio", "7. Julio", "8. Agosto", "9. Septiembre", "10. Octubre", "11. Noviembre", "12. Diciembre" }));
        tarjetaSelectorMes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tarjetaSelectorMesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tarjetaSelectorMesFocusLost(evt);
            }
        });
        tarjetaSelectorMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tarjetaSelectorMesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Registro)
                .addGap(451, 451, 451)
                .addComponent(Java)
                .addGap(6, 6, 6)
                .addComponent(Eat, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(SeparadorInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Java2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(Java4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(Clave, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Java3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(Java5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Java6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(Java7, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Java12, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Java13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(Java8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(Java9, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(tarjetaTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tarjetaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Java14)
                .addGap(227, 227, 227)
                .addComponent(Java11, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(Java10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(tarjetaSelectorMes, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(tarjetaAno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(dCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dCP, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(BotonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addComponent(BarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(Java))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Eat)))
                .addGap(3, 3, 3)
                .addComponent(SeparadorInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Java2)
                    .addComponent(Java4))
                .addGap(6, 6, 6)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Java3)
                    .addComponent(Java5))
                .addGap(6, 6, 6)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Java6)
                    .addComponent(Java7))
                .addGap(6, 6, 6)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Java12)
                        .addComponent(Java13))
                    .addComponent(Java8)
                    .addComponent(Java9))
                .addGap(6, 6, 6)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tarjetaTitular)
                    .addComponent(dCalle)
                    .addComponent(dNumero)
                    .addComponent(tarjetaNumero))
                .addGap(18, 18, 18)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Java14)
                    .addComponent(Java11)
                    .addComponent(Java10))
                .addGap(6, 6, 6)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tarjetaSelectorMes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tarjetaAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void NombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreMouseClicked

    private void NombreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreMousePressed
        Global.cleanWrite(Nombre);
    }//GEN-LAST:event_NombreMousePressed

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        Global.cleanWrite(Nombre);
    }//GEN-LAST:event_NombreActionPerformed

    private void EmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailMouseClicked

    private void EmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmailMousePressed
        Global.cleanWrite(Email);
    }//GEN-LAST:event_EmailMousePressed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        Global.cleanWrite(Email);
    }//GEN-LAST:event_EmailActionPerformed

    private void ClaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClaveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ClaveMouseClicked

    private void ClaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClaveMousePressed
        Global.cleanWrite(Clave);
    }//GEN-LAST:event_ClaveMousePressed

    private void ClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClaveActionPerformed
        Global.cleanWrite(Clave);
    }//GEN-LAST:event_ClaveActionPerformed

    private void TelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelefonoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TelefonoMouseClicked

    private void TelefonoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TelefonoMousePressed
        Global.cleanWrite(Telefono);
    }//GEN-LAST:event_TelefonoMousePressed

    private void TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TelefonoActionPerformed
        Global.cleanWrite(Telefono);
    }//GEN-LAST:event_TelefonoActionPerformed

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

        String nombreTxt = Nombre.getText().trim();
        String emailTxt = Email.getText().trim();
        String claveTxt = Clave.getText().trim();
        String telefonoTxt = Telefono.getText().trim();

        //Campos de direccion
        String dCalleTxt = dCalle.getText().trim();
        String dNumeroTxt = dNumero.getText().trim();
        String dCPTxt = dCP.getText().trim();
        String dCiudadTxt = dCiudad.getText().trim();

        String tTitularTxt = tarjetaTitular.getText().trim();
        String tNumeroTxt = tarjetaNumero.getText().trim();
        String tAnoTxt = tarjetaAno.getText().trim();
        String mes = tarjetaSelectorMes.getSelectedItem().toString().trim();
        String tMesTxt = obtenerDigitos(mes);

        // Criterios de registro por campo 
        boolean cNombre = !nombreTxt.isEmpty() && !Nombre.getForeground().equals(Global.GRIS);                                //Esta relleno  (puede llamarse cualquier cosa)
        boolean cClave = !claveTxt.isEmpty() && !Clave.getForeground().equals(Global.GRIS);                                    //Esta relleno (puede llamarse cualquier cosa)
        boolean cTelefono = telefonoTxt.matches("\\d+") && telefonoTxt.length() == 9;                                          // Solo compuesto por numeros (REGEX) y 9 digitos (Espana) 
        boolean cEmail = emailTxt.matches(".*@.*\\..*");                                                                       // Regex tipo bla@bla.com
        // Criterios de direccion
        boolean cdCalle = dCalleTxt.matches("\\D+") && !dCalle.getForeground().equals(Global.GRIS);                      // Solo tiene letras
        boolean cdNumero = dNumeroTxt.matches("\\d+");                                                                         // Solo numeros
        boolean cdCP = dCPTxt.matches("\\d+") && dCPTxt.length() == 5;                                                          // Solo compuesto por numeros (REGEX) y 5 digitos (Espana) 
        boolean cdCiudad = !dCiudadTxt.isEmpty() && !dCiudad.getForeground().equals(Global.GRIS);                             //Esta relleno (puede llamarse cualquier cosa)
        boolean cDireccion = cdCalle && cdNumero && cdCP && cdCiudad;

        boolean ctTitular = !tTitularTxt.isEmpty() && !tarjetaTitular.getForeground().equals(Global.GRIS);                    //Esta relleno  (puede llamarse cualquier cosa)
        boolean ctNumero = tNumeroTxt.matches("\\d+") && tNumeroTxt.length() == 16;                                            // Solo compuesto por numeros (REGEX) y 16 digitos 
        boolean ctAno = tAnoTxt.matches("\\d+") && (Integer.parseInt(tAnoTxt) >= LocalDate.now().getYear());                  // Solo numeros y mayor/igual al actual                                                             // Solo numeros
        boolean ctMes = tMesTxt.matches("\\d+");                                                                     // Solo numeros (tratamiento especial al ser char)    
        boolean cTarjeta = ctTitular && ctNumero && ctAno && ctMes; // Anadir mes

        boolean checkCondiciones = cNombre && cClave && cTelefono && cEmail && cDireccion && cTarjeta;

        try {
            if (Serializacion.estaEnBD(Global.USER_FILE, emailTxt)) {
                Global.panelAviso("Usuario Registrado, utilize otro");
            } else if (!checkCondiciones) {
                Global.panelAviso("Faltan datos por rellenar o no cumplen con las condiciones normales");
            } else {
                // Registro de usuario
                Direccion nuevadireccion = new Direccion(dCalleTxt, dNumeroTxt, dCPTxt, dCiudadTxt);
                Tarjeta nuevaTarjeta = new Tarjeta(tTitularTxt, tNumeroTxt, tMesTxt, tAnoTxt);
                Usuario user = new Usuario(nombreTxt, emailTxt, claveTxt, nuevadireccion, nuevaTarjeta, telefonoTxt);

                int opcion = Global.panelDecisionSN("¿Se registra un particular o una empresa?", "Tipo de registro", "Particular", "Empresa");
                switch (opcion) {
                    case JOptionPane.YES_OPTION -> {
                        // Particular
                        arrancarMiniMenu(true, user);

                    }

                    case JOptionPane.NO_OPTION -> {
                        // Empresa
                        arrancarMiniMenu(false, user);

                    }
                    default -> // Cerrada la ventana emergente
                        System.out.println(Global.EMPTY);
                }

            };
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_BotonRegistrarActionPerformed

    private void BotonLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotonLimpiarMouseClicked
        Nombre.setText(Global.EMPTY);
        Email.setText(Global.EMPTY);
        Clave.setText(Global.EMPTY);
        Telefono.setText(Global.EMPTY);
        tarjetaTitular.setText(Global.EMPTY);
        tarjetaSelectorMes.setSelectedIndex(0);
        tarjetaSelectorMes.setForeground(Global.GRIS);
        tarjetaNumero.setText(Global.EMPTY);
        tarjetaTitular.setText(Global.EMPTY);
        tarjetaAno.setText(Global.EMPTY);
        dCalle.setText(Global.EMPTY);
        dCP.setText(Global.EMPTY);
        dCiudad.setText(Global.EMPTY);
        dNumero.setText(Global.EMPTY);

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

    private void tarjetaTitularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tarjetaTitularMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tarjetaTitularMouseClicked

    private void tarjetaTitularMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tarjetaTitularMousePressed
        Global.cleanWrite(tarjetaTitular);
    }//GEN-LAST:event_tarjetaTitularMousePressed

    private void tarjetaTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaTitularActionPerformed
        Global.cleanWrite(tarjetaTitular);
    }//GEN-LAST:event_tarjetaTitularActionPerformed

    private void tarjetaNumeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tarjetaNumeroMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tarjetaNumeroMouseClicked

    private void tarjetaNumeroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tarjetaNumeroMousePressed
        Global.cleanWrite(tarjetaNumero);
    }//GEN-LAST:event_tarjetaNumeroMousePressed

    private void tarjetaNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaNumeroActionPerformed
        Global.cleanWrite(tarjetaNumero);
    }//GEN-LAST:event_tarjetaNumeroActionPerformed

    private void tarjetaAnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tarjetaAnoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tarjetaAnoMouseClicked

    private void tarjetaAnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tarjetaAnoMousePressed
        Global.cleanWrite(tarjetaAno);
    }//GEN-LAST:event_tarjetaAnoMousePressed

    private void tarjetaAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaAnoActionPerformed
        Global.cleanWrite(tarjetaAno);
    }//GEN-LAST:event_tarjetaAnoActionPerformed

    private void tarjetaSelectorMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tarjetaSelectorMesActionPerformed
        Global.cleanWrite(tarjetaSelectorMes);

    }//GEN-LAST:event_tarjetaSelectorMesActionPerformed

    private void NombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreFocusGained
        Global.cleanWrite(Nombre);
    }//GEN-LAST:event_NombreFocusGained

    private void EmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailFocusGained
        Global.cleanWrite(Email);
    }//GEN-LAST:event_EmailFocusGained

    private void ClaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ClaveFocusGained
        Global.cleanWrite(Clave);
    }//GEN-LAST:event_ClaveFocusGained

    private void TelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TelefonoFocusGained
        Global.cleanWrite(Telefono);
    }//GEN-LAST:event_TelefonoFocusGained

    private void tarjetaTitularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tarjetaTitularFocusGained
        Global.cleanWrite(tarjetaTitular);
    }//GEN-LAST:event_tarjetaTitularFocusGained

    private void tarjetaNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tarjetaNumeroFocusGained
        Global.cleanWrite(tarjetaNumero);
    }//GEN-LAST:event_tarjetaNumeroFocusGained

    private void tarjetaSelectorMesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tarjetaSelectorMesFocusGained
        Global.cleanWrite(tarjetaSelectorMes);
    }//GEN-LAST:event_tarjetaSelectorMesFocusGained

    private void tarjetaAnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tarjetaAnoFocusGained
        Global.cleanWrite(tarjetaAno);
    }//GEN-LAST:event_tarjetaAnoFocusGained

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

    private void NombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NombreFocusLost
        Global.deCleanWrite(Nombre, "Nombre");
    }//GEN-LAST:event_NombreFocusLost

    private void EmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailFocusLost
        Global.deCleanWrite(Email, "Email");
    }//GEN-LAST:event_EmailFocusLost

    private void ClaveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ClaveFocusLost
        Global.deCleanWrite(Clave, "Clave");
    }//GEN-LAST:event_ClaveFocusLost

    private void TelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TelefonoFocusLost
        Global.deCleanWrite(Telefono, "Teléfono");

    }//GEN-LAST:event_TelefonoFocusLost

    private void tarjetaTitularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tarjetaTitularFocusLost

        Global.deCleanWrite(tarjetaTitular, "Titular");

    }//GEN-LAST:event_tarjetaTitularFocusLost

    private void tarjetaNumeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tarjetaNumeroFocusLost
        Global.deCleanWrite(tarjetaNumero, "Numero");
    }//GEN-LAST:event_tarjetaNumeroFocusLost

    private void tarjetaAnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tarjetaAnoFocusLost
        Global.deCleanWrite(tarjetaAno, "Año");
    }//GEN-LAST:event_tarjetaAnoFocusLost

    private void tarjetaSelectorMesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tarjetaSelectorMesFocusLost

        Global.deCleanWrite(tarjetaSelectorMes, "Año");

    }//GEN-LAST:event_tarjetaSelectorMesFocusLost

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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioCreacionCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JButton BotonLimpiar;
    private javax.swing.JButton BotonRegistrar;
    private javax.swing.JTextField Clave;
    private javax.swing.JLabel Eat;
    private javax.swing.JTextField Email;
    private javax.swing.JButton ExitButton;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Java;
    private javax.swing.JLabel Java10;
    private javax.swing.JLabel Java11;
    private javax.swing.JLabel Java12;
    private javax.swing.JLabel Java13;
    private javax.swing.JLabel Java14;
    private javax.swing.JLabel Java2;
    private javax.swing.JLabel Java3;
    private javax.swing.JLabel Java4;
    private javax.swing.JLabel Java5;
    private javax.swing.JLabel Java6;
    private javax.swing.JLabel Java7;
    private javax.swing.JLabel Java8;
    private javax.swing.JLabel Java9;
    private javax.swing.JTextField Nombre;
    private javax.swing.JLabel Registro;
    private javax.swing.JSeparator SeparadorInferior;
    private javax.swing.JTextField Telefono;
    private javax.swing.JTextField dCP;
    private javax.swing.JTextField dCalle;
    private javax.swing.JTextField dCiudad;
    private javax.swing.JTextField dNumero;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tarjetaAno;
    private javax.swing.JTextField tarjetaNumero;
    private javax.swing.JComboBox<String> tarjetaSelectorMes;
    private javax.swing.JTextField tarjetaTitular;
    // End of variables declaration//GEN-END:variables
}
