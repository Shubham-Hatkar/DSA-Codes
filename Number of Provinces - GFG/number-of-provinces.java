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
    private static void DFS(int src, ArrayList<ArrayList<Integer>> adj, boolean vis[])
    {
        vis[src] = true;
        
        for(int i = 0; i < adj.size(); i++)
        {
            if(adj.get(src).get(i) == 1 && vis[i] == false)
            {
                DFS(i, adj, vis);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) 
    {
        boolean vis[] = new boolean[V+1];
        int count = 0;
        for(int i = 0; i < V; i++)
        {
            if(vis[i] == false)
            {
                count++;
                DFS(i, adj, vis);
            }
        }
        return count;
    }
};