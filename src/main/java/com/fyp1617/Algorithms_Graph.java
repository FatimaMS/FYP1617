package com.fyp1617;

import java.util.LinkedList;

//This class contains a list of DAs
//This list can be used later in the project
public class Algorithms_Graph {
    private LinkedList<Diagnostic_Algorithm> Algorithms_List;
    
    public Algorithms_Graph(){
        Algorithms_List = new LinkedList<Diagnostic_Algorithm>();
    }
    
    //To initialize the list from another list
    public void setList(LinkedList<Diagnostic_Algorithm> list){
        Algorithms_List = list;
    }
    
    //To add an algorithm
    //It first checks that the algorithm is not in the list
    public boolean addDA(Diagnostic_Algorithm da){
        for(int i=0;i<Algorithms_List.size();i++){
            if(Algorithms_List.get(i).getID() == da.getID())
                return false;
        }
        Algorithms_List.add(da);
        return true;
    }
    
    //This function checks the occurence of a list of terms in all algorithms
    //and returns a list of indexes of all DAs that contain these terms
    //This function is still not implemented at this point
    public LinkedList FindTerms(LinkedList<String> term_list){
        LinkedList DA_index = new LinkedList();
        for(int i=0;i<Algorithms_List.size();i++){
            
        }
        return DA_index;
    }
}
