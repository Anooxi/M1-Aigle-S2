package base;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {
    public void alert(int i) throws RemoteException;
}
