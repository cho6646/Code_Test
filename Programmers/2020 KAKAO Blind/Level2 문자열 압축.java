class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(String s) {
        encodingHelper(s);
        return answer;
    }

    public void encodingHelper(String s)
    {
        int len = s.length();
        if(len == 1) answer = 1;
        for(int i=1; i<=len/2; i++)
        {
            String output = "";
            int pointer = 0;
            while(pointer * i <= len)
            {
                int count = 1;
                String checkString;

                if((pointer+1)*i <= len) checkString = s.substring(pointer*i, (pointer+1)*i);
                else checkString = s.substring(pointer*i);

                while((pointer+2)*i <= len
                        && s.substring((pointer+1)*i,(pointer+2)*i).equals(checkString))
                {
                    count+=1;
                    pointer+=1;
                }
                output += (count > 1) ?count + checkString : checkString;
                pointer++;
            }
            answer = Math.min(answer, output.length());
        }
    }
}