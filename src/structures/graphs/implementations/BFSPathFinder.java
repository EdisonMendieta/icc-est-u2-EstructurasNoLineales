package structures.graphs.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import nodes.Node;
import structures.graphs.Graph;
import structures.graphs.PathFinder;
import structures.graphs.PathResul;

public class BFSPathFinder<T> implements PathFinder{

    @Override
    public PathResul find(Graph graph, Node start, Node end) {


        //Para no revisar dos veces los nodos revisados
        Set<Node<T>> visited = new HashSet<>();
        Queue<Node<T>> queue = new LinkedList<>();

        Map<Node<T>,Node<T>> parente = new HashMap<>();
        List<Node<T>> visitados = new ArrayList<>();
         
        queue.add(start);
        visited.add(start);
        parente.put(start, null);

        //mientras la cola no este vacia.
        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();

            //imprimir
            System.out.println(current.getValue() + " ");

            if (current.equals(end)) {
                return new PathResul<>(visitados, builPath(parente,end));
            }

            for (Node<T> conocido : graph.getNeighbors(current)) {

                //visitado contiene conocido
                if (!visited.contains(conocido)) {
                    visited.add(conocido);
                    parente.put(conocido, current);
                    queue.add(conocido);
                }
            }
        }
        return new PathResul<>(visitados, List.of());
    }

    //este metodo nos va aconstruir la ruta 
    private List<Node<T>> builPath(Map<Node<T>,Node<T>> parente, Node end) {
        List<Node<T>> path = new ArrayList<>();

        for (Node<T> at = end; at != null; at = parente.get(at)){

            path.add(at);
        }

        Collections.reverse(path);
        return path;
        
    }
  
}
