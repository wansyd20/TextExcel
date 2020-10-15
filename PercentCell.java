/*
Sydney Wan
AP CS A
Text Excel Lab

Percent Cell Class
*/

public class PercentCell extends RealCell {
   
   //constructor
   public PercentCell(String percent) {
      super(percent.substring(0, percent.indexOf("%")));
   }
   
   //gets double value by multipling percent by .01
   public double getDoubleValue() {
      return super.getDoubleValue() * .01;  
   }
   
   public String abbreviatedCellText() {
      String text = super.getValueString();
      
      //removes any decimals if they exist
      if (text.indexOf(".") >= 0) {
         text = text.substring(0, text.indexOf("."));
      }
      
      //pads cell with spaces if the percent is too short
      if (text.length() < 10) {
         text += "%";
         while (text.length() < CELLWIDTH) {
            text += " ";
         }
         return text;
      }
      //truncates the percent to fit in the cell
      else if (text.length() > 9) {
         text = text.substring(0, 10);          
      }
      return text + "%";
   }
   
   //returns the full percent including the percent symbol
   public String fullCellText() {
      return super.fullCellText() + "%";
   }

}