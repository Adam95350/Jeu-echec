public class Roi extends Piece{

	private String logo ;

	public Roi(){
		if (piece.estBlanc()){
			String logo = "RB" /*Si la piece est blanche c'est ca */
		}
		else {
			String logo = "RN" /*Si la piece est noir c'est celui la */
		}
	}

	public boolean deplacementValide(Case : caseArrivee){
		if ((piece.getLigne() - caseArrivee.getLigne == Math.abs(1)) || 
			(piece.getLigne() - caseArrivee.getLigne == Math.abs(0)){
				return true ;
			}

		else if ((piece.getColonne() - caseArrivee.getColonne == Math.abs(1)) || 
			(piece.getColonne() - caseArrivee.getColonne == Math.abs(0)){
				return true ;
			}
		else {
			return false ;
		}
	}




}