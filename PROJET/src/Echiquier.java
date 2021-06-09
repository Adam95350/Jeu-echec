import java.util.ArrayList;
import java.io.Serializable ;

public class Echiquier implements Serializable{  //Pour les sauvegardes

	private Case[][] cases ;
	private ArrayList<Piece> pieceNoire ;
	private ArrayList<Piece> pieceBlanche ;
	private Roi rB,rN;


	public Echiquier(){
		this.defEchiquier();
		this.defPiecesBlanches();
		this.defPiecesNoires();
	}

	public Echiquier(Object o){
		Echiquier e = (Echiquier) o ;
		this.cases = e.getCases() ;
		this.pieceBlanche = e.getPB() ;
		this.pieceNoire = e.getPN() ;
		this.rB = e.getRb() ;
		this.rN = e.getRn() ;
	}

	public void defEchiquier(){
		cases = new Case[8][8] ;
		rB = new Roi(true);
		rN = new Roi(false);
		cases[7][0] = new Case(7,0,new Tour(true));  /*Tour blanche (true = blanc), ligne 0, colonne 0 */
		cases[7][1] = new Case(7,1,new Cavalier(true)); /*ect.. ect.. */
		cases[7][2] = new Case(7,2,new Fou(true));
		cases[7][3] = new Case(7,3,new Reine(true));
		cases[7][4] = new Case(7,4,rB);
		cases[7][5] = new Case(7,5,new Fou(true));
		cases[7][6] = new Case(7,6,new Cavalier(true));
		cases[7][7] = new Case(7,7,new Tour(true));

		cases[6][0] = new Case(6,0,new Pion(true));
		cases[6][1] = new Case(6,1,new Pion(true));
		cases[6][2] = new Case(6,2,new Pion(true));
		cases[6][3] = new Case(6,3,new Pion(true));
		cases[6][4] = new Case(6,4,new Pion(true));
		cases[6][5] = new Case(6,5,new Pion(true));
		cases[6][6] = new Case(6,6,new Pion(true));
		cases[6][7] = new Case(6,7,new Pion(true));
		
		cases[0][0] = new Case(0,0,new Tour(false));
		cases[0][1] = new Case(0,1,new Cavalier(false));
		cases[0][2] = new Case(0,2,new Fou(false));
		cases[0][3] = new Case(0,3,new Reine(false));
		cases[0][4] = new Case(0,4,rN);
		cases[0][5] = new Case(0,5,new Fou(false));
		cases[0][6] = new Case(0,6,new Cavalier(false));
		cases[0][7] = new Case(0,7,new Tour(false));
		
		cases[1][0] = new Case(1,0,new Pion(false));
		cases[1][1] = new Case(1,1,new Pion(false));
		cases[1][2] = new Case(1,2,new Pion(false));
		cases[1][3] = new Case(1,3,new Pion(false));
		cases[1][4] = new Case(1,4,new Pion(false));
		cases[1][5] = new Case(1,5,new Pion(false));
		cases[1][6] = new Case(1,6,new Pion(false));
		cases[1][7] = new Case(1,7,new Pion(false));
		

		for (int ligne = 2; ligne < 6; ligne++){  /* ligne et colonne vide */
			for (int colonne = 0; colonne < 8; colonne++) {
				cases[ligne][colonne] = new Case(ligne,colonne, null);
			}
		}
	}

	public void defPiecesNoires(){
		this.pieceNoire = new ArrayList<Piece>() ;
		int i = 0;
		while (i < 2){
			int j = 0;
			while (j < 8){
				this.pieceNoire.add(cases[i][j].getPiece());
				j++;
			}
			i++;
		}
	}

	public void defPiecesBlanches(){
		this.pieceBlanche = new ArrayList<Piece>() ;
		int i = 7;
		while (i > 5){
			int j = 0;
			while (j < 8){
				this.pieceBlanche.add(cases[i][j].getPiece());
				j++;
			}
			i--;
		}
	}

	public void afficher() {		
		int l = 8;
		for(int ligne = 0 ; ligne <= 7 ; ligne++) {
			System.out.println(" -------------------------");
			System.out.print(l);
			for(int colonne = 0 ; colonne < 8 ; colonne++) {
				if(!cases[ligne][colonne].estVide()) 
					System.out.print("|"+ cases[ligne][colonne].getPiece().getLogo());
				else 
					System.out.print("|  ");
				}
			System.out.print("|");
			System.out.print("\n");
			l--;
			}
		System.out.println(" -------------------------");
		System.out.println("  A  B  C  D  E  F  G  H");
	}


    /*public void ajouterPiece(p: Piece, c: Case){
    	c == cases([c.getLigne()][c.getColonne()], p) ; // la case en parametre devient elle meme + la piece "p"
    } */

    //  public void ajouterPiece(Piece p, Case c){
    // 	this.cases[c.getLigne()][c.getColonne()].setCase(c.getLigne(), c.getColonne(), p) ; // ici on utilise la methode ajouterPiece alors 
    // 	p.setCase(this.cases[c.getLigne()][c.getColonne()]) ;      // qu'on l'a pas encore définie.
    // 															   // ici j'ai pas compris l'utilité de setCase.
    // }

    // public Case supprimerPiece(Case c){
    //     //c = cases([c.getLigne()][c.getColonne()], null) ; // la case en paramete devient elle meme avec piece == null (sans piece)
    // 	c = new Case(c.getLigne(), c.getColonne(), null) ;
    // 	return c ;
    // }

	public ArrayList<Piece> getPN(){
		return this.pieceNoire;
	}

	public ArrayList<Piece> getPB(){
		return this.pieceBlanche;
	}

	public Roi getRn(){
		return this.rN;
	}

	public Roi getRb(){
		return this.rB;
	}

	public Case[][] getCases(){
		return this.cases;
	}

    public static void main(String[] args) {
    	Echiquier e = new Echiquier() ;
    	// e.defPiecesNoires();
		// System.out.println(e.pieceNoire);
		e.afficher();
    }
}



