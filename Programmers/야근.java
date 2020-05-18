import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++)
        {
            pq.offer(works[i]);
        }
        while(n>0)
        {
            int a = pq.poll();
            if(a == 0)
            {
                pq.offer(0);
                break;
            }
            int b = pq.peek();
            if(n>a && b == 0)
            {
                pq.offer(0);
                n-=a;
                continue;
            }
            int m = (n>(a-(b-1)))?(a-(b-1)):n;
            n -= m;
            pq.offer(a-m);
        }
        long sum = 0;
        for(int i=0; i<works.length; i++)
        {
            int a = pq.poll();
            sum+= a*a;
        }
        return sum;
    }
}