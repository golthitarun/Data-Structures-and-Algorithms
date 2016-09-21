import java.util.Scanner;
public class SelectionSort1 {
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
		node temp=head;
		while(temp!=null){
			if(head.data>temp.data){
				//if (head==temp){
					//return;		
			//	}
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
					if(curnode2==temp){
						break;
					}
					prevnode2=curnode2;
					curnode2=curnode2.next;
				}
				if(prevnode1==null){
					Head=temp;
				}
				else{
					prevnode1.next=temp;
				}
				if(prevnode2==null){
					Head=head;
				}
				else{
					prevnode2.next=head;
				}
				node t=head.next;
				head.next=temp.next;
				temp.next=t;
				head=temp;
			}
			temp=temp.next;
			}
		sort(head.next);
		}


	public static void main(String[] args){
		System.out.println("Enter ten Elements of the list:");
		int n[]=new int[100];
		Scanner s =new Scanner(System.in);
		for(int i=0;i<10;i++){
			n[i]=s.nextInt();
		}
		SelectionSort1 list=new SelectionSort1();
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


