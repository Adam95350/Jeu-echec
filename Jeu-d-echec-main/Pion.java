public class Pion extends Piece{

	private String logo ;

	public Pion(){
		if (piece.estBlanc()){
			String logo = "PB" /*Si la piece est blanche c'est ca */
		}
		else {
			String logo = "PN" /*Si la piece est noir c'est celui la */
		}
	}

	public boolean deplacementValide(Case : caseArrivee){
		if (piece.getColonne() == caseArrivee.getColonne() || piece.getLigne() == caseArrivee.getColonne() + 1 ){
			return true ;
		}
		else {
			return false ;
		}
	}

}