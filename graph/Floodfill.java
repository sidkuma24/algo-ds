package graphs;

/*************************************************
 * 
 * @author siddharth
 *   
 *  The idea is simple, we first replace the color of current pixel, 
 *  then recur for 4 surrounding points.
 *  
 *  A recursive function to replace previous color 'prevC' at  '(x, y)' 
 *  and all surrounding pixels of (x, y) with new color 'newC' and
 *  floodFil(screen[M][N], x, y, prevC, newC)
 *  1) If x or y is outside the screen, then return. 
 *  2) If color of screen[x][y] is not same as prevC, then return
 *  3) Recur for north, south, east and west.
 *  floodFillUtil(screen, x+1, y, prevC, newC);
 *  floodFillUtil(screen, x-1, y, prevC, newC);
 *  floodFillUtil(screen, x, y+1, prevC, newC);
 *  floodFillUtil(screen, x, y-1, prevC, newC); 
 *  
 *  (Description from : https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/)
 */

public class Floodfill {
	
	public static void floodFillUtil(int[][] screen, int x, int y, int prevC, int newC) {
		int M = screen.length;
		int N = screen[0].length;
		
		if(x < 0 || y < 0 || x >= M || y >= N )
			return;
		
		if(screen[x][y] != prevC)
			return;
		
		screen[x][y] = newC;
		
		floodFillUtil(screen, x+1, y, prevC, newC);
		floodFillUtil(screen, x-1, y, prevC, newC);
		floodFillUtil(screen, x, y+1, prevC, newC);
		floodFillUtil(screen, x, y-1, prevC, newC);
	}
	
	public static void floodFill(int [][] screen, int x, int y, int newC) {
		int prevC = screen[x][y];
		floodFillUtil(screen, x, y, prevC, newC);
	}
	
	public static void printScreen(int [][] screen) {
		for(int i=0; i < screen.length; ++i) {
			for(int j=0;j < screen[0].length; ++j) {
				System.out.print(screen[i][j] + " ");
				
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int 
		M = 5,
		N = 5,
		screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
               };
		
		floodFill(screen, 4, 4, 5);
		
		printScreen(screen);
		
		
		
		
	}
}

