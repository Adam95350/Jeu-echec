public class Cavalier extends Piece{

	private String logo ;

	public Cavalier(boolean blanc){
		super(blanc) ;
		if (this.blanc){
			String logo = "CB";/*Si la piece est blanche c'est ca */
		}
		else {
			String logo = "CN";/*Si la piece est noir c'est celui la */
		}
	}

	public boolean deplacementValide(Case caseArrivee, Case caseDepart){
		if (caseDepart.getColonne() == caseArrivee.getColonne() + 1 || caseDepart.getLigne() == caseArrivee.getLigne() + 2){
			return true ;
		}

		else if (caseDepart.getColonne() == caseArrivee.getColonne() + 1 || caseDepart.getLigne() == caseArrivee.getLigne() - 2){
			return true ;
		}

		else if (caseDepart.getColonne() == caseArrivee.getColonne() - 1 || caseDepart.getLigne() == caseArrivee.getLigne() + 2){
			return true ;
		}

		else if (caseDepart.getColonne() == caseArrivee.getColonne() - 1 || caseDepart.getLigne() == caseArrivee.getLigne() - 2){
			return true ;
		}


		if (caseDepart.getColonne() == caseArrivee.getColonne() + 2 || caseDepart.getLigne() == caseArrivee.getLigne() + 1){
			return true ;
		}

		else if (caseDepart.getColonne() == caseArrivee.getColonne() + 2 || caseDepart.getLigne() == caseArrivee.getLigne() - 1){
			return true ;
		}

		else if (caseDepart.getColonne() == caseArrivee.getColonne() - 2 || caseDepart.getLigne() == caseArrivee.getLigne() + 1){
			return true ;
		}

		else if (caseDepart.getColonne() == caseArrivee.getColonne() - 2 || caseDepart.getLigne() == caseArrivee.getLigne() - 1){
			return true ;
		}

		else { 
			return false ;
		}
	}
}