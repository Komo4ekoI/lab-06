package it.unibo.generics.graph.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.GraphExplorationStrategy;

public class GraphImpl<N> implements Graph<N> {
    private final Map<N, Set<N>> edges;
    private final GraphExplorationStrategy<N> explorationStrategy;

    public GraphImpl(GraphExplorationStrategy<N> explorationStrategy) {
        edges = new HashMap<>();

        this.explorationStrategy = explorationStrategy;
    }

    @Override
    public void addNode(N node) {
        this.edges.putIfAbsent(node, new HashSet<>());
    }

    @Override
    public void addEdge(N source, N target) {
        this.nodeExists(source);
        this.nodeExists(target);
        this.edges.get(source).add(target);
    }

    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(this.edges.keySet());
    }

    @Override
    public Set<N> linkedNodes(N node) {
        this.nodeExists(node);
        return new HashSet<>(this.edges.get(node));
    }

    @Override
    public List<N> getPath(N source, N target) {
        this.nodeExists(source);
        this.nodeExists(target);

        this.explorationStrategy.reset();

        Set<N> visited = new HashSet<>();
        Map<N, N> previous = new HashMap<>();

        this.explorationStrategy.add(source);
        visited.add(source);

        while (!this.explorationStrategy.isEmpty()) {
            N currentNode = this.explorationStrategy.remove();

            if (currentNode.equals(target)) {
                List<N> path = new LinkedList<>();

                for (N node = target; node != null; node = previous.get(node)) {
                    path.add(node);
                }

                Collections.reverse(path);

                return path;
            }

            for (N connectedNode : this.edges.get(currentNode)) {
                if (visited.add(connectedNode)) {
                    previous.put(connectedNode, currentNode);
                    this.explorationStrategy.add(connectedNode);
                }
            }
        }

        return List.of();
    }

    private boolean nodeExists(N node) {
        if (!this.edges.containsKey(node)) {
            throw new IllegalArgumentException("Node does not exists: " + node);
        }
        return true;
    }
    
}
