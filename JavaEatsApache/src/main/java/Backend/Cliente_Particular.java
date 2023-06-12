package Backend;

import Backend.Direccion;
import java.io.Serializable;
/**
 * Cliente Particular 
 * Diferencia: Tiene DNI
 * Clases usadas: {@link Tarjeta}
 * Viene de: @see Usuario
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class Cliente_Particular extends Usuario implements Serializable{
    private String DNI;
    /**
     * Constructor completo particular
     * @param nombre
     * @param mail
     * @param clave
     * @param direccion
     * @param tarjetaCredito
     * @param telefono
     * @param DNI 
     */
    public Cliente_Particular(String nombre, String mail, String clave, Direccion direccion, Tarjeta tarjetaCredito, String telefono, String DNI) {
        super(nombre, mail, clave, direccion, tarjetaCredito, telefono);
        this.DNI = DNI;
    }
    /**
     * Constructor particular a partir de usuario
     * @param usuario
     * @param DNI 
     */
    public Cliente_Particular(Usuario usuario, String DNI) {
        super(usuario.getNombre(), usuario.getMail(), usuario.getClave(), usuario.getDireccion(), usuario.getTarjetaCredito(), usuario.getTelefono());
        this.DNI = DNI;
    }

    public String getDNI() { return DNI; }
    public void setDNI(String cif) { this.DNI = DNI; }

}
