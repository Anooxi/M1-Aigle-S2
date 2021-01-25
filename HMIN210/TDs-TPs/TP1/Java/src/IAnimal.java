import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote {
    public String printNom() throws RemoteException;
}
