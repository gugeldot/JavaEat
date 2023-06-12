package Backend;

import java.io.Serializable;

/**
 * Declarar una tarjeta
 * Esta dentro del paquete al solo ser utilizado por 
 * {@link Cliente_Empresa} y {@link Cliente_Particular}
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 */
public class Tarjeta implements Serializable {

    private String titular;
    private String numero;
    private String mesCaducidad;
    private String anoCaducidad;

    public Tarjeta(String titular, String numero, String mesCaducidad, String anoCaducidad) {
        this.titular = titular;
        this.numero = numero;
        this.mesCaducidad = mesCaducidad;
        this.anoCaducidad = anoCaducidad;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMesCaducidad() {
        return mesCaducidad;
    }
    /**
     * Tener toda la fecha de una sentada, util en {@link Serializacion#emitirFactura(Backend.Utilidades.Venta, double, java.lang.String)}
     * @return 
     */
    public String getCaducidad() {
        return (mesCaducidad + "/" + anoCaducidad);
    }
    
    /**
     * Definir fecha de caducidad de una sentada
     * @param mes
     * @param ano 
     */
    public void setCaducidad(String mes, String ano) {
        this.mesCaducidad = mes;
        this.anoCaducidad = ano;
    }

    public void setMesCaducidad(String mesCaducidad) {
        this.mesCaducidad = mesCaducidad;
    }

    public String getAnoCaducidad() {
        return anoCaducidad;
    }

    public void setAnoCaducidad(String anoCaducidad) {
        this.anoCaducidad = anoCaducidad;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "titular=" + titular + ", numero=" + numero + ", mesCaducidad=" + mesCaducidad + ", anoCaducidad=" + anoCaducidad + '}';
    }

}
