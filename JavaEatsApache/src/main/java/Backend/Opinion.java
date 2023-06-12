package Backend;

import Backend.Global;
import java.io.Serializable;

/**
 * Clase encargada de definir una opinión
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class Opinion implements Serializable {

    private int puntuacion;
    private String resena;

    /**
     * Constructor
     *
     * @param puntuacion Puntuación sobre 5
     * @param resena Texto.
     */
    public Opinion(int puntuacion, String resena) {
        this.puntuacion = puntuacion;
        this.resena = resena;
    }

    /**
     * Constructor solo con puntuacion
     *
     * @param puntuacion
     */
    public Opinion(int puntuacion) {
        this.puntuacion = puntuacion;
        this.resena = Global.EMPTY;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }

}
