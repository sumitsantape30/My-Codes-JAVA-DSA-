package TakeInputIteratively;

import java.util.Scanner;

public class TakeInputLevelWise {

	//beacuse hum recusrion use nhi kr rhe hai iske andar so we don't have to pass Scanner, it's okay if this function creates the Scanner itself
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner s= new Scanner(System.in);
		
		//we need a queue, Queue ke andar binary tree node dalenge, and Binary tree node integer type ka hai
		//this is pending node, yeh woh nodes hai jinke child nhi puche abhitak (isme woh nodes rahenge jinke humne child nhi puche abhitak)(e.g. maine 1 input liya, 1 to aagya but 1 ke children nhi aaye to mai 1 ko uthake pendingnodes mai dal dunga taki mai next time 1 ke children puch lu
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes= new QueueUsingLL<>();
		
		//root ka data input lenge and uske corresponding node banake queue mai dal denge
		System.out.println("Enter the root data");
		int rootData= s.nextInt();
		BinaryTreeNode<Integer> root= new BinaryTreeNode<>(rootData);
	
		if( rootData == -1) { //this is edge case 
			return null; // agar input nhi dena chahta means -1 dega to hum null return kar denge
		}
		
		pendingNodes.enqueue(root); //apne queue ke andar root ko dal rhe
		
		while( ! pendingNodes.isEmpty()) { //tabtak kam karenge jabtak humari queue puri khali nhi hojati
			 // jo bhi queue mai sabse aage node hai uske children puchne hai
			//kya kam karenge? queue mai jo element sabse aage(front) hoga usko bahar nikal lenge
			
			BinaryTreeNode<Integer> front= pendingNodes.dequeue();
			
			//front aagya, ab front ka left and right child chahiye
			System.out.println("Enter left child of "+front.data);
			int leftChild= s.nextInt();
			
			//i am going to make the node of left only if it is not equal to -1
			if( leftChild != -1) { //-1 ka matlab hai woh nhi lagana chahta left child, woh null chahta hai wahape
				//left ka node banake queue mai dalenge and jo front hai uske left mai dalenge
				BinaryTreeNode<Integer> child= new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.enqueue(child);
				front.left= child; //humne front ka left child pucha tha upar so left milne ke bad usko left mai dal denge
			}
			
			//Exactly same kam hume right keliye karna hai
			
			//front ka left child aagya, ab front ka right child chahiye
			System.out.println("Enter right child of "+front.data);
			int rightChild= s.nextInt();
			
			//i am going to make the node of right only if it is not equal to -1
			if( leftChild != -1) { //-1 ka matlab hai woh nhi lagana chahta right child, woh null chahta hai wahape
				//right ka node banake queue mai dalenge and jo front hai uske right mai dalenge
				BinaryTreeNode<Integer> child= new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.enqueue(child);
				front.right = child;
			}
			
		}
		return root;		
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		 Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
			
		   queue.add(root);
		  // queue.add(null);
			
		   while ( !queue.isEmpty() ) {
			    
			   BinaryTreeNode<Integer> frontNode = queue.poll();
			   
			   
				   
				   System.out.print(frontNode.data +":");
			   
			   if ( frontNode.left != null) {

					System.out.print("L:" + frontNode.left.data +",");
					queue.add(frontNode.left);
			   } 
			   else
			   {
				   System.out.print("L:"+ -1 + ",");
			   }

				if ( frontNode.right != null) {

					System.out.print("R:" + frontNode.right.data );
					queue.add(frontNode.right);
				}
			    else 
			    {
				    System.out.print("R:" + -1 );
			    }
			    
				System.out.println();
		   }

	}
	public static void main(String[] args)  {

		BinaryTreeNode<Integer> root= takeInputLevelWise();
		printLevelWise(root);
	}

}
