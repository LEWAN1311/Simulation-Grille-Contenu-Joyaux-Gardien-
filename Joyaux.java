/* Nom et prénom: LE Tran Dang Quang
 * Numéro d'étudiant: 21107520
 * Groupe 9
 */

public class Joyaux extends Contenu{
    private final int prix;

    public Joyaux(String typeJoy, int quantiteJoy){
        super(typeJoy, quantiteJoy);
        this.prix = (int)(Math.random()*(9000)+1);
    }
    public String getTypeJoy() {
        return super.type;
    }
    public int getQuantiteJoy() {
        return super.getQuantite();
    }
    public int getPrix() {
        return this.prix;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}