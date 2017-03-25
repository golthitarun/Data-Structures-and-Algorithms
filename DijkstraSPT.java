import java.util.*;
class node implements Comparable<node>{
	int label;
	int weight;
	node(int a,int b){
		label=a;
		weight=b;
	}
	public int getDistanceFromSource() {
	    return weight;
	}
	
	public int getlable(){
		return label;
	}
	void update(int i){
		weight=i;
	}
	public int compareTo(node o) {
	    return Integer.compare(this.getDistanceFromSource(), o.getDistanceFromSource());
		
	}
}
public class DijkstraSPT {
  int V,S;	
  PriorityQueue<node> heap=new PriorityQueue<>();
  LinkedList<node> DisplayList=new LinkedList<>();
  LinkedList<node> List=new LinkedList<>();
  int[] distance;
  LinkedList<Integer> adjlist[];
  int weight[][];
  @SuppressWarnings("unchecked")
  DijkstraSPT(int v,int s){
	  V=v;
	  S=s;
	  distance= new int[V];
	  weight = new int[V][V];
	  adjlist = new LinkedList[V];
	  for(int i=0;i<v;i++){
  		adjlist[i]=new LinkedList<>();
  	  }
  	  for(int i=0;i<v;i++){
		  if(i==s){
			  SetDistance(i,0);
		  }
		  else{
			  SetDistance(i,Integer.MAX_VALUE);
		  }
	  }
  }
  void add_edge(int a,int b){
  	adjlist[a].add(b);
  
  }
  void add_weight(int a,int b,int w){
	  weight[a][b]=w; 
  }
  void SetDistance(int i,int j){
	  distance[i]=j;
	  node newnode=new node(i,j);
	  heap.add(newnode);
  }
  void findSPT(){
	 //boolean SPT[]=new boolean[V]; 
	 while(!heap.isEmpty()){
	    node min=heap.poll();
	    DisplayList.add(min);
	    int vertex=min.getlable();
	    LinkedList<node> newnode= new LinkedList<>();
	    //SPT[vertex]=true;
	    for(int i=0;i<adjlist[vertex].size();i++){
		    int distance2=weight[vertex][adjlist[vertex].get(i)]+distance[vertex];
	    	if(distance2<distance[adjlist[vertex].get(i)]){
	    		distance[adjlist[vertex].get(i)]=distance2;
	    		Iterator<node> it=heap.iterator();
	    		while(it.hasNext()){
	    			node temp=it.next();
	    			if(temp.label==adjlist[vertex].get(i)){
	    				temp.update(distance2);
	    				newnode.add(temp);
	    				it.remove();
	    			}
	    		}
	    	}
	    }
	    Iterator<node> nn= newnode.iterator();
        while(nn.hasNext()){
        	heap.add(nn.next());
        }
	 
 }
 }//i am very sincere organizational skills 
  void display(){
//	  Iterator<node> D= DisplayList.iterator();
//	  while(D.hasNext())
//		  {   node n=D.next();
//			  System.out.println(n.label+"->"+n.weight);
//			  
//		  }
	  System.out.print("Adjacency List of Graph");
	  for(int i=0;i<V;i++){
		  System.out.print("\n");
		  System.out.print(i+"->");
		  for(int j=0;j<adjlist[i].size();j++){
			  System.out.print(adjlist[i].get(j));
			  if(j<adjlist[i].size()-1){
				  System.out.print("->");
			  }
		  }
		  System.out.print(": ");
		  //System.out.print(weight[i]);
		  for(int j=0;j<adjlist[i].size();j++){
			  System.out.print(weight[i][adjlist[i].get(j)]+" ");
		  }
		  
	  }
	  System.out.print("\n");
	  System.out.print("Vertex "+" Distance from source-"+S);
	  for(int i=0;i<DisplayList.size();i++){
		  System.out.print("\n");
		  System.out.print(" "+DisplayList.get(i).getlable()+" ");
		  System.out.print("      "+DisplayList.get(i).getDistanceFromSource()+" ");
	  }
//	  System.out.print(": ");
//	  for(int i=0;i<DisplayList.size();i++){
//		  System.out.print(DisplayList.get(i).getDistanceFromSource()+" ");
//	  }
  }
  
  public static void main(String[] args)
  {   
	  
	  DijkstraSPT d=new DijkstraSPT(10,0);
	  d.add_edge(0, 1);
	  d.add_weight(0, 1, 4);
	  d.add_edge(0, 7);
	  d.add_weight(0, 7, 6);
	  d.add_edge(1, 2);
	  d.add_weight(1, 2, 5);
	  d.add_edge(1, 8);
	  d.add_weight(1, 8, 1);
	  d.add_edge(2, 3);
	  d.add_weight(2, 3, 3);
	  d.add_edge(2, 9);
	  d.add_weight(2, 9, 9);
	  d.add_edge(3, 4);
	  d.add_weight(3, 4, 11);
	  d.add_edge(4, 5);
	  d.add_weight(4, 5, 2);
	  d.add_edge(5, 6);
	  d.add_weight(5, 6, 5);
	  d.add_edge(6, 7);
	  d.add_weight(6, 7, 8);
	  d.add_edge(8, 6);
	  d.add_weight(8, 6, 3);
	  d.add_edge(8, 2);
	  d.add_weight(8, 2, 7);
	  d.add_edge(9, 4);
	  d.add_weight(9, 4, 6);
	  d.add_edge(9, 6);
	  d.add_weight(9, 6, 7);
	  d.findSPT();
	  d.display();
  
  }
}
