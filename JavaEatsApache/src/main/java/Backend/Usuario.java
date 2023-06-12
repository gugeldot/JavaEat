package Backend;



import Backend.Direccion;
import java.io.Serializable;
/**
 * Clase padre de {@link Cliente_Empresa} y {@link Cliente_Particular}
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */


public class Usuario implements Serializable{

    private String nombre;
    private String mail;
    private String clave;
    private Direccion direccion;
    private Tarjeta tarjeta; 
    private String telefono;


    public Usuario(String nombre, String mail, String clave, Direccion direccion, Tarjeta tarjeta, String telefono) {
        this.nombre = nombre;
        this.mail = mail;
        this.clave = clave;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
        this.telefono = telefono;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Tarjeta getTarjetaCredito() {
        return tarjeta;
    }

    public void setTarjetaCredito(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
