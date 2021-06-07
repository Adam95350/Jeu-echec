public class Echiquier{

	private Case[][] cases ;
	private Arraylist<Piece> pieceNoire ;
	private Arraylist<Piece> pieceBlanche ;



	public Echiquier(){
		cases = new Case[8][8] ;
		this.pieceNoire = new Arraylist<Piece>() ;
		this.pieceBlanche = new Arraylist<Piece>() ;
		cases[0][0] = new Case(0,0,new Tour(true));  /*Tour blanche (true = blanc), ligne 0, colonne 0 */
		this.pieceBlanche.add(new Tour(true));
		cases[0][1] = new Case(0,1,new Cavalier(true)); /*ect.. ect.. */
		cases[0][2] = new Case(0,2,new Fou(true));
		cases[0][3] = new Case(0,3,new Reine(true));
		cases[0][4] = new Case(0,4,new Roi(true));
		cases[0][5] = new Case(0,5,new Fou(true));
		cases[0][6] = new Case(0,6,new Cavalier(true));
		cases[0][7] = new Case(0,7,new Tour(true));

		cases[1][0] = new Case(1,0,new Pion(true));
		cases[1][1] = new Case(1,1,new Pion(true));
		cases[1][2] = new Case(1,2,new Pion(true));
		cases[1][3] = new Case(1,3,new Pion(true));
		cases[1][4] = new Case(1,4,new Pion(true));
		cases[1][5] = new Case(1,5,new Pion(true));
		cases[1][6] = new Case(1,6,new Pion(true));
		cases[1][7] = new Case(1,7,new Pion(true));
		
		cases[7][0] = new Case(7,0,new Tour(false));
		cases[7][1] = new Case(7,1,new Cavalier(false));
		cases[7][2] = new Case(7,2,new Fou(false));
		cases[7][3] = new Case(7,3,new Reine(false));
		cases[7][4] = new Case(7,4,new Roi(false));
		cases[7][5] = new Case(7,5,new Fou(false));
		cases[7][6] = new Case(7,6,new Cavalier(false));
		cases[7][7] = new Case(7,7,new Tour(false));
		
		cases[6][0] = new Case(6,0,new Pion(false));
		cases[6][1] = new Case(6,1,new Pion(false));
		cases[6][2] = new Case(6,2,new Pion(false));
		cases[6][3] = new Case(6,3,new Pion(false));
		cases[6][4] = new Case(6,4,new Pion(false));
		cases[6][5] = new Case(6,5,new Pion(false));
		cases[6][6] = new Case(6,6,new Pion(false));
		cases[6][7] = new Case(6,7,new Pion(false));
		

		for (int ligne = 2; ligne < 6; ligne++){  /* ligne et colonne vide */
			for (int colonne = 0; colonne < 8; colonne++) {
				cases[ligne][colonne] = new Case(ligne,colonne, null);
			}
		}
	}

		public void afficher() {
		for(int ligne = 7 ; ligne >= 0 ; ligne--) {
			System.out.println(" -------------------------");
			System.out.print(ligne + 1);
			for(int colonne = 0 ; colonne < 8 ; colonne++) {
				if(!cases[ligne][colonne].estVide()) 
					System.out.print("|"+ cases[ligne][colonne].getPiece().getLogo());
				else 
					System.out.print("|  ");
				}
			System.out.print("|");
			System.out.print("\n");
			}
		System.out.println(" -------------------------");
		System.out.println("  A  B  C  D  E  F  G  H");
		}


    /*public void ajouterPiece(p: Piece, c: Case){
    	c == cases([c.getLigne()][c.getColonne()], p) ; // la case en parametre devient elle meme + la piece "p"
    } */

     public void ajouterPiece(Piece p, Case c){
    	this.cases[c.getLigne()][c.getColonne()].setCase(c.getLigne(), c.getColonne(), p) ; // ici on utilise la methode ajouterPiece alors 
    	p.setCase(this.cases[c.getLigne()][c.getColonne()]) ;      // qu'on l'a pas encore définie.
    															   // ici j'ai pas compris l'utilité de setCase.
    }

    public Case supprimerPiece(Case c){
        //c = cases([c.getLigne()][c.getColonne()], null) ; // la case en paramete devient elle meme avec piece == null (sans piece)
    	c = new Case(c.getLigne(), c.getColonne(), null) ;
    	return c ;
    }

    public static void main(String[] args) {
    	Echiquier e = new Echiquier() ;
    	e.afficher();	
    }
}



