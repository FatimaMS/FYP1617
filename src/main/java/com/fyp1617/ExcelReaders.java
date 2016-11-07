package com.fyp1617;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaders {
    public static Diagnostic_Algorithm ReadFullGraph(String file) throws IOException{
        Diagnostic_Algorithm DA = new Diagnostic_Algorithm();
        
        FileInputStream fs = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fs);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        int id,id1,id2;
        String label,type,color,available,label_e;
        
        Node n;
        Edge e;
        LinkedList<Edge> edges = new LinkedList<Edge>();
    
        int rows = sheet.getPhysicalNumberOfRows();
        
        for(int r=2;r<rows;r++){
            row=sheet.getRow(r);
            if(row!=null){
                if(row.getCell(0)!=null){
                    row.getCell(0).setCellType(Cell.CELL_TYPE_NUMERIC);
                    id = (int) row.getCell(0).getNumericCellValue();
                    if(id!=0){
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
                if(row.getCell(6)!=null){
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
        for(int i=0;i<edges.size();i++)
            DA.addEdge(edges.get(i));
        
        return DA;
    }
    
    public static LinkedList<Diagnostic_Algorithm> ReadAllGraphs() throws IOException{
        LinkedList<Diagnostic_Algorithm> DAs = new LinkedList<Diagnostic_Algorithm>();
        String Path = "src\\DA_Excel\\";
        String fullPath;
        for(int i=1;i<=59;i++){
            fullPath = Path + i + ".xlsx";
            Diagnostic_Algorithm DA = ReadFullGraph(fullPath);
            DA.setID(i);
            DAs.add(DA);
        }
        return DAs;
    }
}
