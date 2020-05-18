import java.util.*;
class Solution {
    public class Land implements Comparable<Land>
    {
        int col;
        int row;
        int cost;
        public Land(int col, int row, int cost)
        {
            this.col = col;
            this.row = row;
            this.cost = cost;
        }
        @Override
        public int compareTo(Land l)
        {
            if(this.cost > l.cost) return 1;
            if(this.cost < l.cost) return -1;
            return 0;
        }
    }
    public int solution(int[][] land, int height) {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int answer = 0;
        int landLen = land.length;
        boolean[][] visited = new boolean[landLen][landLen];
        Queue<Land> queue = new LinkedList<Land>();
        PriorityQueue<Land> pQueue = new PriorityQueue<Land>();
        queue.add(new Land(0,0,0));
        while(!queue.isEmpty())
        {
            Land el = queue.poll();
            int col = el.col;
            int row = el.row;
            if(!visited[row][col])
            {
                visited[row][col] = true;
                
                answer += el.cost;
                for(int i=0; i<4; i++)
                {
                    int nCol = col+dx[i];
                    int nRow = row+dy[i];
                    if(nCol < 0 || nCol >= landLen || nRow < 0 || nRow >= landLen ) continue;
                    int cost = (Math.abs(land[nRow][nCol] - land[row][col]) <= height)? 0 : Math.abs(land[nRow][nCol] - land[row][col]);
                    if(Math.abs(land[nRow][nCol] - land[row][col]) <= height)
                    {
                        queue.offer(new Land(nCol, nRow, cost));
                    }
                    else
                    {
                        pQueue.offer(new Land(nCol, nRow, cost));
                    }
                }
            }
            if(queue.isEmpty())
            {
                if(!pQueue.isEmpty())
                {
                    queue.offer(pQueue.poll());
                }
            }
        }
        return answer;
    }
}