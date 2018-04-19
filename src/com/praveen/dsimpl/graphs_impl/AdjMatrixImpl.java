package com.praveen.dsimpl.graphs_impl;

import java.util.Scanner;

public class AdjMatrixImpl {

	int vertexCount;
	private boolean adjMatrix[][];
	private String graphType;

	public AdjMatrixImpl(int vertexCount, String graphType) {
		super();
		this.vertexCount = vertexCount;
		this.graphType = graphType;
		adjMatrix = new boolean[this.vertexCount][this.vertexCount];

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the no of vertices");
		int noOfVertices = input.nextInt();
		String graphType = input.next();
		AdjMatrixImpl adjMatrixImpl = new AdjMatrixImpl(noOfVertices, graphType);

		// Adding edge as follows
		adjMatrixImpl.addEdge(0, 1);
		adjMatrixImpl.addEdge(0, 3);
		adjMatrixImpl.addEdge(1, 2);
		adjMatrixImpl.addEdge(2, 0);
		adjMatrixImpl.addEdge(2, 3);

		// Removing edge as follows
		adjMatrixImpl.removeEdge(0, 1);

		// Checking edge availability
		adjMatrixImpl.checkEdge(0, 1);

		// Print the graph as follows
		adjMatrixImpl.printGraph();

		// finding all adjacent vertices of vertex as follows
		adjMatrixImpl.findAdjVertex(0);

	}

	private void findAdjVertex(int u) {
		if (u >= 0 && u < vertexCount) {
			for(int v =0 ; v < vertexCount; v++) { 
				if(adjMatrix[u][v] == true) { 
					System.out.println("Adjacency Vertex : "+v);
				}
			}
		}

	}

	private void printGraph() {

		for (int u = 0; u < vertexCount; u++) {
			for (int v = 0; v < vertexCount; v++) {
				System.out.print(adjMatrix[u][v] + " ");
			}
			System.out.println();
		}
	}

	private boolean checkEdge(int vertex1, int vertex2) {

		if (checkVertexbounds(vertex1, vertex2)) {
			if (adjMatrix[vertex1][vertex2] || adjMatrix[vertex2][vertex1]) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	private void removeEdge(int vertex1, int vertex2) {

		if (checkVertexbounds(vertex1, vertex2)) {
			if (graphType == "undirected") {
				adjMatrix[vertex1][vertex2] = false;
				adjMatrix[vertex2][vertex1] = false;
			} else {
				adjMatrix[vertex1][vertex2] = false;
			}

		}
	}

	private boolean checkVertexbounds(int vertex1, int vertex2) {

		return (vertex1 >= 0 && vertex1 < vertexCount && vertex2 >= 0 && vertex2 < vertexCount);
	}

	private void addEdge(int vertex1, int vertex2) {

		if (checkVertexbounds(vertex1, vertex2)) {
			if (graphType == "undirected") {
				adjMatrix[vertex1][vertex2] = true;
				adjMatrix[vertex2][vertex1] = true;
			} else {
				adjMatrix[vertex1][vertex2] = true;
			}
		}

	}

}
