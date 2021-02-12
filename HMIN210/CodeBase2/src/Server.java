import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import base.*;

public class Server {
    public Server(){

    }

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.codebase","file:\\C:\\Users\\Anoox\\Desktop\\Cours\\M1-Aigle-S2\\HMIN210\\CodeBase1\\out\\production\\CodeBase1");

            System.setProperty("java.security.policy","C:\\Users\\Anoox\\Desktop\\Cours\\M1-Aigle-S2\\HMIN210\\CodeBase2\\src\\Server.policy");
            System.setSecurityManager(new SecurityManager());
        } catch (Exception e){
            System.err.println("Server Error n2 :" + e);
            e.printStackTrace();
            return;
        }
        //
        // Bloc de code d'envoi d'Animal
        //
        try {
            CabinetVeterinaire obj = new CabinetVeterinaire();
            Registry reg = LocateRegistry.createRegistry(1099);
            if(reg == null){
                System.err.println("RmiRegistry not found");
            } else {
                reg.bind("Cabinet",obj);
                System.out.println("Server Ready (Cabinet bind)");
            }
        } catch (Exception e){
            System.err.println("Server Error n1 :" + e);
            e.printStackTrace();
        }


    }
}
