import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CabinetVeterinaire extends UnicastRemoteObject implements ICabinetVeterinaire {

    ArrayList<Animal> Animaux = new ArrayList<>();

    public CabinetVeterinaire() throws RemoteException {
        Animaux.add(new Animal("Animal1","Maitre1","Chien",1,"Race1"));
        Animaux.add(new Animal("Animal2","Maitre2","Chat",2,"Race2"));
        Animaux.add(new Animal("Animal3","Maitre3","Loup",3,"Race3"));
        Animaux.add(new Animal("Animal4","Maitre4","Renard",4,"Race4"));

    }

    @Override
    public String displayAnimaux() throws RemoteException {
        String res = "";
        for (Animal a : Animaux ) {
            res += a.getNom() + " " + a.getEspece() + " " + a.getNomDuMaitre() + "\n";
        }
        return res;
    }

    @Override
    public String rechercheAnimaux(String nom) throws RemoteException {
        String res = "";
        for ( Animal a : Animaux ){
            if(a.getNom().equals(nom)){
                res += a.getNomDuMaitre() + "\n";
            }
        }
        return res;
    }

    @Override
    public void ajouterAnimal(String nom, String nomDuMaitre, String espece, int age, String race) throws RemoteException {
        Animaux.add(new Animal(nom,nomDuMaitre,espece,age,race));
    }
}
