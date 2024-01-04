//* Nom et prénom: LE Tran Dang Quang
// * Numéro d'étudiant: 21107520
// * Groupe 9

import java.util.ArrayList;

public final class Grille {
   public static final int NBLIGNESMAX = 20;
   public static final int NBCOLONNESMAX = 20;
   public final int nbLignes;
   public final int nbColonnes;
   private Contenu[][] grille;

   public Grille() {
      this(20, 20);
   }

   public Grille(int var1, int var2) {
      if (var1 > 20) {
         this.nbLignes = 20;
      } else if (var1 <= 0) {
         this.nbLignes = 1;
      } else {
         this.nbLignes = var1;
      }

      if (var2 > 20) {
         this.nbColonnes = 20;
      } else if (var2 <= 0) {
         this.nbColonnes = 1;
      } else {
         this.nbColonnes = var2;
      }

      this.grille = new Contenu[this.nbLignes][this.nbColonnes];
   }

   public Contenu getCase(int var1, int var2) throws CoordonneesIncorrectesException {
      if (!this.sontValides(var1, var2)) {
         throw new CoordonneesIncorrectesException("coordonnees (" + var1 + ", " + var2 + ") incorrectes !");
      } else {
         return this.grille[var1][var2];
      }
   }

   public Contenu videCase(int var1, int var2) throws CaseNonPleineException, CoordonneesIncorrectesException {
      if (!this.sontValides(var1, var2)) {
         throw new CoordonneesIncorrectesException("coordonnees (" + var1 + ", " + var2 + ") incorrectes !");
      } else if (this.grille[var1][var2] == null) {
         throw new CaseNonPleineException("La case (" + var1 + ", " + var2 + ") est deja vide !");
      } else {
         Contenu var3 = this.grille[var1][var2];
         var3.initialisePosition();
         this.grille[var1][var2] = null;
         return var3;
      }
   }

   public void setCase(int var1, int var2, Contenu var3) throws CoordonneesIncorrectesException {
      if (!this.sontValides(var1, var2)) {
         throw new CoordonneesIncorrectesException("coordonnees (" + var1 + ", " + var2 + ") incorrectes !");
      } else {
         if (this.grille[var1][var2] != null) {
            this.grille[var1][var2].initialisePosition();
         }

         this.grille[var1][var2] = var3;
         var3.setPosition(var1, var2);
      }
   }

   public boolean caseEstVide(int var1, int var2) throws CoordonneesIncorrectesException {
      if (!this.sontValides(var1, var2)) {
         throw new CoordonneesIncorrectesException("coordonnees (" + var1 + ", " + var2 + ") incorrectes !");
      } else {
         return this.grille[var1][var2] == null;
      }
   }

   public ArrayList<Contenu> lesContenus() {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < this.nbLignes; ++var2) {
         for(int var3 = 0; var3 < this.nbColonnes; ++var3) {
            if (this.grille[var2][var3] != null) {
               var1.add(this.grille[var2][var3]);
            }
         }
      }

      return var1;
   }

   public boolean sontValides(int var1, int var2) {
      return var1 >= 0 && var1 < this.nbLignes && var2 >= 0 && var2 < this.nbColonnes;
   }

   public void affiche(int var1) {
      String var2 = "";
      String var3 = ":";
      String var4 = "";
      int var5 = Math.max(var1, 1);

      int var6;
      for(var6 = 0; var6 < var5; ++var6) {
         var4 = var4 + "-";
      }

      for(var6 = 0; var6 < this.nbColonnes; ++var6) {
         var3 = var3 + var4 + ":";
      }

      var3 = var3 + "\n";
      var2 = var3;

      for(var6 = 0; var6 < this.nbLignes; ++var6) {
         for(int var7 = 0; var7 < this.nbColonnes; ++var7) {
            if (this.grille[var6][var7] == null) {
               var2 = var2 + "|" + String.format("%-" + var5 + "s", " ");
            } else {
               var2 = var2 + "|" + this.premiersCar(this.grille[var6][var7].type, var5);
            }
         }

         var2 = var2 + "|\n" + var3;
      }

      System.out.println(var2);
   }

   public String toString() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.nbLignes; ++var2) {
         for(int var3 = 0; var3 < this.nbColonnes; ++var3) {
            if (this.grille[var2][var3] != null) {
               ++var1;
            }
         }
      }

      String var4 = "Grille de " + this.nbLignes + "x" + this.nbColonnes + " cases: ";
      if (var1 == 0) {
         var4 = var4 + "toutes les cases sont libres.";
      } else if (var1 == 1) {
         var4 = var4 + "il y a une case occup\u00e9e.";
      } else {
         var4 = var4 + "il y a " + var1 + " cases occup\u00e9es.";
      }

      return var4;
   }

   private String premiersCar(String var1, int var2) {
      String var3 = String.format("%-" + var2 + "s", var1);
      return var3.substring(0, var2);
   }
}
