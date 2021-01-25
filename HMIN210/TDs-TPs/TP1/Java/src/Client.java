import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public Client() {

    }

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "C:\\Users\\Anoox\\Desktop\\Cours\\M1-Aigle-S2\\HMIN210\\TDs-TPs\\TP1\\Java\\src\\animal.policy");

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
            System.out.println(stub.displayAnimaux());
            System.out.println(stub.rechercheAnimaux("Animal1"));
            stub.ajouterAnimal("a","a","a",1,"b");
            System.out.println(stub.displayAnimaux());

        } catch (Exception e) {
            System.err.println("Client Error n2 : " + e);
            e.printStackTrace();
        }

    }
}
