package it.unibo.generics.graph.impl;

import java.util.ArrayDeque;
import java.util.Deque;

import it.unibo.generics.graph.api.GraphExplorationStrategy;

public abstract class AbstractGraphExplorationStrategy<N> implements GraphExplorationStrategy<N> {
    private final Deque<N> nodes = new ArrayDeque<>();

    @Override 
    public void reset() {
        nodes.clear();
    }

    protected Deque<N> getNodes() {
        return this.nodes;
    }
}
