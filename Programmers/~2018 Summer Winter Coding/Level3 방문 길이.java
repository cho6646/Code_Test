class Solution {
    public int solution(String dirs) {
        int answer = 0;
        // return answer;
        boolean[][][] visited = new boolean[11][11][2];
        int x = 5;
        int y = 5;
        for(int i=0; i<dirs.length(); i++)
        {
            switch(dirs.charAt(i))
            {
                case 'U':
                    if(y==10) break;
                    if(!visited[x][y][0]) 
                    {
                        answer +=1;
                        visited[x][y][0] = true;
                    }
                    y+=1;
                    break;
                case 'D':
                    if(y==0) break;
                    if(!visited[x][y-1][0])
                    {
                        answer+=1;
                        visited[x][y-1][0] = true;
                    }
                    y-=1;
                    break;
                case 'R':
                    if(x==10) break;
                    if(!visited[x][y][1])
                    {
                        answer+=1;
                        visited[x][y][1] = true;
                    }
                    x+=1;
                    break;
                case 'L':
                    if(x==0) break;
                    if(!visited[x-1][y][1])
                    {
                        answer+=1;
                        visited[x-1][y][1] = true;
                    }
                    x-=1;
                    break;
            }
        }
        return answer;
    }
}