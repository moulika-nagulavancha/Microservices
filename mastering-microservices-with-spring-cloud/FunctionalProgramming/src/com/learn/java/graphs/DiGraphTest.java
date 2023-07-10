package com.learn.java.graphs;

import java.util.ArrayList;
import java.util.List;

class DiGraph<T extends Comparable<T>> {
    public enum State { UNVISITED, VISITED, COMPLETE };
    private List<Vertex> vertices;
    private List<Edge> edges;

    public DiGraph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void add(T from, T to, int cost) {
        Edge edge = new Edge(from, to, cost);
        edges.add(edge);
    }

    private void clearStates() {
        for (Vertex vertex: vertices) {
            vertex.state = State.UNVISITED;
        }
    }

    public boolean isConnected() {
        for (Vertex vertex: vertices) {
            if (!vertex.state.equals(State.COMPLETE)) {
                return false;
            }
        }
        return true;
    }

    public List<String> getPath(T from, T to) {
        boolean test = dijkstra(from);
    }

    private boolean dijkstra(T vertex) {
        if (vertices.isEmpty()) {
            return false;
        }

    }

    class Vertex implements Comparable<Vertex> {
        T value;
        List<Vertex> incoming;
        List<Vertex> outgoing;
        State state;

        Vertex previous = null;
        int minDistance = Integer.MAX_VALUE;

        public Vertex(T value) {
            this.value = value;
            incoming = new ArrayList<>();
            outgoing = new ArrayList<>();
            state = State.UNVISITED;
        }

        public void addIncoming(Vertex v) {
            incoming.add(v);
        }

        public void addOutgoing(Vertex v) {
            outgoing.add(v);
        }

        @Override
        public String toString()
        {
            String retval = "";
            retval += "Vertex: " + value + " : ";
            retval += " In: ";
            for (Vertex each : incoming) retval+= each.value + " ";
            retval += "Out: ";
            for (Vertex each : outgoing) retval += each.value + " ";
            return retval;
        }

        @Override
        public int compareTo(Vertex other) {
            return Integer.compare(minDistance, other.minDistance);
        }
    }

    class Edge {
        Vertex from;
        Vertex to;
        int cost;
        public Edge(T v1, T v2, int cost) {
            from = new Vertex(v1);
            vertices.add(from);

            to = new Vertex(v2);
            vertices.add(to);

            this.cost = cost;

            from.addOutgoing(to);
            to.addIncoming(from);
        }

        @Override
        public String toString()
        {
            return "Edge From: " + from.value + " to: " + to.value + " cost: " + cost;
        }

    }

    @Override
    public String toString()
    {
        String retval = "";
        for (Vertex each : vertices)
        {
            retval += each.toString() + "\n";
        }
        return retval;
    }

}
public class DiGraphTest {
    public static void main(String[] args) {
        DiGraph graph = new DiGraph();

        graph.add("SACRAMENTO", "PHOENIX", 150);
        graph.add("PHOENIX", "SACRAMENTO", 135);
        graph.add("PHOENIX", "SLC", 120);
        graph.add("SLC", "SACRAMENTO", 175);
        graph.add("LAS VEGAS", "CHICAGO", 250);

        System.out.println(graph);
    }
}