class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start=0, left, right;
        for(int i=0; i<stations.length; i++)
        {
            left = stations[i]-1 -w;
            right = stations[i]-1+w;
            while(start<left)
            {
                start+=2*w+1;
                answer+=1;
            }
            start = right+1;
        }
        while(start<n)
        {
            start+=2*w+1;
            answer+=1;
        }

        return answer;
    }
}