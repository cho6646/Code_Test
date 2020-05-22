class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        if(len <= 3)
        {
            int max = 0;
            for(int i=0; i<len; i++)
            {
                max = Math.max(max, sticker[i]);
            }
            return max;
        }
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        dp1[0] = 0;
        dp1[1] = sticker[1];
        dp2[0] = sticker[0];
        dp2[1] = sticker[0];
        for(int i=2; i<len-1; i++)
        {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+sticker[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+sticker[i]);
        }
        int i = len-1;
        dp1[i] = Math.max(dp1[i-2]+sticker[i], dp1[i-1]);
        dp2[i] = Math.max(dp2[i-2], dp2[i-1]);
        
        return Math.max(dp1[i], dp2[i]);
    }
}