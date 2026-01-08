
import trees.Tree;
import trees.intTree;
import models.Persona;
import nodes.Node;
import structures.graphs.Graph;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Estudiante: Edison Mendieta");
        //runIntTree();
        //runTree();
        runGraph();

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
