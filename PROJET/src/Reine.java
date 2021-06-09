public class Reine extends Piece{
	
	public Reine(boolean blanc){
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
			}else{
				if(!caseArrivee.getPiece().estBlanc()){
					return false;
				}
			}
		}

		int a = caseDepart.getLigne() ;
		int b = caseDepart.getColonne() ;
		if (a < caseArrivee.getLigne()){ //deplacement vers le haut  
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


		else if (Math.abs(caseDepart.getLigne()) - Math.abs(caseArrivee.getLigne()) 
			== Math.abs(caseDepart.getColonne()) - Math.abs(caseArrivee.getColonne())){
			return true ;
		}

		else if (caseArrivee.getLigne() != caseDepart.getLigne() && caseArrivee.getColonne() != caseDepart.getColonne()) { // Condition général de vérification de déplacement de la Tour
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


    }	
}