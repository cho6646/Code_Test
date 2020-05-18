class Solution {
    int N;
    int[][] mBoard;
    int top;
    int answer;
    boolean changed;
    public int solution(int[][] board) {
        mBoard = board;
        N = board.length;
        answer = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(mBoard[i][j] == 0) continue;
                if(isA(i,j))
                {
                    if(canFill(i,j+1) && canFill(i+1,j+1))
                    {
                        remove(i,j,1);
                        answer+=1;
                        j=-1;
                    }
                }
                else if(isB(i,j))
                {
                    if(canFill(i,j-1) && canFill(i+1,j-1))
                    {
                        remove(i,j,2);
                        answer+=1;
                        j=-1;
                    }
                }
                else if(isC(i,j))
                {
                    if(canFill(i,j+1) && canFill(i,j+2))
                    {
                        remove(i,j,3);
                        answer+=1;
                        j=-1;
                    }
                }
                else if(isD(i,j))
                {
                    if(canFill(i,j-1) && canFill(i,j-2))
                    {
                        remove(i,j,4);
                        answer+=1;
                        j=-1;
                    }
                }
                else if(isE(i,j))
                {
                    if(canFill(i,j-1) && canFill(i,j+1))
                    {
                        remove(i,j,5);
                        answer+=1;
                        j=-1;
                    }
                }
            }
        }
        return answer;
    }
    
    public boolean isA(int i, int j)
    {
        int num = mBoard[i][j];
        if(i+2>=N || j+1>=N) return false;
        return mBoard[i+1][j] == num && mBoard[i+2][j] == num && mBoard[i+2][j+1] == num;
    }
    
    public boolean isB(int i, int j)
    {
        int num = mBoard[i][j];
        if(i+2>=N || j-1<0) return false;
        return mBoard[i+1][j] == num && mBoard[i+2][j] == num && mBoard[i+2][j-1] == num;
    }
    
    public boolean isC(int i, int j)
    {
        int num = mBoard[i][j];
        if(i+1>=N || j+2>=N) return false;
        return mBoard[i+1][j] == num && mBoard[i+1][j+1] == num && mBoard[i+1][j+2] == num;
    }
    
    public boolean isD(int i, int j)
    {
        int num = mBoard[i][j];
        if(i+1>=N || j-2<0) return false;
        return mBoard[i+1][j] == num && mBoard[i+1][j-1] == num && mBoard[i+1][j-2] == num;
    }
    
    public boolean isE(int i, int j)
    {
        int num = mBoard[i][j];
        if(i+1>=N || j-1<0 || j+1>=N) return false;
        return mBoard[i+1][j] == num && mBoard[i+1][j-1] == num && mBoard[i+1][j+1] == num;
    }
    
    public void remove(int i, int j, int type)
    {
        mBoard[i][j] = 0;
        int i1=i,i2=i,i3=i,j1=j,j2=j,j3=j;
        switch(type)
        {
            case 1:
                i1=i+1;
                j1=j;
                i2=i+2;
                j2=j;
                i3=i+2;
                j3=j+1;
                break;
            case 2:
                i1=i+1;
                j1=j;
                i2=i+2;
                j2=j;
                i3=i+2;
                j3=j-1;
                break;
            case 3:
                i1=i+1;
                j1=j;
                i2=i+1;
                j2=j+1;
                i3=i+1;
                j3=j+2;
                break;
            case 4:
                i1=i+1;
                j1=j;
                i2=i+1;
                j2=j-1;
                i3=i+1;
                j3=j-2;
                break;
            case 5:
                i1=i+1;
                j1=j;
                i2=i+1;
                j2=j-1;
                i3=i+1;
                j3=j+1;
                break;
        }
        mBoard[i1][j1]=0;
        mBoard[i2][j2]=0;
        mBoard[i3][j3]=0;
    }
    
    public boolean canFill(int y, int x)
    {
        for(int i=0; i<=y; i++)
        {
            if(mBoard[i][x]>0) return false;
        }
        return true;
    }
}