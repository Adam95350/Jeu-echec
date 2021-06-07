public class Reine extends Piece{

	private String logo ;

	public Reine(boolean blanc){
		super(blanc) ;
		if (this.blanc){
			String logo = "RB";/*Si la piece est blanche c'est ca */
		}
		else {
			String logo = "RN";/*Si la piece est noir c'est celui la */
		}
	}

    public boolean deplacementValide(Case caseArrivee, Case caseDepart){
    	if ((caseArrivee.getLigne() == caseDepart.getLigne()) || (caseArrivee.getColonne() == caseDepart.getColonne()) || 
    	     (Math.abs(caseDepart.getLigne()) - Math.abs(caseArrivee.getLigne()))  
			  == (Math.abs(caseDepart.getColonne()) - Math.abs(caseArrivee.getColonne()))){
    		return true ; // ca renvoie tru (deplacement de la reine) // si c'est un deplacement en ligne ou colonne // si c'est un deplacement en diagonal
    	}

    	else {
    		return false ;
    	}
    }	
}