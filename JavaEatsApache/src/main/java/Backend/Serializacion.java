package Backend;

import java.io.*;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;

/**
 * Paquete para crear, borrar y modificar ficheros
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class Serializacion {

    /**
     * Creador de claves para cliente particular
     *
     * @see #anexar(java.lang.String, Backend.Cliente_Particular)
     * @param cp {@link Cliente_Particular} al que se le aplica
     * @return String clave
     */
    public static String creadorKey(Cliente_Particular cp) {    //Forma rapida de reconocer Particular
        return (cp.getMail() + "P");
    }

    /**
     * Creador de claves para cliente empresa
     *
     * @see #anexar(java.lang.String, Backend.Cliente_Empresa)
     * @param cp {@link Cliente_Empresa} al que se le aplica
     * @return String clave
     */
    public static String creadorKey(Cliente_Empresa cp) {       //Forma rapida de reconocer Empresa 
        return (cp.getMail() + "E");
    }

    /**
     * Carga en memorioa (proceso repetitivo) un archivo de datos tipo
     * HashMap(String, Object). Muy usada
     *
     * @param filename Archivo a cargar
     * @return Hasmap
     */
    public static HashMap<String, Object> cargarEnMemoria(String filename) {           // Proceso recurrente encapsulado
        HashMap<String, Object> datos = null;
        //Carga archivo en memoria
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            datos = (HashMap<String, Object>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return datos;
    }

    /**
     * Encargado de leer si existe el archivo de persistencia de inicio de
     * sesión
     *
     * @see Frontend.loginInicial#init()
     * @param filename
     * @return
     */
    public static LoginConfig cargarEnMemoriaLogin(String filename) {           // Proceso recurrente encapsulado
        LoginConfig login = null;
        //Carga archivo en memoria
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            login = (LoginConfig) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return login;
    }

    /**
     * Encargado de leer si existe el archivo de persistencia de inicio de
     * sesión
     *
     * @see Frontend.loginInicial#init()
     * @param filename
     * @return
     */
    public static ArrayList<Venta> cargarEnMemoriaVenta(String filename) {           // Proceso recurrente encapsulado
        ArrayList<Venta> venta = null;
        //Carga archivo en memoria
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            venta = (ArrayList<Venta>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return venta;
    }

    /**
     * Encargado de leer si existe el archivo de persistencia de inicio de
     * sesión
     *
     * @see Frontend.loginInicial#init()
     * @param filename
     * @return
     */
    public static ArrayList<Comida> cargarEnMemoriaComidas(String filename) {           // Proceso recurrente encapsulado
        ArrayList<Comida> comidas = new ArrayList<Comida>();
        //Carga archivo en memoria
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            comidas = (ArrayList<Comida>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return comidas;
    }

    /**
     * Se activa cuando no existen los ficheros, habilidad de funcionar si no
     * existen. Especifico de usuarios
     *
     * @see Backend.JavaEatsApache Usa paquetes de: {@link Automate}
     * @param filename Archivo a crear
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void crearFichero(String filename) throws FileNotFoundException, IOException {      // Uso unico
        File fn = new File(filename);
        if (!fn.exists()) {
            // Usuario admin  
            Usuario adminU = new Usuario("admin", "admin@javaeat.com", "admin", new Direccion("", "", "", ""), new Tarjeta("", " ", "", ""), " ");
            Cliente_Particular admin = new Cliente_Particular(adminU, "-");

            // Creador  hasmap del fichero  
            HashMap<String, Object> datos = new HashMap<>();
            datos.put(creadorKey(admin), admin);

            // Creacion archivo
            FileOutputStream fos = new FileOutputStream(filename, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Volcado admin
            oos.writeObject(datos);
            oos.close();

            System.out.println("Serializacion: Archivo DB [" + filename + "] nuevo creado + <" + admin.getNombre() + ">");
            System.out.print("\n\t|->");

            Automate.anexarUsuario1(filename);
            System.out.print("\n\t|->");
            Automate.anexarUsuario2(filename);
            System.out.print("\n\t|->");
            Automate.anexarUsuarioE1(filename);
            System.out.print("\n\t|->");
            Automate.anexarUsuarioE2(filename);
            System.out.print("\n\t|->");
            Automate.anexarUsuarioE3(filename);
        } else {
            System.out.println("Serializacion: Archivo existe [" + filename + "]");
        }
    }

    /**
     * Se activa cuando no existen los ficheros, habilidad de funcionar si no
     * existen. Especifico de restaurantes
     *
     * @see Backend.JavaEatsApache Usa paquetes de: {@link Automate}
     * @param filename Archivo a crear
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void crearFicheroRestaurante(String filename) throws FileNotFoundException, IOException {      // Uso unico
        File fn = new File(filename);

        if (!fn.exists()) {
            // Usuario admin  
            ArrayList<String> ingredientes1 = new ArrayList<String>() {
                {
                    add("Pollo");
                    add("Pimiento verde");
                    add("Cebolla");
                    add("Salsa de soja");
                }
            };

            ArrayList<String> ingredientes2 = new ArrayList<String>() {
                {
                    add("Salmon");
                    add("Espinacas");
                    add("Aceite de oliva");
                    add("Limón");
                }
            };
            ArrayList<String> ingredientes3 = new ArrayList<String>() {
                {
                    add("Tofu");
                    add("Zanahoria");
                    add("Champiñones");
                    add("Salsa teriyaki");
                }
            };

            ArrayList<Opinion> opiniones = new ArrayList<Opinion>() {
                {
                    add(new Opinion(5, "Bueno"));
                    add(new Opinion(4, "Decente"));
                    add(new Opinion(3, "Gracioso"));
                }
            };
            ArrayList<Comida> comidas = new ArrayList<Comida>() {
                {
                    add(new Comida("Pizza Pollo", ingredientes1, 10, "fotografias/PP.png"));
                    add(new Comida("Pizza del mar", ingredientes1, 5, "fotografias/PM.png"));
                    add(new Comida("Pizza vegana", ingredientes1, 6, "fotografias/PV.png"));
                }
            };
            Catering cat = new Catering(false, false, false, false);
            Restaurante res = new Restaurante("U99213100", "EL probador", new Direccion("Mira", "2", "28001", "Madrid"), "Pizza", 2.5, 5, opiniones, comidas, cat);

            // Creador  hasmap del fichero  
            HashMap<String, Object> datos = new HashMap<>();
            datos.put(res.getNombre(), res);

            // Creacion archivo
            FileOutputStream fos = new FileOutputStream(filename, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Volcado admin
            oos.writeObject(datos);
            oos.close();
            System.out.println("Serializacion: Archivo DB [" + filename + "] nuevo creado + <" + res.getNombre() + ">");

            System.out.print("\n\t|->");
            Automate.anexoRestaurante1(filename);
            System.out.print("\n\t|->");
            Automate.anexoRestaurante2(filename);
            System.out.print("\n\t|->");
            Automate.anexoRestaurante3(filename);
            System.out.print("\n\t|->");
            Automate.anexoRestaurante4(filename);
        } else {
            System.out.println("Serializacion: Archivo existe [" + filename + "]");
        }
    }

    /**
     * Se activa cuando no existen los ficheros, habilidad de funcionar si no
     * existen. Especifico de ventas
     *
     * 
     * @param filename Archivo a crear
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void crearFicheroVentas(String filename) throws FileNotFoundException, IOException {      // Uso unico
        File fn = new File(filename);
        if (!fn.exists()) {

            // Creador  hasmap del fichero  
            ArrayList<Venta> datos = new ArrayList<Venta>();

            // Creacion archivo
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Volcado admin
            oos.writeObject(datos);
            oos.close();

            System.out.println("Serializacion: Archivo DB [" + filename + "] nuevo creado ");

        } else {
            System.out.println("Serializacion: Archivo existe [" + filename + "]");
        }
    }

    public static void crearVentaTxt(Venta venta) throws FileNotFoundException, IOException {      // Uso unico

        String filename = "venta" + LocalTime.now() + ".txt";

        // Creacion archivo
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // Volcado adminfo
        oos.writeObject(venta);
        oos.close();

        System.out.println("Serializacion: Archivo DB [" + filename + "] nuevo creado ");

    }

    /**
     * Sobrecarga de metodo
     * {@link #anexar(java.lang.String, Backend.Cliente_Particular)}
     * Para ventas
     * @param filename
     * @param venta 
     */
    public static void anexar(String filename, Venta venta) {
        // Carga en memoria el archivo
        ArrayList<Venta> datos = cargarEnMemoriaVenta(filename);

        // Anexar objetos al HashMap
        datos.add(venta);

        // Serializar HashMap anexado
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(datos);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Serializacion: Venta anexada [" + venta.getFechaVenta() + "]");
    }

    /**
     * Se activa cuando no existen los ficheros, habilidad de funcionar si no
     * existen. Especifico de venta
     *
     * @param filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void limpiarFicheroVentas(String filename) throws FileNotFoundException, IOException {      // Uso unico
        File fn = new File(filename);

        // Creador  arraylist de fichero 
        ArrayList<Venta> datos = new ArrayList<Venta>();

        // Creacion archivo
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // Volcado admin
        oos.writeObject(datos);
        oos.close();
        System.out.println("Serializacion: Archivo DB [" + filename + "] limpio");

    }

    /**
     * Anexa en archivo un usuario, exclusivo en usuarios Utiliza clase: {@link #cargarEnMemoria}
     *                {@link #creadorKey(Backend.Cliente_Particular)}
     *
     * @param filename
     * @param userP
     */
    public static void anexar(String filename, Cliente_Particular userP) {                              // Sobrecarga de metodo para ambos tipos de usuario, almacenados en mismo hasmap, diferenciados por letra al final (P,E) 
        // Carga en memoria el archivo
        HashMap<String, Object> datos = cargarEnMemoria(filename);

        // Anexar objetos al HashMap
        datos.put(creadorKey(userP), userP);

        // Serializar HashMap anexado
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(datos);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Serializacion: <" + userP.getNombre() + "> [particular] anexado");
    }

    /**
     * Sobrecarga de metodo
     * {@link #anexar(java.lang.String, Backend.Cliente_Particular)}
     * Para empresas
     *
     * @param filename
     * @param userE
     */
    public static void anexar(String filename, Cliente_Empresa userE) {
        // Carga en memoria el archivo
        HashMap<String, Object> datos = cargarEnMemoria(filename);

        // Anexar objetos al HashMap
        datos.put(creadorKey(userE), userE);

        // Serializar HashMap anexado
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(datos);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Serializacion: <" + userE.getNombre() + "> [empresa] anexado");
    }

    /**
     * Anexa en archivo un restaurante, exclusivo en restaurantes Utiliza clase:
     * {@link #cargarEnMemoria}
     *
     * @param filename
     * @param restaurante
     */
    public static void anexar(String filename, Restaurante restaurante) {
        // Carga en memoria el archivo
        HashMap<String, Object> datos = cargarEnMemoria(filename);

        // Anexar objetos al HashMap
        datos.put(restaurante.getNombre(), restaurante);

        // Serializar HashMap anexado
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(datos);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Serializacion: <" + restaurante.getNombre() + "> [restaurante] anexado [" + filename + "]");
    }

    /**
     * Anexa en archivo un restaurante, exclusivo en comida Utiliza clase:
     * {@link #cargarEnMemoriaComidas(java.lang.String)}
     *
     * @param filename
     * @param comida
     */
    public static void anexar(String filename, Comida comida) {
        // Carga en memoria el archivo
        ArrayList<Comida> datos = cargarEnMemoriaComidas(filename);

        // Anexar objetos al HashMap
        datos.add(comida);

        // Serializar HashMap anexado
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(datos);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Serializacion: <" + comida.getTitulo() + "> [comida] anexado [" + filename + "]");
    }

    /**
     * Superflua, de test
     *
     * @param filename
     */
    public static void leer(String filename) {
        HashMap<String, Object> datos = cargarEnMemoria(filename);
        System.out.println(datos);
    }

    /**
     * Función booleana de comprobación si esta en la base de datos
     *
     * @see Frontend.FormularioCreacionCuenta#BotonRegistrarActionPerformed(java.awt.event.ActionEvent)
     * @param filename
     * @param mail
     * @return
     */
    public static boolean estaEnBD(String filename, String mail) {                  //Enlazado en FormularioCreacionCuenta -> aceptarActionPerformed
        HashMap<String, Object> datos = cargarEnMemoria(filename);
        return (datos.containsKey(mail + "P") || datos.containsKey(mail + "E"));
    }

    /**
     * Función booleana de comprobación si esta en la base de datos un
     * restaurante
     *
     * @param filename
     * @param mail
     * @return
     */
    public static boolean estaEnBdRestaurante(String filename, String mail) {                  //Enlazado en FormularioCreacionCuenta -> aceptarActionPerformed
        HashMap<String, Object> datos = cargarEnMemoria(filename);
        return (datos.containsKey(mail));
    }

    /**
     * Función booleana de comprobación si es un particular en la base de datos
     *
     * @param filename
     * @param mail
     * @return
     */
    public static boolean esParticular(String filename, String mail) {
        HashMap<String, Object> datos = cargarEnMemoria(filename);
        return datos.containsKey(mail + "P");
    }

    /**
     * Función booleana de comprobación si puede logearse
     *
     * @see Frontend.loginInicial#BotonAceptarActionPerformed(java.awt.event.ActionEvent)
     * @param filename
     * @param mail
     * @return
     */
    public static boolean puedeLogin(String filename, String mail, String passwd) {  // Se entiende que no puede haber un mail registrado dos veces por empresa y particular
        HashMap<String, Object> datos = cargarEnMemoria(filename);                  //Carga en memoria
        boolean result = false;
        String clave;
        if (estaEnBD(filename, mail)) {
            if (datos.containsKey(mail + "P")) {                                     //Acceso a contenido con key particular
                Cliente_Particular cP = (Cliente_Particular) datos.get(mail + "P");
                clave = cP.getClave();
            } else {                                                                   // Acceso a contendio con key empresa 
                Cliente_Empresa cE = (Cliente_Empresa) datos.get(mail + "E");
                clave = cE.getClave();
            }
            result = passwd.equals(clave);
        }
        return result;
    }

    /**
     * Borra un usuario
     *
     * @param filename
     * @param mail
     */
    public static void borrarUsuario(String filename, String mail) {
        HashMap<String, Object> datos = cargarEnMemoria(filename);                  //Carga en memoria
        String key;
        String frase = "Serializacion: Usuario eliminado <" + mail + ">";
        if (esParticular(filename, mail)) {
            key = mail + "P";
            frase += "[particular]";
        } else {
            key = mail + "E";
            frase += "[empresa]";
        }

        datos.remove(key);
        if (!datos.containsKey(key)) {
            System.out.println(frase);   // Confirmar que se ha borrado 
        }

        // Serializar HashMap anexado
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(datos);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Borra un restaurante
     *
     * @param filename
     * @param nombre
     */
    public static void borrarRestaurante(String filename, String nombre) {
        HashMap<String, Object> datos = cargarEnMemoria(filename);                  //Carga en memoria

        String frase = "Serializacion: Usuario eliminado <" + nombre + ">";

        datos.remove(nombre);
        if (!datos.containsKey(nombre)) {
            System.out.println(frase);   // Confirmar que se ha borrado 
        }

        // Serializar HashMap anexado
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(datos);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Con un nombre devuelve el objeto Restaurante correspondiente a este
     * Utiliza clase: {@link #cargarEnMemoria}
     *
     * @param filename
     * @param nombre
     * @return
     */
    public static Restaurante getRestaurante(String filename, String nombre) {
        HashMap<String, Object> datos = cargarEnMemoria(filename);                  //Carga en memoria
        Restaurante res = (Restaurante) datos.get(nombre);
        return res;
    }

    /**
     * Sobrecarga de metodo con Cliente_Particular {@link #getRestaurante(java.lang.String, java.lang.String)
     * }
     *
     * @param filename
     * @param nombre
     * @return
     */
    public static Cliente_Particular getClienteParticular(String filename, String nombre) {

        HashMap<String, Object> datos = cargarEnMemoria(filename);                  //Carga en memoria
        Cliente_Particular usr = (Cliente_Particular) datos.get(nombre + "P");

        //System.out.println(usr.getDireccion()); // Pasa como toString?!?!??!
        return usr;
    }

    /**
     * Sobrecarga de metodo con Cliente_Empresa {@link #getRestaurante(java.lang.String, java.lang.String)
     * }
     *
     * @param filename
     * @param nombre
     * @return
     */
    public static Cliente_Empresa getClienteEmpresa(String filename, String nombre) {
        HashMap<String, Object> datos = cargarEnMemoria(filename);                  //Carga en memoria
        Cliente_Empresa usr = (Cliente_Empresa) datos.get(nombre + "E");
        return usr;
    }

    /**
     * Consigue la comida como objeto por su nombre de determinado restaurante
     *
     * @param res
     * @param comidaNombre
     * @return
     */
    public static Comida getComida(Restaurante res, String comidaNombre) {
        ArrayList<Comida> comidas = res.getComidas();
        int index = 0;

        while (index < comidas.size() && !comidas.get(index).getTitulo().equals(comidaNombre)) {
            index++;
        }

        return comidas.get(index);
    }

    /**
     * Se activa cuando no existen los ficheros, habilidad de funcionar si no
     * existen. Especifico de comidas
     *
     * @param filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void crearFicheroComidas(String filename) throws FileNotFoundException, IOException {      // Uso unico
        File fn = new File(filename);
        if (!fn.exists()) {
            // Creador  arraylist de fichero 
            ArrayList<Comida> datos = new ArrayList<Comida>();

            // Creacion archivo
            FileOutputStream fos = new FileOutputStream(filename, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Volcado admin
            oos.writeObject(datos);
            oos.close();
            System.out.println("Serializacion: Archivo DB [" + filename + "] nuevo creado");
        } else {
            System.out.println("Serializacion: Archivo existe [" + filename + "]");
        }
    }

    /**
     * Se activa cuando no existen los ficheros, habilidad de funcionar si no
     * existen. Especifico de comidas
     *
     * @param filename
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void limpiarFicheroComidas(String filename) throws FileNotFoundException, IOException {      // Uso unico
        File fn = new File(filename);

        // Creador  arraylist de fichero 
        ArrayList<Comida> datos = new ArrayList<Comida>();

        // Creacion archivo
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // Volcado admin
        oos.writeObject(datos);
        oos.close();
        System.out.println("Serializacion: Archivo DB [" + filename + "] limpio");

    }

    /**
     * Borra una comida
     *
     * @param filename
     * @param nombre
     */
    public static void borrarComida(String filename, String nombre) {
        ArrayList<Comida> datos = cargarEnMemoriaComidas(filename);                  //Carga en memoria

        int i = 0;
        while (i < datos.size() && !datos.get(i).getTitulo().equals(nombre)) {
            i++;
        }
        if (datos.get(i).getTitulo().equals(nombre)) {
            datos.remove(i);
            System.out.println("Serializacion: Comida eliminado <" + nombre + ">");
        }

        // Serializar arraylist anexado
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(datos);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * Funcion checkeo para {@link #emitirFactura(Backend.Venta, double, java.lang.String)}
     * @param name
     * @param check
     * @return 
     */
    private static String checkPrint(String name, boolean check) {
        String input = "";
        if (check) {
            input = "+ " + name + "\n";
        }
        return input;
    }
    
    /**
     * Encargado solo de poder emitir la factura con un estilo especifico de texto plano
     * @param venta
     * @param total
     * @param filename 
     */
    public static void emitirFactura(Venta venta, double total, String filename) {

        // Instancias y clases
        String mail = venta.getMail();
        Restaurante res = venta.getRestaurant();
        Direccion dire = res.getDireccion();
        Catering cate = res.getCatering();
        ArrayList<Comida> comidaRes = res.getComidas();

        String escritos = "JAVAEAT\nFactura  ---------------------- \n";
        String fecha = "\nDatos de fecha: -----\n+Fecha: " + venta.getFechaVenta() + "\n";
        escritos += fecha;

        String nombre = "\nDatos de restaurante: -----\n" + "+ Nombre: " + res.getNombre() + "\n";
        String cif = "+ CIF: " + res.getCif() + "\n";
        String dir = "+ Direción:\n\t+ Calle: " + dire.getCalle() + "\n\t+ Número: " + dire.getNumero() + "\n\t+ Código Postal: " + dire.getCodigoPostal() + "\n\t+ Ciudad: " + dire.getCiudad() + "\n";
        String esp = "+ Especialidad: " + res.getEspecialidad() + "\n";
        String cal = "+ Calificación promedio: " + res.getCalificacion() + "\n";
        String gde = "+ Gastos de envío: " + res.getGastosEnvio() + "€" + "\n";
        String tde = "+ Tiempo de envío: " + res.getTiempoMedioEnvio() + "€" + "\n";

        escritos += (nombre + cif + dir + esp + cal + gde + tde);

        // Datos de comidas disponibles
        String comidaResTxt = "+ Comidas disponibles:\n";
        for (Comida comida : comidaRes) {
            String nombreC = "\t+Nombre: " + comida.getTitulo() + "\n\t";
            String precioC = "|-> Precio: " + Double.toString(comida.getPrecio()) + "€" + "\n\t";
            comidaResTxt += (nombreC + precioC + "|-> Ingredientes: ");
            ArrayList<String> ingredientes = comida.getIngredientes();
            for (String ingrediente : ingredientes) {
                comidaResTxt += "[" + ingrediente + "]";
            }
            comidaResTxt += "\n\n";
        }
        escritos += comidaResTxt;

        // Datos catering disponible
        if (res.isServicioCatering()) {
            String cat = "\nDatos de catering: -----\n+ Servicio de catering disponible: \n";
            cat += "\t" + checkPrint("Camareros (800 €)", cate.hayCamareros());
            cat += "\t" + checkPrint("Cocineros (1000 €)", cate.hayCocineros());
            cat += "\t" + checkPrint("Decoración (500 €)", cate.hayDeco());
            cat += "\t" + checkPrint("Espacio Privado (1000 €)", cate.hayEP());
            escritos += cat;
        }
        String usrTxt = "\nDatos de usuario: -----\n";

        //Datos usuario
        if (esParticular(Global.USER_FILE, mail)) {
            Cliente_Particular cp = getClienteParticular(Global.USER_FILE, mail);
            Direccion direc = cp.getDireccion();
            Tarjeta tarc = cp.getTarjetaCredito();
            String nombrec = "+ Nombre: " + cp.getNombre() + "\n";
            String mailc = "+ Mail: " + cp.getMail() + "\n";
            String clavec = "+ Clave: " + cp.getNombre() + "\n";
            String dirCP = "+ Direción:\n\t+ Calle: " + direc.getCalle() + "\n\t+ Número: " + direc.getNumero() + "\n\t+ Código Postal: " + direc.getCodigoPostal() + "\n\t+ Ciudad: " + direc.getCiudad() + "\n";
            String tarCP = "+ Direción:\n\t+ Titular: " + tarc.getTitular() + "\n\t+ Número: " + tarc.getNumero() + "\n\t+ Fecha de Caducidad: " + tarc.getCaducidad() + "\n";
            String telfC = "+ Teléfono: " + cp.getTelefono() + "\n";
            String dniC = "+ DNI: " + cp.getDNI() + "\n";
            usrTxt += (nombrec + mailc + clavec + dirCP + tarCP + telfC + dniC);

        } else {
            Cliente_Empresa cp = getClienteEmpresa(Global.USER_FILE, mail);
            Direccion direc = cp.getDireccion();
            Tarjeta tarc = cp.getTarjetaCredito();
            String nombrec = "+ Nombre: " + cp.getNombre() + "\n";
            String mailc = "+ Mail: " + cp.getMail() + "\n";
            String clavec = "+ Clave: " + cp.getNombre() + "\n";
            String dirCP = "+ Direción:\n\t+ Calle: " + direc.getCalle() + "\n\t+ Número: " + direc.getNumero() + "\n\t+ Código Postal: " + direc.getCodigoPostal() + "\n\t+ Ciudad: " + direc.getCiudad() + "\n";
            String tarCP = "+ Direción:\n\t+ Titular: " + tarc.getTitular() + "\n\t+ Número: " + tarc.getNumero() + "\n\t+ Fecha de Caducidad: " + tarc.getCaducidad() + "\n";
            String telfC = "+ Teléfono: " + cp.getTelefono() + "\n";
            String cifC = "+ CIF: " + cp.getCif() + "\n";
            String webC = "+ Web: " + cp.getWeb() + "\n";
            usrTxt += (nombrec + mailc + clavec + dirCP + tarCP + telfC + cifC + webC);
        }
        escritos += usrTxt;

        // Datos del pedido, comidas y servicios
        ArrayList<Comida> comidasCompradas = venta.getComidas();
        String com = "\nDatos de pedido: -----\n+Comida solicitada: \n";
        for (Comida comida : comidasCompradas) {
            String nombreC = "\t+Nombre: " + comida.getTitulo() + "\n";
            String precioC = "\t|-> Precio: " + Double.toString(comida.getPrecio()) + "€" + "\n";
            com += (nombreC + precioC);
        }
        HashMap<String, Double> serEx = venta.getServicios();
        if (serEx.size() > 0) {
            com += "+ Servicios solicitados\n";
            for (Map.Entry<String, Double> entry : serEx.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();

                com += "\t+Nombre: " + key + "\n";
                com += "\t|-> Precio: " + value + "€" + "\n";
                com += "\n";
            }
        }
        com += "+ Gastos de envio:" + res.getGastosEnvio() + "€" + "\n";
        if (!esParticular(Global.USER_FILE, mail)) {
            com += "+ Descuento del 10% \n";
        }
        com += "TOTAL: " + Double.toString(total) + "€" + "\n";
        escritos += com;

        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(escritos);
            writer.flush();
            System.out.println("Serializacion: Factura creada en " + filename);
            
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

    }

}
