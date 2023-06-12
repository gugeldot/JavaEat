package Backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Establecimiento de catering
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class Catering implements Serializable {

    private ArrayList<Comida> comidas = new ArrayList();
    private HashMap<String, Double> servicios = new HashMap<String, Double>();
    private double precioTotal;

    /**
     * Establecimiento de catering con servicios disponibles
     * @param servCamaeros  Tiene servicio camareros
     * @param servCocineros Tiene servicio cocineros
     * @param servDecor     Tiene servicio decoracion 
     * @param enEspacioPrivado Tiene "servicio"/espacio privado
     */
    public Catering(boolean servCamaeros, boolean servCocineros, boolean servDecor, boolean enEspacioPrivado) {
        if (servCamaeros) {
            servicios.put("Camareros", 800.0);
        }
        if (servCocineros) {
            servicios.put("Cocineros", 1000.0);
        }
        if (servDecor) {
            servicios.put("Decoración", 500.0);
        }
        if (enEspacioPrivado) {
           servicios.put("Espacio privado", 1000.0);       // Decidir tipo de espacio
        } else {
            servicios.put("Espacio de la empresa", 0.0);
        }
    }

    public ArrayList<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(ArrayList<Comida> comidas) {
        this.comidas = comidas;
    }

    public HashMap<String, Double> getServicios() {
        return servicios;
    }
    
    /**
     * Mismo que {@link #Catering(boolean, boolean, boolean, boolean) }
     * @param servCamaeros
     * @param servCocineros
     * @param servDecor
     * @param espacioPrivado 
     */
    public void setServicios(boolean servCamaeros, boolean servCocineros, boolean servDecor, boolean espacioPrivado) {
        servicios = new HashMap<String, Double>();
        if (servCamaeros) {
            servicios.put("Camareros", 800.0);
        }
        if (servCocineros) {
            servicios.put("Cocineros", 1000.0);
        }
        if (servDecor) {
            servicios.put("Decoración", 500.0);
        }if(espacioPrivado){
            servicios.put("Espacio Privado",1000.0);
        }else{
            servicios.put("Espacio Libre",0.0);
        }
        this.servicios = servicios;
    }

    

    
    /**
     * Devuelve precio total sumando todos los precios
     *
     * @return 
     */
    public double getPrecioTotal() {
        double sumatorio = 0;

        for (Comida comida : comidas) {
            sumatorio += comida.getPrecio();
        }
        for (Map.Entry<String, Double> entry : servicios.entrySet()) {
             Double valor = entry.getValue();
             sumatorio += valor;
        }

        

        precioTotal = sumatorio;
        return precioTotal;
    }
    
    /**
     * Booleano para comprobar si existe servicio Camaereros en el hashmap
     * @return 
     */
    public boolean hayCamareros(){
        return servicios.containsKey("Camareros");
    }
    /**
     * Booleano para comprobar si existe servicio Cocineros en el hashmap
     * @return 
     */
    public boolean hayCocineros(){
        return servicios.containsKey("Cocineros");
    }
    /**
     * Booleano para comprobar si existe servicio Decoración en el hashmap
     * @return 
     */
    public boolean hayDeco(){
        return servicios.containsKey("Decoración");
    }
     /**
     * Booleano para comprobar si existe servicio Espacio Privado en el hashmap
     * @return 
     */
    public boolean hayEP(){
        return servicios.containsKey("Espacio Privado");
    }

}
