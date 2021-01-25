import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Animal extends UnicastRemoteObject implements IAnimal{
    private String nom;
    private String nomDuMaitre;
    private String espece;
    private int age;
    private String race;
    private Suivi doc;
    private Espece especeClass;

    public String getDoc() throws RemoteException {
        System.out.println("Appel de la méthode getDoc() de Animal");
        return doc.toString();
    }

    public void modifyDoc(String text) throws RemoteException{
        this.doc.setTexte(text);
    }

    public void setDoc(Suivi doc) {
        this.doc = doc;
    }

    public Animal() throws RemoteException {
        this.nom = "TestNom";
        this.nomDuMaitre = "TestNomDuMaitre";
        this.espece = "TestEspece";
        this.age = 13;
        this.race = "TestRace";
        this.doc = new Suivi();
        this.especeClass = new Espece();
    }

    public Animal(String nom, String nomDuMaitre, String espece, int age, String race) throws RemoteException {
        this.nom = nom;
        this.nomDuMaitre = nomDuMaitre;
        this.espece = espece;
        this.age = age;
        this.race = race;
        this.doc = new Suivi();
        this.especeClass = new Espece();
    }

    public Espece getEspeceClass(){
        return especeClass;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomDuMaitre() {
        return nomDuMaitre;
    }

    public void setNomDuMaitre(String nomDuMaitre) {
        this.nomDuMaitre = nomDuMaitre;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nom='" + nom + '\'' +
                ", nomDuMaitre='" + nomDuMaitre + '\'' +
                ", espece='" + espece + '\'' +
                ", age=" + age +
                ", race='" + race + '\'' +
                '}';
    }

    public String printNom(){
        return "Animal{" +
                "nom='" + nom + '\'' +
                ", nomDuMaitre='" + nomDuMaitre + '\'' +
                "}";
    }
}
