# Exercice 1
## Question 1
Séquence de n voitures
- (a) Une permutations de deux éléments quelconque -> n(n-1)/2 possibilités (~n²)
- (b) Une permutations de deux éléments consecutif -> n-1 possibilités
- (c) On coupe en deux et on échange les deux morceaux (nul)
- (d) On change le type des voitures (nul)

## Question 2
1 2 3 4 5 6 7  
A B C B A C B  
TO : A C  
ABS : B C B  
2 Contraintes violés

## Question 3

# Exercice 2
## Question 1
```Java
public static SAT parse(String filePath) throws Exception {
    InputStream is = new FileInputStream(filePath);
    BufferedReader br = new BufferedReader(new InputStreamReader(is));

    Scanner scanner = new Scanner(br);
    String token = scanner.nextLine();
    String[] splitRes;
    SAT sat = null;
    int clause = 0;

    while (!token.equals("%")) {

        //Split the line
        splitRes = token.trim().split(" ");

        //Skip the comments
        if (splitRes[0].equals("c")) {
            token = scanner.nextLine();
            continue;
        }

        //Initialise the GSAT problem with the problem's sizes given in the line starting with "p"
        if (splitRes[0].equals("p")) {
            try {
                //splitRes[2] = nombre de symboles
                //splitRes[4] = nombre de clauses
                //Initialiser l'objet représentant la SAT
                sat = new SAT(Integer.parseInt(splitRes[4]), Integer.parseInt(splitRes[2]));
            } catch (Exception e){
                e.printStackTrace();
            };
            token = scanner.nextLine();
            continue;
        }
        
        //TODO ICI GERER SPLITRES POUR INITIALISER LES CLAUSES :
        
        for (int i = 0; i < splitRes.length - 1; i++) {
             sat.addNewClause(clause, Integer.parseInt(splitRes[i]));
}
        
clause++;
        
        //Go to the next line
        token = scanner.nextLine();
    }
    return sat;
}
```