/*
Sydney Wan
AP CS A
Text Excel Lab

Spreadsheet Class
*/

import java.util.Arrays;

public class Spreadsheet implements Grid {

   Cell[][] allCells;
   private static final int ROWS = 20;
   private static final int COLS = 12;
   
   //creates a new spreadsheet full of empty cells
   public Spreadsheet() {
      allCells = new Cell[20][12];
      clear();
     
   }
   
   //clears the whole sheet
   public void clear() {
      for (int cols = 0; cols < COLS; cols++) {
         for (int rows = 0; rows < ROWS; rows++) {
            allCells[rows][cols] = new EmptyCell();
         }
      }
   }
   
   //adjusts the cell call to make sure the letter column is capitalized
   public String uniformCommand(String com) {
      return com.substring(0, 1).toUpperCase() + com.substring(1);
   }
   
   //processes the command of the user and takes an action based on that command
   public String processCommand(String command) {
      
      if(command.equals("")) {
         return "";
      }
      
      //to inspect a cell 
      if (command.length() == 2 || command.length() == 3) {
         SpreadsheetLocation cell = new SpreadsheetLocation(uniformCommand(command));
         return allCells[cell.getRow()][cell.getCol()].fullCellText();
            
      }
      
      //to clear the whole sheet
      else if (command.equalsIgnoreCase("clear")) {
         clear();
         return getGridText();
      }
      
      
      //to clear a specific cell
      else if ((command.substring(0, 5).equalsIgnoreCase("clear")) && (command.length() > 5)) {
         String cellLoc = uniformCommand(command.substring(6));
         SpreadsheetLocation cell = new SpreadsheetLocation(cellLoc);
         allCells[cell.getRow()][cell.getCol()] = new EmptyCell();
         return getGridText();
      }
            
      
      //cell assignment
      else if (command.indexOf("=") > 0 && command.length() > 4) {
         SpreadsheetLocation cell = new SpreadsheetLocation(uniformCommand(command.substring(0, command.indexOf(" "))));
         String input = command.substring(command.indexOf("=") +2);
         
         //if it is assigning text to the cell, determined by if there are quotation marks
         if (command.indexOf("\"") >= 0) {
            input = input.substring(1, input.length() - 1);
            allCells[cell.getRow()][cell.getCol()] = new TextCell(input);
         }
         
         //creates a formula cell, if there are parentheses
         else if (command.indexOf("(") >= 0) {
            allCells[cell.getRow()][cell.getCol()] = new FormulaCell(input);
         }
         
         //creates a percent cell, if there is the percent symbol
         else if (command.indexOf("%") >= 0) {
            allCells[cell.getRow()][cell.getCol()] = new PercentCell(input);
         }
         
         //creates a value cell
         else {
            allCells[cell.getRow()][cell.getCol()] = new ValueCell(input);
         }
         
         //prints the entire spreadsheet with the new modifications            
         return getGridText();
      }
          
      else {
         return "";  
      }        
   }

   //finds the number of rows total in the spreadsheet
   public int getRows() {
      return allCells.length;
   }

   //finds the number of columns total in the spreadsheet
   public int getCols() {
      return allCells[0].length;
   }

   //gets the location of a specific cell being called
   public Cell getCell(Location loc) {
      return allCells[loc.getRow()][loc.getCol()];

   }

   //prints the entire spreadsheet
   public String getGridText() {
      String header = "   |";
      String body = "";
      
      
      //prints the column headers with corresponding letters
      for (int cols = 0; cols < COLS; cols++) {
         header += (Character.toUpperCase((char)(cols + 'A')) + ("         |"));
      }
     //prints the row labels on the left side 
     for (int row = 0; row < ROWS; row++) {
         if (row < 9) {
            body += ("\n" + (row + 1) + "  |");
         }
         else {
            body += ("\n" + (row + 1) + " |");
         }
         //adds the body of each cell into the spreadsheet
         for (int col = 0; col < COLS; col++) {
            body += allCells[row][col].abbreviatedCellText() + "|";
         }
     }       
            
     return (header + body + "\n"); 
   }
}