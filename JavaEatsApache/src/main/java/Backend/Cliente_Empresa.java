package Backend;

import Backend.Direccion;
import java.io.Serializable;
/**
 * Cliente Empresa 
 * Diferencia: Tiene CIF y Web
 * Clases usadas: {@link Tarjeta}
 * Viene de: @see Usuario
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class Cliente_Empresa extends Usuario implements Serializable{
    private String cif;
    private String web;
    /**
     * Constructor de empresa completo
     * @param cif
     * @param nombre
     * @param mail
     * @param clave
     * @param direccion
     * @param tarjetaCredito
     * @param telefono
     * @param web 
     */
    public Cliente_Empresa (String cif,String nombre, String mail, String clave, Direccion direccion,
                            Tarjeta tarjetaCredito, String telefono, String web) {

        super(nombre, mail, clave, direccion, tarjetaCredito, telefono);
        this.cif = cif;
        this.web = web;
    }
    /**
     * Constructor empresa a partir de clase padre usuario
     * @param usuario
     * @param cif
     * @param web 
     */
    public Cliente_Empresa (Usuario usuario,String cif, String web) {
        super(usuario.getNombre(), usuario.getMail(), usuario.getClave(), usuario.getDireccion(), usuario.getTarjetaCredito(), usuario.getTelefono());
        this.cif = cif;
        this.web = web;
    }

    public String getCif() { return cif; }

    public void setCif(String cif) { this.cif = cif; }

    public String getWeb() { return web; }

    public void setWeb(String web) { this.web = web; }
}

