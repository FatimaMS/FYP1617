package com.fyp1617;

import java.util.LinkedList;

public class Algorithms_Graph {
    private LinkedList<Diagnostic_Algorithm> Algorithms_List;
    
    public Algorithms_Graph(){
        Algorithms_List = new LinkedList<Diagnostic_Algorithm>();
    }
    
    public void setList(LinkedList<Diagnostic_Algorithm> list){
        Algorithms_List = list;
    }
    public boolean addDA(Diagnostic_Algorithm da){
        for(int i=0;i<Algorithms_List.size();i++){
            if(Algorithms_List.get(i).getID() == da.getID())
                return false;
        }
        Algorithms_List.add(da);
        return true;
    }
    
    public LinkedList FindTerms(LinkedList<String> term_list){
        LinkedList DA_index = new LinkedList();
        for(int i=0;i<Algorithms_List.size();i++){
            
        }
        return DA_index;
    }
}
