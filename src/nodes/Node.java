package nodes;

import java.util.List;

public class Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    //listado de nodos conocidos
    private List<Node<T>> conocidos;

    public Node(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue(){
        return value;
    }

    public Node<T> getLeft(){
        return left;
    }

    public Node<T> getRight(){
        return right;
    }

    public void setLeft(Node<T> left){
        this.left = left;
    }

    public void setRight(Node<T> right){
        this.right = right;
    }

    @Override
    public String toString() {
        return "N [" + getValue() + "]";
    }

    
}
