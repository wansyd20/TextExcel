/*
Sydney Wan
AP CS A
Text Excel Lab

Formula Cell Class
*/

import java.util.ArrayList;

public class FormulaCell extends RealCell {
   
   //constructor
   public FormulaCell(String input) {
      super(input);
   }
   
   //placeholder method for later implementation of the getDoubleValue() method
   public double getDoubleValue() {
      //removes the outer parentheses and spaces
      String formula = getValueString().substring(2, getValueString().indexOf(")") - 1);
      
      //splits the values in the formula where spaces occur and puts them into an ArrayList
      String[] values = formula.split(" ");
      ArrayList<String> partsList = new ArrayList<String>();
      for (int i = 0; i < values.length; i++) {
         partsList.add(values[i]);
      }
      
      //if the formula entered is just a constant
      if (partsList.size() == 1) {
         return Double.parseDouble(partsList.get(0));
      }

      //perform basic expressions
      double value = 0;
      while (partsList.size() > 2) {
         String operator = partsList.get(1);
         double operand1 = Double.parseDouble(partsList.get(0));
         double operand2 = Double.parseDouble(partsList.get(2));
         //performs the operation based on the operator symbol
         if (operator.equals("+")) {
            value = operand1 + operand2;
         }
         else if (operator.equals("-")) {
            value = operand1 - operand2;
         }
         else if (operator.equals("/")) {
            value = operand1 / operand2;
         }
         else if (operator.equals("*")) {
            value = operand1 * operand2;
         }
         partsList.remove(0);
         partsList.remove(0);
         partsList.set(0, value + "");     
         
     }   
      
      return value;
   }
   
    public String abbreviatedCellText() {
      String value = getDoubleValue() + "";
      //if the value has an index greater than 10
      if (value.length() > 10) {
         return value.substring(0, 10);
      }
      //if the value has an index less than 10 and needs padding
      else if (value.length() < 10) {
         String input = value;
         int spaces = 10 - value.length();
         for (int k = 1; k <= spaces; k++) {
            input += " ";
         }
         return input;
      }
      //if the value is exactly 10 digits
      else {
         return value;
      }
  
    }
   
   // public String fullCellText() {
//    
//    }

}