package com.fyp1617;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaders {
    //This function reads the  full graph from excel file given its path
    public static Diagnostic_Algorithm ReadFullGraph(String file) throws IOException{
        //Algorithm that will be returned
        Diagnostic_Algorithm DA = new Diagnostic_Algorithm();
        
        //Initialize Excel workbook,sheet,and row
        FileInputStream fs = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fs);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        
        //id of the node and id1, id2 of the terminals of the edge
        int id,id1,id2;
        //label,type,color,available of node and label_e of edge
        String label,type,color,available,label_e;
        
        //n and e will contain node and edge information read from each row
        Node n;
        Edge e;
        
        //a list of edges will be used to save all edges before adding 
        //theme to the algorithm because an edge needs the two nodes
        //to be present in order to be added to the algorithm
        LinkedList<Edge> edges = new LinkedList<Edge>();
    
        //check the number of rows in the sheet and go over them
        int rows = sheet.getPhysicalNumberOfRows();
        
        //we start from row 2 because 0 and 1 contain non-relevant information
        for(int r=2;r<rows;r++){
            row=sheet.getRow(r);
            //make sure the row isn't null
            if(row!=null){
                //check if the node part isn't null and if the node contains
                //information (not empty node)
                if(row.getCell(0)!=null){
                    row.getCell(0).setCellType(Cell.CELL_TYPE_NUMERIC);
                    id = (int) row.getCell(0).getNumericCellValue();
                    if(id!=0){
                        //Get attributes of the node
                        //and assign them to n
                        //then add n to the diagnostic algorithm graph
                        label = row.getCell(1).getStringCellValue();
                        type = row.getCell(2).getStringCellValue();
                        color = row.getCell(3).getStringCellValue();
                        available = row.getCell(4).getStringCellValue();
                
                        n=new Node();
                        n.setID(id);
                        n.setLabel(label);
                        n.setType(type);
                        n.setAvailable(available);
                        n.setColor(color);
                
                        DA.addNode(n);
                    }
                }
                //check if the edge part of the row isn't null
                if(row.getCell(6)!=null){
                    //Get attributes of the edge
                    //and assign them to e
                    //then add e to the list
                    row.getCell(6).setCellType(Cell.CELL_TYPE_NUMERIC);
                    row.getCell(7).setCellType(Cell.CELL_TYPE_NUMERIC);
                    id1 = (int) row.getCell(6).getNumericCellValue();
                    id2 = (int) row.getCell(7).getNumericCellValue();
                    label_e = row.getCell(8).getStringCellValue();
                
                    e = new Edge(id1,id2);
                    e.setLabel(label_e);
                    edges.add(e);
                }
            }
        }
        //finally add the edges to the algorithm
        for(int i=0;i<edges.size();i++)
            DA.addEdge(edges.get(i));
        
        return DA;
    }
    
    //A function that passes over all graphs in the project directory
    //and stores them in a list of DAs
    public static Algorithms_Graph ReadAllGraphs() throws IOException{
        Algorithms_Graph DAs = new Algorithms_Graph();
        //Path to the folder containing excel files
        String Path = "src\\DA_Excel\\";
        String fullPath;
        //go over all excel files from 1 to 59
        for(int i=1;i<=59;i++){
            //Complete the full path of the file
            fullPath = Path + i + ".xlsx";
            //Read each file alone and store them in the list
            Diagnostic_Algorithm DA = ReadFullGraph(fullPath);
            //Set the ID of the DA equal to the name of the excel file
            DA.setID(i);
            DAs.addDA(DA);
        }
        return DAs;
    }
}
