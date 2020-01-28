import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MazeSolver {

	public static void main(String[] args) {
		
		MazeSolver mazeSolver = new MazeSolver();
		
		mazeSolver.initializeMaze();
		
		mazeSolver.printMaze();
		
		boolean done=mazeSolver.findPath(0, 0);
        if (done) {
            System.out.println("There is a path from Start to End in this maze!");
        } else {
            System.out.println("There are no possible paths from Start to End.");
        }
        
        mazeSolver.printMaze();

	}
	
	 int[][] maze = null;
	 int TRIED = 2;
	 int PATH = 9;
	 
	public void printMaze() {
    		int rows = maze.length;
		int cols = maze[0].length;
		for(int i= 0; i < rows; i++) {
			for(int j=0; j < cols; j++) {
				System.out.print(maze[i][j]);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
		
		
	}
	
	
	 public boolean findPath(int row, int column) {
	        boolean done = false;
	        if (valid(row, column)) {
	            maze[row][column] = TRIED; // this cell has been tried, but blocked
	            if (row==maze.length-1 && column==maze[0].length-1)
	                done = true; // the maze is solved
	             else {
	                done = findPath(row + 1, column); // down
	                
	                if (!done) 
	                    done = findPath(row, column + 1); // right
	                if (!done) 
	                    done = findPath(row - 1, column); // up
	                if (!done) 
	                    done = findPath(row, column - 1); // left
	                    
	            }
	            if (done) 
	            	maze[row][column] = PATH;

	        }
	        return done;
	    }
	   
	
		
	 
		
	 private boolean valid(int row, int column) {
	        boolean result = false;
	        if (row >= 0 && row < maze.length
	                && column >= 0 && column < maze[row].length) // check if cell is not blocked and not previously tried
	        {
	            if (maze[row][column] == 0) {
	                result = true;
	            }
	        }
	        return result;
	    }
	 	
	
	 public void initializeMaze() {
		 try {
             
			 BufferedReader in = new BufferedReader(new FileReader("maze2.txt"));
	           
			 String line;
			 int lineNumber = 0;
			 int mazeRows = 0;
			 int mazeColumns = 0;
			
			  
			 //initialize the 2D maze
	          while ((line = in.readLine()) != null) {
	        	  if(lineNumber == 0) {
	        		  mazeRows = Integer.parseInt(line);
	        	  }
	        	  else if(lineNumber == 1) {
	        		  mazeColumns = Integer.parseInt(line);
	        		  maze= new int[mazeRows][mazeColumns];
	        	  } else {
	        		  String[] rowsCols = line.split("\\s+");
	        		  int rowNum = Integer.parseInt(rowsCols[0]);
	        		  int colNum = Integer.parseInt(rowsCols[1]);
	        		  maze[rowNum][colNum] = 1;
	        		  
	        	  }
	        	  lineNumber++;
	          }
	          in.close();
		 	}  catch (IOException e) {
	            System.out.println("I/O Error: " + e.getMessage());
	        }
	 }
	 
	
	

}