class Solution {
    public int solution(int[] stones, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0; i< stones.length; i++)
        {
            if(min > stones[i]) min = stones[i];
            if(max < stones[i]) max = stones[i];
        }
        
        while(min <= max)
        {
            int mid = (min+max) / 2;
            if(canTheyMove(stones, mid, k))
            {
                min = mid + 1;
            }
            else max = mid - 1;
        }
        
        return min;
    }
    public boolean canTheyMove(int[] stones, int n, int k)
    {
        int count = 0;
        for(int i=0; i<stones.length; i++)
        {
            if(stones[i] - n <= 0) count +=1;
            else count = 0;
            if(count >= k) return false;
        }
        return true;
    }
}