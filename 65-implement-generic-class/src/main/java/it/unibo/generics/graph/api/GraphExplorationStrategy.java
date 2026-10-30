package it.unibo.generics.graph.api;

public interface GraphExplorationStrategy<N> {
    void add(N node);

    N remove();

    boolean isEmpty();

    void reset();
}
