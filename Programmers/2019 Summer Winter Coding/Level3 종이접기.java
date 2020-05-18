class Solution {
    public int[] solution(int n) {
        int num = arrLen(n);
        int[] answer = new int[num];
        answer[0] = 0;
        for(int i=1; i<n; i++)
        {
            int pivot = (int)Math.pow(2,i)-1;
            answer[pivot] = 0;
            for(int j=1;j<=pivot;j++)
            {
                answer[pivot+j] = answer[pivot-j] ^ 1;
            }
        }
        return answer;
    }
    
    public int arrLen(int n)
    {
        if(n == 1) return 1;
        return 2*arrLen(n-1)+1;
    }
}