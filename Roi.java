public class Roi extends Piece{

	private String logo ;

	public Roi(boolean blanc){
		super(blanc) ;
		if (this.blanc){
			String logo = "RB";/*Si la piece est blanche c'est ca */
		}
		else {
			String logo = "RN";/*Si la piece est noir c'est celui la */
		}
	}

	public boolean deplacementValide(Case caseArrivee, Case caseDepart){
		if (((caseDepart.getLigne() - caseArrivee.getLigne()) == Math.abs(1)) || 
			((caseDepart.getLigne() - caseArrivee.getLigne()) == Math.abs(0))){
				return true ;
			}

		else if ((caseDepart.getColonne() - caseArrivee.getColonne() == Math.abs(1)) || 
				(caseDepart.getColonne() - caseArrivee.getColonne() == Math.abs(0))){
				return true ;
			}
		else {
			return false ;
		}
	}




}