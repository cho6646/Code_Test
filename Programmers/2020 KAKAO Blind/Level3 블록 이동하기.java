import java.util.Queue;
import java.util.LinkedList;
class Solution {
    class DronePos
    {
        int x1;
        int y1;
        int x2;
        int y2;
        int dist;
        public DronePos(int x1, int y1, int x2, int y2, int dist)
        {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.dist = dist;
        }
    }
    
    int boardLen;
    
    public int solution(int[][] board) {
        int answer = 0;
        boardLen = board.length;
        int[][] newBoard = new int[boardLen+2][boardLen+2];
        for(int i=0; i<boardLen+2; i++)
        {
            for(int j=0; j<boardLen+2; j++)
            {
                if(i>=1 && i<boardLen+1 && j>=1 && j<boardLen+1)
                    newBoard[i][j] = board[i-1][j-1];
                if(i==0 || i==boardLen+1 || j==0 || j==boardLen+1)
                    newBoard[i][j] = 1;
                System.out.print(newBoard[i][j]+" ");
            }
            System.out.println("");
        }
        Queue<DronePos> queue = new LinkedList<>();
        queue.add(new DronePos(1,1,1,2,0));
        int [][][][] visited = new int[boardLen+2][boardLen+2][boardLen+2][boardLen+2];
        visited[1][1][1][2] = 1;
        while(!queue.isEmpty())
        {
            DronePos dronePos = queue.poll();
            int x1 = dronePos.x1;
            int y1 = dronePos.y1;
            int x2 = dronePos.x2;
            int y2 = dronePos.y2;
            int dist = dronePos.dist;

            if((x1==boardLen && y1==boardLen) || (x2==boardLen && y2==boardLen)) return dist;

            if(newBoard[x1-1][y1] == 0 && newBoard[x2-1][y2] == 0) // left
            {
                if(visited[x1-1][y1][x2-1][y2] == 0)
                {
                    queue.offer(new DronePos(x1-1,y1,x2-1,y2, dist+1));
                    visited[x1-1][y1][x2-1][y2] = 1;
                    visited[x2-1][y2][x1-1][y1] = 1;
                }
            }
            if(newBoard[x1+1][y1] == 0 && newBoard[x2+1][y2] == 0) //right
            {
                if(visited[x1+1][y1][x2+1][y2] == 0)
                {
                    queue.offer(new DronePos(x1+1,y1,x2+1,y2, dist+1));
                    visited[x1+1][y1][x2+1][y2] = 1;
                    visited[x2+1][y2][x1+1][y1] = 1;
                }
            }
            if(newBoard[x1][y1-1] == 0 && newBoard[x2][y2-1] == 0) // up
            {
                if(visited[x1][y1-1][x2][y2-1] == 0)
                {
                    queue.offer(new DronePos(x1,y1-1,x2,y2-1, dist+1));
                    visited[x1][y1-1][x2][y2-1] = 1;
                    visited[x2][y2-1][x1][y1-1] = 1;
                }
            }
            if(newBoard[x1][y1+1] == 0 && newBoard[x2][y2+1] == 0) // down
            {
                if(visited[x1][y1+1][x2][y2+1] == 0)
                {
                    queue.offer(new DronePos(x1,y1+1,x2,y2+1, dist+1));
                    visited[x1][y1+1][x2][y2+1] = 1;
                    visited[x2][y2+1][x1][y1+1] = 1;
                }
            }
            if(y1==y2)
            {
                if(newBoard[x1][y1+1] == 0 && newBoard[x2][y2+1] == 0)
                {
                    if(visited[x1][y1+1][x1][y1] == 0)
                    {
                        queue.offer(new DronePos(x1,y1+1,x1,y1, dist+1));
                        visited[x1][y1+1][x1][y1] = 1;
                        visited[x1][y1][x1][y1+1] = 1;
                    }
                    if(visited[x2][y2+1][x2][y2] == 0)
                    {
                        queue.offer(new DronePos(x2,y2+1,x2,y2, dist+1));
                        visited[x2][y2+1][x2][y2] = 1;
                        visited[x2][y2][x2][y2+1] = 1;
                    }
                }
                if(newBoard[x1][y1-1] == 0 && newBoard[x2][y2-1] == 0)
                {
                    if(visited[x1][y1-1][x1][y1] == 0)
                    {
                        queue.offer(new DronePos(x1,y1-1,x1,y1, dist+1));
                        visited[x1][y1-1][x1][y1] = 1;
                        visited[x1][y1][x1][y1-1] = 1;
                    }
                    if(visited[x2][y2-1][x2][y2] == 0)
                    {
                        queue.offer(new DronePos(x2,y2-1,x2,y2, dist+1));
                        visited[x2][y2-1][x2][y2] = 1;
                        visited[x2][y2][x2][y2-1] = 1;
                    }
                }
            }
            if(x1==x2)
            {
                if(newBoard[x1+1][y1] == 0 && newBoard[x2+1][y2] == 0)
                {
                    if(visited[x1+1][y1][x1][y1] == 0)
                    {
                        queue.offer(new DronePos(x1+1,y1,x1,y1, dist+1));
                        visited[x1+1][y1][x1][y1] = 1;
                        visited[x1][y1][x1+1][y1] = 1;
                    }
                    if(visited[x2+1][y2][x2][y2] == 0)
                    {
                        queue.offer(new DronePos(x2+1,y2,x2,y2, dist+1));
                        visited[x2+1][y2][x2][y2] = 1;
                        visited[x2][y2][x2+1][y2] = 1;
                    }
                }
                if(newBoard[x1-1][y1] == 0 && newBoard[x2-1][y2] == 0)
                {
                    if(visited[x1-1][y1][x1][y1] == 0)
                    {
                        queue.offer(new DronePos(x1-1,y1,x1,y1, dist+1));
                        visited[x1-1][y1][x1][y1] = 1;
                        visited[x1][y1][x1-1][y1] = 1;
                    }
                    if(visited[x2-1][y2][x2][y2] == 0)
                    {
                        queue.offer(new DronePos(x2-1,y2,x2,y2, dist+1));
                        visited[x2-1][y2][x2][y2] = 1;
                        visited[x2][y2][x2-1][y2] = 1;
                    }
                }
            }
        }
        return -1;
    }
}