public class Cavalier extends Piece{

	public Cavalier(boolean blanc){
		super(blanc) ;
		if (this.blanc){
			this.logo = "CB";/*Si la piece est blanche c'est ca */
		}
		else {
			this.logo = "CN";/*Si la piece est noir c'est celui la */
		}
	}

	public boolean deplacementValide(Case caseArrivee, Case caseDepart, Case[][] cases){
		if (caseArrivee.getPiece() != null){
			if(this.blanc){
				if(caseArrivee.getPiece().estBlanc()){
					return false;
				}
			}else{
				if(!caseArrivee.getPiece().estBlanc()){
					return false;
				}
			}
		}
		int diffLigne = Math.abs(caseDepart.getLigne() - caseArrivee.getLigne());
        int diffColonne = Math.abs(caseDepart.getColonne() - caseArrivee.getColonne());
        return diffLigne * diffColonne == 2;
	}
}