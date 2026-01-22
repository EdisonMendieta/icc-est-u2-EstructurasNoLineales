package structures.graphs;

import nodes.Node;

public interface PathFinder<T> {

    PathResul<T> find(Graph<T> graph, Node<T> start, Node<T> end);
    
}
