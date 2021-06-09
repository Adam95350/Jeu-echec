import java.util.ArrayList;
import java.util.Scanner;

public class Joueur{

	private String nom ;
	private String prenom ;
	private ArrayList<Piece> mesPieces ;
	private ArrayList<Piece> mesPieces_manger;

	public Joueur(String nom, String prenom){
		this.nom = nom ;
		this.prenom = prenom ;
		this.mesPieces = new ArrayList<Piece>();
        this.mesPieces_manger = new ArrayList<Piece>();
	}

    public String SaisieCase(){
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Case: ");
		String c = scanner.nextLine();  
		return c;	
    }

	public int choixColonne(String c){
        char a = c.charAt(0);
        int y = a - 97;
        return y;
    }

    public int choixLigne(String ligne){
        int l = Integer.parseInt(ligne);
        int x;
        if(l == 1){
            x = 7;
        }else if(l == 2){
            x = 6;
        }else if(l == 3){
            x = 5;
        }else if(l == 4){
            x = 4;
        }else if(l == 5){
            x = 3;
        }else if(l == 6){
            x = 2;
        }else if(l == 7){
            x = 1;
        }else{
            x = 0;
        }
        return x;
    }

	public Echiquier deplacer(Echiquier ech){
		System.out.println("Case de départ ?");
		String cd = this.SaisieCase();
		int colonneDepart = this.choixColonne(cd);
		int ligneDepart = this.choixLigne(cd.substring(1));
		if ( this.mesPieces.contains(ech.getCases()[ligneDepart][colonneDepart].getPiece())){
			System.out.println("Case d'arrivée ?");
			String ca = this.SaisieCase();
			int colonneArrivee = this.choixColonne(ca);
			int ligneArrivee = this.choixLigne(ca.substring(1));
            if(ech.getCases()[ligneDepart][colonneDepart].getPiece().deplacementValide(ech.getCases()[ligneArrivee][colonneArrivee], ech.getCases()[ligneDepart][colonneDepart], ech.getCases())){
    			if(!ech.getCases()[ligneArrivee][colonneArrivee].estVide()){
    				this.mesPieces_manger.add(ech.getCases()[ligneArrivee][colonneArrivee].getPiece());
                    ech.getCases()[ligneArrivee][colonneArrivee].setPiece(null);
    			}
    			ech.getCases()[ligneArrivee][colonneArrivee].setPiece(ech.getCases()[ligneDepart][colonneDepart].getPiece());
    			ech.getCases()[ligneDepart][colonneDepart].setPiece(null);
    		}
            else{
                System.out.print("deplacement invalide") ;
                this.deplacer(ech);
            }
        }else{
            System.out.println("Choisissez une de vos piéces !!!");
            this.deplacer(ech);
        }
		// ech.afficher();
		return ech;
	}

	public void setmesPieces(ArrayList<Piece> p){
		this.mesPieces = p ;
	}
	
    public String getNom(){
        return nom ;
    }

    public String getPrenom(){
        return prenom ;
    }

    public ArrayList<Piece> getMesPieces(){
        return this.mesPieces;
    }

    public ArrayList<Piece> getMesPiecesManger(){
        return this.mesPieces_manger;
    }
}