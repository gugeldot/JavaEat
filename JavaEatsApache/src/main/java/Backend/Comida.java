package Backend;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase determinada para definir una comida
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class Comida implements Serializable {

    private String titulo;
    ArrayList<String> ingredientes = new ArrayList<>();
    private double precio;
    private String rutaFotografia;

    /**
     * Constructor comida
     * @param titulo Nombre 
     * @param ingredientes ArrayList de Strings ingredientes
     * @param precio Coste
     * @param rutaFotografia ruta foto 
     */
    public Comida(String titulo, ArrayList<String> ingredientes, double precio, String rutaFotografia) {
        this.titulo = titulo;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.rutaFotografia = rutaFotografia;
    }
    
    /**
     * Constructor más precario
     * @param titulo
     * @param precio 
     */
    public Comida(String titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }
    

    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }


    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getRutaFotografia() {
        return rutaFotografia;
    }


    public void setRutaFotografia(String rutaFotografia) {
        this.rutaFotografia = rutaFotografia;
    }

    @Override
    public String toString() {
        return "Comida{" + "titulo=" + titulo + ", ingredientes=" + ingredientes + ", precio=" + precio + ", rutaFotografia=" + rutaFotografia + '}';
    }
    
}
