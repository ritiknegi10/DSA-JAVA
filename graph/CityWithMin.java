//Question: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CityWithMin {
      
      static int[] dijkstra(int V,ArrayList<ArrayList<Pair>> adj, int S){
            int arr[] = new int[V];
            boolean vis[] = new boolean[V];
            
            Arrays.fill(arr,Integer.MAX_VALUE);
            Arrays.fill(vis,false);
            
            PriorityQueue<Pair> q = new PriorityQueue<>();
            
            arr[S] = 0;
            q.add(new Pair(S,0));
            
            while(!q.isEmpty())
            {
                Pair cur = q.remove();
                int u = cur.v;
                if(vis[u])
                {
                    continue;
                }
                
                ArrayList<Pair> al = adj.get(u);
                
                for(Pair l :al)
                {
                    int v = l.v;
                    int wt = l.wt;
                    
                    if(!vis[v])
                    {
                        if(arr[v] > arr[u]+wt)
                        {
                            arr[v] = arr[u]+wt;
                            q.add(new Pair(v,arr[v]));
                        }
                    }
                }
            }
            
            return arr;
            
            
      }
      
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
         ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
         for(int i=0;i<n;i++)
         {
             adj.add(new ArrayList<Pair>());
         }
         for(int i=0;i<edges.length;i++)
         {
             int u=edges[i][0];
             int v=edges[i][1];
             int wt=edges[i][2];
             adj.get(u).add(new Pair(v,wt));
             adj.get(v).add(new Pair(u,wt));
         }
         
         
         int res=0;
         int size=Integer.MAX_VALUE;
         
        for(int i=0;i<n;i++){
             
            int arr[] = dijkstra(n,adj,i);
            int k=0;
            for(int j = 0 ;j<arr.length;j++)
            {
                // System.out.print(arr[j]+" ");
                if(arr[j]<=distanceThreshold)
                {
                    k++;
                }
            }
            
            if(size>=k  && res<=i)
                {
                    size=k;
                    res=i;
                }
                
            // System.out.println();
                
        }
         
         return res;
         
      }
}
 
class Pair implements Comparable<Pair>{
    int wt;
    int v;
    
    Pair(int v,int wt)
    {
        this.v=v;
        this.wt=wt;
    }
    
    public int compareTo(Pair that)
    {
        return this.wt-that.wt;
    }
    
}
