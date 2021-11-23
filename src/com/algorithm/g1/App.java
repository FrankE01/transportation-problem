package com.algorithm.g1;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		System.out.println("Connecting vertices...");
		
		ArrayList<Object> vertices = new ArrayList<>();
		vertices.add("A");
		vertices.add("B");
		vertices.add("C");
		vertices.add("D");
		vertices.add("E");
		vertices.add("F");
		vertices.add("G");
		
		GraphHashMap graphHM = new GraphHashMap(vertices);
		graphHM.addEdge("A", "B", 5);
		graphHM.addEdge("A", "C", 6);
		graphHM.addEdge("B", "D", 2);
		graphHM.addEdge("B", "E", 7);
		graphHM.addEdge("C", "D", 10);
		graphHM.addEdge("D", "E", 1);
		graphHM.addEdge("G", "E", 1);
		graphHM.addEdge("A", "G", 3);
		
		graphHM.printGraph();
		System.out.println("--------------------------------Depth First Traversal--------------------------------");
		System.out.println();
		graphHM.printAllPaths("A", "C");
		System.out.println();

		
		for(String[] s : graphHM.allPaths) {
			System.out.print(Arrays.toString(s));
		}
		System.out.println();
		
		graphHM.listToMatrix();
		
		GraphAdjacencyMatrix graphAM = new GraphAdjacencyMatrix(7);
		graphAM.matrix = graphHM.matrix;
		graphAM.printGraph();

		VogelApproximationMethod VAM = new VogelApproximationMethod(7, graphAM.matrix);
		for(int i = 0; i < 6; i++) {			
			VAM.calculatePenalties();
			VAM.getProvisionalRoute();
		}
		System.out.println("List of provisional routes: "+ VAM.provisionalRoute);
		VAM.getSolutionCost();;
		
	}

}
