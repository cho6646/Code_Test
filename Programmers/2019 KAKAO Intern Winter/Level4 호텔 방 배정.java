import java.util.HashMap;

class Solution {
    HashMap<Long, Long> store;
    public long[] solution(long k, long[] room_number) {
        store = new HashMap<>();
        long[] answer = new long[room_number.length];
        for(int i=0; i<room_number.length; i++)
        {
            long picked = room_number[i];
            answer[i] = pickedToStore(picked);
        }
        return answer;
    }
    
    public long pickedToStore(long picked)
    {
        long result;
        if(!store.containsKey(picked))
        {
            store.put(picked, (long)1);
            result = picked;
        }
        else
        {
            Long a = store.get(picked);
            result = pickedToStore(picked+a);
            Long b = result-picked;
            store.put(picked, result-picked);
        }
        return result;
    }
}