package Backend;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Paquete de funciones para anadir de forma automatica restaurantes y usuarios
 * Contiene 3 restaurantes y 5 usuarios por defecto
 * Tener en cuenta que existen restaurante0 y usuario0(admin) creados por defecto
 *
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 */
public class Automate {

    /**
     * Anexo automatico restaurante 1
     *
     * @param filename
     */
    public static void anexoRestaurante1(String filename) {
        ArrayList<String> ingredientes1 = new ArrayList<String>() {
            {
                add("Carne de res");
                add("Cebolla");
                add("Pimiento rojo");
                add("Salsa barbacoa");
            }
        };
        ArrayList<String> ingredientes2 = new ArrayList<String>() {
            {
                add("Atún en lata");
                add("Maíz");
                add("Aceitunas");
                add("Aceite de oliva");
            }
        };
        ArrayList<String> ingredientes3 = new ArrayList<String>() {
            {
                add("Garbanzos");
                add("Pepino");
                add("Aceite de sésamo");
                add("Vinagre de arroz");
            }
        };
        ArrayList<Comida> comidas = new ArrayList<Comida>() {
            {
                add(new Comida("Pollo salteado con verduras y salsa de soja", ingredientes1, 9, "fotografias/PS.png"));
                add(new Comida("Ensalada de atún con maíz y aceitunas", ingredientes2, 7.4, "fotografias/EA.png"));
                add(new Comida("Ensalada de garbanzos con pepino y vinagreta de sésamo", ingredientes3, 2, "fotografias/EG.png"));
            }
        };
        ArrayList<Opinion> opiniones = new ArrayList<Opinion>() {
            {
                add(new Opinion(1, "Local feo"));
                add(new Opinion(2, "Esta bien"));
                add(new Opinion(3, "Decente"));
            }
        };
        Catering cat = new Catering(false, false, false, false);
        Restaurante res = new Restaurante("B72153026", "EL huerto", new Direccion("Huerto", "3", "28003", "Alcala de Henares"), "Verduras", 4, 15, opiniones, comidas, cat);
        Serializacion.anexar(filename, res);
    }

    /**
     * Anexo automatico restaurante 2
     *
     * @param filename
     */
    public static void anexoRestaurante2(String filename) {
        ArrayList<String> ingredientes1 = new ArrayList<String>() {
            {
                add("Pollo");
                add("Pimiento");
                add("Cebolla");
            }
        };
        ArrayList<String> ingredientes2 = new ArrayList<String>() {
            {
                add("Salmón");
                add("Espárragos");
                add("Limón");
            }
        };
        ArrayList<String> ingredientes3 = new ArrayList<String>() {
            {
                add("Ternera");
                add("Queso");
                add("Bacon");
                add("Lechuga");
            }
        };
        ArrayList<Comida> comidas = new ArrayList<Comida>() {
            {
                add(new Comida("Pollo salteado", ingredientes1, 9.5, "fotografias/PS.png"));
                add(new Comida("Salmón a la parrilla", ingredientes2, 12.8, "fotografias/SL.png"));
                add(new Comida("Hamburguesa con queso", ingredientes3, 7.2, "fotografias/HC.png"));
            }
        };
        ArrayList<Opinion> opiniones = new ArrayList<Opinion>() {
            {
                add(new Opinion(4, "Brutal"));
                add(new Opinion(2, "Bueno..."));
                add(new Opinion(3, "Bien"));
            }
        };
        Catering cat = new Catering(false, false, false, false);
        Restaurante res = new Restaurante("E48897813", "La casa", new Direccion("Casitas", "19", "28005", "Alcala de Henares"), "Verduras", 4, 15, opiniones, comidas, cat);
        Serializacion.anexar(filename, res);

    }

    /**
     * Anexo automatico restaurante 3
     *
     * @param filename
     */
    public static void anexoRestaurante3(String filename) {
        ArrayList<String> ingredientes1 = new ArrayList<String>() {
            {
                add("Pollo");
                add("Brócoli");
                add("Zanahoria");
            }
        };
        ArrayList<String> ingredientes2 = new ArrayList<String>() {
            {
                add("Salmón");
                add("Espinacas");
                add("Pasta");
            }
        };
        ArrayList<String> ingredientes3 = new ArrayList<String>() {
            {
                add("Tofu");
                add("Calabacín");
                add("Arroz");
                add("Salsa de soja");
            }
        };

        ArrayList<Comida> comidas = new ArrayList<Comida>() {
            {
                add(new Comida("Pollo al curry", ingredientes1, 12.5, "fotografias/PoC.png"));
                add(new Comida("Salmón con espinacas", ingredientes2, 14.8, "fotografias/SE.png"));
                add(new Comida("Arroz salteado con tofu", ingredientes3, 9.2, "fotografias/AT.png"));
            }
        };
        ArrayList<Opinion> opiniones = new ArrayList<Opinion>() {
            {
                add(new Opinion(1, "Brutalmente malo"));
                add(new Opinion(3, "Bueno..."));
                add(new Opinion(3, "Bien"));
            }
        };
        Catering cat = new Catering(false, false, false, false);
        Restaurante res = new Restaurante("V21403142", "Comida Sana!", new Direccion("Orcasitas", "2", "28000", "Alcala de Henares"), "Comida Casera", 8, 20, opiniones, comidas, cat);

        Serializacion.anexar(filename, res);

    }

