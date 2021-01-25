import java.io.Serializable;

public class Espece implements Serializable {
    private String nom;

    public Espece(){
        this.nom = "Nom de l'espece !";
    }
    public String getNom(){
        System.out.println("Appel de la méthode getNom() de espece");
        return nom;
    }
}
