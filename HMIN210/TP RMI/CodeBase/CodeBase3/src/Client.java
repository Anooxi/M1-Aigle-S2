import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import base.*;

public class Client implements IClient{
    public Client() throws RemoteException {
        UnicastRemoteObject.exportObject(this,0);
    }

    public static void main(String[] args) throws RemoteException {
        IClient client = new Client();
        try {
            System.setProperty("java.rmi.server.codebase","file:\\C:\\Users\\Anoox\\Desktop\\Cours\\M1-Aigle-S2\\HMIN210\\CodeBase1\\out\\production\\CodeBase1");
            System.setProperty("java.security.policy", "C:\\Users\\Anoox\\Desktop\\Cours\\M1-Aigle-S2\\HMIN210\\CodeBase3\\src\\Client.policy");

            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
        } catch (Exception e) {
            System.err.println("Client Error n1 :" + e);
            e.printStackTrace();
        }
        //
        // Bloc de code de récupération d'Animal
        //
        try {
            Registry reg = LocateRegistry.getRegistry(1099);
            ICabinetVeterinaire stub = (ICabinetVeterinaire) reg.lookup("Cabinet");
            stub.addClient(client);
            System.out.println(stub.displayAnimaux());
            System.out.println(stub.rechercheAnimaux("Animal1"));
            stub.ajouterAnimal("a","a","a",1,"b");
            System.out.println(stub.displayAnimaux());
            Scanner sc = new Scanner(System.in);
            sc.next();
            System.exit(0);
        } catch (Exception e) {
            System.err.println("Client Error n2 : " + e);
            e.printStackTrace();
        }
    }

    @Override
    public void alert(int n) throws RemoteException{
        System.out.println("il y'a " + n + " patients");
    }
}
