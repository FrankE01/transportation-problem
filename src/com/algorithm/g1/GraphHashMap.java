package com.algorithm.g1;

import java.util.ArrayList;
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
	List<String[]> allPaths = new ArrayList<>();
	int[][] matrix = new int[adjacencyList.size()][adjacencyList.size()];

	
	
	
	public GraphHashMap(ArrayList<Object> vertices) {
		this.listSize = vertices.size();
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
		
		if(!visited[indexes.get(source)]) {
			DSFUtil(source, visited);
		}
	}
	
	public void DSFUtil(Object source, boolean[] visited) {
		//mark this as visited
		visited[indexes.get(source)] = true;
		
		System.out.print(source + "=> ");
		LinkedList<Edge> list = adjacencyList.get(source);
		System.out.println("\n"+list);
		for(int i = 0; i < list.size(); i++) {
			Object destination = list.get(i).getDestination();
			if(!visited[indexes.get(destination)]) {
				DSFUtil(destination, visited);
			}
			System.out.println();
		}
	}
	
	public void DFSUtil2(Object source, boolean[] visited) {
		visited[indexes.get(source)] = true;
		System.out.print(source + " ");
		
		Iterator<Edge> i = adjacencyList.get(source).listIterator();
		while (i.hasNext()) {
			Edge n = i.next();
			if(!visited[indexes.get(n.getDestination())]) {
				DFSUtil2(n.getDestination(), visited);
			}
		}
	}
	
	public void DFS2(Object source) {
		boolean[] visited = new boolean[adjacencyList.size()];
		DFSUtil2(source, visited);
	}
	
	public void DFS3(Object source) {
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
			if(edge.destination != destination && visited[indexes.get(edge.destination)] == false) {
				print(edge.destination, destination, newPath, visited);
			}else if(edge.destination == destination) {
				System.out.println(newPath+"->"+edge.destination);
				String s = newPath+"->"+edge.destination;
				allPaths.add(s.split("->"));
			}
		}
//		System.out.println(allPaths);
		visited[indexes.get(source)] = false;
	}
		

	public void printGraph() {
		Set<Object> set = adjacencyList.keySet();
		Iterator<Object> iterator = set.iterator();
		
		System.out.println("Graph: (Adjacency List using Hash Maps)");
		while(iterator.hasNext()) {
			Object vertex = iterator.next();
			System.out.print("Vertex " + vertex + " is connected to: ");
			LinkedList<Edge> list = adjacencyList.get(vertex);
			for(int i = 0; i < list.size(); i++) {
				System.out.print("("+list.get(i).getWeight()+")"+list.get(i).getDestination()+ " ");
			}
			System.out.println();
		}
	}
}
