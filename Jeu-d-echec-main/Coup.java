public class Coup{

	private Case casedepart ;
	private Case casearrive ;
    
    public Case getCaseDepart(){
        return casedepart ;
    }

	public void setCaseDepart(Case depart) {
		this.casedepart = depart;
	}

	public Case getCaseArrivee(){
    	return casearrive ;
    }

	public void setCaseArrive(Case arrive) {
		this.casearrive = arrive;
	}


	//Methode pour vérifier si on peut manger une pièce
	public boolean mangerPiece(){
		if (casearrive.estVide() == false && casearrive.getPiece().estBlanc() != piece.estBlanc()) //Si la case n'est pas vide, et que la piece dans cette case
																								   //n'est pas de la même que la couleur de la piece qui se deplace(donc piece enemie), alors il peut la manger
			return true ;
		else 
			return false ;
	}

	//Méthode pour vérifier si la case d'arrivé est vide
	public boolean casearriveVide(){
		return casearrive.estVide();
	}


}