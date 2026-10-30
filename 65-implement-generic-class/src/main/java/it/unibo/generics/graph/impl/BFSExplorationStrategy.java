package it.unibo.generics.graph.impl;


public class BFSExplorationStrategy<N> extends AbstractGraphExplorationStrategy<N> {
    
    @Override
    public void add(N node) {
        this.getNodes().addLast(node);
    }

    @Override
    public N remove() {
        return this.getNodes().removeLast();
    }
}
