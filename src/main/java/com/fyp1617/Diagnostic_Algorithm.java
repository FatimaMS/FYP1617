package com.fyp1617;


import java.util.LinkedList;

//Node class contains attributes aquired from the excel file
class Node{
    private int id;
    private String label;
    private String type;
    private String color;
    private String available;
    
    public Node(){}
    
    public void setID(int id){
        this.id=id;
    }
    public void setLabel(String label){
        this.label = label;
    }
    public void setType(String type){
        this.type=type;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void setAvailable(String available){
        this.available=available;
    }
    
    public int getID(){
        return id;
    }
    public String getLabel(){
        return label;
    }
    public String getType(){
        return type;
    }
    public String getColor(){
        return color;
    }
    public String getAvailable(){
        return available;
    }
}

//Edge class contains attributes aquiered from excel file
class Edge{
    private int sourceID;
    private int targetID;
    private String label;
    
    public Edge() {}
    public Edge(int source,int target){
        sourceID = source;
        targetID = target;
    }
    
    public void setLabel(String label){
        this.label = label;
    }
    
    public int getSource(){
        return sourceID;
    }
    public int getTarget(){
        return targetID;
    }
    public String getLabel(){
        return label;
    }
}

//A diagnostic algorithm contains list of nodes and list of edges
//It also contains functions that are used later in the project
//From this algorithm we can create a graph in any requiered format
//And pass it to graph analysis/processing algorithms or visualization tools
public class Diagnostic_Algorithm {
    private LinkedList<Node> nodes;
    private LinkedList<Edge> edges;
    private String name;
    
    //Each algorithm will be assigned an ID to compare with others
    private int ID;
    
    public Diagnostic_Algorithm() {
        nodes = new LinkedList<Node>();
        edges = new LinkedList<Edge>();
    };
    
    public void setID(int id){
        ID = id;
    }
    
    public int getID(){
        return ID;
    }
    
    public void setNodes(LinkedList<Node> nodes){
        this.nodes = nodes;
    }
    public void setEdges(LinkedList<Edge> edges){
        this.edges = edges;
    }
    public void setName(String name){
        this.name = name;
    }
         
    public LinkedList<Node> getNodes(){
        return nodes;
    }
    public LinkedList<Edge> getEdges(){
        return edges;
    }
    public String getImage(){
        return name;
    }
    
    //To add a node first check that no other nodes with same ID exist
    public boolean addNode(Node n){
        for(int i=0;i<nodes.size();i++){
            if(nodes.get(i).getID()==n.getID())
                return false;
        }
        nodes.add(n);
        return true;
    }
    //To delete a node 
    public boolean deleteNode(int id){
        for(int i=0;i<nodes.size();i++){
            if(nodes.get(i).getID()==id){
                nodes.remove(i);
                return true;
            }
        }
        return false;
    }
    //To delete a node and all edges having this node as an end
    public boolean deleteNodeEdges(int i){
        if(deleteNode(i)){
            for(int j=0;j<edges.size();j++){
                if(edges.get(j).getSource()==i || edges.get(j).getTarget()==i)
                    edges.remove(j);
            }
            return true;
        }
        else return false;
    }
    
    //Searchs for a node by ID
    public Node getNode(int id){
        for(int i=0;i<nodes.size();i++){
            if(nodes.get(i).getID()==id)
                return nodes.get(i);
        }
        Node n = new Node();
        n.setID(0);
        return n;
    }
    
    //To add an edge first check if both ends are in the graph
    public boolean addEdge(Edge e){
        if(getNode(e.getSource()).getID()!=0 && getNode(e.getTarget()).getID()!=0){
            edges.add(e);
            return true;
        }
        else
            return false;
    }
    
    //Delete an edge using ID
    public boolean deleteEdge(Edge e){
        for(int i=0;i<edges.size();i++){
            if(edges.get(i)==e){
                edges.remove(i);
                return true;
            }
        }
        return false;
    }
    
    //Return the label of the edge given its two ends
    public String getEdge(Edge e){
        for(int i=0;i<edges.size();i++){
            if(edges.get(i).getSource()==e.getSource() && edges.get(i).getTarget()==e.getTarget()){
               return edges.get(i).getLabel();
            }
        }
        return null;
    }
    
    //Check for the occurence of terms in the graph
    //The method returns IDs of the nodes containing matched terms
    //This function can be edited --or optimized-- based on further reqirements
    public LinkedList containsTerm(String[] terms){
        LinkedList result = new LinkedList();
        for(int i=0;i<nodes.size();i++){
            for(int j=0;j<terms.length;j++){
                if(nodes.get(i).getLabel().contains(terms[j])){
                    if (!result.contains(i))
                    
                    result.add(i);
                }
            }
        }
        return result;
    }
}
