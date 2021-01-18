## Question 1
Pour lancer le serveur il faut avoir lancer registre :
1. On lance le registre (tourne sur une JVM tierce sur 1099)
   > rmiregistry &
2. Lance le serveur qui récupère le registre via le RmiRegistry.locateRegistry() 
   > java Server
3. Lance le client en lui passant le port sur lequel le registre écoute
   > java Client 1099

## Question 2
Si on remplace la ligne 15 par 14 alors le registre est lancé depuis le Serveur et tourne donc dans la même machine virtuelle.
Pour lancer le serveur et le client, on fait alors :
> java Server  
> java Client 1099

## Question 3
Serveur :
- 1 -> Server ready
- 3 -> Server prints : Hello, World!
      
Client :
- 4 -> réponse : Hello, World!

## Question 4
Dans la Java Virtual Machine(JVM) du Serveur

## Question 5
Permet :
- typer côté client le proxy reçu à la suite du lookup -> mise en preuve du patron de conception
- spécifier les méthodes accessibles à distance pour les classes implémentant cette interface (ici : HelloImpl)
  
## Question 6
A cause du bind :
   - AlreadyBoundException -> if name is already bound
   - RemoteException -> if remote communication with the registre failed; if exception is a ServerException containing an AccessException, then the registry denies the caller access to perform this operation (if originating from a non-local host, for example)
   - AccessException - if this registry is local and it denies the caller access to perform this operation
   - NullPointerException - if name is null, or if obj is null

A cause 

## Question 7
bind jette une exception ALreadyBoundException si le nom est déjà utilisé dans le registre, alors que rebind remplace dans ce cas l'ancien objet associé par le nouveau passé en paramètre