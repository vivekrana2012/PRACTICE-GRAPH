package org.example;

import java.util.List;
import java.util.Map;

public class Graph<T> {

    private GraphNode<T> root;

    public Graph(Map<T, List<T>> adjacency) {
        create(adjacency);
    }

    private void create(Map<T, List<T>> adjacency) {

        Stack<GraphNode<T>> stack = new Stack<>();

        adjacency.entrySet().stream().findFirst().ifPresent(entry -> {
            this.root = new GraphNode<>(entry.getKey());
            this.root.getNeighbors().addAll(entry.getValue().stream().map(GraphNode::new).toList());

            this.root.getNeighbors().forEach(stack::push);
        });

        create(stack, adjacency);
    }

    private void create(Stack<GraphNode<T>> stack, Map<T, List<T>> adjacency) {

        GraphNode<T> node = stack.pop();

        if (node != null) {
            List<T> neighbors = adjacency.get(node.getData());

            neighbors.stream().map(GraphNode::new).forEach(node::addNeighbor);

            adjacency.remove(node.getData());
        }
    }

    public void printDF() {
        print(this.root, new Stack<>());
    }

    public void printBF() {
        print(this.root, new Queue<>());
    }

    private void print(GraphNode<T> graphNode, BasicStructure<GraphNode<T>> basicStructure) {

        System.out.println(graphNode);

        graphNode.getNeighbors().forEach(basicStructure::push);

        GraphNode<T> next = basicStructure.pop();

        if (next != null) {
            print(next, basicStructure);
        }
    }
}
