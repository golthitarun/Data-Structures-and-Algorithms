package AvlTree;
import AvlTree.node;
public class Avlinsert {
  node root;
  int max(node a, node b){
	  if(a==null && b== null){
		  return 0;
	  }
	  if(a==null){
		  return b.height;
	  }
	  else if(b==null){
		  return a.height;
	  }
	  
	  if(a.height>b.height){
		  return a.height;
	  }
	  else{
		  return b.height;
	  }
	  
  }
  int check_balance(node n){
	  if(n.left==null){
		 return -n.right.height;
	  }
	  else if(n.right==null){
		 return n.left.height;
	  }
	  return (n.left.height-n.right.height);
  }
  node LeftRotate(node n){
	  node temp1=n;
	  node temp2=n.right.left;
	  n=n.right;
	  n.parent=temp1.parent;
	  if(n.parent!=null){
		  if(temp1.parent.right==temp1){
			  n.parent.right=n;
		  }
		  else{
		  n.parent.left=n;}
	  }
	  n.left=temp1;
	  n.left.parent=n;
	  n.left.right=temp2;
	  if(temp2!=null){
		  n.left.right.parent=temp1;
	  }
	  n.left.height=max(n.left.left,n.left.right)+1;
	  n.height=max(n.left,n.right)+1;
	  return n;
  }
  node RightRotate(node n){
	  node temp1=n;
	  node temp2=n.left.right;
      n=n.left;
	  n.parent=temp1.parent;
	  if(n.parent!=null){
		  if(temp1.parent.right==temp1){
			  n.parent.right=n;
		  }
		  else{
		  n.parent.left=n;}
	  }
	  n.right=temp1;
	  n.right.parent=n;
	  n.right.left=temp2;
	  if(temp2!=null){
	  n.right.left.parent=temp1;
	  }
	  n.right.height=max(n.right.left,n.right.right)+1;
	  n.height=max(n.left,n.right)+1;
	  return n;
  }
  void inorder(node r){
	  if(r==null){
		  return;
	  }
	  
	  inorder(r.left);
	  
	  inorder(r.right);
	  System.out.print(r.key+" ");
  }
//  node largest(node r,node large){
//	  
//	  if(r==null){
//		  return large;
//	  }
//	  if(r.key>large.key){
//		  large=r;
//	  }
//	  return largest(r.left,large);
//  }
  void insert(node n,node par,int d){
	  if(n==null){
		  node t=new node(d);
		  if(root==null){
			  root=t;
			  return;
		  }
		  if(par.key<d){
			  par.right=t;
		  }
		  else{
			  par.left=t;
		  }
		  n=t;
		  t.parent=par;
		  return;
	 }
	  if(n.key<=d){
		  insert(n.right,n,d);
		  }
	  else{
		  insert(n.left,n,d);
	  }
	  n.height=max(n.left,n.right)+1;
	  int balance;
	  balance=check_balance(n);
	  if(balance<-1&&d>n.right.key){
		  node t=n;
		  n=LeftRotate(n);
		  if(t==root){
			  root=n;
		  }
		  return;
		  
	  }
	  if(balance>1&&d<n.left.key){
		  node t=n;
		  n=RightRotate(n);
		  if(t==root){
			  root=n;
		  }
		  return;
	  }
	  if(balance<-1&&d<n.right.key){
		  n.right=RightRotate(n.right);
		  node t=n;
		  n=LeftRotate(n);
		  if(t==root){
			  root=n;
		  }
		  return;
	  }
	  if(balance>1&&d>n.left.key){
		  node t=n;
		  n.left=LeftRotate(n.left);
		  n=RightRotate(n);
		  if(t==root){
			  root=n;
		  }
		  return;
	  }
 }
 void Equal(node a,node b,boolean flag){
	 if(flag==true){
		 System.out.println("They are not equal");
		 return;
	 }
	 if((a==null) || (b==null)){
		 return;
	 }
	 if(a.key!=b.key){
		 flag=true;
		 //System.out.println("They are not equal");
	 }
	 Equal(a.left,b.left,flag);
	 Equal(a.right,b.right,flag);
	 if(flag!=true){
	 System.out.println("They are equal");}
 }
  public static void main(String[] args){
	  
	  
	  Avlinsert tree= new Avlinsert();
	  tree.insert(tree.root, null, 7);
	  System.out.println("");
	  tree.inorder(tree.root);
	  tree.insert(tree.root, null, 9);
	  System.out.println(" ");
	  tree.inorder(tree.root);
	  tree.insert(tree.root, null, 13);
	  System.out.println("");
	  tree.inorder(tree.root);
	  tree.insert(tree.root, null, 21);
	  System.out.println(" ");
	  tree.inorder(tree.root);
	  tree.insert(tree.root, null, 34);
	  System.out.println(" ");
	  tree.inorder(tree.root);
	  tree.insert(tree.root, null, 36);
	  System.out.println(" ");
	  tree.inorder(tree.root);
	  tree.insert(tree.root, null, 45);
	  System.out.println(" ");
	  tree.inorder(tree.root);
	  tree.insert(tree.root, null, 54);
	  System.out.println(" ");
	  tree.inorder(tree.root);
	  tree.insert(tree.root, null, 65);
	  System.out.println(" ");
	  tree.inorder(tree.root);
	  tree.insert(tree.root, null, 87);
	  System.out.println(" ");
	  tree.inorder(tree.root);
	  
	  Avlinsert tr= new Avlinsert();
	  tr.insert(tr.root, null, 7);
	  System.out.println("");
	  tr.inorder(tr.root);
	  tr.insert(tr.root, null, 9);
	  System.out.println(" ");
	  tr.inorder(tr.root);
	  tr.insert(tr.root, null, 13);
	  System.out.println("");
	  tr.inorder(tr.root);
	  tr.insert(tr.root, null, 21);
	  System.out.println(" ");
	  tr.inorder(tr.root);
	  tr.insert(tr.root, null, 34);
	  System.out.println(" ");
	  tr.inorder(tr.root);
	  tr.insert(tr.root, null, 36);
	  System.out.println(" ");
	  tr.inorder(tr.root);
	  tr.insert(tr.root, null, 45);
	  System.out.println(" ");
	  tr.inorder(tr.root);
	  tr.insert(tr.root, null, 5);
	  System.out.println(" ");
	  tr.inorder(tr.root);
	  tr.insert(tr.root, null, 65);
	  System.out.println(" ");
	  tr.inorder(tr.root);
	  tr.insert(tr.root, null, 87);
	  System.out.println(" ");
	  tr.inorder(tr.root);
	  tree.Equal(tree.root,tr.root,false);
  }
}
