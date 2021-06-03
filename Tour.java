public class Tour extends Piece{

	private String logo ;

	public Tour(){
		if (piece.estBlanc()){
			String logo = "TB" /*Si la piece est blanche c'est ca */
		}
		else {
			String logo = "TN" /*Si la piece est noir c'est celui la */
		}
	}

    public boolean deplacementValide(Case : caseArrivee){
    	if (caseArrivee.getLigne() != piece.getLigne() || caseArrivee.getColonne() != piece.getColonne()) {
    		return false ;
    	}
    	return true ;

        /*Deplacement de la tour se fait en ligne ou colonne, donc la ligne doit pas bouger lorsqu'elle se deplace en ligne
        et la colonne doit pas bouger lorsqu'elle se deplace en colonne
        Donc si la ligne et la colonne sont diferent c'est un mauvais mouvement, si seulement la ligne bouge => deplacement
        en colonne, si seulement colonne bouge => deplacement en ligne... */
    }
}