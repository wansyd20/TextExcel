/*
Sydney Wan
AP CS A
Text Excel Lab

EmptyCell Class
*/

public class EmptyCell implements Cell {

   private String input;
   
   //creates an empty cell with the designated width
   public EmptyCell() {
      input = "";
      for (int size = 1; size <= CELLWIDTH; size++) {
         this.input += " ";
      }
   }
   
   public String abbreviatedCellText() {
      return "          ";
   }
   
   public String fullCellText() {
      return "";
   }
      
}