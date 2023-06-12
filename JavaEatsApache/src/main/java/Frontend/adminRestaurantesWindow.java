package Frontend;

import Backend.Opinion;
import Backend.Serializacion;
import Backend.Restaurante;
import Backend.Global;
import Backend.Catering;
import Backend.Comida;
import Backend.Direccion;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 * Panel de control restaurantes por admin
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class adminRestaurantesWindow extends javax.swing.JFrame {

    int RatonX, RatonY;
    FormularioCreacionRestaurante frr = new FormularioCreacionRestaurante();

    /**
     * Setup de JFrame con listeners incluidos para borrado y edición de
     * restaurantes
     */
    public adminRestaurantesWindow() throws IOException {
        initComponents();
        Global.frameSetUp(this, 1300, 700);

        Global.setTabla(200, tablaR);
        Global.setTabla(200, tablaI);
        Global.setTabla(200, tablaC);
        Global.setTabla(200, tablaO);

        textoCantidadTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        tablaR.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    // Para evitar que en una tabla se pueda hacer Ctrl+(Click a filas)

        mostrarR();

        ListSelectionModel modeloR = tablaR.getSelectionModel();
        ListSelectionModel modeloC = tablaC.getSelectionModel();

        TableModel R = tablaR.getModel();
        TableModel C = tablaC.getModel();
        TableModel I = tablaI.getModel();
        TableModel O = tablaO.getModel();


        ListenerSeleccionRestaurante(modeloR, R);
        ListenerEdicionRestaurante(R);
        ListenerEdicionComida(R, C);
        ListenerEdicionIngredientes(R, C, I);
        ListenerEdicionOpiniones(R, O);
        ListenerSeleccionComida(modeloC);
        ListenerEdicionServicios();

        checkCamareros.setVisible(false);
        checkCocineros.setVisible(false);
        checkDeco.setVisible(false);
        checkEspacio.setVisible(false);

        frr.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {

                mostrarR();
            }
        });
    }

    /**
     * ]
     * Detecta cuando el usuario esta seleccionado un restaurante para mostrar
     * sus comidas entre otros
     *
     * @param modeloR
     * @param R
     */
    public void ListenerSeleccionRestaurante(ListSelectionModel modeloR, TableModel R) {
        modeloR.addListSelectionListener(new ListSelectionListener() {                                  // Listener de seleccion de restaurante
            public void valueChanged(ListSelectionEvent e) {

                int filaR = tablaR.getSelectedRow();
                if (filaR != -1) {

                    String nombre = (String) R.getValueAt(filaR, 1);
                    Restaurante res = Serializacion.getRestaurante(Global.RESTAURANT_FILE, nombre);

                    textoDatos.setText("Datos de '" + nombre + "'");

                    if (!res.isServicioCatering()) {
                        
                        textoCatering.setText("Catering: (No tiene)");
                        checkCamareros.setVisible(false);
                        checkCocineros.setVisible(false);
                        checkDeco.setVisible(false);
                        checkEspacio.setVisible(false);
                        textoCantidadTotal.setText(Global.EMPTY);
                    } else {
                        textoCatering.setText("Catering");
                        Catering cat = res.getCatering();
                        checkCamareros.setVisible(true);
                        checkCocineros.setVisible(true);
                        checkDeco.setVisible(true);
                        checkEspacio.setVisible(true);
                        
                        checkCamareros.setSelected(cat.hayCamareros());
                        checkCocineros.setSelected(cat.hayCocineros());
                        checkDeco.setSelected(cat.hayDeco());
                        checkEspacio.setSelected(cat.hayEP());
                        
                    }

                    mostrarO(res);
                    mostrarC(res);
                } else {
                    clearModel(tablaO);
                    clearModel(tablaC);
                    clearModel(tablaI);
     

                    textoDatos.setText("Datos");
                    textoCatering.setText("Catering");
                    checkCamareros.setVisible(false);
                    checkCocineros.setVisible(false);
                    checkDeco.setVisible(false);
                    checkEspacio.setVisible(false);

                    textoCantidadTotal.setText(Global.EMPTY);
                }

            }
        });
    }

    /**
     * Detecta cuando el usuario esta editando la tabla de restaurantes y aplica
     * (o no) sus cambios
     *
     * @param R
     */
    public void ListenerEdicionRestaurante(TableModel R) {
        tablaR.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        tablaR.getModel().addTableModelListener(new TableModelListener() {                      //Listener Restaurantes que salta cuando se edita una celda SOLO POR USUARIO
            @Override
            public void tableChanged(TableModelEvent e) {                                       // Parte hasta String nombre encargada de diferenciar rdicion de usuario de una de un porceso
                if (tablaR.isEditing()) {
                    int rowR = e.getFirstRow();
                    int columnR = e.getColumn();

                    if (rowR != -1 && columnR != -1) {                                                                 // Evita bugs al denegar el paneldecision
                        if (columnR != encontrarIndice(tablaR, "Nombre")) {
                            String nombre = (String) R.getValueAt(rowR, encontrarIndice(tablaR, "Nombre"));
                            int opcion = Global.panelDecisionSN("¿Deseas registrar los cambios de " + nombre + "?", "Modificación de datos", Global.SI, Global.NO);
                            switch (opcion) {
                                case JOptionPane.YES_OPTION: {

                                    Restaurante resBase = Serializacion.getRestaurante(Global.RESTAURANT_FILE, nombre);

                                    ArrayList<Comida> comidas = resBase.getComidas();
                                    ArrayList<Opinion> opiniones = resBase.getOpiniones();

                                    String cif = RtoString(rowR, "CIF");
                                    String especialidad = RtoString(rowR, "Especialidad");
                                    String calle = RtoString(rowR, "Calle");
                                    String numero = RtoString(rowR, "Número");
                                    String cp = RtoString(rowR, "Código Postal");
                                    String ciudad = RtoString(rowR, "Ciudad");
                                    double gastosE = RtoDouble(rowR, "Gastos de Envío");
                                    int tiempoE = RtoInt(rowR, "Tiempo de envio");
                                    boolean catering = RtoBoolean(rowR, "Tiene Servicio Catering");

                                    Direccion d = new Direccion(calle, numero, cp, ciudad);

                                    // Condicional ternario para asignacion con/sin catering
                                    Restaurante resNuevo = catering ? new Restaurante(cif, nombre, d, especialidad, gastosE, tiempoE, opiniones, comidas, resBase.getCatering()) : new Restaurante(cif, nombre, d, especialidad, gastosE, tiempoE, opiniones, comidas,new Catering(false,false,false,false));

                                    System.out.println("Admin Menu: Edición confirmada de " + nombre + "[" + rowR + "," + columnR + "]\n\t|-> ");
                                    Serializacion.anexar(Global.RESTAURANT_FILE, resNuevo);
                                    break;
                                }

                                default:
                                    System.out.println("Admin Menu: Edicion cancelada");
                                    mostrarR();
                                    break;
                            }
                        } else {
                            Global.panelAviso("No se puede modificar el nombre, cree otro restaurante");
                            System.out.print("Admin Menu: Edicion cancelada");
                            mostrarR();
                        }
                    }
                }
            }
        });
    }

    /**
     * Detecta cuando el usuario esta editando la tabla de comidas y aplica (o
     * no) sus cambios
     *
     * @param R
     * @param C
     */
    public void ListenerEdicionComida(TableModel R, TableModel C) {
        tablaC.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);            // 
        tablaC.getModel().addTableModelListener(new TableModelListener() {                      //Listener de comida que salta cuando se edita una celda SOLO POR USUARIO
            @Override
            public void tableChanged(TableModelEvent e) {                                       // Parte hasta String nombre encargada de diferenciar rdicion de usuario de una de un porceso
                if (tablaC.isEditing()) {
                    int rowC = e.getFirstRow();
                    int columnC = e.getColumn();

                    int rowR = tablaR.getSelectedRow();;
                    int columnR = tablaR.getSelectedColumn();

                    if ((rowC != -1 && columnC != -1) && (rowR != -1 && columnR != -1)) {                                                                 // Evita bugs al denegar el paneldecision
                        if (columnC != encontrarIndice(tablaC, "Nombre")) {
                            String nombreComida = (String) C.getValueAt(rowC, encontrarIndice(tablaC, "Nombre"));
                            String nombreRes = (String) R.getValueAt(rowR, encontrarIndice(tablaR, "Nombre"));

                            int opcion = Global.panelDecisionSN("¿Deseas registrar los cambios de la comida " + nombreComida + " en " + nombreRes + "?", "Modificación de datos", Global.SI, Global.NO);
                            switch (opcion) {
                                case JOptionPane.YES_OPTION: {
                                    // Al no poderse editar dos campos a la vez y estar actualizados los contenidos se tira directamente de la DB
                                    Restaurante res = Serializacion.getRestaurante(Global.RESTAURANT_FILE, nombreRes);
                                    ArrayList<Opinion> opiniones = res.getOpiniones();

                                    ArrayList<Comida> comidasNuevas = new ArrayList<Comida>();
                                    for (int row = 0; row < tablaC.getRowCount(); row++) {
                                        String nombre = (String) tablaC.getValueAt(row, encontrarIndice(tablaC, "Nombre"));
                                        double precio = (double) tablaC.getValueAt(row, encontrarIndice(tablaC, "Precio"));
                                        String rutaFoto = (String) tablaC.getValueAt(row, encontrarIndice(tablaC, "Ruta fotografia"));
                                        ArrayList<String> Ingredientes = Serializacion.getComida(res, nombre).getIngredientes();

                                        Comida nuevaComida = new Comida(nombre, Ingredientes, precio, rutaFoto);

                                        comidasNuevas.add(nuevaComida);

                                    }

                                    res.setComidas(comidasNuevas);

                                    System.out.print("Admin Menu: Edición confirmada de " + nombreRes + "(Comida)[" + nombreComida + "]\n\t|-> ");
                                    Serializacion.anexar(Global.RESTAURANT_FILE, res);

                                    break;
                                }

                                default:
                                    System.out.println("Admin Menu: Edicion cancelada");
                                    mostrarR();
                                    break;
                            }
                        } else {
                            Global.panelAviso("No se puede modificar el nombre");
                            System.out.println("Admin Menu: Edicion cancelada");
                            mostrarR();
                        }
                    }
                }
            }
        });
    }

    /**
     * Detecta cuando el usuario esta editando la tabla de ingredientes y aplica
     * (o no) sus cambios
     *
     * @param R
     * @param C
     * @param I
     */
    public void ListenerEdicionIngredientes(TableModel R, TableModel C, TableModel I) {
        tablaI.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);            // 
        tablaI.getModel().addTableModelListener(new TableModelListener() {                      //Listener de ingredientes que salta cuando se edita una celda SOLO POR USUARIO
            @Override
            public void tableChanged(TableModelEvent e) {                                       // Parte hasta String nombre encargada de diferenciar rdicion de usuario de una de un porceso
                if (tablaI.isEditing()) {
                    int rowC = tablaC.getSelectedRow();
                    int columnC = tablaC.getSelectedColumn();

                    int rowR = tablaR.getSelectedRow();
                    int columnR = tablaR.getSelectedColumn();
                    //Obten posiciones de filas seleccionadas en tabla afectada por listener
                    int rowI = e.getFirstRow();
                    int columnI = e.getColumn();
                    //Si no se suelta ninguna fila(Para mostrar comidas restaurante debe estar seleccionado, para mostrar ingredientes comida debe estar seleccionado)...
                    if ((rowC != -1 && columnC != -1) && (rowR != -1 && columnR != -1) && (rowI != -1 && columnI != -1)) {                                                                 // Evita bugs al denegar el paneldecision

                        String nombreIngrediente = (String) I.getValueAt(rowI, encontrarIndice(tablaI, "Nombre"));
                        String nombreComida = (String) C.getValueAt(rowC, encontrarIndice(tablaC, "Nombre"));
                        String nombreRes = (String) R.getValueAt(rowR, encontrarIndice(tablaR, "Nombre"));

                        System.out.println(nombreIngrediente);
                        int opcion = Global.panelDecisionSN("¿Deseas registrar los cambios del ingrediente " + nombreIngrediente + " en " + nombreRes + "?", "Modificación de datos", Global.SI, Global.NO);
                        switch (opcion) {
                            case JOptionPane.YES_OPTION: {
                                // Al no poderse editar dos campos a la vez y estar actualizados los contenidos se tira directamente de la DB
                                Restaurante res = Serializacion.getRestaurante(Global.RESTAURANT_FILE, nombreRes);
                                //Se consideran nuevas todas las comidas
                                ArrayList<Comida> comidasNuevas = new ArrayList<Comida>();
                                for (int row = 0; row < tablaC.getRowCount(); row++) {
                                    String nombre = (String) tablaC.getValueAt(row, encontrarIndice(tablaC, "Nombre"));
                                    double precio = (double) tablaC.getValueAt(row, encontrarIndice(tablaC, "Precio"));
                                    String rutaFoto = (String) tablaC.getValueAt(row, encontrarIndice(tablaC, "Ruta fotografia"));
                                    ArrayList<String> Ingredientes = Serializacion.getComida(res, nombre).getIngredientes();

                                    Comida nuevaComida = new Comida(nombre, Ingredientes, precio, rutaFoto);
                                    comidasNuevas.add(nuevaComida);
                                }
                                //Se obtiene el nombre del objeto comida cuyo ingrediente ha sido editado
                                Comida comidaTarget = res.getComidas().get(encontrarIndiceComidas(res.getComidas(), nombreComida));
                                //Indice sobre el que sobreescribir 
                                int indexComidaTarget = encontrarIndiceComidas(comidasNuevas, nombreComida);
                                
                                ArrayList<String> ingredientesNuevos = new ArrayList<String>();
                                for (int row = 0; row < tablaI.getRowCount(); row++) {
                                    String nombreIngredienteNuevo = (String) tablaI.getValueAt(row, encontrarIndice(tablaI, "Nombre"));
                                    ingredientesNuevos.add(nombreIngredienteNuevo);
                                }

                                comidaTarget.setIngredientes(ingredientesNuevos);

                                comidasNuevas.set(indexComidaTarget, comidaTarget);
                                res.setComidas(comidasNuevas);

                                System.out.print("Admin Menu: Edición confirmada de " + nombreRes + "(Comida)[" + nombreComida + "] -> [" + nombreIngrediente + "]\n\t|-> ");
                                Serializacion.anexar(Global.RESTAURANT_FILE, res);
                                break;
                            }

                            default:
                                System.out.println("Admin Menu: Edicion cancelada");
                                mostrarR();
                                break;
                        }

                    }
                }
            }
        });
    }

    /**
     * Detecta cuando el usuario esta editando la tabla de Opiniones y aplica (o
     * no) sus cambios
     *
     * @param R
     * @param O
     */
    public void ListenerEdicionOpiniones(TableModel R, TableModel O) {
        tablaO.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);            // 
        tablaO.getModel().addTableModelListener(new TableModelListener() {                      //Listener opiniones que salta cuando se edita una celda SOLO POR USUARIO
            @Override
            public void tableChanged(TableModelEvent e) {                                       // Parte hasta String nombre encargada de diferenciar rdicion de usuario de una de un porceso
                if (tablaO.isEditing()) {
                    int rowO = e.getFirstRow();
                    int columnO = e.getColumn();

                    int rowR = tablaR.getSelectedRow();
                    int columnR = tablaR.getSelectedColumn();

                    if ((rowR != -1 && columnR != -1) && (rowO != -1 && columnO != -1)) {                                                                 // Evita bugs al denegar el paneldecision

                        String nombreRes = (String) R.getValueAt(rowR, encontrarIndice(tablaR, "Nombre"));

                        
                        int puntNueva = (int) O.getValueAt(rowO, encontrarIndice(tablaO, "Puntuación"));

                        if (puntNueva <= 5) {
                            int opcion = Global.panelDecisionSN("¿Deseas registrar los cambios de " + nombreRes + "?", "Modificación de datos", Global.SI, Global.NO);
                            switch (opcion) {
                                case JOptionPane.YES_OPTION: {
                                    Restaurante resBase = Serializacion.getRestaurante(Global.RESTAURANT_FILE, nombreRes);

                                    ArrayList<Opinion> opiniones = new ArrayList<Opinion>();
                                    for (int row = 0; row < tablaO.getRowCount(); row++) {
                                        int puntuacion = (int) tablaO.getValueAt(row, encontrarIndice(tablaO, "Puntuación"));
                                        String comentario = (String) tablaO.getValueAt(row, encontrarIndice(tablaO, "Comentario"));

                                        opiniones.add(new Opinion(puntuacion, comentario));

                                    }

                                    resBase.setOpiniones(opiniones);

                                    System.out.print("Admin Menu: Edición confirmada de " + nombreRes + "(Opinion)" + "\n\t|-> ");
                                    Serializacion.anexar(Global.RESTAURANT_FILE, resBase);

                                    break;
                                }

                                default:
                                    System.out.println("Admin Menu: Edicion cancelada");
                                    mostrarR();
                                    break;
                            }
                        } else {
                            Global.panelAviso("La puntuación tiene que ser menor a 5");
                            System.out.println("Admin Menu: Edicion cancelada");
                            mostrarR();
                        }
                    }
                }
            }
        });
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
                int filaR = tablaR.getSelectedRow();
                if (filaC != -1) {

                    TableModel R = tablaR.getModel();
                    TableModel C = tablaC.getModel();

                    String nombreRestaurante = (String) R.getValueAt(filaR, encontrarIndice(tablaR, "Nombre"));
                    String nombreComida = (String) C.getValueAt(filaC, encontrarIndice(tablaC, "Nombre"));

                    ArrayList<Comida> comidas = Serializacion.getRestaurante(Global.RESTAURANT_FILE, nombreRestaurante).getComidas();

                    String str = "Ingredientes de '" + nombreComida + "'";

                    for (Comida comida : comidas) {
                        if (comida.getTitulo().equals(nombreComida)) {                  // Mostrar ingredientes de cada comida
                            mostrarI(comida);
                        }
                    }

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
     * Detecta cuando se edita alguno de los servicios acordados del catering
     */
    public void ListenerEdicionServicios() {
        TableModel R = tablaR.getModel();
        int rowR = tablaR.getSelectedRow();
        int columnR = tablaR.getSelectedColumn();

        if (rowR != -1 && columnR != -1) {
            String nombreRes = (String) R.getValueAt(rowR, encontrarIndice(tablaR, "Nombre"));
            int opcion = Global.panelDecisionSN("¿Deseas registrar los cambios de " + nombreRes + "?", "Modificación de datos", Global.SI, Global.NO);

            switch (opcion) {
                case JOptionPane.YES_OPTION:
                    Restaurante resBase = Serializacion.getRestaurante(Global.RESTAURANT_FILE, nombreRes);
                    boolean camareros = checkCamareros.isSelected();
                    boolean cocineros = checkCocineros.isSelected();
                    boolean deco = checkDeco.isSelected();
                    boolean espacio = checkEspacio.isSelected();

                    Catering cat = resBase.getCatering();
                    cat.setServicios(camareros, cocineros, deco,espacio);
                    
                    resBase.setCatering(cat);

                    Serializacion.anexar(Global.RESTAURANT_FILE, resBase);

                    

                    break;
                default:
                    System.out.println("Admin Menu: Edicion cancelada");
                    mostrarR();
                    break;
            }
        }
    }

    /**
     * Funcion básica para encontrar el inidice de un arraylist de comidas segun
     * nombre.
     *
     * @param comidas
     * @param nombre
     * @return
     */
    public static int encontrarIndiceComidas(ArrayList<Comida> comidas, String nombre) {
        int index = 0;

        while (index < comidas.size() && !comidas.get(index).getTitulo().equals(nombre)) {
            index++;
        }

        return index;
    }

    /**
     * Funcion básica para encontrar el inidice de un arraylist de opiniones
     * segun puntuacion y resena.
     *
     * @param opiniones
     * @param punt
     * @param resena
     * @return
     */
    public static int encontrarIndiceOpinion(ArrayList<Opinion> opiniones, int punt, String resena) {
        int index = 0;

        while (index < opiniones.size() && !(opiniones.get(index).getPuntuacion() == punt) && !(opiniones.get(index).getResena().equals(resena))) {
            index++;
        }

        return index;
    }

    /**
     * Convierte valor de celda Object a String Usa: {@link #encontrarIndice}
     *
     * @param row
     * @param colName
     * @return
     */
    public String RtoString(int row, String colName) {
        TableModel R = tablaR.getModel();
        return (String) R.getValueAt(row, encontrarIndice(tablaR, colName));
    }

    /**
     * Sobrecarga de {@link #RtoString(int, java.lang.String)} con Double
     *
     * @param row
     * @param colName
     * @return
     */
    public Double RtoDouble(int row, String colName) {
        TableModel R = tablaR.getModel();
        return (Double) R.getValueAt(row, encontrarIndice(tablaR, colName));
    }

    /**
     * Sobrecarga de {@link #RtoString(int, java.lang.String)} con Boolean
     *
     * @param row
     * @param colName
     * @return
     */
    public boolean RtoBoolean(int row, String colName) {
        TableModel R = tablaR.getModel();
        return (boolean) R.getValueAt(row, encontrarIndice(tablaR, colName));
    }

    /**
     * Sobrecarga de {@link #RtoString(int, java.lang.String)} con Int
     *
     * @param row
     * @param colName
     * @return
     */
    public int RtoInt(int row, String colName) {
        TableModel R = tablaR.getModel();
        return (int) R.getValueAt(row, encontrarIndice(tablaR, colName));
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

    /**
     * Muestra exclusivamente tabla restaurantes
     */
    public void mostrarR() {

        DefaultTableModel model = (DefaultTableModel) tablaR.getModel();                                     // Cargar en memoria modelo de la tabla para actualizar metiendo nueva row
        HashMap<String, Object> datos = Serializacion.cargarEnMemoria(Global.RESTAURANT_FILE);                   // Cargar en memoria usuarios

        model.setRowCount(0);                                                                         // Limpiar de todas las rows anteriores para actualizar
        checkCamareros.setSelected(false);
        checkCocineros.setSelected(false);
        checkDeco.setSelected(false);
        checkEspacio.setSelected(false);

        for (Map.Entry<String, Object> restaurante : datos.entrySet()) {                                          // Organizarlos en un set para poder iterarlos 
            Restaurante resT = (Restaurante) restaurante.getValue();
            Direccion dRes = resT.getDireccion();
            Object[] rowData = {resT.getCif(), resT.getNombre(), resT.getEspecialidad(), dRes.getCalle(), dRes.getNumero(), dRes.getCodigoPostal(), dRes.getCiudad(), resT.getCalificacion(), resT.getGastosEnvio(), resT.getTiempoMedioEnvio(), resT.isServicioCatering()};
            model.addRow(rowData);
        }
    }

   

    /**
     * Muestra exclusivamente tabla opiniones
     * @param res
     */
    public void mostrarO(Restaurante res) {
        DefaultTableModel model = (DefaultTableModel) tablaO.getModel();
        ArrayList<Opinion> opiniones = res.getOpiniones();

        model.setRowCount(0);
        for (Opinion opinion : opiniones) {                                          // Organizarlos en un set para poder iterarlos 
            Object[] rowData = {opinion.getPuntuacion(), opinion.getResena()};
            model.addRow(rowData);
        }
    }

    /**
     * Muestra exclusivamente tabla Comidas
     * @param res
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
     * @param comida
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
        Java = new javax.swing.JLabel();
        Eat = new javax.swing.JLabel();
        particularesTexto1 = new javax.swing.JLabel();
        scrollR = new javax.swing.JScrollPane();
        tablaR = new javax.swing.JTable();
        textoComidas = new javax.swing.JLabel();
        textoOpiniones = new javax.swing.JLabel();
        scrollIngredientes = new javax.swing.JScrollPane();
        tablaI = new javax.swing.JTable();
        textoIngredientes = new javax.swing.JLabel();
        scrollOpiniones = new javax.swing.JScrollPane();
        tablaO = new javax.swing.JTable();
        scrollComida = new javax.swing.JScrollPane();
        tablaC = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        textoDatos = new javax.swing.JLabel();
        botonBorrar = new javax.swing.JButton();
        botonClean = new javax.swing.JButton();
        textoCatering = new javax.swing.JLabel();
        textoCantidadTotal = new javax.swing.JLabel();
        botonCrear = new javax.swing.JButton();
        checkCocineros = new javax.swing.JCheckBox();
        checkCamareros = new javax.swing.JCheckBox();
        checkDeco = new javax.swing.JCheckBox();
        checkEspacio = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(246, 238, 249));
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
        particularesTexto.setText("Restaurantes (Permite edición de campos)");
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
        particularesTexto1.setText("Panel de Restaurantes");
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
                .addGap(24, 24, 24)
                .addComponent(particularesTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 935, Short.MAX_VALUE)
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

        jPanel1.add(BarraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1496, -1));

        scrollR.setBackground(new java.awt.Color(246, 238, 249));

        tablaR.setBackground(new java.awt.Color(234, 223, 238));
        tablaR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIF", "Nombre", "Especialidad", "Calle", "Número", "Código Postal", "Ciudad", "Calificación Global", "Gastos de Envío", "Tiempo de envio", "Tiene Servicio Catering"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaR.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaR.getTableHeader().setReorderingAllowed(false);
        scrollR.setViewportView(tablaR);

        jPanel1.add(scrollR, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 125, 1262, 186));

        textoComidas.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoComidas.setForeground(new java.awt.Color(0, 0, 0));
        textoComidas.setText("Comidas");
        textoComidas.setToolTipText("");
        jPanel1.add(textoComidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 409, -1, -1));

        textoOpiniones.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoOpiniones.setForeground(new java.awt.Color(0, 0, 0));
        textoOpiniones.setText("Opiniones");
        textoOpiniones.setToolTipText("");
        jPanel1.add(textoOpiniones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 409, -1, -1));

        scrollIngredientes.setBackground(new java.awt.Color(246, 238, 249));

        tablaI.setBackground(new java.awt.Color(234, 223, 238));
        tablaI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ));
        tablaI.getTableHeader().setReorderingAllowed(false);
        scrollIngredientes.setViewportView(tablaI);

        jPanel1.add(scrollIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 451, 260, 190));

        textoIngredientes.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoIngredientes.setForeground(new java.awt.Color(0, 0, 0));
        textoIngredientes.setText("Ingredientes");
        textoIngredientes.setToolTipText("");
        textoIngredientes.setAutoscrolls(true);
        jPanel1.add(textoIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 409, 260, -1));

        scrollOpiniones.setBackground(new java.awt.Color(246, 238, 249));

        tablaO.setBackground(new java.awt.Color(234, 223, 238));
        tablaO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Puntuación", "Comentario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaO.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaO.getTableHeader().setReorderingAllowed(false);
        scrollOpiniones.setViewportView(tablaO);

        jPanel1.add(scrollOpiniones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1041, 451, 404, 190));

        scrollComida.setBackground(new java.awt.Color(246, 238, 249));

        tablaC.setBackground(new java.awt.Color(234, 223, 238));
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

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaC.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaC.getTableHeader().setReorderingAllowed(false);
        scrollComida.setViewportView(tablaC);

        jPanel1.add(scrollComida, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 451, 281, 190));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 382, 1388, 9));

        textoDatos.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoDatos.setForeground(new java.awt.Color(0, 0, 0));
        textoDatos.setText("Datos");
        textoDatos.setToolTipText("");
        jPanel1.add(textoDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 346, 377, -1));

        botonBorrar.setBackground(new java.awt.Color(246, 238, 249));
        botonBorrar.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        botonBorrar.setForeground(new java.awt.Color(0, 0, 0));
        botonBorrar.setText("Borrar  Restaurante Seleccionado");
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
        jPanel1.add(botonBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 660, 384, -1));

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
        jPanel1.add(botonClean, new org.netbeans.lib.awtextra.AbsoluteConstraints(1063, 660, 384, -1));

        textoCatering.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoCatering.setForeground(new java.awt.Color(0, 0, 0));
        textoCatering.setText("Catering");
        textoCatering.setToolTipText("");
        textoCatering.setAutoscrolls(true);
        jPanel1.add(textoCatering, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 415, 260, -1));

        textoCantidadTotal.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        textoCantidadTotal.setForeground(new java.awt.Color(0, 0, 0));
        textoCantidadTotal.setToolTipText("");
        textoCantidadTotal.setAutoscrolls(true);
        textoCantidadTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(textoCantidadTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 660, 350, 27));

        botonCrear.setBackground(new java.awt.Color(246, 238, 249));
        botonCrear.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        botonCrear.setForeground(new java.awt.Color(0, 0, 0));
        botonCrear.setText("Crear Restaurante");
        botonCrear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                botonCrearFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                botonCrearFocusLost(evt);
            }
        });
        botonCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCrearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonCrearMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonCrearMousePressed(evt);
            }
        });
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        jPanel1.add(botonCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 660, 204, -1));

        checkCocineros.setBackground(new java.awt.Color(246, 238, 249));
        checkCocineros.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        checkCocineros.setForeground(new java.awt.Color(0, 0, 0));
        checkCocineros.setText("Cocineros (1000)");
        checkCocineros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkCocinerosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                checkCocinerosMousePressed(evt);
            }
        });
        jPanel1.add(checkCocineros, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 450, 183, -1));

        checkCamareros.setBackground(new java.awt.Color(246, 238, 249));
        checkCamareros.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        checkCamareros.setForeground(new java.awt.Color(0, 0, 0));
        checkCamareros.setText("Camareros (800)");
        checkCamareros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkCamarerosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                checkCamarerosMousePressed(evt);
            }
        });
        jPanel1.add(checkCamareros, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, 183, -1));

        checkDeco.setBackground(new java.awt.Color(246, 238, 249));
        checkDeco.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        checkDeco.setForeground(new java.awt.Color(0, 0, 0));
        checkDeco.setText("Decoración (500)");
        checkDeco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkDecoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                checkDecoMousePressed(evt);
            }
        });
        jPanel1.add(checkDeco, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 480, 183, -1));

        checkEspacio.setBackground(new java.awt.Color(246, 238, 249));
        checkEspacio.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        checkEspacio.setForeground(new java.awt.Color(0, 0, 0));
        checkEspacio.setText("Espacio Privado (1000)");
        checkEspacio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkEspacioMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                checkEspacioMousePressed(evt);
            }
        });
        jPanel1.add(checkEspacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, 183, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 710));

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

    private void botonBorrarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonBorrarFocusGained

    }//GEN-LAST:event_botonBorrarFocusGained

    private void botonBorrarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonBorrarFocusLost

    }//GEN-LAST:event_botonBorrarFocusLost
/**
 * Limpia la tabla del restaurante borrado
 * @param evt 
 */
    private void botonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBorrarMouseClicked
        int filaR = tablaR.getSelectedRow();
        if (filaR != -1) {
            TableModel R = tablaR.getModel();
            String mail;

            // Codigo tiene que ser optimizado, mucha repeticion
            mail = (String) R.getValueAt(filaR, 1);

            int opcion = Global.panelDecisionSN("¿Deseas borrar al restaurante " + mail + "?", "Borrado de restaurante", Global.SI, Global.NO);
            switch (opcion) {
                case JOptionPane.YES_OPTION: {
                    Serializacion.borrarRestaurante(Global.RESTAURANT_FILE, mail);
                    mostrarR();
                    break;
                }
                default:
                    break;
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
        tablaR.clearSelection();
        tablaO.clearSelection();
        tablaC.clearSelection();
        tablaI.clearSelection();
        checkCamareros.setSelected(false);
        checkCocineros.setSelected(false);
        checkDeco.setSelected(false);
        checkEspacio.setSelected(false);

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

    private void botonCrearFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonCrearFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCrearFocusGained

    private void botonCrearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_botonCrearFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCrearFocusLost

    private void botonCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCrearMouseClicked
        frr.setVisible(true);
        try {
            frr.vaciarWindow();
        } catch (IOException ex) {
            Logger.getLogger(adminRestaurantesWindow.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_botonCrearMouseClicked

    private void botonCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCrearMouseEntered
        botonCrear.setForeground(Color.white);
        botonCrear.setBackground(Color.green);
    }//GEN-LAST:event_botonCrearMouseEntered

    private void botonCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCrearMouseExited
        botonCrear.setBackground(Global.ROSA);
        botonCrear.setForeground(Color.black);
    }//GEN-LAST:event_botonCrearMouseExited

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCrearActionPerformed

    private void checkCamarerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkCamarerosMouseClicked

    }//GEN-LAST:event_checkCamarerosMouseClicked

    private void checkDecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkDecoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_checkDecoMouseClicked

    private void checkCocinerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkCocinerosMouseClicked

    }//GEN-LAST:event_checkCocinerosMouseClicked

    private void checkEspacioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkEspacioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_checkEspacioMouseClicked

    private void botonCrearMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCrearMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCrearMousePressed

    private void checkCamarerosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkCamarerosMousePressed
        ListenerEdicionServicios();// TODO add your handling code here:
    }//GEN-LAST:event_checkCamarerosMousePressed

    private void checkCocinerosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkCocinerosMousePressed
        ListenerEdicionServicios();        // TODO add your handling code here:
    }//GEN-LAST:event_checkCocinerosMousePressed

    private void checkDecoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkDecoMousePressed
        ListenerEdicionServicios();        // TODO add your handling code here:
    }//GEN-LAST:event_checkDecoMousePressed

    private void checkEspacioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkEspacioMousePressed
        ListenerEdicionServicios();        // TODO add your handling code here:
    }//GEN-LAST:event_checkEspacioMousePressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new adminRestaurantesWindow().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(adminRestaurantesWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JLabel Eat;
    private javax.swing.JLabel Java;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonClean;
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonExit;
    private javax.swing.JCheckBox checkCamareros;
    private javax.swing.JCheckBox checkCocineros;
    private javax.swing.JCheckBox checkDeco;
    private javax.swing.JCheckBox checkEspacio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel particularesTexto;
    private javax.swing.JLabel particularesTexto1;
    private javax.swing.JScrollPane scrollComida;
    private javax.swing.JScrollPane scrollIngredientes;
    private javax.swing.JScrollPane scrollOpiniones;
    private javax.swing.JScrollPane scrollR;
    private javax.swing.JTable tablaC;
    private javax.swing.JTable tablaI;
    private javax.swing.JTable tablaO;
    private javax.swing.JTable tablaR;
    private javax.swing.JLabel textoCantidadTotal;
    private javax.swing.JLabel textoCatering;
    private javax.swing.JLabel textoComidas;
    private javax.swing.JLabel textoDatos;
    private javax.swing.JLabel textoIngredientes;
    private javax.swing.JLabel textoOpiniones;
    // End of variables declaration//GEN-END:variables
}
