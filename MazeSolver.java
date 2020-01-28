 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MazeSolver {

	public static void main(String[] args) {
		
		
		 try {
             
			 BufferedReader in = new BufferedReader(new FileReader("maze2.txt"));
	           
			 String line;
			 int lineNumber = 0;
			 int mazeRows = 0;
			 int mazeColumns = 0;
			 int[][] maze = null;
			 
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
	          
	         printMaze(maze);
	         
	         
	         
	         in.close();
		 }  catch (IOException e) {
	            System.out.println("I/O Error: " + e.getMessage());
	        }
		 

	}
	
	public static void printMaze(int[][] table) {
		int rows = table.length;
		int cols = table[0].length;
		for(int i= 0; i < rows; i++) {
			for(int j=0; j < cols; j++) {
				System.out.print(table[i][j]);
				System.out.print(" ");
			}
			System.out.println(" ");
		}
		
		
	}
	
	

}
