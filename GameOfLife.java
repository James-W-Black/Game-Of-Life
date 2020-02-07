package CodilityChallanges;

import java.util.Scanner;

public class GameOfLife {

	public final static int SIZE = 4;
	
	public static void main(String[] args) 
	{
		boolean run = true;
		
		//create 2d array to represent the grid
		boolean[][] cells = new boolean[SIZE][SIZE];
		
		//randomly initialise and print the grid
		for(int i=0; i<SIZE; i++)
		{
			for(int j=0; j<SIZE; j++)
			{
				cells[i][j] = (Math.random() < 0.25);
			}
			
		}
		
		//print the boards first state
		printGrid(cells);
		
		//while run is true, ask the user to either go to next generation or end the cycle
		//run is then updated based off checkForTrue, which will set run to false if there is no alive cells left
		//to continue the cycle
		while(run)
		{
			System.out.println("Press n for next or e to exit: ");
			
			Scanner sc = new Scanner(System.in);
			String proceed = sc.next();
			
			if(proceed.equals("e"))
			{
				System.exit(0);
			}
			
			cells = nextGeneration(cells);
			printGrid(cells);
			
			run = checkForTrue(cells);
		}
		

	}
	
	public static boolean checkForTrue(boolean[][] cells) 
	{
		for(int i=0; i<SIZE; i++)
		{
			for(int j=0; j<SIZE; j++)
			{
				if(cells[i][j] == true) return true;
			}
			
		}
		
		return false;
	}
	
	
	//takes cells and runs through each element, counting its neighbours, when on an edge piece the grid loops back, for example
	//if you take position cells[0][0] and go left you will now be on cells[0][SIZE-1]. Same applies for going above and below the grid
	public static boolean[][] nextGeneration(boolean[][] cells)
	{
		
		boolean[][] cells2 = new boolean[SIZE][SIZE];
		
		for(int i=0; i<SIZE; i++)
		{
			int above, below, left, right;
				
			above = i>0 ? i-1 : SIZE-1;
			below = i<SIZE-1 ? i+1 : 0;
			
			for(int j=0; j<SIZE; j++)
			{
				
				left = j > 0 ? j-1 : SIZE-1;
				right = j < SIZE-1 ? j+1 : 0;
				
				int n =0;
				
				if(cells[above][left]) n++;
				if(cells[above][right]) n++;
				if(cells[above][j]) n++;
				if(cells[i][left]) n++;
				if(cells[i][right]) n++;
				if(cells[below][right]) n++;
				if(cells[below][left]) n++;
				if(cells[below][j]) n++;
				
				//check if alive to then change its state
				if(cells[i][j])
				{
					if(n==2 || n==3)
					{
						cells2[i][j] = true;
					}else 
					{
						cells2[i][j] = false;
					}
					
				}else {
					//if cell is false/ dead
					if(n == 3)
					{
						cells2[i][j] = true;
					}
				}
				
			}
			
		}
		
		return cells2;
	}
	
	public static void printGrid(boolean[][] cells)
	{
		for(int i=0; i<SIZE; i++)
		{
			for(int j=0; j<SIZE; j++)
			{	
				if(cells[i][j]) 
				{
					System.out.print("1");
				}else
				{
					System.out.print("0");
				}
				
			}
			
			System.out.println();
		}
	}

}
