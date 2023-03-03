//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Pair{
    int r;
    int c;
    int d;
    Pair(int r, int c, int d){
        this.r=r;
        this.c=c;
        this.d=d;
    }
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        int dist[][]=new int[n][m];
        
        boolean visited[][]=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    visited[i][j]=true;
                    q.add(new Pair(i,j,0));;
                    dist[i][j]=0;
                }
            }
        }
        
        while(q.size()>0){
            
            Pair pop=q.remove();
            int r=pop.r;
            int c=pop.c;
            int d=pop.d;
            int row[]={0,-1,0, 1};
            int col[]={-1,0,1,0};
            for(int i=0;i<4;i++){
                int nr=r+row[i];
                int nc=c+col[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==false){
                    dist[nr][nc]=d+1;
                    visited[nr][nc]=true;
                    q.add(new Pair(nr,nc,d+1));
                }
            }
        }
        return dist;
    }
}