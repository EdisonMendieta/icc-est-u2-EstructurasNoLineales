package structures.graphs.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import nodes.Node;
import structures.graphs.Graph;
import structures.graphs.PathFinder;
import structures.graphs.PathResul;

public class DFSPathFinder<T> implements PathFinder {

    @Override
    public PathResul find(Graph graph, Node start, Node end) {

        Map<Node<T>,Node<T>> parente = new HashMap<>();
        List<Node<T>> visitados = new ArrayList<>();
        findRecursive(graph,start,end);
        return new PathResul<>(new ArrayList<>(visitados), buildPath(parente, end));
    }


    private List<Node<T>> buildPath(Map<Node<T>,Node<T>> parente, Node<T> end) {
        List<Node<T>> path = new ArrayList<>();

        for (Node<T> at = end; at != null; at = parente.get(at)){

            path.add(at);
        }

        Collections.reverse(path);
        return path;
        
    }


    private PathResul findRecursive(Graph<T> graph,Node<T> start, Node<T> end) {
        start.add(current);
        System.out.println(current.getValue());

        if (current.equals(end)) {
            return true; 
        }

        for (Node<T> vecino : graph.getNeighbors(current)) {
            if (!visited.contains(vecino)) {
                parent.put(vecino, current);

                if (dfs(graph, vecino, end)) {
                    return true; 
                }
            }
        }
        return false;
    }          
    
}
    

