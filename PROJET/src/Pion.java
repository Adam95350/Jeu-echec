public class Pion extends Piece{

	public Pion(boolean blanc){
		super(blanc) ;
		if (this.blanc){
			this.logo = "PB"; /*Si la piece est blanche c'est ca */
		}
		else {
			this.logo = "PN";/*Si la piece est noir c'est celui la */
		}
	}

	public String toString() {
		return "Je suis un pion blanc";
	}

	public boolean deplacementValide(Case caseArrivee, Case caseDepart, Case[][] cases){
		
		if(this.blanc){
			if (caseArrivee.getPiece() != null){  //Si y'a une piece dans la case d'arrivé
				if(caseArrivee.getPiece().estBlanc()){  //Si cette piece est blanche
					return false;  //false car peut pas manger pièce de la meme couleur
				}
			}
			if(caseDepart.getLigne() == 6){  //si la pièce est dans la ligne de depart
				if (caseDepart.getColonne() == caseArrivee.getColonne() && (caseArrivee.getLigne() == (caseDepart.getLigne() - 1) ||  caseArrivee.getLigne() == (caseDepart.getLigne() - 2))){
					return true ;
				}
				else {
					return false ;
				}
			}

			else if(caseDepart.getLigne() > caseArrivee.getLigne()){
				return false ;
			}

			else if(caseArrivee.getLigne() == (caseDepart.getLigne()-1) && ((caseArrivee.getColonne() == (caseDepart.getColonne()-1) || caseArrivee.getColonne() == (caseDepart.getColonne()+1)))){
				if(!caseArrivee.estVide()){
					return true ;
				}
			}
			else if (caseDepart.getColonne() == caseArrivee.getColonne() && caseArrivee.getLigne() == (caseDepart.getLigne() - 1 )){
				return true ;
			}
		}

		else{
			if (caseArrivee.getPiece() != null){
				if(!caseArrivee.getPiece().estBlanc()){
					return false;
				}
			}
			if(caseDepart.getLigne() == 1){
				if (caseDepart.getColonne() == caseArrivee.getColonne() && (caseArrivee.getLigne() == (caseDepart.getLigne() + 1) ||  caseArrivee.getLigne() == (caseDepart.getLigne() + 2))){
					return true ;
				}
				else {
					return false ;
				}
			}

			else if(caseDepart.getLigne() < caseArrivee.getLigne()){
				return false ;
			}

			else if(caseArrivee.getLigne() == (caseDepart.getLigne()+1) && ((caseArrivee.getColonne() == (caseDepart.getColonne()+1) || caseArrivee.getColonne() == (caseDepart.getColonne()-1)))){
				if(!cases[(caseDepart.getLigne()) + 1][(caseDepart.getColonne() + 1)].estVide()){
					return true ;
				}
			}
			else if (caseDepart.getColonne() == caseArrivee.getColonne() && caseArrivee.getLigne() == (caseDepart.getLigne() + 1 )){
				return true ;
			}
		}

		return false ;
	}

}