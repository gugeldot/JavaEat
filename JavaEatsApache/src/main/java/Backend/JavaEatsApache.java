package Backend;


import Frontend.loginInicial;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Programa main del proyecto
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class JavaEatsApache {

    /**
     * Arranca pantalla inicial de login {@link Frontend.loginInicial}
     */
    public static void Pantalla0() {
        loginInicial loginPanel = new loginInicial();
        loginPanel.init();
    }

    public static void main(String[] args) throws IOException {

        Serializacion.crearFichero(Global.USER_FILE);                             // Se empieza con 6 usaurios creados (3 particulares y 3 empresas)
        Serializacion.crearFicheroRestaurante(Global.RESTAURANT_FILE);                 // Se empieza con 4 restaurantes con de 3 comidas con 3/4 ingredientes y 3 opiniones cada
        Serializacion.crearFicheroVentas(Global.VENTA_FILE);
        Pantalla0();
  
    }

}
