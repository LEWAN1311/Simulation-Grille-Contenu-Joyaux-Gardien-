/* Nom et prénom: LE Tran Dang Quang
 * Numéro d'étudiant: 21107520
 * Groupe 9
 */

public class Gardien extends Contenu{
    private int nbPVie;

    public Gardien(int quantiteGar){
        super("Gardien",quantiteGar);
        this.nbPVie = (int)(Math.random()*(201));
    }

    public int getQuantiteGar() {
        return super.getQuantite();
    }

    public int getNbPVie() {
        return nbPVie;
    }

    public void nbVieRestant(int f){
        this.nbPVie = nbPVie - f;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}