# Exercice 1
## Question 1
Étapes à suivre pour Animal / IAnimal :
- Créer une interface IAnimal qui extends Remote
- Créer la classe Animal qui extends UnicastRemoteObject et implements IAnimal
- Les méthodes de l'interface doivent throws RemoteException
- Pareil pour les constructeurs d'Animal

Étapes à suivre pour Server / Client :
- Dans Server créer le registre et bind Animal :  
```Java
Animal obj = new Animal();
Registry reg = LocateRegistry.createRegistry(1099);
reg.bind("Animal",obj);
```
- Dans client récuperer le registre et le stub d'Animal :  
```Java
Registry reg = LocateRegistry.getRegistry(1099);
IAnimal stub = (IAnimal) reg.lookup("Animal");
```
- PS : Entourer le code par des try / catch!
- PS : 1099 est un port qu'on attribut que l'on peut changer
- PS : reg.lookup récupère l'interface!
## Question 2
Étapes à suivre :  
- Créer un fichier animal.policy (et écrire dedans les permissions) :  
```Java
grant {
    permission java.net.SocketPermission "*:1024-65535","connect,accept";
    permission java.net.SocketPermission ":80","connect";
};
```
- Dans le client et le serveur rajouter  
```Java
System.setProperty("java.security.policy","chemin absolu du animal.policy")
```
- Vérifier en rajoutant du faux code dans animal.policy pour voir si le fichier est bien récupérer
- Créer des gestionnaire de sécurité :  
```Java
//Dans Server
System.setSecurityManager(new SecurityManager);
//Dans Client
System.getSecurityManager();
```

## Question 3
On rajoute une classe (Suivi) et une interface (ISuivi) en suivant l'implémentation de rmi (comme pour Animal)  
Les méthodes appelé sur Suivi sont lancées dans le Serveur
## Question 4
On créer une classe (Espece) avec l'interface Serializable qui permet de lancé les méthodes sur client et pas sur le serveur!

# Exercice 2