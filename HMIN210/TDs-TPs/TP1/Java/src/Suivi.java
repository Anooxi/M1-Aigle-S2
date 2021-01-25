import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Suivi extends UnicastRemoteObject implements ISuivi {
    private String texte;

    public Suivi() throws RemoteException {
        this.texte = "Ceci est un dossier de suivi!";
    }

    public String getTexte() throws RemoteException{
        return texte;
    }

    public void setTexte(String texte) throws RemoteException{
        this.texte = texte;
    }

    @Override
    public String toString() {
        return "Suivi{" +
                "texte='" + texte + '\'' +
                '}';
    }
}
