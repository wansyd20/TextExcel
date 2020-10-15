/*
Sydney Wan
AP CS A
Text Excel Lab
Checkpoint B1

TextExcel Client Code
*/

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextExcel {

   public static void main(String[] args) {
       Spreadsheet spreadsheet = new Spreadsheet();
       Scanner scan = new Scanner(System.in);
     
       
       System.out.print(spreadsheet.getGridText());
       
       //checks for input and runs until the user inputs "quit"
       String input = scan.nextLine();
       while (!input.equalsIgnoreCase("quit")) {
         System.out.println(spreadsheet.processCommand(input));
         input = scan.nextLine();
       }
       
       
   }
}
