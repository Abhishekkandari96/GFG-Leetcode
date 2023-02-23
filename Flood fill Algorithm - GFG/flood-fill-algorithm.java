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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends

class Pair{
    int sr;
    int sc;
    Pair(int sr, int sc){
        this.sr=sr;
        this.sc=sc;
    }
}
class Solution
{
    public void bfs(int sr,int sc,int[][] image,int newcolor,boolean[][]visited, int inicolor){
       
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        int n=image.length;
        int m=image[0].length;
        while(q.size()>0){
            
            Pair remove=q.remove();
            int row=remove.sr;
            int col=remove.sc;
           
            image[row][col]=newcolor;
             int delrow[] = {-1,0,+1,0};
             int delcol[] = {0,+1,0,-1};
            for(int i=0;i<4;i++)
            {
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==inicolor && !visited[nrow][ncol])
                {
                     visited[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int n=image.length;
        int m=image[0].length;
        boolean[][] visited=new boolean[n][m];
        int inicolor=image[sr][sc];
        
        bfs(sr,sc,image,newColor,visited,inicolor);
        return image;
    }
}