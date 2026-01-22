
import trees.Tree;
import trees.intTree;

import java.nio.file.Path;

import models.Persona;
import nodes.Node;
import structures.graphs.Graph;
import structures.graphs.PathFinder;
import structures.graphs.PathResul;
import structures.graphs.implementations.BFSPathFinder;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Estudiante: Edison Mendieta");
        //runIntTree();
        //runTree();
        //runGraph();
        runGraphRecoorido();
        

    }

    private static void runGraphRecoorido(){

        Graph<Persona> grafo = new Graph<>();

        Persona pC23 = new Persona("Carlos", 23);
        Persona pL18 = new Persona("Luis", 18);
        Persona pA23 = new Persona("Andres", 23);
        Persona pA30 = new Persona("Ana", 30);
        Persona pJ25 = new Persona("Juan", 25);
        Persona pAn20 = new Persona("Ana", 20);
        Persona pM10 = new Persona("Mateo", 10);
        Persona pJ10 = new Persona("Julio", 10);

        grafo.addEdge(new Node<>(pC23), new Node<>(pA30));
        grafo.addConocido(new Node<>(pC23), new Node<>(pL18));
        grafo.addConocido(new Node<>(pC23), new Node<>(pA23));
        grafo.addConocido(new Node<>(pL18), new Node<>(pJ25));
        grafo.addEdge(new Node<>(pL18), new Node<>(pA23));
        grafo.addConocido(new Node<>(pAn20), new Node<>(pA30));
        grafo.addEdge(new Node<>(pA30), new Node<>(pM10));
        grafo.addEdge(new Node<>(pM10), new Node<>(pJ10));


        System.out.println("BFS");

        PathFinder<Persona> finder = new BFSPathFinder<>();
        PathResul<Persona> resultado = finder.find(grafo, new Node<>(pC23),new Node<>(pJ10) );

        System.err.println("Orden BFs");
        resultado.getVisitados().forEach(node -> System.err.println(node.getValue() + ""));

        System.err.println("Ruta encontrada ");
        resultado.getPath().forEach(node -> System.err.println(node.getValue()));
    }

    private static void runGrapshRecorridos() {
        Graph<Persona> grafo = new Graph<>();
        Node<Persona> pC23 = new Node<Persona>(new Persona("Carlos", 23));
        Node<Persona> pL18 = new Node<Persona>(new Persona("Luis", 18));
        Node<Persona> pA23 = new Node<Persona>(new Persona("Andres", 23));
        Node<Persona> pA30 = new Node<Persona>(new Persona("Ana", 30));
        Node<Persona> pJ25 = new Node<Persona>(new Persona("Juan", 25));
        Node<Persona> pAn20 = new Node<Persona>(new Persona("Andre", 20));
        
        grafo.addConocido(pC23,pL18);
        grafo.addEdge(pC23,pA30 );
        grafo.addConocido(pC23,pA23);

        grafo.addConocido(pL18,pJ25);
        grafo.addEdge(pL18,pA23);


        grafo.addConocido(pA30,pAn20);
        System.out.println("====recorrido bfs====");
        grafo.bfs(pC23);
        System.out.println("====recorrido bfs====");
        grafo.dfs(pC23);
    }

    private static void runTree() {
        Tree<Persona> tree = new Tree<>();
        tree.insert(new Persona("Pablo", 21));
        tree.insert(new Persona("Maria", 23));
        tree.insert(new Persona("Ana", 25));
        tree.insert(new Persona("Pedro", 23));
        tree.insert(new Persona("Luis", 19));

        System.out.println(" InOrder ");
        tree.inOrder();

        System.out.println("\nBusqueda de persona de 23 años ");
        Persona finPerson = tree.searchByAge( 23);

        if (finPerson == null) {
            System.out.println("No se encontro");    
        }else{
            System.out.println(finPerson);
        }
    }
    
    private static void runIntTree(){
        intTree tree = new intTree();

        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(15);
        System.out.println("PreOrder");
        tree.preOrder();
        System.out.println("\nPosOrder");
        tree.posOrder();
        System.out.println("\nInOrder");
        tree.inOrder();
        System.out.println("\nSize: " + tree.size());
        
    }

    private static void runGraph(){
        Graph<String> graph = new Graph<>(); 
        Node<String> nA = new Node<String>("A");
        Node<String> nB = new Node<String>("B");
        Node<String> nC = new Node<String>("C");
        Node<String> nD = new Node<String>("D");

        graph.addEdge(nA, nB);
        graph.addEdge(nB, nD);
        graph.addEdge(nC, nD);

        graph.printGraph();

        Node<String>[] neighbors = graph.getNeighbors(nA);

        System.out.print("Neighbors de A: ");
        for(Node<String> neigtbor : neighbors){
            System.out.println(neigtbor + "");
        }

        

    }
}
