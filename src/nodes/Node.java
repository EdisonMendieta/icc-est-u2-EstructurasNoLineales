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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result + ((right == null) ? 0 : right.hashCode());
        result = prime * result + ((conocidos == null) ? 0 : conocidos.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        if (left == null) {
            if (other.left != null)
                return false;
        } else if (!left.equals(other.left))
            return false;
        if (right == null) {
            if (other.right != null)
                return false;
        } else if (!right.equals(other.right))
            return false;
        if (conocidos == null) {
            if (other.conocidos != null)
                return false;
        } else if (!conocidos.equals(other.conocidos))
            return false;
        return true;
    }

    

    
}
