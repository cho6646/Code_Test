import java.util.List;
import java.util.LinkedList;
class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length()-2);
        String[] inputListInString = s.split("\\},\\{");
        List<List<Integer>> inputList = new LinkedList<>();
        for(int i=0; i<inputListInString.length; i++)
        {
            List<Integer> a = new LinkedList<>();
            String[] str = inputListInString[i].split(",");
            for(int j=0; j<str.length; j++)
            {
                a.add(Integer.parseInt(str[j]));
            }
            inputList.add(a);
        }
        int len = inputList.size();
        List<Integer> result = new LinkedList<>();
        int[] answer = new int[len];
        int idx = 0;
        for(int i=1; i<=len; i++)
        {
            List<Integer> a = new LinkedList<>();
            for(int j=0; j<len; j++)
            {
                if(inputList.get(j).size() == i)
                {
                    a = inputList.get(j);
                    break;
                }
            }
            if(a.size() == 1) 
            {
                result.add(a.get(0));
                answer[idx++] = a.get(0);
            }
            else
            {
                for(int j=0; j<a.size(); j++)
                {
                    int compNum = a.get(j);
                    if(!result.contains(compNum))
                    {
                        result.add(compNum);
                        answer[idx++] = compNum;
                    }
                }
            }
        }
        return answer;
    }
}