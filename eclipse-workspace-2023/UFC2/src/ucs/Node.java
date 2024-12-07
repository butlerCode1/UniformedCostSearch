package ucs;

/**
 * The Node class creates the nodes that get
 * placed in the queue by the uniform-cost-search algorithm.
 * Each node is an object of this class.  Each object has
 * an id, cost, and child id.  This class has accessor
 * methods that return the id, cost, and child id.  This
 * class has an overridden compare method that compares
 * the cost of two objects.
 * @author susie
 *
 */
public class Node implements Comparable<Object> {

	private int node;
	private int cost;
	private int parent;
	
	public Node(int node, int cost, int parent) {
		this.node = node;
		this.cost = cost;
		this.parent = parent;
	}
	
	public Node () {
        this.node = 0;
        this.cost = 0;
        this.parent = 0;
    }

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Node [node=" + node + ", cost=" + cost + ", parent=" + parent
				+ "]";
	}	
	
	@Override
	public int compareTo(Object arg0) {
		Node node = (Node) arg0;
		
		if (cost == node.getCost()) return 0;
		if (cost < node.getCost()) return -1;
		if (cost > node.getCost()) return 1;
		
		return 0;
	}
}