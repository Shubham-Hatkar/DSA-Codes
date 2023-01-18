//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution 
{
    boolean BFS(int src, ArrayList<ArrayList<Integer>> adj, boolean vis[], int parent[] )
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src] = true;
        parent[src] = -1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                int temp = q.remove();
                
                for(int nbr : adj.get(temp))
                {
                    if(vis[nbr] == false)
                    {
                        q.add(nbr);
                        vis[nbr] = true;
                        parent[nbr] = temp;
                    }
                    else if(vis[nbr] == true && nbr != parent[temp])
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean vis[] = new boolean[V];
        int parent[] = new int[V];
        for(int i = 0; i < V; i++)
        {
            if(vis[i] == false)
            {
                if(BFS(i, adj, vis, parent)) return true;
            }
        }
        return false;
    }
}