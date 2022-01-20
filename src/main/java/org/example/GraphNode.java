package org.example;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {

    private final T data;
    private final List<GraphNode<T>> neighbors;

    public GraphNode(T data) {
        this.data = data;
        neighbors = new ArrayList<>();
    }

    public void addNeighbor(GraphNode<T> graphNode) {
        this.neighbors.add(graphNode);
    }

    public T getData() {
        return data;
    }

    public List<GraphNode<T>> getNeighbors() {
        return neighbors;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "data=" + data +
                '}';
    }
}
