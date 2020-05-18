import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

class Solution {
    class RecordInfo
    {
        boolean enter;
        String id;
        public RecordInfo(boolean enter, String id)
        {
            this.enter = enter;
            this.id = id;
        }
    }
    public String[] solution(String[] record) {
        List<RecordInfo> recordList = new LinkedList<>();
        HashMap<String, String> idMap = new HashMap<>();
        for(int i=0; i<record.length; i++)
        {
            String[] eachRecord = record[i].split(" ");
            String doWhat = eachRecord[0];
            String id = eachRecord[1];
            if(doWhat.equals("Enter"))
            {
                recordList.add(new RecordInfo(true, id));
                idMap.put(id,eachRecord[2]);
            }
            else if(doWhat.equals("Leave"))
            {
                recordList.add(new RecordInfo(false, id));
            }
            else
            {
                idMap.put(id,eachRecord[2]);
            }
        }
        String[] answer = new String[recordList.size()];
        for(int i=0; i<recordList.size(); i++)
        {
            RecordInfo rec = recordList.get(i);
            String id = idMap.get(rec.id);
            if(rec.enter)
            {
                answer[i] = String.format("%s님이 들어왔습니다.",id);
            }
            else
            {
                answer[i] = String.format("%s님이 나갔습니다.",id);
            }
        }
        return answer;
    }
}