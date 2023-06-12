package Backend;

import java.io.Serializable;
/**
 * Clase para determinar una dirección
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class Direccion implements Serializable{
    private String calle;
    private String numero;
    private String codigoPostal;
    private String ciudad;

    public Direccion(String calle, String numero,String codigoPostal, String ciudad) {//
        this.calle = calle;
        this.numero = numero;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
   
    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
   
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
   
    @Override
    public String toString() {
        return calle + "(" + numero + ") [" + codigoPostal + "] " +  ciudad ;
    }
    
}
