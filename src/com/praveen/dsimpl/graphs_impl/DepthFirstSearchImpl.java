package com.praveen.dsimpl.graphs_impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class DepthFirstSearchImpl {

	private int vertexCount;
	private String graphType;
	private LinkedList<Integer> adjList[];

	public DepthFirstSearchImpl(int vertexCount, String graphType) {
		super();
		this.vertexCount = vertexCount;
		this.graphType = graphType;

		this.adjList = new LinkedList[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			adjList[i] = new LinkedList<>();
		}

	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the no of vertices ");
		int vertexCount = input.nextInt();
		System.out.println("Please enter the graph type directed/undirected");
		String graphType = input.next();

		DepthFirstSearchImpl depthFirstSearchImpl = new DepthFirstSearchImpl(vertexCount, graphType);

		// Adding edge to adjList as follows
		depthFirstSearchImpl.addEdge(0, 1);
		depthFirstSearchImpl.addEdge(0, 3);
		depthFirstSearchImpl.addEdge(1, 2);
		depthFirstSearchImpl.addEdge(2, 0);
		depthFirstSearchImpl.addEdge(2, 3);
		
		depthFirstSearchImpl.printGraph();
		depthFirstSearchImpl.dfsUtil(0);

		input.close();
	}

	private void dfsUtil(int vertex) {
		
		boolean visited[] = new boolean[vertexCount];
		
		dfs(vertex,visited);
		
	}

	private void dfs(int vertex, boolean[] visited) {
		
		//1) make the current vertex as visited  
		visited[vertex] = true;
		System.out.print(" "+ vertex);
		
		//2) iterate over the vertex adjacent to  current vertex 
		Iterator<Integer> adjIter = adjList[vertex].listIterator();
		while(adjIter.hasNext()) { 
			int selectedVertex = adjIter.next();
			if(!visited[selectedVertex]) { 
				dfs(selectedVertex,visited);
			}
		}
		
	}

	private void printGraph() {
		for(LinkedList<Integer> u:adjList) { 
			System.out.println(u);
		}
		
	}

	private void addEdge(int vertex1, int vertex2) {
		if (checkVertexbounds(vertex1, vertex2)) {
			if (graphType == "directed") {
				adjList[vertex1].add(vertex2);
				adjList[vertex2].add(vertex1);
			} else {
				adjList[vertex1].add(vertex2);
			}
		}

	}

	private boolean checkVertexbounds(int vertex1, int vertex2) {

		return (vertex1 >= 0 && vertex1 < vertexCount && vertex2 >= 0 && vertex2 < vertexCount);
	}

}
