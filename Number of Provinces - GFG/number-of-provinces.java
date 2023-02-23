//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void dfs(int i,ArrayList<ArrayList<Integer>> adj, boolean [] visited ){
        if(visited[i]) return;
        visited[i]=true;
        for(int vertex:adj.get(i)){
            if(!visited[vertex]) 
            dfs(vertex,adj,visited);
        }
        
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<V;i++){
           list.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        // code here
        boolean []visited=new boolean[V+1];
        int count=0;
        for(int i=0;i<V;i++){
            if(!visited[i]){ 
             count++;
                dfs(i,list,visited);
            }
        }
        return count;
        
    }
};