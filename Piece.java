import java.lang.Math;


public abstract class Piece {
    
	protected boolean blanc ;
	protected String logo ;  /* a definir dans chaque classe de piece */
	protected Case cases ;

	public Piece(boolean blanc){
		this.blanc = blanc ; // "blanc" en attribut prend le "blanc" en paramettre
	}

	public boolean estBlanc(){
		return this.blanc ;  //retourne True si la pièce est blanc, sinon False
	}

	public void setBlanc(boolean blanc){
		this.blanc = blanc ;
	}

	public String getLogo() {
		return this.logo ;
	}

	public void setLogo(String logo) {
		this.logo = logo ;
	}

    public Case getCase(){
    	return this.cases ;
    }

    public void setCase(Case cases){
    	this.cases = cases ;
    }

    public abstract boolean deplacementValide(Case caseArrivee, Case caseDepart) ;
}