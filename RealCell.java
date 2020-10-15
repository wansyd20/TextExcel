/*
Sydney Wan
AP CS A
Text Excel Lab

Real Cell Super Class
*/

public class RealCell implements Cell {
   
   private String valueString;
   
   //constructor
   public RealCell(String input) {
      this.valueString = input;
   }
   
   //converts user's entered String to a double
   public double getDoubleValue() {
      return Double.parseDouble(valueString);
   }
   
   //accessor
   public String getValueString() {
      return this.valueString;
   }
   
   //mutator
   public void setValueString(String s) {
      this.valueString = s;
   }
   
   //truncates input if needed to fit into spreadsheet
   public String abbreviatedCellText() {
      //if the value has an index greater than 10
      if (valueString.length() > 10) {
         return valueString.substring(0, 10);
      }
      //if the value has an index less than 10 and needs padding
      else if (valueString.length() < 10) {
         String input = valueString;
         int spaces = 10 - this.valueString.length();
         for (int k = 1; k <= spaces; k++) {
            input += " ";
         }
         return input;
      }
      //if the value is exactly 10 digits
      else {
         return valueString;
      }
   }
   
   //returns the full value
   public String fullCellText() {
      return valueString;
   }

}