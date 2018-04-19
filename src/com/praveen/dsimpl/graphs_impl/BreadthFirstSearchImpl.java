package com.praveen.dsimpl.graphs_impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BreadthFirstSearchImpl {

	private int vertexCount;
	private String graphType;
	private LinkedList<Integer> adjList[];

	public BreadthFirstSearchImpl(int vertexCount, String graphType) {
		super();
		this.vertexCount = vertexCount;
		this.graphType = graphType;

		adjList = new LinkedList[vertexCount];
		for (int u = 0; u < vertexCount; u++) {
			adjList[u] = new LinkedList<>();
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the no of vertices");
		int vertexCount = input.nextInt();
		System.out.println("Please enter the garph Type");
		String graphType = input.next();

		BreadthFirstSearchImpl breadthFirstSearchImpl = new BreadthFirstSearchImpl(vertexCount, graphType);
		breadthFirstSearchImpl.addEdge(0, 1);
        breadthFirstSearchImpl.addEdge(0, 2);
        breadthFirstSearchImpl.addEdge(1, 2);
        breadthFirstSearchImpl.addEdge(2, 0);
        breadthFirstSearchImpl.addEdge(2, 3);
        breadthFirstSearchImpl.addEdge(3, 3);
        
        breadthFirstSearchImpl.printGraph();
        breadthFirstSearchImpl.bfsImpl(2);
		

	}

	private void bfsImpl(int vertex) {
		
		//1) Define the visited status boolean array
		 boolean visited[] = new boolean[vertexCount];
		 
		 //2) Define the Queue to store the visited vertex
		 LinkedList<Integer> queue = new LinkedList<>();
		 
		 //3) Mark the current vertex as visited and visited array  
		 visited[vertex] = true;
		 queue.add(vertex);
		 
		 while(queue.size() >0)  { 
			 
			 int selectedVertex = queue.poll();
			 System.out.print(" "+ selectedVertex);
			 Iterator<Integer> iter = adjList[selectedVertex].iterator();
			 while(iter.hasNext()) { 
				 int nextVertex = iter.next();
				 if(!visited[nextVertex]) { 
					 visited[nextVertex] = true;
					 queue.add(nextVertex);
				 }
			 }
		 }
		 
		 
		
	}

	private void printGraph() {
		for(LinkedList<Integer> u:adjList) { 
			System.out.println(u);
		}
		
	}

	private void addEdge(int vertex1, int vertex2) {
		if(checkVertexbounds(vertex1, vertex2)) { 
			if(graphType == "undirected") { 
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
