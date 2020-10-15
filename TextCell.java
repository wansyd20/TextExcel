/*
Sydney Wan
AP CS A
Text Excel Lab

EmptyCell Class
*/

public class TextCell implements Cell {

   private String input;
   private String fullText;
   
   //creates an empty cell with the designated width
   public TextCell(String text) {
      this.input = text;
      this.fullText = text;
   }
   
   public String abbreviatedCellText() {
      //if the word is longer than 10, it only puts the first 10 values in the grid
      if (input.length() > 10) {
         return this.input.substring(0, 10);
      }
      //for if the word is exactly 10 letters
      else if (input.length() == 10) {
         return this.input;
      }
      //for all words that don't fill up the grid, pads the rest of the cell with spaces
      else {
         int spaces = 10 - this.input.length();
         for (int k = 1; k <= spaces; k++) {
            this.input += " ";
         }
         return this.input;
      }
   }
   
   public String fullCellText() {
      return "\"" + this.fullText + "\"";
   }
      
}