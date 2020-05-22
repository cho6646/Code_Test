class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        // return answer;
        int len = cookie.length;
        int[] sumOfCookie = new int[len];
        sumOfCookie[0] = cookie[0];
        for(int i=1; i<len; i++)
        {
            sumOfCookie[i] = cookie[i] + sumOfCookie[i-1];
        }
        for(int m=0; m<len-1; m++)
        {
            int sum1 = sumOfCookie[m];
            for(int r = m+1; r<len; r++)
            {
                int sum2 = sumOfCookie[r]-sumOfCookie[m];
                if(sum2 > sum1 || answer > sum2) continue;
                if(sum2==sum1 && answer<sum2) 
                {
                    answer = sum2;
                    continue;
                }
                for(int l=0; l<m; l++)
                {
                    int sum1_ = sum1 - sumOfCookie[l];
                    if(sum1_ == sum2)
                    {
                        if(sum1_>answer) answer = sum1_;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}