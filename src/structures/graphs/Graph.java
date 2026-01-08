package structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nodes.Node;

public class Graph<T> {

    //Primera forma
    List<Node<T>>nodes;

    //2da forma
    private Map<Node<T>, List<Node<T>>> mapa;

    public Graph() {
        this.nodes = new ArrayList<Node<T>>();
        this.mapa = new HashMap<Node<T>,List<Node<T>>>();
    }


    //inserta nodo o vertice
    public void insertNode(T value){
        Node<T> newNode = new Node<T>(value);
        this.nodes.add(newNode);
    }

    public void addNode(Node<T> node){
        mapa.putIfAbsent(node, new ArrayList<Node<T>>());
    }

    //Grafo no dirgido
    public void addEdge(Node<T> n1, Node<T> n2){
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
        mapa.get(n2).add(n1);
    }

    public void printGraph(){
        for(Map.Entry<Node<T>, List<Node<T>>> entry: mapa.entrySet()){
            System.out.print(entry.getKey() + " ->");
            for(Node<T> neigbor: entry.getValue()){
                System.out.print(neigbor + " ");
            }
            System.out.println("");
        }

        
    }


    public Node<String>[] getNeighbors(Node<T> nA) {
        return mapa.get(nA).toArray(new Node[0]);
    }


    
    
}
