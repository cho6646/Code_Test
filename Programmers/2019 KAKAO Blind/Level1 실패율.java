import java.util.*;

class Solution {
    class FailRatio implements Comparable<FailRatio>
    {
        int stage;
        float failRatio;
        
        public FailRatio(int stage, float failRatio)
        {
            this.stage = stage;
            this.failRatio = failRatio;
        }
        
        @Override
        public int compareTo(FailRatio o)
        {
            if(o.failRatio - this.failRatio > 0) return 1;
            else if(o.failRatio-this.failRatio < 0) return -1;
            else
            {
                return this.stage - o.stage;
            }
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int len = stages.length;
        PriorityQueue<FailRatio> failRatioQueue = new PriorityQueue<>();
        for(int i=1; i<=N; i++)
        {
            int sum =0;
            for(int j=0; j<stages.length; j++)
            {
                if(stages[j] == i)
                {
                    sum++;
                }
            }
            failRatioQueue.add(new FailRatio(i, (N!=0)?(float)sum/len:0.0f));
            len-=sum;
        }
        for(int i=0; i<N; i++)
        {
            answer[i] = failRatioQueue.poll().stage;
        }
        return answer;
    }
}