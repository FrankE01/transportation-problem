package com.algorithm.g1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class GraphHashMap {
	HashMap<Object, LinkedList<Edge>> adjacencyList = new HashMap<>();
	HashMap<Object, Integer> indexes = new HashMap<>();
	int index = -1;
	int listSize = 0;
	List<List<String>> allPaths = new ArrayList<>();
	int[][] matrix;

	
	
	
	public GraphHashMap(ArrayList<Object> vertices) {
		this.listSize = vertices.size();
		this.matrix = new int[vertices.size()][vertices.size()];
		for (int i = 0; i < vertices.size(); i++) {
			Object vertex = vertices.get(i);
			LinkedList<Edge> list = new LinkedList<>();
			adjacencyList.put(vertex, list);
			indexes.put(vertex, ++index);
		}
	}
	
	public void addEdge(Object source, Object destination, Integer weight) {
		//add forward edge
		Edge edge = new Edge(source, destination, weight);
		LinkedList<Edge> list;
		list = adjacencyList.get(source);
		list.addFirst(edge);
		adjacencyList.put(source, list);
		
		//add back edge
		edge = new Edge(destination, source, weight);
		list = adjacencyList.get(destination);
		list.addFirst(edge);
		adjacencyList.put(destination, list);

	}
	
	
	public void DFS(Object source) {
		boolean[] visited = new boolean[adjacencyList.size()];
		
		Stack<Object> stack = new Stack<>();
		stack.push(source);
		Object a = null;
		
		while(!stack.empty()) {
			source = stack.peek();
			stack.pop();
			
			if(visited[indexes.get(source)] == false) {
				System.out.print(source + " ");
				visited[indexes.get(source)] = true;
			}
			
			for(int i = 0; i < adjacencyList.get(source).size(); i++) {
				a = adjacencyList.get(source).get(i).destination;
				if(!visited[indexes.get(a)]) {
					stack.push(a);
				}
			}
		}
	}
	
	public void printAllPaths(Object source, Object destination) {
		allPaths = new ArrayList<>();
		boolean[] visited = new boolean[adjacencyList.size()];
		visited[indexes.get(source)] = true;
		print(source, destination, "", visited);
	}
	
	public void print(Object source, Object destination, String path, boolean[] visited) {
		String newPath = path + "->" + source;
		visited[indexes.get(source)] = true;
		
		LinkedList<Edge> list = adjacencyList.get(source);
		for(int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);
			if(indexes.get(edge.destination)< adjacencyList.size() && edge.destination != destination && visited[indexes.get(edge.destination)] == false) {
				print(edge.destination, destination, newPath, visited);
			}else if(edge.destination == destination) {
//				System.out.println(newPath+"->"+edge.destination);
				String s = newPath+"->"+edge.destination;
				List<String> temp = Arrays.asList(s.split("->"));
				allPaths.add(temp);
			}
		}
		visited[indexes.get(source)] = false;
	}
	
	public void listToMatrix() {
		for(List<String> o : allPaths) {
			for(String p : o) {
				if(p != "" && o.indexOf(p)+1 < o.size()) {
					LinkedList<Edge> LL = adjacencyList.get(p);
					Edge next = null;
					for(Edge e : LL) {
						if(e.destination.equals((o.get(o.indexOf(p)+1)))){
							next = e;
						}
					}
					matrix[indexes.get(p)][indexes.get(o.get(o.indexOf(p)+1))] = next.weight;
				} 
			}
		}
	}
	

	public void printGraph() {
		Set<Object> set = adjacencyList.keySet();
		Iterator<Object> iterator = set.iterator();
		
		System.out.println("Graph: (Adjacency List using Hash Maps)");
		while(iterator.hasNext()) {
			Object vertex = iterator.next();
			System.out.print(vertex + " is connected to: ");
			LinkedList<Edge> list = adjacencyList.get(vertex);
			for(int i = 0; i < list.size(); i++) {
				System.out.print("("+list.get(i).getWeight()+")"+list.get(i).getDestination()+ " ");
			}
			System.out.println();
		}
	}
	
	public void getShortestPath() {
		int smallest = Integer.MAX_VALUE;
		int index = Integer.MAX_VALUE;
		for(List<String> LL : allPaths) {
			int cost = 0;
			for(int i = 1; i < LL.size(); i++) {
				List<Edge> LL2 = adjacencyList.get(LL.get(i));
				for(Edge e : LL2) {
					if(i< LL.size()-1) {
						if((LL.get(i+1).toString().equalsIgnoreCase(e.destination.toString()))) {
							cost += e.weight;
						}
					}
				}
			}
			if(cost< smallest) {
				smallest = cost;
				index = allPaths.indexOf(LL);
			}
		}
		System.out.println("Actual Shortest Path with a distance of "+smallest+" meters : "+String.join(" -> ", allPaths.get(index)));
	}
	
	public void printGraph2() {
		System.out.println("Graph: (Adjacency Matrix)");
		for(int i = 0; i < adjacencyList.size(); i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println();
		for (int i = 0; i < adjacencyList.size(); i++) {
			System.out.println(i + " is connected to: ");
			for(int j = 0; j < adjacencyList.size(); j++) {
				if(matrix[i][j]>0) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}
}
