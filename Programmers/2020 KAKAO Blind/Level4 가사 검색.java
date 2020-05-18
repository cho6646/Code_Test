import java.util.HashMap;

class Solution {
    static class Trie
    {
        char data;
        HashMap<Character, Trie> children;
        HashMap<Integer, Integer> numChildren;
        Trie(char data)
        {
            this.data = data;
            children = new HashMap<>();
            numChildren = new HashMap<>();
        }
        public Trie putChild(Trie t, int len)
        {
            if(!children.containsKey(t.data))
            {
                children.put(t.data, t);
            }
            if(!numChildren.containsKey(len))
            {
                numChildren.put(len, 1);
            }
            else
            {
                numChildren.put(len, numChildren.get(len)+1);
            }
            return children.get(t.data);
        }
        Trie getChild(char c)
        {
            return children.get(c);
        }
        int getnumChild(int len)
        {
            return numChildren.containsKey(len) ? numChildren.get(len) : 0;
        }
    }
    
    public static int[] solution(String[] words, String[] queries) {
        int wordsLen = words.length;
        int queriesLen = queries.length;
        int[] result = new int[queriesLen];
        Trie originalTrie = new Trie('.');
        Trie reverseTrie = new Trie('/');
        for(int i=0; i<wordsLen; i++)
        {
            String word = words[i];
            int wordLen = word.length();
            Trie start = originalTrie;
            Trie reverseStart = reverseTrie;
            for(int j=0; j<wordLen; j++)
            {
                char c = word.charAt(j);
                char rc = word.charAt(wordLen-1-j);
                Trie now = new Trie(c);
                Trie rNow = new Trie(rc);
                start = start.putChild(now, wordLen);
                reverseStart = reverseStart.putChild(rNow, wordLen);

            }
        }

        for(int i=0; i<queriesLen; i++)
        {
            String query = queries[i];
            int queryLen = query.length();
            Trie a;
            int resultV = 0;
            if(query.charAt(0)!='?')
            {
                a = originalTrie;
                int remaining = queryLen;
                for(int j=0; j<queryLen; j++)
                {
                    char ch = query.charAt(j);
                    if(ch == '?')
                    {
                        resultV = a.getnumChild(queryLen);
                        break;
                    }
                    a = a.getChild(ch);
                    if(a == null)
                    {
                        resultV = 0;
                        break;
                    }
                }
            }
            else
            {
                a = reverseTrie;
                int remaining = queryLen;
                for(int j=0; j<queryLen; j++)
                {
                    char ch = query.charAt(queryLen-1-j);
                    if(ch == '?')
                    {
                        resultV = a.getnumChild(queryLen);
                        break;
                    }
                    a = a.getChild(ch);
                    if(a == null)
                    {
                        resultV = 0;
                        break;
                    }
                }
            }
            result[i] = resultV;
        }
        return result;
    }
}