    /**
     * Anexo automatico restaurante 4
     *
     * @param filename
     */
    public static void anexoRestaurante4(String filename) {
        ArrayList<String> ingredientes1 = new ArrayList<>(Arrays.asList("Carne de res", "Cebolla", "Pimiento rojo", "Salsa barbacoa"));
        ArrayList<String> ingredientes2 = new ArrayList<>(Arrays.asList("Atún en lata", "Maíz", "Aceitunas", "Aceite de oliva"));
        ArrayList<String> ingredientes3 = new ArrayList<>(Arrays.asList("Garbanzos", "Pepino", "Aceite de sésamo", "Vinagre de arroz"));

        ArrayList<Comida> comidas = new ArrayList<>(Arrays.asList(
                new Comida("Pollo salteao", ingredientes1, 5, "fotografias/PS.png"),
                new Comida("Ensalada de pescado", ingredientes2, 3.4, "fotografias/EA.png"),
                new Comida("Ensalada de legumbres", ingredientes3, 2, "fotografias/EG.png")
        ));

        ArrayList<Opinion> opiniones = new ArrayList<Opinion>() {
            {
                add(new Opinion(4, "Rápdio"));
                add(new Opinion(3, "Esta bien"));
                add(new Opinion(5, "Muy buena la comida"));
            }
        };

        Catering cat = new Catering(true, true, true, true);
        Restaurante res = new Restaurante("V30287601", "Todo a un euro", new Direccion("Brugal", "8", "28005", "Alcala de Henares"), "Frituras", 2, 20, opiniones, comidas, cat);

        Serializacion.anexar(filename, res);
    }

    /**
     * Anexo automatico usuario 1
     *
     * @param filename
     */
    public static void anexarUsuario1(String filename) {
        Usuario userU = new Usuario("alejandro", "alejandro@ruizz.es", "alex", new Direccion("Huevo", "3", "28890", "Meco"), new Tarjeta("Alex R.", "123412341235", "7", "2025"), "600000000");
        Cliente_Particular user = new Cliente_Particular(userU, "12245678D");
        Serializacion.anexar(filename, user);
    }

    /**
     * Anexo automatico usuario 2
     *
     * @param filename
     */
    public static void anexarUsuario2(String filename) {
        Usuario userU = new Usuario("rodrigo", "rodrigo@palomo.es", "palomo", new Direccion("Manuel", "12", "28874", "Guada"), new Tarjeta("Rodrigo P.", "123412341235", "1", "2028"), "682505050");
        Cliente_Particular user = new Cliente_Particular(userU, "13220316B");
        Serializacion.anexar(filename, user);

    }

    /**
     * Anexo automatico usuario 3
     *
     * @param filename
     */
    public static void anexarUsuarioE1(String filename) {
        Usuario userU = new Usuario("Google", "google@gmail.com", "google", new Direccion("Lauerl", "1", "28701", "Meco"), new Tarjeta("Google SA", "123412341235", "9", "2029"), "700000000");
        Cliente_Empresa user = new Cliente_Empresa(userU, "P2481837I", "google.com");
        Serializacion.anexar(filename, user);
    }

    /**
     * Anexo automatico usuario 4
     *
     * @param filename
     */
    public static void anexarUsuarioE2(String filename) {
        Usuario userU = new Usuario("Terra", "terra@mail.com", "terramail", new Direccion("Linga", "8", "28501", "Toledo"), new Tarjeta("Terra", "123412341235", "10", "2029"), "700234123");
        Cliente_Empresa user = new Cliente_Empresa(userU, "V37394624", "terra.mail.com");
        Serializacion.anexar(filename, user);
    }

    /**
     * Anexo automatico usuario 5
     *
     * @param filename
     */
    public static void anexarUsuarioE3(String filename) {
        Usuario userU = new Usuario("Amazon", "amazon@amazon.com", "amazon", new Direccion("Lituna", "89", "28820", "Almeria"), new Tarjeta("Amazon", "123412341235", "12", "2035"), "600000000");
        Cliente_Empresa user = new Cliente_Empresa(userU, "R7766752E", "amazon.com");
        Serializacion.anexar(filename, user);
    }

    /**
     * Crea n cantidad de usuarios en el archivo usuarios
     *
     * @param filename
     * @param n
     */
    public static void anexarNfalso(String filename, int n) {
        for (int i = 0; i < n; i++) {
            String nombre = Integer.toString(i);
            Usuario userU = new Usuario("prueba", nombre, "prueba", new Direccion("Prueba", "1", "28800", "Paris"), new Tarjeta("Man P.", "123412341235", "1", "2028"), "682505050");
            Cliente_Particular user = new Cliente_Particular(userU, "03220319Z");
            Serializacion.anexar(filename, user);
        }
    }

}
