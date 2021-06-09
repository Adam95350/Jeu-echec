public class Roi extends Piece{

	public Roi(boolean blanc){
		super(blanc) ;
		if (this.blanc){
			this.logo = "RB";/*Si la piece est blanche c'est ca */
		}
		else {
			this.logo = "RN";/*Si la piece est noir c'est celui la */
		}
	}

	public boolean deplacementValide(Case caseArrivee, Case caseDepart, Case[][] cases){
		if (caseArrivee.getPiece() != null){
			if(this.blanc){
		 		if(caseArrivee.getPiece().estBlanc()){
		 			return false;
		 		}
		 	}
		 	else{
		 		if(!caseArrivee.getPiece().estBlanc()){
		 			return false;
			}
			}
		}
		if ((((caseDepart.getLigne() - caseArrivee.getLigne()) == Math.abs(1)) || //ligne de depart - ligne arrivé = 1 ou -1 c'est OK (car deplacement du roi limité a ca)
			((caseDepart.getLigne() - caseArrivee.getLigne()) == Math.abs(0)))   //ligne de depart - ligne arrivé = 0 c'est OK car deplacement en Colonne 
			&& ((caseDepart.getColonne() - caseArrivee.getColonne() == Math.abs(1)) || //colonne de depart - colonne arrive = 1 ou -1 c'est OK
				(caseDepart.getColonne() - caseArrivee.getColonne() == Math.abs(0)))){ //colonne de depart - colonne arrive = 0 c'est OK déplacement en Ligne
			//Condition sous la forme Xa ou Ya et Xb ou Yb (si XX ou YY = deplacement +1 en diagonale si XY = depalcement +1 ou -1 en colonne si YX = deplacement +1 ou -1 en colonne)
				return true ;
			}

		return false ;
		}
}