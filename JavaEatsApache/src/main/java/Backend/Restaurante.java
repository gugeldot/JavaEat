package Backend;

import Backend.Direccion;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase para definir restaurantes
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class Restaurante implements Serializable {
    // Atributos

    private String cif;
    private String nombre;
    private Direccion direccion;
    private String especialidad;
    private double gastosEnvio;
    private int tiempoMedioEnvio;
    private ArrayList<Opinion> opiniones = new ArrayList();
    private ArrayList<Comida> comidas = new ArrayList();
    private Catering catering;

    /**
     * Constructor CON CATERING
     *
     * @param cif CIF
     * @param nombre NOMBRE
     * @param direccion DIRECCIÓN
     * @param especialidad ESPECIALIDAD
     * @param gastosEnvio GASTOS DE ENVIO
     * @param tiempoMedioEnvio TIEMPO DE ENVIO
     * @param opiniones OPINIONES
     * @param comidas COMIDAS
     * @param catering CATERING
     */
    public Restaurante(String cif, String nombre, Direccion direccion, String especialidad, double gastosEnvio, int tiempoMedioEnvio, ArrayList<Opinion> opiniones, ArrayList<Comida> comidas, Catering catering) {
        this.cif = cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.gastosEnvio = gastosEnvio;
        this.tiempoMedioEnvio = tiempoMedioEnvio;                                       // Constructor si se incluye catering
        this.opiniones = opiniones;
        this.comidas = comidas;
        this.catering = catering;

    }

    /**
     * Get Calificacion de media de las opiniones
     *
     * @return Autoexplicativo
     */
    public double getCalificacion() {
        // Bucle foreach para conseguir todas las calificaciones
        int i = 0;
        double notaFinal = 0;
        for (Opinion nota : opiniones) {
            i++;
            notaFinal += nota.getPuntuacion();
        }
        notaFinal = notaFinal / i;
        return notaFinal;
    }

    /**
     * Booleano para comprobar si tiene catering No se provee de
     * setServicioCatering
     *
     * @return Autoexplicativo
     */
    public boolean isServicioCatering() {
        boolean isCatering = (this.catering.hayCamareros() || this.catering.hayCocineros() || this.catering.hayDeco() || this.catering.hayEP());
        return isCatering;
    }

    public Catering getCatering() {
        return catering;
    }

    public void setCatering(Catering catering) {
        this.catering = catering;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(double gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public int getTiempoMedioEnvio() {
        return tiempoMedioEnvio;
    }

    public void setTiempoMedioEnvio(int tiempoMedioEnvio) {
        this.tiempoMedioEnvio = tiempoMedioEnvio;
    }

    public ArrayList<Opinion> getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(ArrayList<Opinion> opiniones) {
        this.opiniones = opiniones;
    }

    public void addOpinion(Opinion opinion) {
        this.opiniones.add(opinion);
    }

    public ArrayList<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(ArrayList<Comida> comidas) {
        this.comidas = comidas;
    }

}
