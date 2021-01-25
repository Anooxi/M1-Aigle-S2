import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISuivi extends Remote {
    public String getTexte() throws RemoteException;
    public void setTexte(String texte) throws RemoteException;
}
