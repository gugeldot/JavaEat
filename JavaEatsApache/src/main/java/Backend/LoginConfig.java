
package Backend;

import java.io.Serializable;
/**
 * Clase para determinar un login persistente 
 * @see Frontend.loginInicial#init() 
 * @author Alejandro Ruiz
 * @author Rodrigo Palomo
 *
 */
public class LoginConfig implements Serializable{
    private String mail;
    private String passwd; 

    public LoginConfig(String mail, String passwd) {
        this.mail = mail;
        this.passwd = passwd;
    }

    public LoginConfig() {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "LoginConfig{" + "mail=" + mail + ", passwd=" + passwd + '}';
    }
    
}
