//Question link https://www.geeksforgeeks.org/problems/euler-circuit-in-a-directed-graph/1

class Solution
{
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj)
    {
        int deg = 0;
        for(int i=0;i<v;i++){
            if(adj.get(i).size()%2==0){
                deg++;
            }
        }
        if(deg==v){
            return true;
        }
        return false;
        
    }
}