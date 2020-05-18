import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public class Pair
    {
        int i;
        int j;
        public Pair(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }

    public boolean solution(int[][] key, int[][] lock) {
        int lockSize = lock.length;
        int keySize = key.length;

        if(lockSize < 3 || lockSize > 20) return false;
        if(keySize < 3 || keySize > 20) return false;
        if(keySize > lockSize) return false;

        List<Pair> keyspace = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int lockCount = 0;
        for(int i=0; i<lockSize; i++)
        {
            for(int j=0; j<lockSize; j++)
            {
                if(lock[i][j] == 0)
                {
                    map.put((i+keySize-1)<<16+(j+keySize-1), 1);
                    lockCount += 1;
                }
            }
        }
        int keyCount = 0;
        for(int i=0; i<keySize; i++)
        {
            for(int j=0; j<keySize; j++)
            {
                if(key[i][j] == 1) {
                    keyspace.add(new Pair(i, j));
                    keyCount += 1;
                }
            }
        }
        if(lockCount == 0) return true;
        if(keyCount == 0) return false;
        if(lockCount == lockSize * lockSize)
        {
            if(lockSize == keySize && lockCount == keyCount) return true;
            if(keySize < lockSize) return false;
        }

        int dim = lockSize+keySize-1;
        int lastindex = keySize - 1;
        for(int i=0; i<4; i++)
        {
            for(int j=0; j<=dim; j++)
            {
                for(int k=0; k<=dim; k++)
                {
                    int count = 0;
                    for(int l=0; l<keyspace.size(); l++)
                    {
                        Pair a = keyspace.get(l);
                        int i_ = 0;
                        int j_ = 0;
                        switch(i)
                        {
                            case 0:
                                i_ = a.i;
                                j_ = a.j;
                                break;
                            case 1:
                                i_ = a.j;
                                j_ = lastindex - a.i;
                                break;
                            case 2:
                                i_ = lastindex - a.i;
                                j_ = lastindex - a.j;
                                break;
                            case 3:
                                i_ = lastindex - a.j;
                                j_ = a.i;
                                break;
                        }
                        int i__ = i_+j-(keySize-1);
                        int j__ = j_+k-(keySize-1);
                        if(i__ >= 0 && i__ < lockSize
                        && j__ >= 0 && j__ < lockSize)
                        {
                            if(lock[i__][j__] == 0) count += 1;
                            if(lock[i__][j__] == 1) break;
                        }
                        else continue;
                        if(count == lockCount) return true;
                    }
                }
            }
        }
        return false;
    }
}