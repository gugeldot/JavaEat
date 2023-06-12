
package Backend;

import Backend.Comida;
import Backend.Restaurante;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase venta 
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 */
public class Venta implements Serializable {

    private String fechaVenta;
    private Restaurante restaurant;
    private ArrayList<Comida> comidas = new ArrayList<>();
    private String mail;
    private double precioFinal;
    private HashMap<String,Double> servicios = new HashMap<String,Double>();
    
    /**
     * Constructor
     * @param fechaVenta    Fecha de la venta
     * @param restaurant    Restaurante al que se le ha hecho el pedido
     * @param comidas       Comdias PEDIDAS del restaurante
     * @param mail          Mail del usuario que las ha pedido
     * @param precioFinal   Precio final del pedido (aplicado descuentos y todo)
     * @param servicios     Servicios pedidos de catering (Solo empresa)
     */
    public Venta(String fechaVenta, Restaurante restaurant, ArrayList<Comida> comidas,String mail , double precioFinal,HashMap<String,Double> servicios) {
        this.fechaVenta = fechaVenta;
        this.restaurant = restaurant;
        this.precioFinal = precioFinal;
        this.comidas = comidas;
        this.mail = mail;
        this.servicios = servicios;
    }

    public HashMap<String, Double> getServicios() {
        return servicios;
    }
   

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    // Métodos getter y setter para restaurant
    public Restaurante getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurante restaurant) {
        this.restaurant = restaurant;
    }

    // Métodos getter y setter para comidas
    public ArrayList<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(ArrayList<Comida> comidas) {
        this.comidas = comidas;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    

    public double getPrecioTotal() {
        return this.precioFinal;
    }

    @Override
    public String toString() {
        return "Venta{" + "fechaVenta=" + fechaVenta + ", restaurant=" + restaurant + ", comidas=" + comidas + ", mail=" + mail + ", precioFinal=" + precioFinal + '}';
    }
    

}
