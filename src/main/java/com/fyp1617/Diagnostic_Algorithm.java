package com.fyp1617;


import java.util.LinkedList;

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

public class Diagnostic_Algorithm {
    private LinkedList<Node> nodes;
    private LinkedList<Edge> edges;
    private String name;
    
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
    
    public boolean addNode(Node n){
        for(int i=0;i<nodes.size();i++){
            if(nodes.get(i).getID()==n.getID())
                return false;
        }
        nodes.add(n);
        return true;
    }
    public boolean deleteNode(int i){
        if(nodes.get(i)==null){
            return false;
        }
        else {
            nodes.set(i,null);
            return true;
        }
    }
    public boolean deleteNodeEdges(int i){
        if(nodes.get(i)==null){
            return false;
        }
        else {
            for(int j=0;j<edges.size();j++){
                if(edges.get(j).getSource()==i || edges.get(j).getTarget()==i)
                    edges.remove(j);
            }
            nodes.set(i,null);
            return true;
        }
    }
    public Node getNode(int id){
        for(int i=0;i<nodes.size();i++){
            if(nodes.get(i).getID()==id)
                return nodes.get(i);
        }
        Node n = new Node();
        n.setID(0);
        return n;
    }
    
    public boolean addEdge(Edge e){
        if(getNode(e.getSource()).getID()!=0 && getNode(e.getTarget()).getID()!=0){
            edges.add(e);
            return true;
        }
        else
            return false;
    }
    public boolean deleteEdge(Edge e){
        for(int i=0;i<edges.size();i++){
            if(edges.get(i)==e){
                edges.remove(i);
                return true;
            }
        }
        return false;
    }
    public String getEdge(Edge e){
        for(int i=0;i<edges.size();i++){
            if(edges.get(i).getSource()==e.getSource() && edges.get(i).getTarget()==e.getTarget()){
               return edges.get(i).getLabel();
            }
        }
        return null;
    }
    
    public LinkedList containsTerm(String term){
        LinkedList result = new LinkedList();
        for(int i=0;i<nodes.size();i++){
            
        }
        return result;
    }
}
