import java.util.*;
class Hashnode{
	int key;
	String value;
	Hashnode next;
	Hashnode(int k,String v){
		this.key=k;
		this.value=v;
	}
}
public class StudentHashing {
	ArrayList<Hashnode> Hashtable;
	int size;
	int tablesize;
   StudentHashing(){
	   Hashtable=new ArrayList<>();
	   size=0;
	   tablesize=10;
	   for(int i=0;i<tablesize;i++){
		   Hashtable.add(null);
	   }
   }
   int HashFunction(Integer k){
	   int hashcode=k.hashCode();
	   hashcode=hashcode%tablesize;
	   return hashcode;
	   
   }
   void add(int k,String v){
	   int index=HashFunction(k);
	   Hashnode Head=Hashtable.get(index);
	   size++;
	   //System.out.println("Size is"+size);
	   Hashnode n=new Hashnode(k,v);
	   n.next=Head;
	   Hashtable.set(index, n);
	   if((1.0*size)/tablesize>0.7){
		   //System.out.println("UPDATING"+(1.0*size)/tablesize+" "+size+" "+tablesize);
		   ArrayList<Hashnode> t=Hashtable;
		   Hashtable=new ArrayList<>();
		   tablesize=2*tablesize;
		   size=0;
		   for(int i=0;i<tablesize;i++){
			   Hashtable.add(null);
		   }
		   for(Hashnode r : t){
			   while(r!=null){
				   add(r.key,r.value);
				   r=r.next;
			   }
		   }
	   }
   }
   void Display(){
	   int i=0;
	   for(Hashnode d:Hashtable){
		   System.out.print("\n");
		   if(d==null){
			   System.out.print("index:"+i+"= "+d);
		   }
		   else{
		   System.out.print("index:"+i+"= "+d.key+"->"+d.value);
		   d=d.next;
		   //System.out.print("Check"+d);
		   while(d!=null){
			   System.out.print(", "+d.key+"->"+d.value);
			   d=d.next;
		   }
		   }
		   i++;
		   
	   }
	   System.out.println("\n");
   }
   public static void main(String[] args){
	   StudentHashing h=new StudentHashing();
	   h.add(2021305757, "Tharunn");
	   h.add(2021305758, "alice");
	   h.add(2021305753, "casy");
	   h.add(2021305753, "brian");
	   h.add(2021305751, "daniel");
	   h.add(2021305755, "emily");
	   h.add(2021305755, "ford");
	   System.out.println( " The Hash table :");
	   h.Display();
	   h.add(2021305756, "george");
	   h.add(2021305752, "hillary");
	   h.add(2021305754, "ian");
	   h.add(2021305759, "john");
	   h.add(2021305773, "qinn");
	   h.add(2021305735, "reshma");
	   h.add(2021305555, "sachin");
	   System.out.print("After first updation :");
	   h.Display();
	   h.add(2021305014, "tiesto");
	   h.add(2021305017, "usher");
	   h.add(2021305701, "varun");
	   h.add(2021305327, "william");
	   h.add(2026932496, "kaka");
	   h.add(2042859774, "lilly");
	   System.out.print("After Second updation :");
	   h.Display();
   }
  
}
