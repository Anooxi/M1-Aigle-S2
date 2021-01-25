import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public Server(){

    }

    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy","C:\\Users\\Anoox\\Desktop\\Cours\\M1-Aigle-S2\\HMIN210\\TDs-TPs\\TP1\\Java\\src\\animal.policy");
            System.setSecurityManager(new SecurityManager());
        } catch (Exception e){
            System.err.println("Server Error n2 :" + e);
            e.printStackTrace();
        }
        //
        // Bloc de code d'envoi d'Animal
        //
        try {
            Animal obj = new Animal();
            Registry reg = LocateRegistry.createRegistry(1099);
            if(reg == null){
                System.err.println("RmiRegistry not found");
            } else {
                reg.bind("Animal",obj);
                System.out.println("Server Ready (Animal bind)");
            }
        } catch (Exception e){
            System.err.println("Server Error n1 :" + e);
            e.printStackTrace();
        }


    }
}
