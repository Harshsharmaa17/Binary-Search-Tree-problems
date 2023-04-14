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
