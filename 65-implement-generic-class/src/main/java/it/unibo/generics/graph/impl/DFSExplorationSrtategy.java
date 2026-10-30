package it.unibo.generics.graph.impl;

public class DFSExplorationSrtategy<N> extends AbstractGraphExplorationStrategy<N> {
    @Override
    public void add(N node) {
        this.getNodes().addFirst(node);
    }

    @Override
    public N remove() {
        return this.getNodes().removeLast();
    }

    @Override
    public boolean isEmpty() {
        return this.getNodes().isEmpty();
    }

}
