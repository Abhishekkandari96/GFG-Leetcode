//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int r;
    int c;
    Pair(int r, int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {

    int numberOfEnclaves(int[][] grid) {
    int n=grid.length;
    int m=grid[0].length;
    boolean visited[][]=new boolean[n][m];
    
    Queue<Pair> q=new LinkedList<>();
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==1&&(i==0 || j==0 ||i==n-1|| j==m-1)){
                q.add(new Pair(i,j));
                visited[i][j]=true;
            }
        }
    }
    
    while(q.size()>0){
        Pair pop=q.remove();
        int r=pop.r;
        int c=pop.c;
        int row[]={-1,0,+1,0};
        int col[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr=r+row[i];
            int nc=c+col[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==false && grid[nr][nc]==1 ){
                 q.add(new Pair(nr,nc));
                visited[nr][nc]=true;
                
            }
            
        }
        
    }
    int count=0;
     for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==1 && visited[i][j]==false){
                count++;
            }
        }
    }
    return count;
       
    }
}