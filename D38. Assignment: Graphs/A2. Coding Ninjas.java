Coding Ninjas

Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an edge or a corner with the cell.

Input Format :
The first line of input contains two space separated integers N and M, where N is number of rows and M is the number of columns in the matrix. 
Each of the following N lines contain M characters. Please note that characters are not space separated.
Output Format :
Print 1 if there is a path which makes the sentence “CODINGNINJA” else print 0.

Constraints :
1 <= N <= 1000
1 <= M <= 1000
Time Limit: 1 second

Sample Input 1:
2 11
CXDXNXNXNXA
XOXIXGXIXJX
Sample Output 1:
1

Code:

public class Solution {
	
	int solve(String[] Graph , int N, int M)
	{
		String str = "CODINGNINJA";
		boolean visited[][] = new boolean[ Graph.length ][];
		
		for( int i = 0; i < Graph.length; i++ ) {
			visited[i] = new boolean[ Graph[i].length() ];
		}
		
		for( int i = 0; i < Graph.length; i++ ) {
			for( int j = 0; j < Graph[i].length(); j++ ) {
				if( Graph[i].charAt(j) == 'C' ) {
					boolean ans = dfs( Graph, visited, str.substring(1), i, j);
					if( ans ) {
						return 1;
					}
				}
			}
		}
		
		return 0;
	}
	
    private static boolean dfs(String[] graph, boolean[][] visited, String str, int i, int j) {
		
		if( str.length() == 0 ) {
			visited[i][j] = true;
			return true;
		}
		
		visited[i][j] = true;
		// to traverse in 8 different directions
		int xdir[] = { -1, 1, 0, 0, 1, -1, 1,-1 }; 
		int ydir[] = {  0, 0,-1, 1, 1, -1,-1, 1 };
		
		for( int k = 0; k < xdir.length; k++ ) {
			
			int x = i + xdir[k];
			int y = j + ydir[k];
			
			if( x >= 0 && y >= 0 && x < graph.length && y < graph[x].length() && graph[x].charAt(y) == str.charAt(0) && !visited[x][y] ) {
				
				boolean smallAns = dfs( graph, visited, str.substring(1), x, y);
				if( smallAns ) {
					return smallAns;
				}
			}
		}
		
		visited[i][j] = false;
		return false;
	}

	
}
