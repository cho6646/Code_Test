import java.util.List;
import java.util.ArrayList;

class Solution {
    int numOfAttributes;
    int nAtt;
    List<Integer> attributes;
    List<List<Integer>> candidateKeys;
    int result;
    String[][] relations;
    public int solution(String[][] relation) {
        this.relations = relation;
        candidateKeys = new ArrayList<>();
        nAtt = relation[0].length;
        result = 0;
        for(int i=1; i<=nAtt; i++)
        {
            numOfAttributes = i;
            attributes = new ArrayList<>();
            permutation(0, new boolean[nAtt]);
        }
        return result;
    }
    
    public void permutation(int depth, boolean[] visited)
    {
        if(depth == numOfAttributes)
        {
            for(int j=0; j<candidateKeys.size(); j++)
            {
                if(attributes.containsAll(candidateKeys.get(j)))
                {
                    return;
                }
            }
            List<String> tuples = new ArrayList<>();
            for(int j = 0; j< relations.length; j++)
            {
                String a = "";
                for(int k=0; k<attributes.size(); k++)
                {
                    a += relations[j][attributes.get(k)];
                }
                if(tuples.contains(a)) return;
                tuples.add(a);
            }
            result += 1;
            candidateKeys.add(List.copyOf(attributes));
            return;
        }
        for(int i=0; i<nAtt; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                attributes.add(i);
                permutation(depth+1, visited);
                visited[i] = false;
                attributes.remove(depth);
            }
        }
    }
}