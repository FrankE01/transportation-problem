package com.algorithm.g1;

import java.util.Arrays;

public class GraphAdjacencyMatrix {
	int vertices;
	int[][] matrix;
	
	public GraphAdjacencyMatrix(int vertices) {
		this.vertices = vertices;
		matrix = new int[vertices][vertices];
	}
	
	
	public void addEdge(int source, int destination, int weight) {
		//add forward edge
		matrix[source][destination]= weight;
		
		//add back edge for undirected matrix
		matrix[destination][source] = weight;
	}
	
	public void printGraph() {
		System.out.println("Graph: (Adjacency Matrix)");
		for(int i = 0; i < vertices; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println();
		for (int i = 0; i < vertices; i++) {
			System.out.println("Vertex " + i + " is connected to: ");
			for(int j = 0; j < vertices; j++) {
				if(matrix[i][j]>0) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}
	
}
