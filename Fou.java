public class Fou extends Piece{

	private String logo ;

	public Fou(boolean blanc){
		super(blanc);
		if (this.blanc){
			String logo = "FB"; /*Si la piece est blanche c'est ca */
		}
		else {
			String logo = "FN";/*Si la piece est noir c'est celui la */
		}
	}

	public boolean deplacementValide(Case caseArrivee, Case caseDepart){
		
		if (Math.abs(caseDepart.getLigne()) - Math.abs(caseArrivee.getLigne()) 
			== Math.abs(caseDepart.getColonne()) - Math.abs(caseArrivee.getColonne())){
			return true ;
		}
		else { 
			return false ;
		}
	}
}