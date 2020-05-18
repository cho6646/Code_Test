import java.util.*;
class Solution {
    HashSet<HashSet<String>>hs;
    int userIdLen;
    int bannedIdLen;
    String[] userId;
    String[] bannedId;
    String[] temp;
    boolean[] visited;
    int answer;
    
    public int solution(String[] user_id, String[] banned_id) {
        hs = new HashSet<>();
        userIdLen = user_id.length;
        bannedIdLen = banned_id.length;
        userId = user_id;
        bannedId = banned_id;
        temp = new String[bannedIdLen];
        visited = new boolean[userIdLen];
        answer = 0;

        backTracking(0);
        return answer;
    }
    
    public void backTracking(int n)
    {
        if(n==bannedIdLen)
        {
            for(int i=0; i<bannedIdLen; i++)
            {
                String str1 = temp[i];
                String str2 = bannedId[i];
                int check = str1.length();
                if(check == str2.length())
                {
                    for(int j=0; j<check; j++)
                    {
                        if(str2.charAt(j) != '*')
                        {
                            if(str2.charAt(j) != str1.charAt(j)) return;
                        }
                    }
                }
                else return;
            }
            HashSet<String> check = new HashSet<>();
            for(String s: temp) check.add(s);
            if(!hs.contains(check))
            {
                answer++;
                hs.add(check);
            }
            return;
        }
        for(int i=0; i<userIdLen; i++) //making permutation
        {
            if(!visited[i])
            {
                visited[i] = true;
                temp[n] = userId[i];
                backTracking(n+1);
                visited[i] = false;
            }
        }
    }
}