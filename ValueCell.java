/*
Sydney Wan
AP CS A
Text Excel Lab

Value Cell Class
*/

public class ValueCell extends RealCell {
   
   //constructor
   public ValueCell(String value) {
      super("" + Double.parseDouble(value));
   }
   
   public String fullCellText() {
      return "" + Double.parseDouble(super.fullCellText());
   }
}