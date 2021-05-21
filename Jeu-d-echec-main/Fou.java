public class Fou extends Piece{

	private String logo ;

	public Fou(){
		if (piece.estBlanc()){
			String logo = "FB" /*Si la piece est blanche c'est ca */
		}
		else {
			String logo = "FN" /*Si la piece est noir c'est celui la */
		}
	}

	public boolean deplacementValide(Case: caseArrivee){
		
		if (Math.abs(piece.getLigne()) - Math.abs(caseArrivee.getLigne()) 
			== Math.abs(piece.getColonne()) - Math.abs(caseArrivee.getColonne())){
			return true
		}
		else { 
			return false ;
		}
	}
}