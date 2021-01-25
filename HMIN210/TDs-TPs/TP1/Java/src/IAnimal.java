import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote {
    public String printNom() throws RemoteException;
    public void modifyDoc(String text) throws RemoteException;
    public Espece getEspeceClass() throws RemoteException;
    public String getDoc() throws RemoteException;
}
