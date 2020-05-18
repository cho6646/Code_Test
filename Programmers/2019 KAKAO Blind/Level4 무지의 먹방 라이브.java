import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    class FoodTime
    {
        int time, index;
        public FoodTime(int time, int index)
        {
            this.time = time;
            this.index = index;
        }
    }
    
    public int solution(int[] food_times, long k) {
        if(k==0) return 1;
        long sum = 0;
        for(int i=0; i<food_times.length; i++) sum+=(long)food_times[i];
        if(k>=sum) return -1;
        Comparator<FoodTime> comp = new Comparator<FoodTime>()
        {
            @Override
            public int compare(FoodTime o1, FoodTime o2)
            {
                return o1.time - o2.time;
            }
        };
        Comparator<FoodTime> comp2 = new Comparator<FoodTime>()
        {
            @Override
            public int compare(FoodTime o1, FoodTime o2)
            {
                return o1.index - o2.index;
            }
        };
        List<FoodTime> foodTimeList = new ArrayList<>();
        
        for(int i=0; i<food_times.length; i++)
        {
            foodTimeList.add(new FoodTime(food_times[i], i));
        }
        Collections.sort(foodTimeList, comp);
        int index = 0;
        long time = (long) foodTimeList.get(0).time;
        long size = (long) foodTimeList.size();
        long removedTime=0;
        while(k >= (time-removedTime)*size)
        {
            k -= (time-removedTime)*size;
            for(int i=index; i<foodTimeList.size(); i++)
            {
                if((long)foodTimeList.get(i).time != time)
                {
                    removedTime = time;
                    time = (long) foodTimeList.get(i).time;
                    index = i;
                    size = (long) foodTimeList.size() - i;
                    break;
                }
            }
        }
        k %= size;
        List<FoodTime> newList = new ArrayList<>();
        for(int i=index; i<foodTimeList.size(); i++)
        {
            newList.add(foodTimeList.get(i));
        }
        Collections.sort(newList, comp2);
        return newList.get((int)k).index+1;
    }
}