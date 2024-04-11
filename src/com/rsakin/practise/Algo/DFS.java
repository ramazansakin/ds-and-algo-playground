package com.rsakin.practise.Algo;

import java.util.LinkedList;

// DFS algorithm in Java
class Graph {
    private LinkedList<Integer>[] adjList;
    private boolean[] visited;

    // Graph creation
    Graph(int vertices) {
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
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adj : adjList[vertex]) {
            if (!visited[adj])
                DFS(adj);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Following is Depth First Traversal");

        g.DFS(0);
    }
}
