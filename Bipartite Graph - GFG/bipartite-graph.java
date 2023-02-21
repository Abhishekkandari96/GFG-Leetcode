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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean checkBFS (int start, int visited[],ArrayList<ArrayList<Integer>>adj){
        visited[start]=1;
            Queue<Integer> q=new LinkedList<>();
            q.add(start);
            while(q.size()>0){
               int node=q.remove();
               
               for(int nbr:adj.get(node)){
                   
                   if(visited[nbr]==0){
                      int nbrcolor= visited[node]==1?2:1;
                       visited[nbr]=nbrcolor;
                       q.add(nbr);
                   }
                   else if(visited[nbr]==visited[node]) return false;
                   else {
                       continue;
                   }
               }
            }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // 0-> uncolored , 1->red , 2 ->blue;
        int visited[]=new int[V];
        
         for(int i=0;i<V;i++){
         
         if(visited[i]==0){
             boolean check=checkBFS(i,visited,adj);
             if(check==false) return false;
         }
             
         }
         return true;
            
        
    }
}