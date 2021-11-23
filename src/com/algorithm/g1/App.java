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
		graphHM.printAllPaths("D", "A");
		System.out.println();

		
		for(String[] s : graphHM.allPaths) {
			System.out.print(Arrays.toString(s));
		}
		System.out.println();
		

		//--------------------------------------------------Adjacency Matrix-------------------------------------
//		GraphAdjacencyMatrix graphAM = new GraphAdjacencyMatrix(7);
//		
//		graphAM.addEdge(0, 1, 5);
//		graphAM.addEdge(0, 2, 6);
//		graphAM.addEdge(0, 6, 3);
//		graphAM.addEdge(1, 3, 2);
//		graphAM.addEdge(1, 4, 7);
//		graphAM.addEdge(2, 3, 10);
//		graphAM.addEdge(3, 4, 1);
//		graphAM.addEdge(4, 6, 1);		
//		
//		graphAM.printGraph();
//		
//		VogelApproximationMethod VAM = new VogelApproximationMethod(7, graphAM.matrix);
//		
//		for(int i = 0; i < 6; i++) {			
//			VAM.calculatePenalties();
//			System.out.println("Row Penalties: "+Arrays.toString(VAM.rowPenalties));
//			System.out.println("Column Penalties: "+Arrays.toString(VAM.columnPenalties));
//			VAM.getProvisionalRoute();
//			graphAM.printGraph();
//			System.out.println("\n\n");
//		}
//		VAM.getSolutionCost();;
		
	}

}
