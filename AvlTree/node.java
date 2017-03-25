package AvlTree;
public class node {
	int key;
	int height;
	node right;
	node left;
	node parent;
	node(int n){
		key=n;
		right=null;
		left=null;
		parent=null;
		height=1;
	}
}

