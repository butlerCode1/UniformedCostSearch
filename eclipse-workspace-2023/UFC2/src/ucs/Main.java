package ucs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		
		/* Create the matrix */
        int rows = 7;
        int columns = 7;
        
        Matrix m = new Matrix (rows, columns);
        
        /* Connect the nodes in the matrix */
        /* These connections mean ...
         * node 0 is connected to node 1 at a cost of 2
         * node 0 is connected to node 2 at a cost of 3
         * node 1 is connected to node 3 at a cost of 4
         * node 2 is connected to node 3 at a cost of 2
         * node 2 is connected to node 4 at a cost of 4
         * node 3 is connected to node 5 at a cost of 2
         * node 4 is connected to node 5 at a cost of 1
         */
        m.connectNodes(0, 1, 1);
        m.connectNodes(0, 3, 4);
        m.connectNodes(1, 3, 3);
        m.connectNodes(1, 2, 1);
        m.connectNodes(1, 4, 3);
        m.connectNodes(2, 3, 1);
        m.connectNodes(2, 4, 1);
        m.connectNodes(3, 4, 1);
        m.connectNodes(4, 5, 3);
        
        /* Establish the root and goal */
        int root = 0;
        int goal = 5;
        
        run(m, root, goal, columns);
        
	}
	
	public static void run (Matrix m, int root, int goal, int nodes){
		
		/* Create a node for the root */
        Node rnode = new Node (root, 0, 0);
        
        /* Create a node used to store dequeued nodes */
        Node node = new Node();
        
        int iteration = 1;
        
        /* Create the queue */
        Comparator<Node> comparator = new NodeComparator();
		PriorityQueue<Node> queue = 
	            new PriorityQueue<Node>(10, comparator);
		
		/* Enqueue the root node */
		queue.add(rnode);
		
		System.out.println("Priority queue at iteration " + iteration + ":");
		System.out.println(rnode);
		
		/* While the queue is not empty */
		while (queue.size() != 0){
			
			/* Dequeue a node */
			node = queue.remove();
			
			System.out.println("\nRemoved node is" + node.toString());		
			iteration++;
			
			/* If the dequeued node is equal to the goal, display
			 * its cost and stop searching */
			if (node.getNode() == goal){
				System.out.println("Cost is : " + node.getCost());
				break;
			}
			
			/* Loop through all of the nodes in the graph (columns in
             * the matrix) starting with the root */
			for (int i = 0; i < nodes; i++){
				
				/* If the current node is adjacent to the dequeued node */
				if (m.isNodeAdjacent(node.getNode(), i)){
					/* Calculate the aggregate cost and add the node to the queue */
                    queue.add(new Node (i, node.getCost() + m.getCost(node.getNode(), i), node.getNode()));
				}
			}
			
			System.out.println("\nPriority queue at iteration " + iteration + ":");
			/* Display queue */
			Object arrNode [] = queue.toArray();
		    Arrays.sort(arrNode);
		    for (int i = 0; i < arrNode.length; i++){
		    	System.out.println(arrNode[i].toString());
		    }
		    System.out.println();
		}
	}
}