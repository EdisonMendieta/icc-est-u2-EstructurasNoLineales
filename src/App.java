
import trees.Tree;
import trees.intTree;
import models.Persona;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Estudiante: Edison Mendieta");
        //runIntTree();
        runTree();

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
}
