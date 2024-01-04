//* Nom et prénom: LE Tran Dang Quang
// * Numéro d'étudiant: 21107520
// * Groupe 9

public class Contenu {
   private static int nbContenusCrees = 0;
   public final int ident;
   public final String type;
   private int quantite;
   private int x;
   private int y;

   public Contenu(String var1, int var2) {
      this.type = var1;
      this.quantite = var2;
      this.ident = nbContenusCrees++;
      this.x = -1;
      this.y = -1;
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   public int getQuantite() {
      return this.quantite;
   }

   public void setQuantite(int var1) {
      this.quantite = var1;
   }

   public void setPosition(int var1, int var2) {
      this.x = var1;
      this.y = var2;
   }

   public void initialisePosition() {
      this.x = -1;
      this.y = -1;
   }

   public String toString() {
      String var1 = this.type + "[id:" + this.ident + " quantite: " + this.quantite + "] ";
      if (this.x != -1 && this.y != -1) {
         var1 = var1 + " en position (" + this.x + ", " + this.y + ")";
      } else {
         var1 = var1 + " n'est pas sur le terrain.";
      }

      return var1;
   }
}
