public class Pion extends Piece{

	private String logo ;

	public Pion(boolean blanc){
		super(blanc) ;
		if (this.blanc){
			String logo = "PB"; /*Si la piece est blanche c'est ca */
		}
		else {
			String logo = "PN";/*Si la piece est noir c'est celui la */
		}
	}

	public boolean deplacementValide(Case caseArrivee, Case caseDepart){
		if (caseDepart.getColonne() == caseArrivee.getColonne() || caseDepart.getLigne() == caseArrivee.getColonne() + 1 ){
			return true ;
		}
		else {
			return false ;
		}
	}

}