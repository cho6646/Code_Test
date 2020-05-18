import java.util.List;
import java.util.LinkedList;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        int[][] square = new int[n+3][n+3];
        int buildFrameLen = build_frame.length;
        List<int[]> preAns = new LinkedList<>();
        int count =0;
        for(int i=0; i<buildFrameLen; i++)
        {
            int[] instruction = build_frame[i];
            int x = instruction[0]+1;
            int y = instruction[1]+1;
            int a = instruction[2];
            int b = instruction[3];
            if(b == 0) // delete
            {
                if(possibleToDestruct(square,n, x,y,a))
                {
                    if(a==0) square[y][x] -= 2;
                    else square[y][x] -= 1;
                    count -=1;
                }
            }
            else // construct
            {
                if(possibleToConstruct(square,n, x,y,a))
                {
                    if(a == 0) square[y][x] += 2;
                    else square[y][x] += 1;
                    
                    count += 1;
                }
            }
        }
        
        int[][] answer = new int[count][3];
        int index = 0;
        for(int i=1; i<=n+1; i++)
        {
            for(int j=1; j<=n+1; j++)
            {
                if(square[j][i]>0)
                {
                    if(square[j][i]==2 || square[j][i] == 3) 
                    {
                        answer[index++] = new int[]{i-1,j-1,0};
                    }
                    if(square[j][i]%2==1) 
                    {
                        answer[index++] = new int[]{i-1,j-1,1};
                    }
                }
            }
        }
        return answer;
    }
    
    public boolean possibleToConstruct(int[][] square, int n, int x, int y, int type)
    {
        if(type == 0) //기둥
        {
            if(y == 1) return true;
            if(isColumn(square, x, y-1)) return true;
            if(isBar(square, x, y)) return true;
            if(isBar(square, x-1, y)) return true; //왼쪽 보 위에
        }
        else //보
        {
            if(isBar(square, x-1, y) && isBar(square, x+1, y)) return true;
            if(isColumn(square, x, y-1) || isColumn(square, x+1, y-1)) return true;    
        }
        return false;
    }
    
    public boolean possibleToDestruct(int[][] square, int n, int x, int y, int type)
    {
        boolean result = true;
        if(type == 0) square[y][x] -=2;
        else square[y][x] -= 1;
        loop:
        for(int i=1; i<=n+1; i++)
        {
            for(int j=1; j<=n+1; j++)
            {
                if(isColumn(square,i,j) && !possibleToConstruct(square,n,i,j,0))
                {
                    result = false;
                    break loop;
                }
                if(isBar(square,i,j) && !possibleToConstruct(square,n,i,j,1))
                {
                    result = false;
                    break loop;
                }
            }
        }
        if(type==0) square[y][x] += 2;
        else square[y][x] +=1;
        return result;
    }
    
    public boolean isColumn(int[][] square, int x, int y)
    {
        return (square[y][x] == 2 || square[y][x] == 3);
    }
    
    public boolean isBar(int[][] square, int x, int y)
    {
        return (square[y][x]%2 == 1);
    }
}