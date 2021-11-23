package com.algorithm.g1;

public class Edge {
	Object source;
	Object destination;
	Integer weight;
	
	public Edge(Object source, Object destination, Integer weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	Object getSource() {
		return this.source;
	}
	
	Object getDestination() {
		return this.destination;
	}
	
	Object getWeight() {
		return this.weight;
	}
	
	public String toString() {
		String s = source + " =(" + weight + ")> " + destination ;
		return s;
	}

}
