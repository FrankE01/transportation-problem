package com.algorithm.g1;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		System.out.println("Connecting vertices...");
		
		ArrayList<Object> vertices = new ArrayList<>();
		vertices.add("Great Hall");
		vertices.add("School of Graduate Studies");
		vertices.add("Volta Hall");
		vertices.add("Balme Library");
		vertices.add("New N Block");
		vertices.add("Department of Political Science");
		vertices.add("School of Engineering");
		vertices.add("Department of Mathematics");
		vertices.add("School of Graduate Studies");
		vertices.add("UGBS");
		vertices.add("UGCS");
		vertices.add("Chemistry Department");
		vertices.add("International Programs Office");
		vertices.add("JQB");
		vertices.add("Department of Geography");
		vertices.add("Legon Hall");
		vertices.add("Akuafo Hall");
		vertices.add("College of Basic and Applied Sciences");
		vertices.add("Mensah Sarbah Hall");
		vertices.add("Athletic Oval");
		vertices.add("GCB");
		
		GraphHashMap graphHM = new GraphHashMap(vertices);
		graphHM.addEdge("Great Hall", "School of Graduate Studies", 500);
		graphHM.addEdge("Great Hall", "Volta Hall", 500);
		graphHM.addEdge("School of Graduate Studies", "Volta Hall", 300);
		graphHM.addEdge("School of Graduate Studies", "UGBS", 290);
		graphHM.addEdge("Volta Hall", "UGBS", 190);
		graphHM.addEdge("Volta Hall", "Legon Hall", 190);
		graphHM.addEdge("UGBS", "UGCS", 210);
		graphHM.addEdge("UGBS", "GCB", 450);
		graphHM.addEdge("GCB", "New N Block", 110);
		graphHM.addEdge("New N Block", "Department of Political Science", 400);
		graphHM.addEdge("Department of Political Science", "Department of Mathematics", 280);
		graphHM.addEdge("Department of Mathematics", "Chemistry Department", 180);
		graphHM.addEdge("UGBS", "Chemistry Department", 350);
		graphHM.addEdge("UGCS", "Legon Hall", 240);
		graphHM.addEdge("Legon Hall", "Mensah Sarbah Hall", 1200);
		graphHM.addEdge("Legon Hall", "Athletic Oval", 800);
		graphHM.addEdge("Legon Hall", "Akuafo Hall", 700);
		graphHM.addEdge("Legon Hall", "Balme Library", 500);
		graphHM.addEdge("Balme Library", "Akuafo Hall", 270);
		graphHM.addEdge("Balme Library", "Chemistry Department", 400);
		graphHM.addEdge("Mensah Sarbah Hall", "Athletic Oval", 400);
		graphHM.addEdge("Mensah Sarbah Hall", "Akuafo Hall", 850);
		graphHM.addEdge("Athletic Oval", "Akuafo Hall", 550);
		graphHM.addEdge("College of Basic and Applied Sciences", "Akuafo Hall", 240);
		graphHM.addEdge("College of Basic and Applied Sciences", "Department of Geography", 280);
		graphHM.addEdge("JQB", "Department of Geography", 400);
		graphHM.addEdge("JQB", "International Programs Office", 270);
		graphHM.addEdge("School of Engineering", "International Programs Office", 350);
		graphHM.addEdge("International Programs Office", "Chemistry Department", 400);
		graphHM.addEdge("Chemistry Department", "Akuafo Hall", 450);

		graphHM.printGraph();
		System.out.println("--------------------------------Depth First Traversal--------------------------------");
		System.out.println();
		graphHM.printAllPaths("Great Hall", "Volta Hall");
		System.out.println();

		
		for(String[] s : graphHM.allPaths) {
			System.out.print(Arrays.toString(s));
		}
		System.out.println();
		
		graphHM.listToMatrix();
		
		GraphAdjacencyMatrix graphAM = new GraphAdjacencyMatrix(21);
		graphAM.matrix = graphHM.matrix;
		graphAM.printGraph();

		VogelApproximationMethod VAM = new VogelApproximationMethod(21, graphAM.matrix);
		for(int i = 0; i < 20; i++) {			
			VAM.calculatePenalties();
			VAM.getProvisionalRoute();
		}
		System.out.println("List of provisional routes: "+ VAM.provisionalRoute);
		VAM.getSolutionCost();
		
	}

}
