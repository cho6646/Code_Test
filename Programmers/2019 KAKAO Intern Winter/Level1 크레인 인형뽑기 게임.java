import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int boardLen = board.length;
        System.out.println(boardLen);
        Deque<Integer> stack = new LinkedList<>();
        for(int move: moves)
        {
            int i = 0;
            while(i<boardLen && board[i][move-1] == 0)
            {
                i++;
            }
            if(i>=boardLen) continue;
            int item = board[i][move-1];
            
            if(!stack.isEmpty())
            {
                if(stack.peekFirst() == item)
                {
                    answer += 2;
                    stack.removeFirst();
                }
                else
                    stack.offerFirst(item);
            }
            else
            {
                stack.offerFirst(item);
            }
            board[i][move-1] = 0;
        }
        return answer;
    }
}