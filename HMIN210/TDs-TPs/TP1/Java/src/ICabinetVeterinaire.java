import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICabinetVeterinaire extends Remote {
    public String displayAnimaux() throws RemoteException;
    public String rechercheAnimaux(String nom) throws RemoteException;
    public void ajouterAnimal(String nom, String nomDuMaitre, String espece, int age, String race) throws RemoteException;
    public void ajouterPatient(String nom, String prenom) throws RemoteException;
}
