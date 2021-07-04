package com.bridgelabz.binary;

public class MyBinary<K extends Comparable<K>>
{	
	private BinaryNode<K> root;
	
	
	public void add(K key)
	{
		this.root = this.insertData(root,key);
	}

	public BinaryNode<K> insertData(BinaryNode<K> current, K key)
	{
		if(current ==  null)
			return new BinaryNode<>(key);
		int compareResult = key.compareTo(current.key);
		if(compareResult==0) return current;
		if(compareResult<0)
		{
			current.left = insertData(current.left, key);
		}
		else 
		{
			current.right = insertData(current.right, key);
		}
		return current;
	}
	public BinaryNode<K> search(BinaryNode<K> current ,K key)
	{
		if(current==null || root.key == key)
		{
			return root;
		}
		if(root.key.compareTo(key)<0)
		{
			return search(current.right, key);
		}
		return search(current.left, key);
	}
	
	public int getSize() 
	{
		return this.getSizeBinary(root);
	}
	
	public int getSizeBinary(BinaryNode<K> current)
	{
		return current == null ? 0 : 1 + this.getSizeBinary(current.left)+this.getSizeBinary(current.right);
	}
	@Override
	public String toString() {
		return "MyBinary [root=" + root + "]";
	}

	public MyBinary() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		MyBinary<Integer> binaryTree = new MyBinary<>();
		binaryTree.add(56);
		binaryTree.add(30);
		binaryTree.add(70);
		binaryTree.add(22);
		binaryTree.add(40);
		binaryTree.add(60);
		binaryTree.add(95);
		binaryTree.add(11);
		binaryTree.add(65);
		binaryTree.add(3);
		binaryTree.add(16);
		binaryTree.add(63);
		binaryTree.add(67);
		int size = binaryTree.getSize();
		System.out.println(binaryTree);
		System.out.println("size of binary tree:"+size);
		
		if(binaryTree.search(root, 22))
		{
			System.out.println("yes");
		}
		else
			System.out.println("no");
	}

}
