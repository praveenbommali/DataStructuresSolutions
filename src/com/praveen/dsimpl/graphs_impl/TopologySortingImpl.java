package com.praveen.dsimpl.graphs_impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class TopologySortingImpl {

	private int vertexCount;
	private LinkedList<Integer> adjList[];

	public TopologySortingImpl(int vertexCount) {
		super();
		this.vertexCount = vertexCount;
		adjList = new LinkedList[vertexCount];

		for (int u = 0; u < vertexCount; u++) {
			adjList[u] = new LinkedList<>();
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the no of vertex");
		int vertexCount = input.nextInt();

		TopologySortingImpl topologySortingImpl = new TopologySortingImpl(vertexCount);

		topologySortingImpl.addEdge(5, 2);
		topologySortingImpl.addEdge(5, 0);
		topologySortingImpl.addEdge(4, 0);
		topologySortingImpl.addEdge(4, 1);
		topologySortingImpl.addEdge(2, 3);
		topologySortingImpl.addEdge(3, 1);
		
		topologySortingImpl.topologySortImpl();

	}

	private void topologySortImpl() {
		
		//1) Define the stack  
		Stack stack = new Stack();
		//2) Define boolean array of  vertex visit status  
		boolean visited[] = new boolean[vertexCount];
		for(int  i=0 ; i<vertexCount;i++) 
			visited[i] = false;
		
		for(int u =0; u< vertexCount;u++) { 
			if(!visited[u]) { 
				topologySort(u, visited,stack);
			}
		}
		
		while(!stack.isEmpty()) { 
			System.out.print(stack.pop());
		}
		
		
	}

	private void topologySort(int vertex, boolean[] visited, Stack stack) {
		
		visited[vertex] = true;
		
		Integer selectedVertex; 
		
		Iterator<Integer> iter = adjList[vertex].iterator();
		while(iter.hasNext()) { 
			selectedVertex = iter.next();
			if(!visited[selectedVertex]) { 
				topologySort(selectedVertex, visited, stack);
			}
		}
		
		stack.push(new Integer(vertex));
		
	}

	private void addEdge(int vertex1, int vertex2) {
		
		adjList[vertex1].add(vertex2);
	}

}
