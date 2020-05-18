class Solution {
    boolean finished = false;
    int[] weak, dist, distPermutation;
    int numOfFriends = 0, n;
    int[][] weakMaps;
    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        int answer = 0;
        this.weak = weak;
        this.dist = dist;
        weakMaps = new int[weak.length][weak.length];
        setWeak();
        for(int i=1; i<=dist.length; i++)
        {
            numOfFriends = i;
            distPermutation = new int[i];
            permutation(0, new boolean[dist.length]);
            if(finished) break;
        }
        
        return (finished) ? numOfFriends : -1;
    }
    
    public void permutation(int depth, boolean[] visited)
    {
        if(finished) return;
        if(depth == numOfFriends)
        {
            check();
            return;
        }
        for(int i=0; i<dist.length; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                distPermutation[depth] = dist[i];
                permutation(depth+1, visited);
                visited[i] = false;
            }
        }
    }
    
    public void check()
    {
        for(int[] weak: weakMaps)
        {
            boolean[] visit = new boolean[weak.length];
            int idx=0, start =0;
            while(idx!=numOfFriends)
            {
                int value = distPermutation[idx++];
                int i = start;
                for(int j=start; j<weak.length; j++)
                {
                    if(!(weak[i]<=weak[j] && weak[j]<=weak[i]+value)) break;
                    visit[j] = true;
                    start++;
                }
            }
            if(isFinished(visit))
            {
                finished = true;
                return;
            }
        }
    }
    
    public boolean isFinished(boolean[] visit)
    {
        for(boolean each: visit)
        {
            if(!each) return false;
        }
        return true;
    }
    
    public void setWeak()
    {
        for(int i=0; i<weak.length; i++)
        {
            int[] newWeak = new int[weak.length];
            for(int j=0; j<weak.length; j++)
            {
                newWeak[j] = weak[(j+i)%weak.length] + (((j+i)>=weak.length) ? n : 0);
            }
            weakMaps[i] = newWeak;
        }
    }
}