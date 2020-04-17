/*
Route between Nodes: Given a directed graph, design an algorithm to find out 
whether there is a route between two nodes.
*/

import java.io.*;
import java.util.*;
import java.util.LinkedList;

class Route {

	private int vertices;
	private LinkedList<Integer> adj[]; //adjacency list

	Route(int v) {
		this.vertices = v;
		adj = new LinkedList[vertices];
		for(int i=0; i<v; i++){
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int dest) {
		adj[source].add(dest);
	}

	public Boolean isReachable(int s, int d) {
		LinkedList<Integer> temp;
		boolean visited[] = new boolean[vertices];

		//queue for bfs
		LinkedList<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.add(s);

		// 'i' will be used to get all adjacent vertices of a vertex 
        Iterator<Integer> i;

        while(!q.isEmpty()) {

        	//dequeue and print it.
        	s = q.poll();

        	int n;
        	i = adj[s].listIterator();

        	while(i.hasNext()) {
        		n = i.next();

        		if(n == d){
        			return true;
        		}
        		if(!visited[n]){
        			visited[n] = true; 
                    q.add(n); 
        		}
        	}
        }
        return false;
	}

	public static void main(String[] args) {

		Route g = new Route(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        int u = 1; 
        int v = 3; 
        if (g.isReachable(u, v)) 
            System.out.println("There is a path from " + u +" to " + v); 
        else
            System.out.println("There is no path from " + u +" to " + v);; 
  
        u = 3; 
        v = 1; 
        if (g.isReachable(u, v)) 
            System.out.println("There is a path from " + u +" to " + v); 
        else
            System.out.println("There is no path from " + u +" to " + v);; 
    
	}
}
