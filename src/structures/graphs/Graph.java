package structures.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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


    public void addConocido(Node<T> n1, Node<T> n2){
        addNode(n1);
        addNode(n2);
        mapa.get(n1).add(n2);
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

    public Node<T>[] getNeighbors(Node<T> nA) {
        return mapa.getOrDefault(nA, List.of()).toArray(new Node[0]);
    }

    public void bfs(Node<T> start){

        //Para no revisar dos veces los nodos revisados
        Set<Node<T>> visitados = new LinkedHashSet<>();
        Queue<Node<T>> queue = new LinkedList<>();
        visitados.add(start);
        queue.add(start);

        //mientras la cola no este vacia.
        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            System.out.println(current.getValue() + " ");

            for (Node<T> conocido : getNeighbors(current)) {

                //visitado contiene conocido
                if (!visitados.contains(conocido)) {
                    visitados.add(conocido);
                    queue.add(conocido);
                }
            }
        }
    }

    public void dfs(Node<T> start){
        Set<Node<T>> visitados = new LinkedHashSet<>();
        dfsRecursive(start, visitados);
    }

    private void dfsRecursive(Node<T> start, Set<Node<T>> visitados) {
        
        visitados.add(start);
        System.out.println(start.getValue() + " ");

        for (Node<T> conocido : getNeighbors(start)) {
            if (!visitados.contains(conocido)) {
                dfsRecursive(conocido,visitados);
            }
            
        }
    }


    
}
