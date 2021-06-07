public class Partie {

	private Joueur j1 ;
	private Joueur j2 ;

    public void SaisieCoup(){
    	Scanner scanner = new scanner(System.in){
    		Systeme.out.print("Veuillez saisir la colonne du départ");
    		int a = scanner.nextInt();

    		Systeme.out.print("Veuillez saisir la ligne du départ");
    		int b = scanner.nextInt();

    		System.out.print("Vous voulez bougez la pièce de la case : " + a + b);


    	}
    }

    public boolean ValidationCoup(){
    	
    }

    public void gererFinPartie(){
        /* ????? */
    }


    public static void main(String[] args) {

    }
}