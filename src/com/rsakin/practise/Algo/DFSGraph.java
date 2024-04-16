package com.rsakin.practise.Algo;

import java.util.LinkedList;

// DFS algorithm in Java
public class DFSGraph {
    private LinkedList<Integer>[] adjList;
    private boolean[] visited;

    // Graph creation
    DFSGraph(int vertices) {
        adjList = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjList[i] = new LinkedList<>();
    }

    // Add edges
    void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    // DFS algorithm
    void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adj : adjList[vertex]) {
            if (!visited[adj])
                dfs(adj);
        }
    }

    public static void main(String[] args) {
        DFSGraph g = new DFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Following is Depth First Traversal");

        g.dfs(0);
    }
}
