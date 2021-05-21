public class Reine extends Piece{

	private String logo ;

	public Reine(){
		if (piece.estBlanc()){
			String logo = "RB" /*Si la piece est blanche c'est ca */
		}
		else {
			String logo = "RN" /*Si la piece est noir c'est celui la */
		}
	}

    public boolean deplacementValide(Case : caseArrivee){
    	if (((caseArrivee.getLigne() == piece.getLigne()) || (caseArrivee.getColonne() == piece.getColonne()))) || // si c'est un deplacement en ligne ou colonne
    	     (Math.abs(piece.getLigne()) - Math.abs(caseArrivee.getLigne())  // si c'est un deplacement en diagonal
			  == Math.abs(piece.getColonne()) - Math.abs(caseArrivee.getColonne())){
    		return true ; // ca renvoie tru (deplacement de la reine)
    	}

    	else {
    		return false ;
    	}
    }	
}