package newjava;
import java.util.*;
//import newjava.Searchinbst.Node;

// time complexity is o(h);
public class dnode {
static class Node {
	int data;
	Node left;
	Node right;
	Node(int data)
	{
		this.data = data;
	}
}
public static Node insert(Node root, int val)
{
	if( root == null )
	{
		root = new Node(val);
	     return root;
	}
	if(root.data > val)
	{
		root.left = insert(root.left,val);
	}
	else {
		root.right = insert(root.right,val);
	}
	return root;
}
public static Node delete(Node root, int val)
{
	
	if(root.data > val)
	{
		root.left = delete(root.left,val);
	}
	else  if(root.data < val)
	{
		root.right = delete(root.right,val);
	}
	else {
		if(root.left == null && root.right ==  null)
		{
			return null;
		}
		else if(root.left == null)
		{
			return root.right;
		}
		else if(root.right == null)
		{
			return root.left;
		}
		Node IS = inordersucc(root.right);
		root.data = IS.data;
		root.right = delete(root.right,IS.data);
	}
		return root;
	}
	public static Node inordersucc(Node root)
	{
		while(root.right != null)
		{
		root =	root.left;
		}
		return root;
	}

public static void inorder(Node root)
{
	if(root == null)
	{
		return;
	}
	inorder(root.left);
	System.out.print(root.data + " ");
	inorder(root.right);
}
public static boolean search(Node root, int key)
{
	if( root == null)
	{
		return false;
	}
	if(root.data > key) 
	{
		return search(root.left,key);
	}
	if( root.data == key)
	{
		return true;
	}
	else {
		return search(root.right,key);
	}
}
public static void main(String args[])
{ 
	Scanner scn = new Scanner(System.in);
	int a = scn.nextInt();
	int values[] = new int[a];
	Node root = null;
	int del = scn.nextInt();
	for(int i=0;i<a;i++)
	{
		values[i] = scn.nextInt();
	}
//	int key = scn.nextInt();
	for(int i=0;i<values.length;i++)
	{
		root = insert(root,values[i]);
	}
	inorder(root);
	System.out.println();
	
	System.out.println();
//	if(search(root,key))
//	{
//		System.out.println("Found");
//	}
//	else {
//		System.out.println("Not Found");
//	}
	delete(root,del);
	inorder(root);
	delete(root,del);
}
}
