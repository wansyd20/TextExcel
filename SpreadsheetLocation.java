/*
Sydney Wan
AP CS A
Text Excel Lab

SpreadsheetLocation Class
*/

public class SpreadsheetLocation implements Location {
   
   private String cellName;

   public SpreadsheetLocation(String cellName) {
      this.cellName = cellName;
   }
   
   //finds the specified row by converting the letter into an int
   public int getRow() {
      int row = 0;
      String r = cellName.substring(1);
      row = Integer.parseInt(r);
      return row - 1;
         }

   //finds the specified column by turning the String number into an int
   public int getCol() {
      int col = 0;
      char c = Character.toUpperCase(cellName.charAt(0));
      col = ((int)c) - 65;
      return col;
   
   }
   
}
