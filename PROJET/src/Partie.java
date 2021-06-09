import java.util.Scanner;
import java.io.* ;

public class Partie implements Serializable{

    private Echiquier echiquier;
	private Joueur j1 ;
	private Joueur j2 ;
    private static final String SAUVEGARDE = "sauvegarde";


    public Partie(Echiquier e, Joueur j1, Joueur j2){
        this.echiquier = e;
        this.j1 = j1;
        this.j2 = j2;
    }

    public Echiquier getEC(){
        return this.echiquier;
    }

    public Joueur getJ1(){
        return this.j1;
    }

    public Joueur getJ2(){
        return this.j2;
    }

    public void lancer(){
        Joueur joueurB ; // Joueur blanc
        Joueur joueurN ; // Joueur Noir
        Scanner sc = new Scanner(System.in);  //fait son choix de couleur
        System.out.println("Joueur 1 choisit ta couleur entre (n et b)");
        String choix = sc.nextLine(); 
        if(choix.toLowerCase().trim().equals("b")){ //Si le choix c'est blanc 
            this.j1.setmesPieces(this.echiquier.getPB());  //initialise ses pieces blanches 
            this.j2.setmesPieces(this.echiquier.getPN());  //initialise les pieces noires
            joueurB = j1;  //joueur blanc = joueur 1
            joueurN = j2;
        }else{
            this.j2.setmesPieces(this.echiquier.getPB());  //else  = contraire 
            this.j1.setmesPieces(this.echiquier.getPN());
            joueurB = j2;
            joueurN = j1;
        }
        while (!(joueurB.getMesPiecesManger().contains(this.echiquier.getRn()) && joueurN.getMesPiecesManger().contains(this.echiquier.getRb()))){  //tant que le joueur blanc n'a pas manger le roi Noir et tant que le joueur blanc n'a pas manger le roi blanc
            this.echiquier.afficher(); //afiche echiquier
            System.out.println("A toi "+this.j1.getPrenom());  //demande au joueur 1 de jouer
            this.echiquier = this.j1.deplacer(this.echiquier);  //si le coup est valide sa deplace
            this.sauvegarde() ; //appel la sauvegarde
            this.echiquier.afficher();  // affiche l'echiquier
            if(this.j1.getMesPieces().get(0).estBlanc()){  //gère un des fin de jeu (quand il mange le roi) si ses pieces sont blanche
                if(this.j1.getMesPiecesManger().contains(this.echiquier.getRn())){ //Si dans ses pieces supprimer y'a un roi noir --> gagné donc BReak
                    System.out.println("Bravo "+this.j1.getPrenom());
                    break;
                }
            }else{
                if(this.j1.getMesPiecesManger().contains(this.echiquier.getRb())){  //si pieces noires la meme en contraire
                    System.out.println("Bravo "+this.j1.getPrenom());
                    break;
                }
            }
            System.out.println("A toi"+this.j2.getPrenom());  //au tour du joueur 2, qui fait la meme chose que le jouer 1
            this.echiquier = this.j2.deplacer(this.echiquier);
            this.sauvegarde() ;
            this.echiquier.afficher();
            if(this.j2.getMesPieces().get(0).estBlanc()){  //la meme que en haut ; 
                if(this.j2.getMesPiecesManger().contains(this.echiquier.getRn())){
                    System.out.println("Bravo "+this.j1.getPrenom());
                    break;
                }
            }else{
                if(this.j2.getMesPiecesManger().contains(this.echiquier.getRb())){
                    System.out.println("Bravo "+this.j1.getPrenom());
                    break;
                }
            }
        }
    }

    public void sauvegarde(){
        try {
            FileOutputStream fileOut = new FileOutputStream(SAUVEGARDE) ;  //Je choisis l'emplacement du fichier
            ObjectOutputStream out = new ObjectOutputStream(fileOut) ;  //je lui dit que je veut ecrire dans l'emplacement
            out.writeObject(this.echiquier) ;  //dans le fichier je met l'echiquier
            out.close() ;//je ferme les fichiers 
        }

        catch (FileNotFoundException e) { //gerer les erreurs
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void chargement(){
        try{
            FileInputStream fileIn = new FileInputStream(SAUVEGARDE) ;  //je choisis le fichier que je veut prendre
            ObjectInputStream in = new ObjectInputStream(fileIn) ;  //je veut lire dans le fichier
            this.echiquier = new Echiquier(in.readObject()) ; //dans mon echiquier je met ce qu il y a dans le fichier
            in.close() ;
        }
        catch (FileNotFoundException e) { //gerer les erreurs
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }

    /**
        *Pour gerer les différentes fin de parties
    */
    public void gererFinPartie(){
        /* ????? */
    }


    public static void main(String[] args) {
        Echiquier ech = new Echiquier();
        Joueur j1 = new Joueur("I","E");
        Joueur j2 = new Joueur("B","A");
        Partie p = new Partie(ech,j1,j2);
        p.chargement() ;
        p.lancer();
    }
}