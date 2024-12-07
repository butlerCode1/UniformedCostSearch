package ucs;

/**
 * The Matrix class creates the adjacency matrix
 * used by the uniform-cost-search algorithm.
 * The matrix is a two-dimensional array of integers.  
 * Nodes in the matrix that are adjacent have a value
 * of 1.  Nodes in the matrix that are not adjacent
 * have a value of 0.
 * @author susie
 *
 */
public class Matrix {
    
    int [][] matrix;
      
    /**
     * Initializes a matrix having the specified number
     * of rows and columns.
     * @param rows specified rows
     * @param columns specified columns
     */
    public Matrix (int rows, int columns){
        
        matrix = new int [rows][columns];
     
    }
    
    public void connectNodes (int row, int column, int cost){
        
    	matrix[row][column] = cost;
        
    }
    
    public void displayMatrix (){
        
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + "\t");
            }

            System.out.print("\n");
        }
        
    }
    
    public boolean isNodeAdjacent (int row, int column){
        
        return (matrix[row][column] != 0);
        
    }
    
    public void resetNodes (){
    	
    	for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = 0;
            }
        }
    }
    
    public int getCost (int row, int column){
        return (matrix[row][column]);
    }
    
}