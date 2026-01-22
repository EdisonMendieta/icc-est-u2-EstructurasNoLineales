package structures.graphs;

import java.util.List;

import nodes.Node;

public class PathResul<T>{

    private final List<Node<T>> visitados;
    private final List<Node<T>> path;

    public PathResul(List<Node<T>> visitados, List<Node<T>> path) {
        this.visitados = visitados;
        this.path = path;
    }
    public List<Node<T>> getVisitados() {
        return visitados;
    }
    public List<Node<T>> getPath() {
        return path;
    }
    
    
    

}

