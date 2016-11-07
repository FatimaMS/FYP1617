package com.fyp1617;

import static com.fyp1617.ExcelReaders.ReadAllGraphs;
import java.io.IOException;
import java.util.LinkedList;

public class FYP1617 {
    public static void main(String args[]) throws IOException{
        LinkedList<Diagnostic_Algorithm> A1;
        //A1 = ReadFullGraph("C:\\Users\\Acer\\Desktop\\Symptoms to Diagnosis\\ch 5\\ch 5-1 headache in hiv positive patients\\ch 5-1 headache with hiv postive patients.xlsx");
        A1 = ReadAllGraphs();
        System.out.println();
    }
}