public class Cavalier extends Piece{

	private String logo ;

	public Cavalier(){
		if (piece.estBlanc()){
			String logo = "CB" /*Si la piece est blanche c'est ca */
		}
		else {
			String logo = "CN" /*Si la piece est noir c'est celui la */
		}
	}

	public boolean deplacementValide(Case : caseArrivee){
		if (piece.getColonne() == caseArrivee.getColonne() + 1 || piece.getLigne() == caseArrivee.getLigne() + 2){
			return true ;
		}

		else if (piece.getColonne() == caseArrivee.getColonne() + 1 || piece.getLigne() == caseArrivee.getLigne() - 2){
			return true ;
		}

		else if (piece.getColonne() == caseArrivee.getColonne() - 1 || piece.getLigne() == caseArrivee.getLigne() + 2){
			return true ;
		}

		else if (piece.getColonne() == caseArrivee.getColonne() - 1 || piece.getLigne() == caseArrivee.getLigne() - 2){
			return true ;
		}


		if (piece.getColonne() == caseArrivee.getColonne() + 2 || piece.getLigne() == caseArrivee.getLigne() + 1){
			return true ;
		}

		else if (piece.getColonne() == caseArrivee.getColonne() + 2 || piece.getLigne() == caseArrivee.getLigne() - 1){
			return true ;
		}

		else if (piece.getColonne() == caseArrivee.getColonne() - 2 || piece.getLigne() == caseArrivee.getLigne() + 1){
			return true ;
		}

		else if (piece.getColonne() == caseArrivee.getColonne() - 2 || piece.getLigne() == caseArrivee.getLigne() - 1){
			return true ;
		}

		else { 
			return false ;
		}
	}
}