public class Tour extends Piece{

	public Tour(boolean blanc){
		super(blanc) ;
		if (this.blanc){
			this.logo = "TB" ;/*Si la piece est blanche c'est ca */
		}
		else {
			this.logo = "TN" ;/*Si la piece est noir c'est celui la */
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
    	if (caseArrivee.getLigne() != caseDepart.getLigne() && caseArrivee.getColonne() != caseDepart.getColonne()) { // Condition général de vérification de déplacement de la Tour
    		return false ;  //Si la Ligne arrivé est différent de ligne depart  ET  colonne arrivé est différent de colonne depart = mouvement autre que vertical ou Horizontale
        	}

        //if(caseArrivee.getColonne() == caseDepart.getColonne()){  //Deplacement en vertical

        else if(caseArrivee.getLigne() > caseDepart.getLigne()){   //Deplacement Vertical en descente    
             while(caseArrivee.getLigne() >= caseDepart.getLigne()){  //Boucle pour vérifier que chaque case jusqu'a l'arrivé est bien vide
                int i = caseDepart.getLigne() ;
                i++ ;

                if(!cases[i][caseDepart.getColonne()].estVide()){  //Vérification de chaque si vide ou pas, si c'est pas vide return false directement
                   return false ;
                }
            }
        }

        else if(caseArrivee.getLigne() < caseDepart.getLigne()){ //Deplacement Vertical en monté

             while(caseArrivee.getLigne() <= caseDepart.getLigne()){  //Boucle pour vérifier que chaque case jusqu'a l'arrivé est bien vide
                int i = caseDepart.getLigne() ;
                i-- ;

                if(!cases[i][caseDepart.getColonne()].estVide()){  //Vérification de chaque si vide ou pas, si c'est pas vide return false directement
                    return false ;
                }
             }
        }

        

        else if(caseArrivee.getColonne() > caseDepart.getColonne()){ //Deplacement Horizontale vers la droite
            while(caseArrivee.getColonne() >= caseDepart.getColonne()){  //Boucle pour vérifier que chaque case jusqu'a l'arrivé est bien vide
                int i = caseDepart.getColonne() ;
                i++ ;
 
                if(!cases[caseDepart.getLigne()][i].estVide()){  //Vérification de chaque si vide ou pas, si c'est pas vide return false directement
                    return false ;
                }
            }
        }

        else if(caseArrivee.getColonne() < caseDepart.getColonne()){  //Deplacement Horizontale vers la gauche
            while(caseArrivee.getColonne() < caseDepart.getColonne()){  //Boucle pour vérifier que chaque case jusqu'a l'arrivé est bien vide
                int i = caseDepart.getColonne() ;
                i-- ;

                if(!cases[caseDepart.getLigne()][i].estVide()){  //Vérification de chaque si vide ou pas, si c'est pas vide return false directement
                    return false ; 
                }
            }
        }

        return true ;

        /*Deplacement de la tour se fait en ligne ou colonne, donc la ligne doit pas bouger lorsqu'elle se deplace en ligne
        et la colonne doit pas bouger lorsqu'elle se deplace en colonne
        Donc si la ligne et la colonne sont diferent c'est un mauvais mouvement, si seulement la ligne bouge => deplacement
        en colonne, si seulement colonne bouge => deplacement en ligne... */
    }

        /*Deplacement de la tour se fait en ligne ou colonne, donc la ligne doit pas bouger lorsqu'elle se deplace en ligne
        et la colonne doit pas bouger lorsqu'elle se deplace en colonne
        Donc si la ligne et la colonne sont diferent c'est un mauvais mouvement, si seulement la ligne bouge => deplacement
        en colonne, si seulement colonne bouge => deplacement en ligne... */
}
