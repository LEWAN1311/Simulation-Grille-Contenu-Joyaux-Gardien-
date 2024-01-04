//* Nom et prénom: LE Tran Dang Quang
// * Numéro d'étudiant: 21107520
// * Groupe 9

import java.util.ArrayList;

public class Agent9{
    private int coorX;
    private int coorY;
    private ArrayList<Contenu> sac;
    private Grille grilleAgent;

    public Agent9(int coorX, int coorY, Grille g){
        this.coorX = coorX;
        this.coorY = coorY;
        this.grilleAgent = g;
        this.sac = new ArrayList<Contenu>();
    }

    public int getCoorX() {
        return this.coorX;
    }

    public int getCoorY() {
        return this.coorY;
    }

    public Grille getGrille_agent() {
        return grilleAgent;
    }

    public void seDeplacer(int xnew,int ynew) throws DeplacementIncorrectException, CoordonneesIncorrectesException, CaseNonPleineException{
        if(grilleAgent.sontValides(xnew,ynew)){
            Contenu con = grilleAgent.getCase(xnew,ynew);

            if(con instanceof Joyaux){
                sac.add((Joyaux) con);
                grilleAgent.videCase(xnew,ynew);
                System.out.println("Joyaux rajouté dans le sac");

            }
            else if(con instanceof Gardien){
                sac.clear();
                System.out.println("Sac est vide");
            }
            else{
                System.out.println("Rien de changer");
            }

            this.coorX = xnew;
            this.coorY = ynew;
            
        }
        else{
            throw new DeplacementIncorrectException("Les coordonnées: (lig: "+this.coorX+", col: "+this.coorY+") ne peuvent pas se déplacer");
        }
    }

    public void seDeplacer(int xnew, int ynew, int f) throws DeplacementIncorrectException, CoordonneesIncorrectesException, CaseNonPleineException{
        if(grilleAgent.sontValides(xnew,ynew)){
            Contenu con = grilleAgent.getCase(xnew,ynew);
            if(con instanceof Joyaux){
                sac.add((Joyaux) con);
                grilleAgent.videCase(xnew,ynew);
                System.out.println("Joyaux rajouté dans le sac");

            }
            else if(con instanceof Gardien){
                if(((Gardien)con).getNbPVie()  < f){
                    grilleAgent.videCase(xnew,ynew);
                    System.out.println("Joyaux gardé, Gardien est vide");

                }else{
                    sac.clear();
                    System.out.println("Sac est vide");
                }
            } else{
                System.out.println("Rien de changer");
            }
            this.coorX = xnew;
            this.coorY = ynew;

        }
        else{
            throw new DeplacementIncorrectException("Les coordonnées: (lig: "+this.coorX+", col: "+this.coorY+") ne peuvent pas se déplacer");
        }

    }
    public int fortune(){
        int res = 0;
        for(int i=0; i<this.sac.size(); i++){
            res += ((Joyaux)sac.get(i)).getPrix();
        }
        return res;
    }

    public ArrayList<Contenu> contenuSac(){
        ArrayList<Contenu> res = new ArrayList<Contenu>();
        for(int i=0; i<this.sac.size(); i++){
            res.add(((Joyaux)sac.get(i)));
        }
        return res;
    }
}