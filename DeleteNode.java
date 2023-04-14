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
