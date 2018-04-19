package com.praveen.dsimpl.graphs_impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AdjListImpl {

	private int vertexCount;
	private String graphType;
	private LinkedList<Integer> adjList[];

	@SuppressWarnings("unchecked")
	public AdjListImpl(int vertexCount, String graphType) {
		super();
		this.vertexCount = vertexCount;
		this.graphType = graphType;
		adjList = new LinkedList[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			adjList[i] = new LinkedList<>();
		}

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the no of vertex");
		int vertexCount = input.nextInt();
		System.out.println("Please enter the graphType");
		String graphType = input.next();
		AdjListImpl adjListImpl = new AdjListImpl(vertexCount, graphType);

		// Adding edge to adjList as follows
		adjListImpl.addEdge(0, 1);
		adjListImpl.addEdge(0, 3);
		adjListImpl.addEdge(1, 2);
		adjListImpl.addEdge(2, 0);
		adjListImpl.addEdge(2, 3);

		
		adjListImpl.printGraph();
		// Remove edge from the adjList
		adjListImpl.removeEdge(0, 1);

	}

	private void printGraph() {
		
		for(int u =0; u <vertexCount; u++) { 
			System.out.println(adjList[u]);
		}
	}

	private void removeEdge(int vertex1, int vertex2) {
		if (graphType == "undirected") {
			adjList[vertex1].remove(vertex2);
			adjList[vertex2].remove(vertex1);

		} else {
			adjList[vertex1].remove(vertex2);
		}

	}

	private void addEdge(int vertex1, int vertex2) {
		if (graphType == "undirected") {
			adjList[vertex1].addFirst(vertex2);
			adjList[vertex2].addFirst(vertex1);
		} else {
			adjList[vertex1].addFirst(vertex2);
		}

	}
}
