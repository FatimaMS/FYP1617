package com.fyp1617;
import java.util.Scanner;
import static com.fyp1617.ExcelReaders.ReadAllGraphs;
import java.io.IOException;
import java.util.LinkedList;

public class FYP1617 {
    public static void main(String args[]) throws IOException{
        Algorithms_Graph AG;
        //A1 = ReadFullGraph("C:\\Users\\Acer\\Desktop\\Symptoms to Diagnosis\\ch 5\\ch 5-1 headache in hiv positive patients\\ch 5-1 headache with hiv postive patients.xlsx");
        AG = ReadAllGraphs();
        System.out.println();
        
 
        Scanner user_input = new Scanner( System.in );
        String entered_string;
        System.out.print("Enter your search term: ");
        entered_string = user_input.nextLine();
        String terms[] = entered_string.split(" ");
        LinkedList ll = AG.FindTerms(terms);
      
   }
    
    
}