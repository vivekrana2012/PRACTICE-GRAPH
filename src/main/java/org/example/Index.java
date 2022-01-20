package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Index {

    public static void main(String[] args) {

        Map<String, List<String>> adjacency = new HashMap<>();

        adjacency.put("a", List.of("b", "c"));
        adjacency.put("b", List.of("d"));
        adjacency.put("c", List.of("e"));
        adjacency.put("d", List.of("f"));
        adjacency.put("e", List.of());
        adjacency.put("f", List.of());

        Graph<String> graph = new Graph<>(adjacency);

        System.out.println("DF");
        graph.printDF();
        System.out.println("BF");
        graph.printBF();
    }
}
