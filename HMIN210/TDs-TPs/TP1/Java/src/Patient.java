import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Patient extends UnicastRemoteObject implements  IPatient {
    private String nom;
    private String prenom;

    public Patient() throws RemoteException {
        super();
        this.nom = "jesaispas";
        this.prenom = "jesaispas";
    }

    public Patient(String nom, String prenom) throws RemoteException{
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
