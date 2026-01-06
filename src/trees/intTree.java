package trees;
import nodes.Node;

public class intTree {
    private Node<Integer> root;
    private int size;

    public intTree() {
        this.root = null;
        this.size = 0;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node<Integer> insertRecursive(Node<Integer> current, int value) {
        if (current == null) {
            size++; //Contador ya que aqui es donde en verdad se inserta el nodo
            return new Node<>(value);
        }

        //Insertar Nodos a la izquierda y a la derecha
        if (value < current.getValue()) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        //mandar else if porque no se puede insertar nodos duplicados
        } else if(value > current.getValue()){
            current.setRight(insertRecursive(current.getRight(), value));
        }
        return current;
    }

    public void preOrder(){
        preOrderRecursive(root);
    }

    private void preOrderRecursive(Node<Integer> node){
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        preOrderRecursive(node.getLeft());
        preOrderRecursive(node.getRight());
    }

    public void posOrder(){
        posOrderRecursive(root);
    }

    private void posOrderRecursive(Node<Integer> node){
        if (node == null) {
            return;
        }
        posOrderRecursive(node.getLeft());
        posOrderRecursive(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    public void inOrder(){
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node<Integer> node){
        if (node == null) {
            return;
        }
        inOrderRecursive(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrderRecursive(node.getRight());
    }

    public int size(){
        return this.size;
    }
}
