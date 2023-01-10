package com.rsakin.practise.datastructures;

// Adjacency List representation in Java

public class Graph2 {

    private LinkedList graph[]; // Adjacency List representation of a graph
    private int vertexNum;

    public Graph2(int numVertices) {
        vertexNum = numVertices;
        this.graph = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            graph[i] = new LinkedList();
        }
    }

    // Add edge
    public void addEdge(int s, int d) {
        graph[s].insertAtBeginning(d);
        graph[d].insertAtBeginning(s);
    }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < vertexNum; i++) {
            System.out.println("\nVertex " + i + ":");
            LinkedList.Node temp = graph[i].head;
            while (temp != null) {
                System.out.print(" -> " + temp.data);
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Create the graph
        Graph2 graph = new Graph2(5);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);

        graph.printGraph();
    }
}
