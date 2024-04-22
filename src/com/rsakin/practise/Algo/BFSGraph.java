package com.rsakin.practise.Algo;

import java.util.LinkedList;
import java.util.Queue;

// BFS algorithm in Java
public class BFSGraph {
    private LinkedList<Integer>[] adjList;
    private boolean[] visited;

    // Create a graph
    BFSGraph(int v) {
        adjList = new LinkedList[v];
        visited = new boolean[v];

        for (int i = 0; i < v; ++i)
            adjList[i] = new LinkedList();
    }

    // Add edges to the graph
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // BFS algorithm
    void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();

        visited[vertex] = true;
        queue.add(vertex);

        while (!queue.isEmpty()) {
            vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int n : adjList[vertex]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFSGraph g = new BFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("--------------------------------");

        int startingVertex = 2;
        System.out.println("Following is Breadth First Traversal " + "(starting from vertex " + startingVertex + ")");
        g.bfs(startingVertex);

        System.out.println("\n--------------------------------");
    }
}
