public class Fou extends Piece{

	public Fou(boolean blanc){
		super(blanc);
		if (this.blanc){
			this.logo = "FB"; /*Si la piece est blanche c'est ca */
		}
		else {
			this.logo = "FN";/*Si la piece est noir c'est celui la */
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
		int a = caseDepart.getLigne() ;
		int b = caseDepart.getColonne() ;
		if (a < caseArrivee.getLigne()){ //deplacement vers le haut  OPTIONEL ????
			while(a < caseArrivee.getLigne()){ //tant que la condition de deplacement vers le haut est bon
				if (caseDepart.getColonne() < caseArrivee.getColonne()){ //deplacement en haut à droite
					a++ ;	 //droite
					b++ ;	 //droite
					if (!cases[a][b].estVide()){
						return false ;
						}
					}
				else if (caseDepart.getColonne() > caseArrivee.getColonne()){ //deplacement en haut à gauche
					a++ ; 	//gauche
					b-- ;	//gauche
					if (!cases[a][b].estVide()){
						return false ;
						}
					}
				}
			}

			else{ //A VERIFIER SI DANS CES ELSE/IF ON MET <= OU JUST < !!!!!   //deplacement vers le bas
				while(a > caseArrivee.getLigne()){ //tant que la condition de deplacement vers le bas est bon
				if (caseDepart.getColonne() < caseArrivee.getColonne()){ //deplacement en bas à droite
					a-- ;	 //droite
					b++ ;	 //droite
					if (!cases[a][b].estVide()){
						return false ;
						}
					}
				else if (caseDepart.getColonne() > caseArrivee.getColonne()){ //deplacement en bas à gauche
					a-- ; 	//gauche
					b-- ;	//gauche
					if (!cases[a][b].estVide()){
						return false ;
						}
					}
				}
			}


		if (Math.abs(caseDepart.getLigne()) - Math.abs(caseArrivee.getLigne()) 
			== Math.abs(caseDepart.getColonne()) - Math.abs(caseArrivee.getColonne())){
			return true ;
		}
		else { 
			return false ;
		}

	}

}