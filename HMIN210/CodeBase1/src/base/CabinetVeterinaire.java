package base;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CabinetVeterinaire extends UnicastRemoteObject implements ICabinetVeterinaire {

    ArrayList<Animal> animaux = new ArrayList<>();
    ArrayList<IClient> clients = new ArrayList<>();

    public CabinetVeterinaire() throws RemoteException {
        animaux.add(new Animal("Animal1","Maitre1","Chien",1,"Race1"));
        animaux.add(new Animal("Animal2","Maitre2","Chat",2,"Race2"));
        animaux.add(new Animal("Animal3","Maitre3","Loup",3,"Race3"));
        animaux.add(new Animal("Animal4","Maitre4","Renard",4,"Race4"));

    }

    @Override
    public String displayAnimaux() throws RemoteException {
        String res = "";
        for (Animal a : animaux ) {
            res += a.getNom() + " " + a.getEspece() + " " + a.getNomDuMaitre() + "\n";
        }
        return res;
    }

    public void addClient(IClient client) throws RemoteException{
        clients.add(client);
    }

    @Override
    public String rechercheAnimaux(String nom) throws RemoteException {
        String res = "";
        for ( Animal a : animaux ){
            if(a.getNom().equals(nom)){
                res += a.getNomDuMaitre() + "\n";
            }
        }
        return res;
    }

    @Override
    public void ajouterAnimal(String nom, String nomDuMaitre, String espece, int age, String race) throws RemoteException {
        animaux.add(new Animal(nom,nomDuMaitre,espece,age,race));
    }

    public void check() throws RemoteException {
        int size = this.animaux.size();
        if(size%10 == 0){
            this.alerteClients(size);
        }
    }
    public void alerteClients(int i) throws RemoteException{
        for(IClient client : this.clients){
            client.alert(i);
        }
    }

}
