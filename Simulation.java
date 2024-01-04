/* Nom et prénom: LE Tran Dang Quang
 * Numéro d'étudiant: 21107520
 * Groupe 9
 */

public class Simulation {
    private Agent9 agent9;
    private Grille grille;
    private Contenu[] tabContenus;


    public Simulation(int m ,Agent9 agent) throws CoordonneesIncorrectesException{
        this.tabContenus = new Contenu[m];
        this.agent9 = agent;
        this.grille = agent9.getGrille_agent();
        for(int i=0; i<tabContenus.length; i++){
            int quantiteJoyauxCree = (int)(Math.random()*(15)+1);

            int ligne = (int)(Math.random()*(this.grille.nbLignes));
            int colonne = (int)(Math.random()*(this.grille.nbColonnes));

            int ran = (int)(Math.random()*5);
            // random = 0 -> créer Ruby
            if (ran == 0){
                tabContenus[i] = new Joyaux("Ruby", quantiteJoyauxCree);
            }
            // random = 1 -> créer Diamant
            else if(ran == 1){
                tabContenus[i] = new Joyaux("Diamant", quantiteJoyauxCree);
            }
            // random = 2 -> créer Opale
            else if(ran == 2){
                tabContenus[i] = new Joyaux("Opale", quantiteJoyauxCree);
            }
            // random = 3 -> créer Gardien
            else if(ran==3){
                tabContenus[i] = new Gardien(quantiteJoyauxCree);
            }
            // random = 4 -> créer Or
            else {
                tabContenus[i] = new Joyaux("Or", quantiteJoyauxCree);
            }
            this.grille.setCase(ligne, colonne, tabContenus[i]);
        }
    }

    public void lance(int nbEtapes){
        
        for(int i=0;i<nbEtapes; i++){
            // Deplacement Agent + (-1 ou 0 ou 1 position)
            int xnewAgent = this.agent9.getCoorX()+(int)(Math.random()*(3)-1);
            int ynewAgent = this.agent9.getCoorY()+(int)(Math.random()*(3)-1);

            boolean forceMove = Math.random() < 0.3;

            try {
                if (forceMove) {
                    int foceValue = (int)(Math.random()*(100-10+1)+10);
                    this.agent9.seDeplacer(xnewAgent, ynewAgent, foceValue);
                }else{
                    this.agent9.seDeplacer(xnewAgent, ynewAgent);
                }
            } catch (DeplacementIncorrectException | CoordonneesIncorrectesException | CaseNonPleineException e) {
                e.printStackTrace();
            }

            System.out.println("----------");
            System.out.println("Etape"+(i+1));
            System.out.println("----------");
            System.out.println("Les informations de Contenu: ");
            System.out.println(grille);
            System.out.println(this);
            System.out.println("----------");
            grille.affiche(4);
            System.out.println("Les Joyaux dans le sac: ");
            System.out.println(this.agent9.contenuSac());
            System.out.println("----------");

            // set time sleep afin d'observer
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public String toString(){
        String s = "";
        for(int i=0; i<tabContenus.length; i++){
            s += "\n"+tabContenus[i].toString()+"\n"+"Fortune des pièces d'or: "+agent9.fortune();
        }
        return s;
    }
}