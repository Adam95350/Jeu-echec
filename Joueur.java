public class Joueur{

	private String nom ;
	private String prenom ;
	private Arraylist<Piece> mesPieces ;

	public Joueur(String nom, String prenom){
		this.nom = nom ;
		this.prenom = prenom ;
	}

    public void SaisieCoup(){
    	Scanner scanner = new scanner(System.in){
    		Systeme.out.print("Veuillez saisir la colonne du départ");
    		int a = scanner.nextInt();

    		Systeme.out.print("Veuillez saisir la ligne du départ");
    		int b = scanner.nextInt();

    		System.out.print("Vous voulez bougez la pièce de la case : " + a + b);

    	}
    }

	public void setmesPieces(Arraylist<Piece> p){
		this.mesPieces = p ;
	}
	
    public String getNom(){
        return nom ;
    }

    public String getPrenom(){
        return prenom ;
    }
}