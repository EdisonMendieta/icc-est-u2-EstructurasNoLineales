package trees;

import models.Persona;
import nodes.Node;

public class Tree<T extends Comparable<T>> {

    private Node<T> root;
    private int size;

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            size++;
            return new Node<>(value);
        }

        int cmp = value.compareTo(current.getValue());

        if (cmp < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (cmp > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    public void inOrder(){
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node<T> node){
        if (node == null) {
            return;
        }
        inOrderRecursive(node.getLeft());
        System.out.println(node.getValue() + " ");
        inOrderRecursive(node.getRight());
    }

    public int size(){
        return this.size;
    }

    public T searchByAge(int edad){
        return searchByAge(root, edad);
    }

    public T searchByAge(Node<T> current, int i) {
        if (current == null) {
            return null;
        }

        Persona persona =(Persona) current.getValue();

        if (persona.getEdad() == i) {
            return current.getValue();
        }

        if (persona.getEdad() > i ) {
            return searchByAge(current.getLeft(), i);
        }else{
            return searchByAge(current.getRight(), i);
        }
               
    }

     public T search(T value){
        return search(root, value);
    }

    public T search(Node<T> current, T i) {
        if (current == null) {
            return null;
        }

        int comparation = i.compareTo(current.getValue());

        if (comparation == 0) {
            return current.getValue();
        }

        if (comparation < 0 ) {
            return search(current.getLeft(), i);
        }else{
            return search(current.getRight(), i);
        }
               
    }
}


