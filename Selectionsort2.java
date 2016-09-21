import java.util.Scanner;
public class Selectionsort2 {
	node Head;
	 class node{
		 int data;
		 node next;
		 node(int n){
			 data=n;
			 next= null;
		 }
	 }
	 void push(int n){
		 node nw= new node(n);
		 nw.data=n;
		 nw.next= Head;
		 Head= nw;				 
	 }
	 void traverse(node Head){
		 if (Head== null){
			 return;
		}
		 System.out.print(Head.data+"  ");
		 traverse(Head.next);
	 }
	void sort(node head){
		if(head==null){
			return;
		}
		node min=head;
		node temp=head;
		while(temp!=null){
			if(min.data>temp.data){
				min=temp;
			}
			temp=temp.next;
			}
		node prevnode1=null;
		node curnode1=Head;
		while(curnode1!=null){
			if(curnode1==head){
				break;
			}
			prevnode1=curnode1;
			curnode1=curnode1.next;
		}
		node prevnode2=null;
		node curnode2=Head;
		while(curnode2!=null){
			if(curnode2==min){
				break;
			}
			prevnode2=curnode2;
			curnode2=curnode2.next;
		}
		if(prevnode1==null){
			Head=min;
		}
		else{
			prevnode1.next=min;
		}
		if(prevnode2==null){
			Head=head;
		}
		else{
			prevnode2.next=head;
		}
		node t=head.next;
		head.next=min.next;
		min.next=t;
		head=min;
		sort(head.next);
	}


	public static void main(String[] args){
		System.out.println("Enter ten Elements of the list:");
		int n[]=new int[100];
		Scanner s =new Scanner(System.in);
		for(int i=0;i<10;i++){
			n[i]=s.nextInt();
		}
		Selectionsort2 list=new Selectionsort2();
		for(int j=0;j<10;j++){
			list.push(n[j]);
		}
		System.out.println("The entered list before sorting");
		list.traverse(list.Head);
		list.sort(list.Head);
		System.out.println("\n"+"The sorted list");
		list.traverse(list.Head);	
	} 
}

