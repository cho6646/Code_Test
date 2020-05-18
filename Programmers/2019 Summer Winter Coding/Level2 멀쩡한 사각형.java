class Solution {
	public long solution(int w,int h) {
		long answer = 0;
        if(w==1 || h==1) return 0;
        long start = 0;
        long end = 0;
        for(long i=1; i<(long)w; i++)
        {
            while(end*(long)w <= (long)h*i)
            {
                end++;
            }
            end-=1;
            answer+=(end-start) * ((long)w-i);
            start = end;
        }
        answer *=2;
		return answer;
	}
}