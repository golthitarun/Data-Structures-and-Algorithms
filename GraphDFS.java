import java.util.*;
public class GraphDFS {
	int N;
	LinkedList<Integer> adjlist[];
    GraphDFS(int n){
    	N=n;
    	adjlist = new LinkedList[n];
    	for(int i=0;i<n;i++){
    		adjlist[i]=new LinkedList<>();
    	}
    }
    void add_edge(int a,int b){
    	adjlist[a].add(b);
    }
   void DFSPrint(int a, boolean visited[]){
    	ListIterator<Integer> l=adjlist[a].listIterator();
    	while(l.hasNext()){
    		int n= l.next();
    		if(visited[n]==false){
    			visited[n]=true;
    			System.out.print(n+" ");
    			DFSPrint(n, visited);
    		}
    	}
    }
    void DFS(int a){
    	boolean visited[]=new boolean[N];
    	visited[a]=true;
    	System.out.print(a+" ");
    	DFSPrint(a, visited);
    }
    void BFS(int a){
    	boolean visited1[]=new boolean[N];
    	Queue<Integer> q=new LinkedList<Integer>();
    	q.add(a);
    	System.out.print(a+" ");
    	visited1[a]=true;
    	while(q.size()!=0){
    		int b=q.remove();
    		ListIterator<Integer> l=adjlist[b].listIterator();
    		while(l.hasNext()){
    			int n=l.next();
    			if(visited1[n]==false){
    				System.out.print(n+" ");
    				visited1[n]=true;
    				q.add(n);
    			}
    		}
    	}
    }
    
    
    public static void main(String[] args){
    	GraphDFS g=new GraphDFS(10);
    	g.add_edge(0, 1);
    	g.add_edge(0, 2);
    	g.add_edge(0, 3);
    	g.add_edge(0, 4);
    	g.add_edge(1, 0);
    	g.add_edge(1, 3);
    	g.add_edge(1, 5);
    	g.add_edge(2, 0);
    	g.add_edge(2, 4);
    	g.add_edge(2, 7);
    	g.add_edge(3, 0);
    	g.add_edge(3, 1);
    	g.add_edge(3, 5);
    	g.add_edge(3, 6);
    	g.add_edge(3, 9);
    	g.add_edge(4, 0);
    	g.add_edge(4, 2);
    	g.add_edge(4, 5);
    	g.add_edge(4, 7);
    	g.add_edge(5, 1);
    	g.add_edge(5, 3);
    	g.add_edge(5, 4);
    	g.add_edge(5, 6);
    	g.add_edge(5, 8);
    	g.add_edge(5, 9);
    	g.add_edge(6, 3);
    	g.add_edge(6, 5);
    	g.add_edge(6, 9);
    	g.add_edge(7, 2);
    	g.add_edge(7, 4);
    	g.add_edge(7, 8);
    	g.add_edge(7, 9);
    	g.add_edge(8, 5);
    	g.add_edge(8, 7);
    	g.add_edge(8, 9);
    	g.add_edge(9, 3);
    	g.add_edge(9, 5);
    	g.add_edge(9, 6);
    	g.add_edge(9, 7);
    	g.add_edge(9, 8);
    	System.out.print("DFS :");
    	g.DFS(0);
    	System.out.print("\n"+"BFS :");    	
    	g.BFS(0);
    }
}